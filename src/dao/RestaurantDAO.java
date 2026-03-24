package dao;

import model.DBConnection;
import model.Restaurant;
import java.sql.*;

public class RestaurantDAO {

    public boolean addRestaurant(Restaurant r){
        String sql = "INSERT INTO restaurants (id, name, location) VALUES (?, ?, ?)";
        try(Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1,r.getId());
            ps.setString(2,r.getName());
            ps.setString(3,r.getLocation());
            ps.executeUpdate();
            return true;
        } catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    public Restaurant getRestaurantById(int id){
        String sql = "SELECT * FROM restaurants WHERE id=?";
        try(Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return new Restaurant(rs.getInt("id"),
                                      rs.getString("name"),
                                      rs.getString("location"));
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}