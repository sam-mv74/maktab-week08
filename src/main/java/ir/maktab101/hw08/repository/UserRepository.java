package ir.maktab101.hw08.repository;

import ir.maktab101.hw08.base.repository.BaseEntityRepository;
import ir.maktab101.hw08.domain.User;

import java.sql.SQLException;

public interface UserRepository extends BaseEntityRepository {
    boolean existByUsernameAndPassword(String username, String password) throws SQLException;
}
