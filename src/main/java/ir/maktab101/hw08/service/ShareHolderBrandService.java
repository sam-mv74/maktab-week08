package ir.maktab101.hw08.service;

import java.sql.SQLException;

public interface ShareHolderBrandService {
    int save(Long shareHolderId, Long brandId) throws SQLException;
    int delete(Long shareHolderId, Long brandId) throws SQLException;
}
