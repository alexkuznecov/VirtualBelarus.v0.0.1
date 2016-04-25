package by.grsu.servlets;

import by.grsu.domain.Token;
import by.grsu.domain.Tour;
import by.grsu.service.TourService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ToursServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Token token = new Token();
        token.setToken(Integer.parseInt(req.getHeader("token")));

        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        TourService tourService = (TourService) ctx.getBean("tourService");

        List<Tour> tours = tourService.getTours();
        resp.setHeader("token", token.getToken().toString());
        resp.setContentType("text/html");
        resp.setCharacterEncoding("ISO-8859-1");
    }
}
