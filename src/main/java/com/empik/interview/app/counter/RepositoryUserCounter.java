package com.empik.interview.app.counter;

//import org.springframework.data.repository.query.Param;

//import javax.transaction.Transactional;

//@Primary
//@Repository
public interface RepositoryUserCounter /*extends CrudRepository<Audit, String>, UserCounter<Audit>*/ {
    boolean existsByLoginLikeIgnoreCase(String login);
//    @Modifying
//    @Transactional
//    @Query(value = "MERGE INTO AUDIT USING DUAL ON LOGIN=:login WHEN MATCHED THEN UPDATE SET REQUEST_COUNT=REQUEST_COUNT + 1 WHEN NOT MATCHED THEN INSERT (LOGIN, REQUEST_COUNT) VALUES (:login,1)",
//            nativeQuery = true)
//    Integer makeItCount(@Param("login") String login);
}
