package dao;

import java.sql.*;
import model.UserBean;

public class UserDAO {

    // LOGIN
	public boolean validateUser(UserBean user) {
	    boolean status = false;

	    try {
	        Connection con = DBConnection.getConnection();

	        String sql = "SELECT * FROM users WHERE email=? AND password=?";
	        PreparedStatement ps = con.prepareStatement(sql);

	        String email = user.getEmail().trim();
	        String password = user.getPassword().trim();

	        System.out.println("Checking Email: " + email);
	        System.out.println("Checking Password: " + password);

	        ps.setString(1, email);
	        ps.setString(2, password);

	        ResultSet rs = ps.executeQuery();

	        if (rs.next()) {
	            System.out.println("User found in DB");
	            status = true;
	        } else {
	            System.out.println("No match found in DB");
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return status;
	}

    // REGISTER
    public boolean registerUser(UserBean user) {
        boolean status = false;

        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO users(name,email,password) VALUES(?,?,?)"
            );

            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());

            int i = ps.executeUpdate();

            if (i > 0) {
                status = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }
}