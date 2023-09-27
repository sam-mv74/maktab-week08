package ir.maktab101.hw08.service.impl;

import ir.maktab101.hw08.base.repository.BaseEntityRepository;
import ir.maktab101.hw08.base.service.impl.BaseEntityServiceImpl;
import ir.maktab101.hw08.service.ShareHolderService;

public class ShareHolderServiceImpl extends BaseEntityServiceImpl
        implements ShareHolderService {
    public ShareHolderServiceImpl(BaseEntityRepository baseRepository) {
        super(baseRepository);
    }
}
