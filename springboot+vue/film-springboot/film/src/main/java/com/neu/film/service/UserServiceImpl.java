package com.neu.film.service;

import com.neu.film.mapper.UserEntityRepository;
import com.neu.film.mapper.UserMapper;
import com.neu.film.pojo.ResultDTO;
import com.neu.film.pojo.UserEntity;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service("/UserService")
public class UserServiceImpl implements UserService{

    private static final org.slf4j.Logger Logger = LoggerFactory.getLogger(UserServiceImpl.class);
    @Resource
    UserEntityRepository userEntityRepository;
    @Resource
    UserMapper userMapper;

    @Override
    public Page<UserEntity> findAll(Pageable pageable) {
        return userEntityRepository.findAll(pageable);
    }

    @Override
    public UserEntity findUserByUserId(int uId) {
        return userMapper.findUserById(uId);
    }

    @Override
    public boolean delUser(Integer uId) {
        int i = userMapper.delUserByUserId(uId);
        if(i>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean addUser(UserEntity userEntity) {
        int i = userMapper.addUser(userEntity);
        if(i>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean updateUser(UserEntity userEntity){
        int i =userMapper.updateUser(userEntity);
        if(i>0){
            return true;
        }
        return false;
    }

    @Override
    public ResultDTO<UserEntity> uploadResult(MultipartFile file, Integer uId) throws Exception {
        ResultDTO<UserEntity> uploadResult = new ResultDTO<UserEntity>();
        if (file.isEmpty()){
            //处理文件未得到的DTO
            uploadResult.setCode(1001);
            uploadResult.setMsg("上传文件为空");
        }else {
            String fileName = file.getOriginalFilename();
            Logger.info("上传文件名："+fileName);
            String suffixName = fileName.substring(fileName.lastIndexOf("."));
            Logger.info("上传后缀"+suffixName);
            String prefixName = fileName.substring(0,fileName.indexOf("."));
            Logger.info("上传前缀"+prefixName);
            //文件上传地址  将图片地址拼接
            //文件同名 怎么办？  使用UUID 改造  文件
            String newFileName = UUID.randomUUID()+suffixName;
            System.out.println("重构后的文件名"+newFileName) ;
            String imagePath = "E:\\upload_2020\\film\\user\\"+uId+"\\image\\"+prefixName+suffixName;
            Logger.info("图片地址"+imagePath);
            File dest = new File(imagePath);
            //判断上级文件是否存在
            if(!dest.getParentFile().exists()){
                dest.getParentFile().mkdirs();
            }
            //上传文件
            try {
                file.transferTo(dest);
            }catch (IOException e){
                e.printStackTrace();
                //处理报错的DTO
                uploadResult.setCode(1002);
                uploadResult.setMsg("上传文件失败");
            }
            //处理 成功的DTO
            uploadResult.setCode(8888);
            uploadResult.setMsg("上传文件成功");
            UserEntity userEntity = new UserEntity();
            String imgUrl = "http://localhost:8090/film/resource/"+uId+"/image/"+prefixName+suffixName;
            System.out.println("图片在服务器的地址"+imgUrl);
            userEntity.setuImg(imgUrl);
            List<UserEntity> datas = new ArrayList<UserEntity>();
            datas.add(userEntity);
            uploadResult.setData(datas);
        }
        return uploadResult;
    }

}
