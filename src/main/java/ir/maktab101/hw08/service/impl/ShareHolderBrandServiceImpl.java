package ir.maktab101.hw08.service.impl;

import ir.maktab101.hw08.repository.ShareHolderBrandRepository;
import ir.maktab101.hw08.repository.ShareHolderRepository;
import ir.maktab101.hw08.service.ShareHolderBrandService;

import java.sql.SQLException;

public class ShareHolderBrandServiceImpl implements ShareHolderBrandService {
    private ShareHolderBrandRepository shareHolderBrandRepository;
    public ShareHolderBrandServiceImpl(ShareHolderBrandRepository shareHolderBrandRepository) {
        this.shareHolderBrandRepository = shareHolderBrandRepository;
    }


    @Override
    public int save(Long shareHolderId, Long brandId) throws SQLException {
        return shareHolderBrandRepository.save(shareHolderId,brandId);
    }

    @Override
    public int delete(Long shareHolderId, Long brandId) throws SQLException {
        return shareHolderBrandRepository.delete(shareHolderId,brandId);
    }
}
