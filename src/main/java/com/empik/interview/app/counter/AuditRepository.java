package com.empik.interview.app.counter;

import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Primary
@Repository
public interface AuditRepository extends CrudRepository<Audit, String>, UserCounter<Audit> {
    Audit findByLogin(String login);

    @Modifying
    @Transactional
    @Query(value = "MERGE INTO AUDIT USING DUAL ON LOGIN=:login WHEN MATCHED THEN UPDATE SET REQUEST_COUNT=REQUEST_COUNT + 1 WHEN NOT MATCHED THEN INSERT (LOGIN, REQUEST_COUNT) VALUES (:login,1)",
            nativeQuery = true)
    Integer makeItCount(@Param("login") String login);
}
