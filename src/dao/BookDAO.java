package dao;

import model.Book;
import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookDAO {

    // Add Book
    public void addBook(Book book) {

        String sql = "INSERT INTO books (book_id, title, author, available) VALUES (?, ?, ?, ?)";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setInt(1, book.getBookId());
            ps.setString(2, book.getTitle());
            ps.setString(3, book.getAuthor());
            ps.setBoolean(4, book.isAvailable());

            ps.executeUpdate();

            System.out.println("Book added successfully.");

        } catch (SQLException e) {

            if (e.getErrorCode() == 1062) {

                System.out.println(
                        "Book ID already exists. Please use a different ID."
                );

            } else {

                System.out.println("Error adding book to database.");
                e.printStackTrace();
            }
        }
    }


    // Get All Books
    public void getAllBooks() {

        String sql = "SELECT * FROM books";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()
        ) {

            boolean found = false;

            while (rs.next()) {

                found = true;

                System.out.println(
                        "Book ID: " + rs.getInt("book_id")
                );

                System.out.println(
                        "Title: " + rs.getString("title")
                );

                System.out.println(
                        "Author: " + rs.getString("author")
                );

                System.out.println(
                        "Available: " + rs.getBoolean("available")
                );

                System.out.println();
            }

            if (!found) {
                System.out.println("No books found.");
            }

        } catch (SQLException e) {

            System.out.println("Error retrieving books.");
            e.printStackTrace();
        }
    }


    // Find Book By ID
    public void findBookById(int bookId) {

        String sql = "SELECT * FROM books WHERE book_id = ?";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setInt(1, bookId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                System.out.println("BOOK FOUND!");

                System.out.println(
                        "Book ID: " + rs.getInt("book_id")
                );

                System.out.println(
                        "Title: " + rs.getString("title")
                );

                System.out.println(
                        "Author: " + rs.getString("author")
                );

                System.out.println(
                        "Available: " + rs.getBoolean("available")
                );

            } else {

                System.out.println("BOOK NOT FOUND.");
            }

        } catch (SQLException e) {

            System.out.println("Error searching for book.");
            e.printStackTrace();
        }
    }


    // Issue / Return Book
    public void updateAvailability(
            int bookId,
            boolean available) {

        String sql =
                "UPDATE books SET available = ? WHERE book_id = ?";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setBoolean(1, available);
            ps.setInt(2, bookId);

            int rows = ps.executeUpdate();

            if (rows == 0) {

                System.out.println("Book not found.");

            } else if (available) {

                System.out.println(
                        "Book returned successfully."
                );

            } else {

                System.out.println(
                        "Book issued successfully."
                );
            }

        } catch (SQLException e) {

            System.out.println(
                    "Error updating book availability."
            );

            e.printStackTrace();
        }
    }


    // Delete Book
    public void deleteBook(int bookId) {

        String sql =
                "DELETE FROM books WHERE book_id = ?";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setInt(1, bookId);

            int rows = ps.executeUpdate();

            if (rows == 0) {

                System.out.println("Book not found.");

            } else {

                System.out.println(
                        "Book deleted successfully."
                );
            }

        } catch (SQLException e) {

            System.out.println(
                    "Error deleting book."
            );

            e.printStackTrace();
        }
    }
}