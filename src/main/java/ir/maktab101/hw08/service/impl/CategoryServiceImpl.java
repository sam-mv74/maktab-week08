package ir.maktab101.hw08.service.impl;

import ir.maktab101.hw08.base.repository.BaseEntityRepository;
import ir.maktab101.hw08.base.service.impl.BaseEntityServiceImpl;
import ir.maktab101.hw08.domain.Category;
import ir.maktab101.hw08.repository.CategoryRepository;
import ir.maktab101.hw08.service.CategoryService;

import java.sql.SQLException;

public class CategoryServiceImpl extends BaseEntityServiceImpl
        implements CategoryService {
    public CategoryServiceImpl(BaseEntityRepository baseRepository) {
        super(baseRepository);
    }

    @Override
    public Category[] getCategory() throws SQLException {
        return (Category[]) super.findAll();
    }

    @Override
    public boolean existByName(String name) throws SQLException {
        return ((CategoryRepository)(baseRepository)).existByName(name);
    }
}
