package ir.maktab101.hw08.service.impl;

import ir.maktab101.hw08.base.repository.BaseEntityRepository;
import ir.maktab101.hw08.base.service.impl.BaseEntityServiceImpl;
import ir.maktab101.hw08.domain.Brand;
import ir.maktab101.hw08.repository.BrandRepository;
import ir.maktab101.hw08.service.BrandService;

import java.sql.SQLException;

public class BrandServiceImpl extends BaseEntityServiceImpl
        implements BrandService {
    public BrandServiceImpl(BaseEntityRepository baseRepository) {
        super(baseRepository);
    }

    @Override
    public Brand[] getBrands() throws SQLException {
        return (Brand[]) super.findAll();
    }
    @Override
    public boolean existByName(String name) throws SQLException {
        return ((BrandRepository)(baseRepository)).existByName(name);
    }
}
