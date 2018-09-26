package pl.coderslab.warsztat3krks04.servlet.student;

import pl.coderslab.warsztat3krks04.model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "StudentEditFormServlet", urlPatterns = "/student/editform")
public class StudentEditFormServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idStr = request.getParameter("id");
        long id = Long.parseLong(idStr);

        Student student = Student.loadById(id);
        request.setAttribute("student", student);

        getServletContext()
                .getRequestDispatcher("/WEB-INF/views/student/editForm.jsp")
                .forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final  String idStr = request.getParameter("id");
        long id = Long.parseLong(idStr);
        final  String firstName = request.getParameter("first_name");
        final  String lastName = request.getParameter("last_name");
        Student student = new Student(id, firstName, lastName);
        Student.save(student);
        response.getWriter().println(student.getId());

        response.sendRedirect("/student/list");
    }
}
