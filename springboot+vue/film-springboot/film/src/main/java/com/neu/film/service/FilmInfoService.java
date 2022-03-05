package com.neu.film.service;

import com.neu.film.pojo.FilmInfoEntity;
import com.neu.film.pojo.ResultDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

public interface FilmInfoService {
    //JPA分页查询电影
    Page<FilmInfoEntity> findAll(Pageable pageable);
    //Mapper根据电影编号查询的电影
    FilmInfoEntity findFilmByFilmId1(int filmId);
    //JPA根据电影编号查询的电影
    FilmInfoEntity findFilmByFilmId2(int filmId);
    //删除电影
    boolean delFilm(Integer filmId);
    //添加电影
    boolean addFilm(FilmInfoEntity filmInfoEntity);
    //文件上传逻辑
    ResultDTO<FilmInfoEntity> uploadResult(MultipartFile file,Integer filmId)
    throws Exception;

    //修改电影
    boolean updateFilm(FilmInfoEntity filmInfoEntity);
}
