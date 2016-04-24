package by.grsu.service;

import by.grsu.domain.Location;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface LocationService {

    @Results(value = {
            @Result(property = "id", column = "id", id = true),
            @Result(property = "latitude", column = "latitude"),
            @Result(property = "longitude", column = "longitude")
    })
    @Select("select * from location where id = #{id}")
    Location getLocationById(@Param(value = "id") Integer id);

}
