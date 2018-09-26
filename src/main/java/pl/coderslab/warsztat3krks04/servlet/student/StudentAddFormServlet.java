package pl.coderslab.warsztat3krks04.servlet.student;

import pl.coderslab.warsztat3krks04.model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "StudentAddFormServlet", urlPatterns = "/student/addform")
public class StudentAddFormServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext()
                .getRequestDispatcher("/WEB-INF/views/student/addForm.jsp")
                .forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final  String firstName = request.getParameter("first_name");
        final  String lastName = request.getParameter("last_name");
        Student student = new Student(firstName, lastName);
        Student.insert(student);
        response.getWriter().println(student.getId());
    }
}
