package com.neu.film.mapper;

import com.neu.film.pojo.FilmInfoEntity;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface FilmInfoMapper {

    @Select("SELECT FILM_ID filmId,FILM_NAME filmName,FILM_RELEASE_TIME filmReleaseTime," +
            "FILM_IMAGE_MAIN filmImageMain,FILM_IMAGE_OTHER filmImageOther,FILM_VIDEO filmVideo," +
            "FILM_VIDEO_URL filmVideoUrl,FILM_DIRECOTR filmDirecotr,FILM_PERFORMER filmPerformer" +
            " FROM film_info WHERE FILM_ID = #{filmId}")
    FilmInfoEntity findFilmById(int filmId);
    //根据电影编号 删除电影
    @Delete("DELETE FROM film_info where film_id=#{filmId}")
    int delFilmByFilmId(Integer filmId);
    //添加电影方法   SQL 编写完整   或者  使用之前讲的  逆向生成Mapper文件
    @Insert("insert into film_info (FILM_NAME,FILM_RELEASE_TIME) " +
            "values (#{filmName},#{filmReleaseTime})")
    int addFilm(FilmInfoEntity filmInfoEntity);

//    @Update("update film_info set FILM_NAME = #{filmName},FILM_RELEASE_TIME = #{filmReleaseTime},FILM_DIRECOTR = #{filmDirecotr}," +
//            "FILM_PERFORMER = #{filmPerformer},FILM_IMAGE_MAIN = #{filmImageMain} where FILM_ID = #{filmId}")
    @Update("update film_info set FILM_NAME = #{filmName},FILM_RELEASE_TIME = #{filmReleaseTime} where FILM_ID = #{filmId}")
    int updateFilm(FilmInfoEntity filmInfoEntity);
}
