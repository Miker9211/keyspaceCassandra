package com.demoach2.ach2.repository;

import com.demoach2.ach2.entity.User1;
import org.springframework.data.cassandra.repository.CassandraRepository;

import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;


@Repository
public interface UserRepository1 extends CassandraRepository<User1, Integer>  {
    @Query("SELECT * FROM demoach.tabledemoach WHERE creation_date >= :des AND creation_date <= :has ALLOW FILTERING")
    List<User1> findByCreation_dateBetween(@Param("des") LocalDate des, @Param("has") LocalDate has);
}
