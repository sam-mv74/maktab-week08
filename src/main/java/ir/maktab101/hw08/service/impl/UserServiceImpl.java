package ir.maktab101.hw08.service.impl;

import ir.maktab101.hw08.base.repository.BaseEntityRepository;
import ir.maktab101.hw08.base.service.impl.BaseEntityServiceImpl;
import ir.maktab101.hw08.repository.UserRepository;
import ir.maktab101.hw08.service.UserService;

import java.sql.SQLException;

public class UserServiceImpl extends BaseEntityServiceImpl
        implements UserService {
    public UserServiceImpl(BaseEntityRepository baseRepository) {
        super(baseRepository);
    }
    //register
    //login
    //add a product

    @Override
    public boolean login(String username, String password) throws SQLException {
        return ((UserRepository) baseRepository).existByUsernameAndPassword(username,password);
    }
}
