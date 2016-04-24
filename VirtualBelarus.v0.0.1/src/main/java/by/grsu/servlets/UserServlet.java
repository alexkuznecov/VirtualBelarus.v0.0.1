package by.grsu.servlets;

import by.grsu.domain.Token;
import by.grsu.domain.User;
import by.grsu.service.ImageService;
import by.grsu.service.TokenService;
import by.grsu.service.UserService;
import org.json.JSONObject;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Token token = new Token();
        token.setToken(Integer.parseInt(req.getHeader("token")));

        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService) ctx.getBean("userService");
        TokenService tokenService = (TokenService) ctx.getBean("tokenService");
        ImageService imageService = (ImageService) ctx.getBean("imageService");

        User user = new User();
        user.setLogin(tokenService.getLoginByToken(token.getToken()));
        if (user.getLogin() != null) {
            user = userService.getUserByLogin(user.getLogin());
            resp.setHeader("token", token.getToken().toString());
            resp.setContentType("text/html");
            resp.setCharacterEncoding("ISO-8859-1");
            JSONObject userData = new JSONObject();
            userData.put("id", user.getId());
            userData.put("name", user.getName());
            userData.put("country", user.getCountry());
            userData.put("city", user.getCity());
            userData.put("email", user.getEmail());
            JSONObject image = new JSONObject();
            image.put("id", user.getAvatar().getId());
            image.put("url", user.getAvatar().getUrl());
            image.put("path",user.getAvatar().getPath());
            userData.put("image", image);
            userData.write(resp.getWriter());
            System.out.println(user.toString());
        } else {
            resp.sendError(200, "Not found");
        }
    }
}
