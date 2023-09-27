package ir.maktab101.hw08.service;

import ir.maktab101.hw08.base.service.BaseEntityService;
import ir.maktab101.hw08.domain.User;

import java.sql.SQLException;

public interface UserService extends BaseEntityService {
    boolean login(String username, String password) throws SQLException;
}
