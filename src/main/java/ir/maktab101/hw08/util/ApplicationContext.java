package ir.maktab101.hw08.util;

import ir.maktab101.hw08.repository.*;
import ir.maktab101.hw08.repository.impl.*;
import ir.maktab101.hw08.service.*;
import ir.maktab101.hw08.service.impl.*;

public class ApplicationContext {
    private static final ApplicationContext applicationContext = new ApplicationContext();

    private CategoryRepository categoryRepository;

    private CategoryService categoryService;

    private ProductRepository productRepository;

    private ProductService productService;

    private BrandRepository brandRepository;

    private BrandService brandService;

    private ShareHolderRepository shareHolderRepository;

    private ShareHolderService shareHolderService;

    private UserRepository userRepository;

    private UserService userService;

    private ShareHolderBrandRepository shareHolderBrandRepository;

    private ShareHolderBrandService shareHolderBrandService;

    private ApplicationContext() {
    }

    public static ApplicationContext getInstance() {
        return applicationContext;
    }

    public CategoryRepository getCategoryRepository() {
        if (categoryRepository == null) {
            categoryRepository = new CategoryRepositoryImpl(
                    DataSource.getConnection()
            );
        }
        return categoryRepository;
    }

    public CategoryService getCategoryService() {
        if (categoryService == null) {
            categoryService = new CategoryServiceImpl(
                    getCategoryRepository()
            );
        }
        return categoryService;
    }

    public ProductRepository getProductRepository() {
        if (productRepository == null) {
            productRepository = new ProductRepositoryImpl(
                    DataSource.getConnection()
            );
        }
        return productRepository;
    }

    public ProductService getProductService() {
        if (productService == null) {
            productService = new ProductServiceImpl(
                    getProductRepository()
            );
        }
        return productService;
    }

    public BrandRepository getBrandRepository() {
        if (brandRepository == null) {
            brandRepository = new BrandRepositoryImpl(
                    DataSource.getConnection()
            );
        }
        return brandRepository;
    }

    public BrandService getBrandService() {
        if (brandService == null) {
            brandService = new BrandServiceImpl(
                    getBrandRepository()
            );
        }
        return brandService;
    }

    public ShareHolderRepository getShareHolderRepository() {
        if (shareHolderRepository == null) {
            shareHolderRepository = new ShareHolderRepositoryImpl(
                    DataSource.getConnection()
            );
        }
        return shareHolderRepository;
    }

    public ShareHolderService getShareHolderService() {
        if (shareHolderService == null) {
            shareHolderService = new ShareHolderServiceImpl(
                    getShareHolderRepository()
            );
        }
        return shareHolderService;
    }

    public UserRepository getUserRepository() {
        if (userRepository == null) {
            userRepository = new UserRepositoryImpl(
                    DataSource.getConnection()
            );
        }
        return userRepository;
    }

    public UserService getUserService() {
        if (userService == null) {
            userService = new UserServiceImpl(
                    getUserRepository()
            );
        }
        return userService;
    }

    public ShareHolderBrandRepository getShareHolderBrandRepository() {
        if (shareHolderBrandRepository == null) {
            shareHolderBrandRepository = new ShareHolderBrandRepositoryImpl(
                    DataSource.getConnection()
            );
        }
        return shareHolderBrandRepository;
    }

    public ShareHolderBrandService getShareHolderBrandService() {
        if (shareHolderBrandService == null) {
            shareHolderBrandService = new ShareHolderBrandServiceImpl(
                    getShareHolderBrandRepository()
            );
        }
        return shareHolderBrandService;
    }
}
