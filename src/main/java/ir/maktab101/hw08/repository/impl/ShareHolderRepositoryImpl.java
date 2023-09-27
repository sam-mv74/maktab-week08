package ir.maktab101.hw08.repository.impl;

import ir.maktab101.hw08.base.domain.BaseEntity;
import ir.maktab101.hw08.base.repository.impl.BaseEntityRepositoryImpl;
import ir.maktab101.hw08.domain.Brand;
import ir.maktab101.hw08.domain.Category;
import ir.maktab101.hw08.domain.Product;
import ir.maktab101.hw08.domain.ShareHolder;
import ir.maktab101.hw08.repository.ShareHolderRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.ZonedDateTime;

public class ShareHolderRepositoryImpl extends BaseEntityRepositoryImpl
        implements ShareHolderRepository {
    public ShareHolderRepositoryImpl(Connection connection) {
        super(connection);
    }

    @Override
    protected String[] getInsertColumns() {
        return new String[]{
                ShareHolder.FULL_NAME,
                ShareHolder.PHONE_NUMBER,
                ShareHolder.NATIONAL_CODE
        };    }

    @Override
    protected String getEntityTableName() {
        return ShareHolder.TABLE_NAME;
    }

    @Override
    protected BaseEntity mapResultSetToEntity(ResultSet resultSet) throws SQLException {
        ShareHolder shareHolder = new ShareHolder();
        shareHolder.setId(
                resultSet.getLong(1)
        );
        shareHolder.setFullName(
                resultSet.getString(2)
        );
        shareHolder.setPhoneNumber(
               resultSet.getString(3)
        );

        return shareHolder;
    }

    @Override
    protected BaseEntity[] getBaseEntityArrayForFindAll() throws SQLException {
        return new ShareHolder[(int) count()];
    }

    @Override
    protected void fillPreparedStatementParamsForSave(PreparedStatement preparedStatement, BaseEntity entity) throws SQLException {
        ShareHolder shareHolder = (ShareHolder) entity;
        preparedStatement.setString(
                1,
                shareHolder.getFullName()
        );
        preparedStatement.setString(
                2,
                shareHolder.getPhoneNumber()
        );
        preparedStatement.setString(
                3,
                shareHolder.getNationalCode()
        );
    }

    @Override
    protected void fillPreparedStatementParamsForUpdate(PreparedStatement preparedStatement, BaseEntity entity) throws SQLException {
        ShareHolder shareHolder = (ShareHolder) entity;
        preparedStatement.setString(
                1,
                shareHolder.getFullName()
        );
        preparedStatement.setString(
                2,
                shareHolder.getPhoneNumber()
        );
        preparedStatement.setString(
                3,
                shareHolder.getNationalCode()
        );
        preparedStatement.setLong(
                4,
                shareHolder.getId()
        );
    }
}
