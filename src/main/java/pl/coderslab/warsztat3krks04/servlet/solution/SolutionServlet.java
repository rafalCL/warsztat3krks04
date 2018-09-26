package pl.coderslab.warsztat3krks04.servlet.solution;

import pl.coderslab.warsztat3krks04.model.Solution;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SolutionServlet", urlPatterns = "/solution/details")
public class SolutionServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idStr = request.getParameter("id");
        long id = Long.parseLong(idStr);

        Solution sol = Solution.loadById(id);
        request.setAttribute("solution", sol);

        getServletContext()
                .getRequestDispatcher("/WEB-INF/views/solution/details.jsp")
                .forward(request, response);
    }
}
