package pl.coderslab.warsztat3krks04.model;

import pl.coderslab.warsztat3krks04.utils.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Student {
    private long id;
    private String firstName;
    private String lastName;

    public static List<Student> loadAll(long max) {
        List<Student> result = new ArrayList<>();

        final String sql = "SELECT id, first_name, last_name " +
                "FROM student " +
                "LIMIT ?";
        try(Connection connection = DbUtil.getConn();
            PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setLong(1, max);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Student sol = getFromRS(rs);
                result.add(sol);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static Student loadById(long id) {
        Student result = null;

        final String sql = "SELECT id, first_name, last_name " +
                "FROM student " +
                "WHERE id=?";
        try(Connection connection = DbUtil.getConn();
            PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                result = getFromRS(rs);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    private static Student getFromRS(ResultSet rs) throws SQLException {
        Student student = new Student();
        student.setId(rs.getLong("id"));
        student.setFirstName(rs.getString("first_name"));
        student.setLastName(rs.getString("last_name"));

        return student;
    }
}
