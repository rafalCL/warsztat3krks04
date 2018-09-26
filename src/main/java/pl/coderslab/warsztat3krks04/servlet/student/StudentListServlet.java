package pl.coderslab.warsztat3krks04.servlet.student;

import pl.coderslab.warsztat3krks04.model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "StudentListServlet", urlPatterns = "/student/list")
public class StudentListServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Student> students = Student.loadAll(999999999);
        request.setAttribute("students" , students);

        getServletContext()
                .getRequestDispatcher("/WEB-INF/views/student/list.jsp")
                .forward(request, response);
    }
}
