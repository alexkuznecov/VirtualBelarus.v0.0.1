package by.grsu.service;

import by.grsu.domain.InfoHotSpot;
import by.grsu.domain.TransitionHotSpot;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface TransitionHotSpotService {

    @Results(value = {
            @Result(property = "id", column = "id", id = true),
            @Result(property = "scenaId", column = "scenaId"),
            @Result(property = "infoHotSpot", column = "infoHotSpotId", javaType = InfoHotSpot.class,
                one = @One(select = "by.grsu.services.InfoHotSpotService.getInfoHotSpotsById", fetchType = FetchType.LAZY))
    })
    List<TransitionHotSpot> getTransitionHotSpotsByScenaId(@Param(value = "scenaId") Integer scenaId);

}
