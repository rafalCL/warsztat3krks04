package pl.coderslab.warsztat3krks04.servlet.student;

import pl.coderslab.warsztat3krks04.model.Solution;
import pl.coderslab.warsztat3krks04.model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "StudentDetailsServlet", urlPatterns = "/student/details")
public class StudentDetailsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idStr = request.getParameter("id");
        long id = Long.parseLong(idStr);

        Student student = Student.loadById(id);
        request.setAttribute("student", student);

        getServletContext()
                .getRequestDispatcher("/WEB-INF/views/student/details.jsp")
                .forward(request, response);
    }
}
