package by.grsu.servlets;

import by.grsu.domain.User;
import by.grsu.domain.UserCredential;
import by.grsu.service.UserCredentialService;
import by.grsu.service.UserService;
import by.grsu.service.impl.UserCredentialServiceImpl;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private UserCredentialServiceImpl userCredentialService;

//    @Autowired
//    private UserServiceImpl userService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String coddedData = req.getHeader("Authorization");

        byte[] authStr = Base64.decodeBase64(coddedData);
        String normalOut = new String(authStr, "UTF-8");

        Pattern patttern = Pattern.compile("(.*):(.*)");
        Matcher matcher = patttern.matcher(normalOut);

        String login = "",password="";

        while (matcher.find()) {
            login = matcher.group(1);
            password = matcher.group(2);
        }

        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserCredentialService userCredentialService = (UserCredentialService)ctx.getBean("userCredentialService");
        UserService userService = (UserService)ctx.getBean("userService");

        UserCredential userCredential = userCredentialService.getRegisteredUserCredential(login,password);

        if (userCredential != null) {
            User registeredUser = userService.getUserByLogin(userCredential.getLogin());
            String str = registeredUser.getName();
        } else {
            int vasja = 44;
            vasja++;
        }

        int george = 12;
        george++;
        resp.setHeader("Head","hjhkhjkh");


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
