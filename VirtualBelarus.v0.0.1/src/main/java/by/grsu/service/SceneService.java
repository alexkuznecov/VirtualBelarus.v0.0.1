package by.grsu.service;

import by.grsu.domain.Image;
import by.grsu.domain.Scene;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface SceneService {

    @Results(value = {
            @Result(property = "id", column = "id", id = true),
            @Result(property = "title", column = "title"),
            @Result(property = "about", column = "description"),
            @Result(property = "sceneType", column = "type"),
            @Result(property = "preview", column = "previewId", javaType = Image.class,
                    one = @One(select = "by.grsu.service.ImageService.getImageById", fetchType = FetchType.LAZY)),
            @Result(property = "transitionHotSpots", column = "id", javaType = List.class,
                    many = @Many(select = "by.grsu.service.TransitionHotSpotService.getTransitionHotSpotsByScenaId", fetchType = FetchType.LAZY)),
            @Result(property = "hotSpots", column = "id", javaType = List.class,
                    many = @Many(select = "by.grsu.service.InfoHotSpotService.getInfoHotSpotsByScenaId", fetchType = FetchType.LAZY)),
            @Result(property = "images", column = "id", javaType = List.class,
                    many = @Many(select = "by.grsu.service.ScenaImageService.getSceneImagesByScenaId", fetchType = FetchType.LAZY))
    })
    @Select("select * from scena where id = #{id}")
    Scene getSceneById(@Param(value = "id") Integer id);

    @Results(value = {
            @Result(property = "id", column = "id", id = true),
            @Result(property = "title", column = "title"),
            @Result(property = "about", column = "description"),
            @Result(property = "sceneType", column = "type"),
            @Result(property = "preview", column = "previewId", javaType = Image.class,
                    one = @One(select = "by.grsu.service.ImageService.getImageById", fetchType = FetchType.LAZY)),
            @Result(property = "transitionHotSpots", column = "id", javaType = List.class,
                    many = @Many(select = "by.grsu.service.TransitionHotSpotService.getTransitionHotSpotsByScenaId", fetchType = FetchType.LAZY)),
            @Result(property = "hotSpots", column = "id", javaType = List.class,
                    many = @Many(select = "by.grsu.service.InfoHotSpotService.getInfoHotSpotsByScenaId", fetchType = FetchType.LAZY)),
            @Result(property = "images", column = "id", javaType = List.class,
                    many = @Many(select = "by.grsu.service.ScenaImageService.getSceneImagesByScenaId", fetchType = FetchType.LAZY))
    })
    @Select("select * from scena where tourId = #{id}")
    List<Scene> getScenesByTourId(@Param(value = "id") Integer id);
}
