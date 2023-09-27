package ir.maktab101.hw08.service.impl;

import ir.maktab101.hw08.base.domain.BaseEntity;
import ir.maktab101.hw08.base.repository.BaseEntityRepository;
import ir.maktab101.hw08.base.service.impl.BaseEntityServiceImpl;
import ir.maktab101.hw08.service.ProductService;

import java.sql.SQLException;

public class ProductServiceImpl extends BaseEntityServiceImpl
        implements ProductService {
    public ProductServiceImpl(BaseEntityRepository baseRepository) {
        super(baseRepository);

    }

}
