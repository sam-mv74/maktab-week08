package ir.maktab101.hw08.service;

import ir.maktab101.hw08.base.service.BaseEntityService;
import ir.maktab101.hw08.domain.Brand;

import java.sql.SQLException;

public interface BrandService extends BaseEntityService {
    Brand[] getBrands() throws SQLException;
    boolean existByName(String name) throws SQLException;

}
