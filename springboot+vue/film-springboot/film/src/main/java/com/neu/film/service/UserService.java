package com.neu.film.service;

import com.neu.film.pojo.ResultDTO;
import com.neu.film.pojo.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface UserService {
    //分页查询用户
    Page<UserEntity> findAll(Pageable pageable);
    //mapper根据用户编号查询用户
    UserEntity findUserByUserId(int uId);
    //删除用户
    boolean delUser(Integer uId);
    //添加用户
    boolean addUser(UserEntity userEntity);
    //文件上传逻辑
    ResultDTO<UserEntity> uploadResult(MultipartFile file, Integer uId) throws Exception;
    boolean updateUser(UserEntity userEntity);
}
