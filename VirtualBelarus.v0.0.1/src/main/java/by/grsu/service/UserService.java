package by.grsu.service;

import by.grsu.domain.Image;
import by.grsu.domain.User;
import org.apache.ibatis.annotations.*;

public interface UserService {

    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "country", column = "city"),
            @Result(property = "email", column = "email"),
            @Result(property = "login", column = "login"),
            @Result(property = "avatar", column = "avatarId", javaType = Image.class,
            one = @One(select = "by.grsu.service.ImageService.getImageById"))
    })
    @Select("select name,surname,telephone,email,login from users where login =#{login}")
    User getUserByLogin(@Param(value = "login") String login);

}
