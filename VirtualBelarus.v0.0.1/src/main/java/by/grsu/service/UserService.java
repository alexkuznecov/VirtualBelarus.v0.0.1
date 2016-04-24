package by.grsu.service;

import by.grsu.domain.Image;
import by.grsu.domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

public interface UserService {

    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "country", column = "country"),
            @Result(property = "city", column = "city"),
            @Result(property = "email", column = "email"),
            @Result(property = "login", column = "login"),
            @Result(property = "avatar", column = "avatarId", javaType = Image.class,
            one = @One(select = "by.grsu.service.ImageService.getImageById", fetchType = FetchType.LAZY))
    })
    @Select("select id,name,country,city,email,login,avatarId from users where login =#{login}")
    User getUserByLogin(@Param(value = "login") String login);

}
