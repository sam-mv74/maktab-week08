package ir.maktab101.hw08.repository;

import java.sql.SQLException;

public interface ShareHolderBrandRepository {
    int save(Long shareHolderId, Long brandId) throws SQLException;
    int delete(Long shareHolderId, Long brandId) throws SQLException;
}
