package ir.maktab101.hw08.service;

import ir.maktab101.hw08.base.service.BaseEntityService;
import ir.maktab101.hw08.domain.Category;

import java.sql.SQLException;

public interface CategoryService extends BaseEntityService {
    Category[] getCategory() throws SQLException;
    boolean existByName(String name) throws SQLException;
}
