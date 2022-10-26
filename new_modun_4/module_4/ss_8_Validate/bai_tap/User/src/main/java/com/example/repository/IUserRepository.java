package com.example.repository;

import com.example.model.User;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {

    @Query(value = "select * from user where first_name like %:keyword%", nativeQuery = true)
    Page<User> searByName(@Param("keyword") String keyword, Pageable pageable);
}
