package dao;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.OrderBean;

public class OrderDAO {
    private Connection conn;

    public OrderDAO(Connection conn) {
        this.conn = conn;
    }

    public boolean insertOrder(OrderBean order) {
        String sql = "INSERT INTO orders(user_id, total_amount, status, order_date) VALUES(?,?,?,?)";
        try (PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, order.getUserId());
            ps.setDouble(2, order.getTotalAmount());
            ps.setString(3, order.getStatus());
            ps.setDate(4, new java.sql.Date(order.getOrderDate().getTime()));

            int rows = ps.executeUpdate();
            if (rows > 0) {
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    order.setOrderId(rs.getInt(1));
                }
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public OrderBean getOrderById(int orderId) {
        String sql = "SELECT * FROM orders WHERE order_id=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, orderId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new OrderBean(
                    rs.getInt("order_id"),
                    rs.getInt("user_id"),
                    rs.getDouble("total_amount"),
                    rs.getString("status"),
                    rs.getDate("order_date")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean updateOrderStatus(int orderId, String status) {
        String sql = "UPDATE orders SET status=? WHERE order_id=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, status);
            ps.setInt(2, orderId);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // TRACKING METHOD
    public String trackOrder(int orderId) {
        OrderBean order = getOrderById(orderId);
        if (order != null) {
            return "Order ID: " + orderId + " is currently: " + order.getStatus();
        }
        return "Order not found!";
    }

    public List<OrderBean> getOrdersByUser(int userId) {
        List<OrderBean> orders = new ArrayList<>();
        String sql = "SELECT * FROM orders WHERE user_id=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                orders.add(new OrderBean(
                    rs.getInt("order_id"),
                    rs.getInt("user_id"),
                    rs.getDouble("total_amount"),
                    rs.getString("status"),
                    rs.getDate("order_date")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }
}