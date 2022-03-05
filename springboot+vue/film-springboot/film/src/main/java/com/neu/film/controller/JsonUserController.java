package com.neu.film.controller;

import com.neu.film.pojo.ResultDTO;
import com.neu.film.pojo.UserEntity;
import com.neu.film.service.UserService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/json/user")
public class JsonUserController {

    @Autowired
    UserService userService;
    /*
    访问地址如下
    http://localhost:8090/film/json/user/showUsers/1
     */
    @RequestMapping("/showUsers/{currPage}")
    public Page<UserEntity> showUsers(Model model, @PathVariable Integer currPage)throws  Exception{
        //注意 使用分页插件的时候 当前页码是1 需要Pageable需要-1
        //size 是每页显示条目数
        Pageable pageable = PageRequest.of(currPage-1,3);
        Page<UserEntity> pages = userService.findAll(pageable);
        return pages;
    }
    /*
    Mapper中  根据用户编号查用户
    */
    /*
    访问地址：http://localhost:8090/film/json/user/showUser/1
     */
    @GetMapping("/showUser/{uId}")
    public UserEntity showFilm(@PathVariable Integer uId)throws Exception{
        UserEntity filmInfoEntity = userService.findUserByUserId(uId);
        return filmInfoEntity;
    }
    /*
    用户删除
     */
    /*
    访问地址：http://localhost:8090/film/json/user/delUser/5
     */
    @GetMapping("/delUser/{uId}")
    public String delFilm(@PathVariable Integer uId)throws Exception{
        System.out.println("获取到的用户编号："+uId);
        //调用删除方法
        boolean result = userService.delUser(uId);
        if(result){
            return "success";
        }
        return "fail";
    }
    /*
    用户添加
     */
    /*
    访问地址：http://localhost:8090/film/json/user/addUser
     */
    @RequestMapping("/addUser")
    public String addUser(@RequestBody UserEntity userEntity) throws Exception{
        System.out.println("VUE发送的数据"+userEntity.toString());
        boolean result = userService.addUser(userEntity);
        if(result){
            return "success";
        }
        return "fail";
    }

    @PostMapping("/updateUser")
    public String updateUser(@RequestBody UserEntity userEntity) throws Exception{
        System.out.println("Vue发送的内容:"+userEntity.toString());
        boolean result = userService.updateUser(userEntity);
        if(result){
            return "success";
        }
        return  "fail";
    }
    /*
使用DTO  作为数据传输载体  携带数据
 */
    @RequestMapping("/uploadUserImage/{uId}")
    public ResultDTO<UserEntity> uploadFilmImageMain2(MultipartFile file, @PathVariable Integer uId)throws Exception{
        //调用Service中 上传方法
        ResultDTO<UserEntity> userDTO = userService.uploadResult(file,uId);
        return userDTO;
    }
}
