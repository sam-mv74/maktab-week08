package ir.maktab101.hw08.repository.impl;

import ir.maktab101.hw08.base.domain.BaseEntity;
import ir.maktab101.hw08.base.repository.impl.BaseEntityRepositoryImpl;
import ir.maktab101.hw08.domain.Brand;
import ir.maktab101.hw08.domain.Category;
import ir.maktab101.hw08.domain.Product;
import ir.maktab101.hw08.repository.ProductRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.ZonedDateTime;

public class ProductRepositoryImpl extends BaseEntityRepositoryImpl
        implements ProductRepository {
    public ProductRepositoryImpl(Connection connection) {
        super(connection);
    }

    @Override
    protected String[] getInsertColumns() {
        return new String[]{
                Product.NAME,
                Product.CREATE_DATE,
                Product.CATEGORY_ID,
                Product.BRAND_ID
        };    }

    @Override
    protected String getEntityTableName() {
        return Product.TABLE_NAME;
    }

    @Override
    protected BaseEntity mapResultSetToEntity(ResultSet resultSet) throws SQLException {
        Product product = new Product();
        product.setId(
                resultSet.getLong(1)
        );
        product.setName(
                resultSet.getString(2)
        );
        product.setCreateDate(
                resultSet.getString(3)
        );
        product.setCategory(
                (Category) new CategoryRepositoryImpl(this.connection).findById(resultSet.getLong(4))
        );
        product.setBrand(
                (Brand) new BrandRepositoryImpl(this.connection).findById(resultSet.getLong(5))
        );

        return product;
    }

    @Override
    protected BaseEntity[] getBaseEntityArrayForFindAll() throws SQLException {
        return new Product[(int) count()];
    }

    @Override
    protected void fillPreparedStatementParamsForSave(PreparedStatement preparedStatement, BaseEntity entity) throws SQLException {
        Product product = (Product) entity;
        preparedStatement.setString(
                1,
                product.getName()
        );
        preparedStatement.setString(
                2,
                product.getCreateDate()
        );
        preparedStatement.setLong(
                3,
                product.getCategory().getId()
        );
        preparedStatement.setLong(
                4,
                product.getBrand().getId()
        );
    }

    @Override
    protected void fillPreparedStatementParamsForUpdate(PreparedStatement preparedStatement, BaseEntity entity) throws SQLException {
        Product product = (Product) entity;
        preparedStatement.setString(
                1,
                product.getName()
        );
        preparedStatement.setLong(
                2,
                product.getCategory().getId()
        );
        preparedStatement.setLong(
                3,
                product.getBrand().getId()
        );
        preparedStatement.setLong(
                4,
                product.getId()
        );
    }
}
