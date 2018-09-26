package pl.coderslab.warsztat3krks04.servlet;

import pl.coderslab.warsztat3krks04.model.Solution;
import pl.coderslab.warsztat3krks04.utils.DbUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "HomeServlet", urlPatterns = "/")
public class HomeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Solution> sols = Solution.loadAll(5);
        request.setAttribute("solutions", sols);

        getServletContext()
                .getRequestDispatcher("/home.jsp")
                .forward(request, response);
    }
}
