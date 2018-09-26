package pl.coderslab.warsztat3krks04.model;

import pl.coderslab.warsztat3krks04.utils.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Solution {
    private long id;
    private String answer;
    private Date submissionDate;

    public static List<Solution> loadAll(long max) {
        List<Solution> result = new ArrayList<>();

        final String sql = "SELECT id, submission_date, answer " +
                "FROM solution " +
                "LIMIT ?";
        try(Connection connection = DbUtil.getConn();
            PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setLong(1, max);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Solution sol = getFromRS(rs);
                result.add(sol);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static Solution loadById(long id) {
        Solution result = null;

        final String sql = "SELECT id, submission_date, answer " +
                "FROM solution " +
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

    public Date getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(Date submissionDate) {
        this.submissionDate = submissionDate;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    private static Solution getFromRS(ResultSet rs) throws SQLException {
        Solution sol = new Solution();
        sol.setId(rs.getLong("id"));
        sol.setSubmissionDate(rs.getDate("submission_date"));
        sol.setAnswer(rs.getString("answer"));

        return sol;
    }
}
