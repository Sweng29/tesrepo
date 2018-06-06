/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mcgambat.com.daoImpl;

import java.sql.PreparedStatement;
import mcgambat.com.connection.DBConnection;
import mcgambat.com.models.UserModel;
import java.sql.ResultSet;
import mcgambat.com.business.MessageForm;

/**
 *
 * @author Rehan Ali Azeemi
 */
public class UserDaoImpl {

    public UserModel checkLogin(UserModel empModel) {
        UserModel userModel = null;
        try {
            PreparedStatement ps = DBConnection.getInstance().prepareStatement("select * from user where user_name = ? AND password = ? AND active = 1");
            ps.setString(1, empModel.getUsername());
            ps.setString(2, empModel.getPassword());
            // ps.setInt(3, 1);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                userModel = new UserModel();
                userModel.setUserId(rs.getInt("user_id"));
                userModel.setUsername(rs.getString("user_name"));
                userModel.setPassword(rs.getString("password"));
            }

        } catch (Exception e) {
            e.printStackTrace();
            new MessageForm("Error", e.toString(), "error.png").setVisible(true);
        }
        return userModel;
    }

    public Boolean checkUsernameAvailbility(String username) {

        try {
            PreparedStatement ps = DBConnection.getInstance().prepareStatement("select * from user where user_name = ? AND active = 1");
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return false;
            }

        } catch (Exception e) {
            e.printStackTrace();
            new MessageForm("Error", e.toString(), "error.png").setVisible(true);
        }
        return true;
    }

    public Integer addUser(UserModel userModel) {
        try {
            PreparedStatement ps = DBConnection.getInstance().prepareStatement("Insert into user(user_name,password) values(?,?)");
            ps.setString(1, userModel.getUsername());
            ps.setString(2, userModel.getPassword());
            return ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            new MessageForm("Error", e.toString(), "error.png").setVisible(true);
        }
        return 0;
    }

    public Integer updateUser(UserModel userModel) {
        try {
            PreparedStatement ps = DBConnection.getInstance().prepareStatement("Update user set user_name = ? where user_id = ? and active = 1");

            ps.setString(1, userModel.getUsername());
            ps.setInt(2, userModel.getUserId());

            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            //  new MessageForm("Error", e.toString(), "error.png").setVisible(true);
        }
        return 0;
    }

    public Integer deleteUser(Integer id) {
        try {
            PreparedStatement ps = DBConnection.getInstance().prepareStatement("Update user set active = 0 where user_id = ?");
            ps.setInt(1, id);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            new MessageForm("Error", e.toString(), "error.png").setVisible(true);
        }
        return 0;
    }

    public ResultSet getAllUsers() {
        try {
            PreparedStatement ps = DBConnection.getInstance().prepareStatement("Select user_id,`user_name` from `user` WHERE active = 1");
            ResultSet rs = ps.executeQuery();

            return rs;

        } catch (Exception e) {
            e.printStackTrace();
            new MessageForm("Error", e.toString(), "error.png").setVisible(true);
        }

        return null;
    }

    public Integer changePassword(UserModel user) {
        try {
            PreparedStatement ps = DBConnection.getInstance().prepareStatement("Update user set password = ? where user_id = ? and active = 1");

            ps.setString(1, user.getPassword());
            ps.setInt(2, user.getUserId());

            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            new MessageForm("Error", e.toString(), "error.png").setVisible(true);
        }
        return 0;
    }
}
