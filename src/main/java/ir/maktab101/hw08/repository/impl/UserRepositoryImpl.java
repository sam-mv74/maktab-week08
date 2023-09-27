package ir.maktab101.hw08.repository.impl;

import ir.maktab101.hw08.base.domain.BaseEntity;
import ir.maktab101.hw08.base.repository.impl.BaseEntityRepositoryImpl;
import ir.maktab101.hw08.domain.Brand;
import ir.maktab101.hw08.domain.Category;
import ir.maktab101.hw08.domain.Product;
import ir.maktab101.hw08.domain.User;
import ir.maktab101.hw08.repository.UserRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.ZonedDateTime;

public class UserRepositoryImpl extends BaseEntityRepositoryImpl
        implements UserRepository {
    public UserRepositoryImpl(Connection connection) {
        super(connection);
    }

    @Override
    protected String[] getInsertColumns() {
        return new String[]{
                User.FULL_NAME,
                User.USERNAME,
                User.PASSWORD,
                User.EMAIL
        };    }

    @Override
    protected String getEntityTableName() {
        return User.TABLE_NAME;
    }

    @Override
    protected BaseEntity mapResultSetToEntity(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setId(
                resultSet.getLong(1)
        );
        user.setFullName(
                resultSet.getString(2)
        );
        user.setUserName(
                resultSet.getString(3)
        );
        user.setPassword(
                resultSet.getString(4)

        );
        user.setEmail(
                resultSet.getString(5)

        );

        return user;
    }

    @Override
    protected BaseEntity[] getBaseEntityArrayForFindAll() throws SQLException {
        return new User[(int) count()];
    }

    @Override
    protected void fillPreparedStatementParamsForSave(PreparedStatement preparedStatement, BaseEntity entity) throws SQLException {
        User user = (User) entity;
        preparedStatement.setString(
                1,
                user.getFullName()
        );
        preparedStatement.setString(
                2,
                user.getUserName()
        );
        preparedStatement.setString(
                3,
                user.getPassword()
        );
        preparedStatement.setString(
                4,
                user.getEmail()
        );
    }

    @Override
    protected void fillPreparedStatementParamsForUpdate(PreparedStatement preparedStatement, BaseEntity entity) throws SQLException {
        User user = (User) entity;
        preparedStatement.setString(
                1,
                user.getFullName()
        );
        preparedStatement.setString(
                2,
                user.getUserName()
        );
        preparedStatement.setString(
                3,
                user.getPassword()
        );
        preparedStatement.setString(
                4,
                user.getEmail()
        );
        preparedStatement.setLong(
                5,
                user.getId()
        );
    }
    @Override
    public boolean existByUsernameAndPassword(String username,String password) throws SQLException {
        String loginQuery = "SELECT * FROM user_tbl WHERE username = ? AND password = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(loginQuery);
        preparedStatement.setString(1, username);
        preparedStatement.setString(2,password);
        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet.next();
    }
}
