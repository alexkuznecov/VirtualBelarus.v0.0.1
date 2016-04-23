package by.grsu.servlets;

import by.grsu.service.TokenService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LogoutServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        TokenService tokenService = (TokenService) ctx.getBean("tokenService");
        Integer token = Integer.parseInt(req.getHeader("token"));
        String login = tokenService.getLoginByToken(token);
        if (login != null) {
            tokenService.deleteToken(login);
        }
    }
}
