package by.grsu.service;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface TokenService {

    @Select("select token from tokens where login = #{login}")
    Integer getTokenByLogin(@Param(value = "login") String login);

    @Insert("insert into tokens(token, login) values (#{token}, #{login})")
    void insertToken(@Param(value = "token") Integer token, @Param(value = "login") String login);

    @Delete("delete into tokens where login = #{login}")
    void deleteToken(@Param(value = "login") String login);
}
