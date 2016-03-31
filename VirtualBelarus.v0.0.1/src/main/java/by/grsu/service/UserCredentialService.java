package by.grsu.service;

import by.grsu.domain.UserCredential;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface UserCredentialService {

    @Results(value = {
            @Result(property = "login", column = "login"),
            @Result(property = "password", column = "password")
    })
    @Select("select login,password from userCredentials where login = #{login} and password = #{password}")
    UserCredential getRegisteredUserCredential(@Param(value = "login") String login, @Param(value = "password") String password);


}
