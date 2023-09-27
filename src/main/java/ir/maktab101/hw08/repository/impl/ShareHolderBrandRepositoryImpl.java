package ir.maktab101.hw08.repository.impl;

import ir.maktab101.hw08.repository.ShareHolderBrandRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ShareHolderBrandRepositoryImpl implements ShareHolderBrandRepository {
    private Connection connection;

    public ShareHolderBrandRepositoryImpl(Connection connection) {
    }

    @Override
    public int save(Long shareHolderId, Long brandId) throws SQLException {
        String add = "INSERT INTO shareholder_brand(shareholder_id,brand_id) VALUES (?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(add);
        preparedStatement.setLong(1, shareHolderId);
        preparedStatement.setLong(2, brandId);
        int result = preparedStatement.executeUpdate();
        return result;
    }

    @Override
    public int delete(Long shareHolderId, Long brandId) throws SQLException {
        String delete = "DELETE FROM shareholder_brand WHERE shareholder_id=? AND brand_id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(delete);
        preparedStatement.setLong(1, shareHolderId);
        preparedStatement.setLong(2, brandId);
        int result = preparedStatement.executeUpdate();
        return result;
    }

}
