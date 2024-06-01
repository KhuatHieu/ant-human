package dao;

import db.DBContext;
import entities.HumanType;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HumanTypeDao extends DBContext {

    private PreparedStatement ps;
    private ResultSet rs;

    public List<HumanType> all() {
        List<HumanType> humanTypes = new ArrayList<>();
        String sql = "SELECT * FROM HumanType";
        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int typeid = rs.getInt("typeid");
                String typename = rs.getString("typename");

                HumanType humanType = new HumanType(typeid, typename);
                humanTypes.add(humanType);
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

        return humanTypes;
    }
}
