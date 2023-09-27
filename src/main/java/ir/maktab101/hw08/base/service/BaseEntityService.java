package ir.maktab101.hw08.base.service;

import ir.maktab101.hw08.base.domain.BaseEntity;

import java.sql.SQLException;

public interface BaseEntityService {

    BaseEntity[] findAll() throws SQLException;

    BaseEntity findById(Long id) throws SQLException;

    void deleteById(Long id) throws SQLException;

    long count() throws SQLException;

    BaseEntity save(BaseEntity entity) throws SQLException;

    BaseEntity update(BaseEntity entity) throws SQLException;

    boolean existsById(Long id) throws SQLException;
}
