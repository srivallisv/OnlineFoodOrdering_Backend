package dao;

import model.DBConnection;
import model.Order;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO {

    public boolean addOrder(Order o){
        String sql = "INSERT INTO orders (id, user_id, restaurant_id, order_date, total) VALUES (?, ?, ?, ?, ?)";
        try(Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1,o.getId());
            ps.setInt(2,o.getUserId());
            ps.setInt(3,o.getRestaurantId());
            ps.setDate(4,new java.sql.Date(o.getOrderDate().getTime()));
            ps.setDouble(5,o.getTotal());
            ps.executeUpdate();
            return true;
        } catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    public List<Order> getOrdersByUserId(int userId){
        List<Order> orders = new ArrayList<>();
        String sql = "SELECT * FROM orders WHERE user_id=?";
        try(Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1,userId);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                orders.add(new Order(rs.getInt("id"),
                                     rs.getInt("user_id"),
                                     rs.getInt("restaurant_id"),
                                     rs.getDate("order_date"),
                                     rs.getDouble("total")));
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return orders;
    }
}