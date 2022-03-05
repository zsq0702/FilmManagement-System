package com.neu.film.mapper;

import com.neu.film.pojo.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserEntityRepository extends JpaRepository<UserEntity,Long> {
    //JPA分页查询
    Page<UserEntity> findAll(Pageable pageable);
//    UserEntity findByUserId(int uId);
}
