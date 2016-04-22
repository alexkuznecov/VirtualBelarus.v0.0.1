package by.grsu.service;

import by.grsu.domain.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface UserService {

    @Results(value = {
            @Result(property = "name", column = "name"),
            @Result(property = "telephone", column = "telephone"),
            @Result(property = "email", column = "email"),
            @Result(property = "login", column = "login")
    })
    @Select("select name,surname,telephone,email,login from users where login =#{login}")
    User getUserByLogin(@Param(value = "login") String login);

}
