package dao;

import model.User;
import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {

    // Add User
    public void addUser(User user) {

        String sql = "INSERT INTO users (user_id, name, email) VALUES (?, ?, ?)";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setInt(1, user.getUserId());
            ps.setString(2, user.getName());
            ps.setString(3, user.getEmail());

            ps.executeUpdate();

            System.out.println("User added successfully.");

        } catch (SQLException e) {

            if (e.getErrorCode() == 1062) {

                System.out.println(
                        "User ID already exists. Please use a different ID."
                );

            } else {

                System.out.println("Error adding user to database.");
                e.printStackTrace();
            }
        }
    }


    // Get All Users
    public void getAllUsers() {

        String sql = "SELECT * FROM users";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()
        ) {

            boolean found = false;

            while (rs.next()) {

                found = true;

                System.out.println(
                        "User ID: " + rs.getInt("user_id")
                );

                System.out.println(
                        "Name: " + rs.getString("name")
                );

                System.out.println(
                        "Email: " + rs.getString("email")
                );

                System.out.println();
            }

            if (!found) {
                System.out.println("No users found.");
            }

        } catch (SQLException e) {

            System.out.println("Error retrieving users.");
            e.printStackTrace();
        }
    }


    // Find User By ID
    public void findUserById(int userId) {

        String sql = "SELECT * FROM users WHERE user_id = ?";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setInt(1, userId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                System.out.println("USER FOUND!");

                System.out.println(
                        "User ID: " + rs.getInt("user_id")
                );

                System.out.println(
                        "Name: " + rs.getString("name")
                );

                System.out.println(
                        "Email: " + rs.getString("email")
                );

            } else {

                System.out.println("USER NOT FOUND.");
            }

        } catch (SQLException e) {

            System.out.println("Error searching for user.");
            e.printStackTrace();
        }
    }


    // Delete User
    public void deleteUser(int userId) {

        String sql =
                "DELETE FROM users WHERE user_id = ?";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setInt(1, userId);

            int rows = ps.executeUpdate();

            if (rows == 0) {

                System.out.println("User not found.");

            } else {

                System.out.println(
                        "User deleted successfully."
                );
            }

        } catch (SQLException e) {

            System.out.println(
                    "Error deleting user."
            );

            e.printStackTrace();
        }
    }
}