package dao;

import java.sql.*;
import entities.Human;
import db.DBContext;
import java.util.ArrayList;
import java.util.List;

public class HumanDao extends DBContext {

    private PreparedStatement ps;
    private ResultSet rs;

    public List<Human> all() {
        List<Human> humans = new ArrayList<>();
        String sql = "SELECT * FROM Human";
        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int humanid = rs.getInt("humanid");
                String humanname = rs.getString("humanname");
                Date humandob = rs.getDate("humandob");
                boolean humangender = rs.getBoolean("humangender");
                int typeid = rs.getInt("typeid");

                Human human = new Human(humanid, humanname, humandob, humangender, typeid);
                humans.add(human);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return humans;
    }

    public Human find(int id) {
        Human human = null;
        String sql = "SELECT * FROM Human WHERE humanid = ?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                int humanid = rs.getInt("humanid");
                String humanname = rs.getString("humanname");
                Date humandob = rs.getDate("humandob");
                boolean humangender = rs.getBoolean("humangender");
                int typeid = rs.getInt("typeid");

                human = new Human(humanid, humanname, humandob, humangender, typeid);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return human;
    }

    public void createHuman(Human human) {
        String sql = "INSERT INTO Human (humanname, humandob, humangender, typeid) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, human.getHumanname());
            ps.setDate(2, human.getHumandob());
            ps.setBoolean(3, human.getHumangender());
            ps.setInt(4, human.getTypeid());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateHuman(Human human) {
        String sql = "UPDATE Human SET humanname = ?, humandob = ?, humangender = ?, typeid = ? WHERE humanid = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, human.getHumanname());
            ps.setDate(2, human.getHumandob());
            ps.setBoolean(3, human.getHumangender());
            ps.setInt(4, human.getTypeid());
            ps.setInt(5, human.getHumanid());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
