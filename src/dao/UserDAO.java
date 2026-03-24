package dao;

import model.DBConnection;
import model.User;
import java.sql.*;

public class UserDAO {

    public boolean addUser(User user){
        String sql = "INSERT INTO users (id, name, email, password) VALUES (?, ?, ?, ?)";
        try(Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1,user.getId());
            ps.setString(2,user.getName());
            ps.setString(3,user.getEmail());
            ps.setString(4,user.getPassword());
            ps.executeUpdate();
            return true;
        } catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    public User getUserById(int id){
        String sql = "SELECT * FROM users WHERE id=?";
        try(Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return new User(rs.getInt("id"),
                                rs.getString("name"),
                                rs.getString("email"),
                                rs.getString("password"));
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}