package by.grsu.service;

import by.grsu.domain.HotSpot;
import by.grsu.domain.Image;
import by.grsu.domain.InfoHotSpot;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface InfoHotSpotSerivce {

    @Results(value = {
            @Result(property = "id", column = "id", id=true),
            @Result(property = "hotSpot", column = "hotSpotId", javaType = HotSpot.class,
                    one = @One(select = "by.grsu.service.HotSpotService.getHotSpotById")),
            @Result(property = "image", column = "imageId", javaType = Image.class,
                    one = @One(select = "by.grsu.service.ImageService.getImageById"))
    })
    @Select("select * from infoHotSpot where scenaId = #{scenaId}")
    List<InfoHotSpot> getInfoHotSpotsByScenaId(@Param(value = "scenaId") Integer scenaId);

}
