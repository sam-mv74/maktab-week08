package ir.maktab101.hw08.repository.impl;

import ir.maktab101.hw08.base.domain.BaseEntity;
import ir.maktab101.hw08.base.repository.impl.BaseEntityRepositoryImpl;
import ir.maktab101.hw08.domain.Brand;
import ir.maktab101.hw08.repository.BrandRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BrandRepositoryImpl extends BaseEntityRepositoryImpl
implements BrandRepository {
    public BrandRepositoryImpl(Connection connection) {
        super(connection);
    }

    @Override
    protected String[] getInsertColumns() {
        return new String[]{
                Brand.NAME,
                Brand.WEBSITE,
                Brand.DESCRIPTION
        };
    }

    @Override
    protected String getEntityTableName() {
        return Brand.TABLE_NAME;
    }

    @Override
    protected BaseEntity mapResultSetToEntity(ResultSet resultSet) throws SQLException {
        Brand brand = new Brand();
        brand.setId(
                resultSet.getLong(1)
        );
        brand.setName(
                resultSet.getString(2)
        );
        brand.setWebsite(
                resultSet.getString(3)
        );
        brand.setDescription(
                resultSet.getString(4)
        );
        return brand;
    }

    @Override
    protected BaseEntity[] getBaseEntityArrayForFindAll() throws SQLException {
        return new Brand[(int) count()];
    }

    @Override
    protected void fillPreparedStatementParamsForSave(PreparedStatement preparedStatement, BaseEntity entity) throws SQLException {
        Brand brand = (Brand) entity;
        preparedStatement.setString(
                1,
                brand.getName()
        );
        preparedStatement.setString(
                2,
                brand.getWebsite()
        );
        preparedStatement.setString(
                3,
                brand.getDescription()
        );
    }

    @Override
    protected void fillPreparedStatementParamsForUpdate(PreparedStatement preparedStatement, BaseEntity entity) throws SQLException {
        Brand brand = (Brand) entity;
        preparedStatement.setString(
                1,
                brand.getName()
        );
        preparedStatement.setString(
                2,
                brand.getWebsite()
        );
        preparedStatement.setString(
                3,
                brand.getDescription()
        );
        preparedStatement.setLong(
                4,
                brand.getId()
        );
    }
    @Override
    public boolean existByName(String name) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "select id from brand_tbl where name = ?"
        );
        preparedStatement.setString(1, name);
        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet.next();
    }
}
