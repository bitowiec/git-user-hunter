package com.empik.interview.app.counter;

import org.springframework.context.annotation.Primary;
//import org.springframework.data.r2dbc.repository.Modifying;
//import org.springframework.data.r2dbc.repository.Query;
//import org.springframework.data.repository.query.Param;
//import org.springframework.data.repository.reactive.ReactiveCrudRepository;
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;

@Primary
//@Repository
public interface ReactiveUserCounter {
//public interface ReactiveUserCounter extends ReactiveCrudRepository<Audit, String>{
//    @Query(value = "SELECT DISTINCT TRUE WHERE LOGIN=:login")
//    Mono<Boolean> existsByLoginLikeIgnoreCase(String login);

//    @Modifying
//    @Transactional
//    @Query(value = "MERGE INTO AUDIT USING DUAL ON LOGIN=:login WHEN MATCHED THEN UPDATE SET REQUEST_COUNT=REQUEST_COUNT + 1 WHEN NOT MATCHED THEN INSERT (LOGIN, REQUEST_COUNT) VALUES (:login,1)")
//    void makeItCount(@Param("login") String login);
}
