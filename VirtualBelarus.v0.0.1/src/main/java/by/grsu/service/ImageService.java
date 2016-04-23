package by.grsu.service;

import by.grsu.domain.Image;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface ImageService {

    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "url", column = "url"),
            @Result(property = "path", column = "path")
    })
    @Select("select id,url,path from image where id = #{id}")
    Image  getImageById(@Param(value = "id") Integer id);

    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "url", column = "url"),
            @Result(property = "path", column = "path")
    })
    @Select("select id,url,path from image where avatarId = {#id}")
    Image  getImageByAvatarId(@Param(value = "id") Integer id);

}
