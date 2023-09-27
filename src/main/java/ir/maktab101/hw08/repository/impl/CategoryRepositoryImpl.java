package ir.maktab101.hw08.repository.impl;

import ir.maktab101.hw08.base.domain.BaseEntity;
import ir.maktab101.hw08.base.repository.impl.BaseEntityRepositoryImpl;
import ir.maktab101.hw08.domain.Brand;
import ir.maktab101.hw08.domain.Category;
import ir.maktab101.hw08.repository.CategoryRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryRepositoryImpl extends BaseEntityRepositoryImpl
        implements CategoryRepository {
    public CategoryRepositoryImpl(Connection connection) {
        super(connection);
    }

    @Override
    protected String[] getInsertColumns() {
        return new String[]{
                Category.NAME,
                Category.DESCRIPTION
        };
    }

    @Override
    protected String getEntityTableName() {
        return Category.TABLE_NAME;

    }

    @Override
    protected BaseEntity mapResultSetToEntity(ResultSet resultSet) throws SQLException {
        Category category = new Category();
        category.setId(
                resultSet.getLong(1)
        );
        category.setName(
                resultSet.getString(2)
        );
        category.setDescription(
                resultSet.getString(3)
        );
        return category;
    }

    @Override
    protected BaseEntity[] getBaseEntityArrayForFindAll() throws SQLException {
        return new Category[(int) count()];
    }

    @Override
    protected void fillPreparedStatementParamsForSave(PreparedStatement preparedStatement, BaseEntity entity) throws SQLException {
        Category category = (Category) entity;
        preparedStatement.setString(
                1,
                category.getName()
        );
        preparedStatement.setString(
                2,
                category.getDescription()
        );
    }

    @Override
    protected void fillPreparedStatementParamsForUpdate(PreparedStatement preparedStatement, BaseEntity entity) throws SQLException {
        Category category = (Category) entity;
        preparedStatement.setString(
                1,
                category.getName()
        );

        preparedStatement.setString(
                2,
                category.getDescription()
        );
        preparedStatement.setLong(
                3,
                category.getId()
        );
    }

    @Override
    public boolean existByName(String name) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "select id from category_tbl where name = ?"
        );
        preparedStatement.setString(1, name);
        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet.next();
    }
}
