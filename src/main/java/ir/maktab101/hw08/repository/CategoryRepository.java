package ir.maktab101.hw08.repository;

import ir.maktab101.hw08.base.repository.BaseEntityRepository;

import java.sql.SQLException;

public interface CategoryRepository extends BaseEntityRepository {
    boolean existByName(String name) throws SQLException;
}
