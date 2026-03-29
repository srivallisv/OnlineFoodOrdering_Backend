package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.RestaurantBean;

public class RestaurantDAO {

    public List<RestaurantBean> getRestaurants() {

        List<RestaurantBean> list = new ArrayList<>();

        try {
            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM restaurant";
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                RestaurantBean r = new RestaurantBean();

                r.setRestaurantId(rs.getInt("restaurant_id"));
                r.setName(rs.getString("name"));
                r.setLocation(rs.getString("location"));

                list.add(r);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}