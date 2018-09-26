package pl.coderslab.warsztat3krks04.model;

import pl.coderslab.warsztat3krks04.utils.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    private long id;
    private String answer;

    public static List<Solution> loadAll(long max) {
        List<Solution> result = new ArrayList<>();

        final String sql = "SELECT id, answer " +
                "FROM solution " +
                "LIMIT ?";
        try(Connection connection = DbUtil.getConn();
            PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setLong(1, max);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Solution sol = new Solution();
                sol.setId(rs.getLong(1));
                sol.setAnswer(rs.getString(2));
                result.add(sol);
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

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
