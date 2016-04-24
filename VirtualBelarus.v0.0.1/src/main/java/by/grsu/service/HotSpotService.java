package by.grsu.service;

import by.grsu.domain.HotSpot;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface HotSpotService {

    @Results(value = {
            @Result(property = "id", column = "id", id = true),
            @Result(property = "title", column = "title"),
            @Result(property = "about", column = "about"),
            @Result(property = "width", column = "width"),
            @Result(property = "height", column = "height"),
            @Result(property = "x", column = "x"),
            @Result(property = "y", column = "y")
    })
    @Select("select * from hotSpot where id = #{id}")
    HotSpot getHotSpotById(@Param(value = "id") Integer id);
}
