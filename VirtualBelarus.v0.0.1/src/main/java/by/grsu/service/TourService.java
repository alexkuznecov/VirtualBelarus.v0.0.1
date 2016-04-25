package by.grsu.service;

import by.grsu.domain.Image;
import by.grsu.domain.Location;
import by.grsu.domain.Tour;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface TourService {

    @Results(value = {
            @Result(property = "id", column = "id", id = true),
            @Result(property = "title", column = "title"),
            @Result(property = "about", column = "about"),
            @Result(property = "location", column = "locationId", javaType = Location.class,
                one = @One(select = "by.grsu.service.LocationService.getLocationById", fetchType = FetchType.LAZY)),
            @Result(property = "preview", column = "previewId", javaType = Image.class,
                one = @One(select = "by.grsu.service.ImageService.getImageById", fetchType = FetchType.LAZY)),
            @Result(property = "scenes", column = "id", javaType = List.class,
                many = @Many(select = "by.grsu.service.SceneService.getScenesByTourId", fetchType = FetchType.LAZY))
    })
    @Select("select * from tour where id = #{id}")
    Tour getTourById(@Param(value = "id") Integer id);

    @Results(value = {
            @Result(property = "id", column = "id", id = true),
            @Result(property = "title", column = "title"),
            @Result(property = "about", column = "about"),
            @Result(property = "location", column = "locationId", javaType = Location.class,
                    one = @One(select = "by.grsu.service.LocationService.getLocationById", fetchType = FetchType.LAZY)),
            @Result(property = "preview", column = "previewId", javaType = Image.class,
                    one = @One(select = "by.grsu.service.ImageService.getImageById", fetchType = FetchType.LAZY)),
            @Result(property = "scenes", column = "id", javaType = List.class,
                    many = @Many(select = "by.grsu.service.SceneService.getScenesByTourId", fetchType = FetchType.LAZY))
    })
    @Select("select * from tour")
    List<Tour> getTours();

}
