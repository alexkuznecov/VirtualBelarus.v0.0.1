package by.grsu.service;

import by.grsu.domain.Image;
import by.grsu.domain.SceneImage;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface ScenaImageService {

    @Results(value = {
            @Result(property = "id", column = "id", id = true),
            @Result(property = "scenaId", column = "scenaId"),
            @Result(property = "image", column = "imageId", javaType = Image.class,
                    one = @One(select = "by.grsu.service.ImageService.getImageById", fetchType = FetchType.LAZY))
    })
    @Select("select * from scenaImage where scenaId = #{scenaId}")
    List<SceneImage> getSceneImagesByScenaId(@Param(value = "scenaId") Integer scenaId);

}
