package by.grsu.servlets;

import by.grsu.domain.Token;
import by.grsu.domain.User;
import by.grsu.domain.UserCredential;
import by.grsu.service.ImageService;
import by.grsu.service.TokenService;
import by.grsu.service.UserCredentialService;
import by.grsu.service.UserService;
import org.apache.commons.codec.binary.Base64;
import org.json.JSONObject;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class LoginServlet extends HttpServlet {;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String coddedData = req.getHeader("Authorization");

        byte[] authStr = Base64.decodeBase64(coddedData);
        String normalOut = new String(authStr, "UTF-8");

        Pattern patttern = Pattern.compile("(.*):(.*)");
        Matcher matcher = patttern.matcher(normalOut);

        String login = "", password = "";

        while (matcher.find()) {
            login = matcher.group(1);
            password = matcher.group(2);
        }

        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserCredentialService userCredentialService = (UserCredentialService) ctx.getBean("userCredentialService");
        UserService userService = (UserService) ctx.getBean("userService");
        TokenService tokenService = (TokenService) ctx.getBean("tokenService");
        ImageService imageService = (ImageService) ctx.getBean("imageService");

        UserCredential userCredential = userCredentialService.getRegisteredUserCredential(login, password);
        User registeredUser;
        if (userCredential != null) {
            registeredUser = userService.getUserByLogin(userCredential.getLogin());
        } else {
            registeredUser = null;
        }

        if (registeredUser != null) {
            Token tg = new Token();
            tg.generateToken(registeredUser.getName(), registeredUser.getEmail());
            tokenService.insertToken(tg.getToken(), registeredUser.getLogin());
            resp.setHeader("token", tg.getToken().toString());
            resp.setContentType("text/html");
            resp.setCharacterEncoding("ISO-8859-1");
            JSONObject user = new JSONObject();
            user.put("id", registeredUser.getId());
            user.put("name", registeredUser.getName());
            user.put("country", registeredUser.getCountry());
            user.put("city", registeredUser.getCity());
            user.put("email", registeredUser.getEmail());
            JSONObject image = new JSONObject();
            image.put("id", registeredUser.getAvatar().getId());
            image.put("url", registeredUser.getAvatar().getUrl());
            image.put("path",registeredUser.getAvatar().getPath());
            user.put("image", image);
            user.write(resp.getWriter());
            System.out.println(user.toString());
        } else {
            resp.sendError(200, "Not found");
        }
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
