package com.neu.film.mapper;

import com.neu.film.pojo.UserEntity;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface UserMapper {

    @Select("select U_ID uId,U_NAME uName,U_PWD uPwd,U_BIRTH uBirth,U_MOBILE uMobile from user where U_ID = #{uId}")
    UserEntity findUserById(int uId);
    //根据用户编号 删除用户
    @Delete("DELETE FROM user where U_ID=#{uId}")
    int delUserByUserId(Integer uId);
    //添加电影方法 需要编写完整sql文
    @Insert("insert into user (U_NAME,U_PWD,U_MOBILE) values(#{uName},#{uPwd},#{uMobile})")
    int addUser(UserEntity userEntity);

    @Update("update user set U_NAME = #{uName},U_MOBILE = #{uMobile} where U_ID = #{uId}")
    int updateUser(UserEntity userEntity);
}
