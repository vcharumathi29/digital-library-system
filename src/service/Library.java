package service;

import dao.BookDAO;
import dao.UserDAO;
import model.Book;
import model.User;

public class Library {

    private BookDAO bookDAO;
    private UserDAO userDAO;

    // Constructor
    public Library() {
        bookDAO = new BookDAO();
        userDAO = new UserDAO();
    }

    // ==================== BOOK METHODS ====================

    public void addBook(Book book) {
        bookDAO.addBook(book);
    }

    public void displayAllBooks() {
        bookDAO.getAllBooks();
    }

    public void searchBook(int bookId) {
        bookDAO.findBookById(bookId);
    }

    public void issueBook(int bookId) {
        bookDAO.updateAvailability(bookId, false);
    }

    public void returnBook(int bookId) {
        bookDAO.updateAvailability(bookId, true);
    }

    public void deleteBook(int bookId) {
        bookDAO.deleteBook(bookId);
    }


    // ==================== USER METHODS ====================

    public void addUser(User user) {
        userDAO.addUser(user);
    }

    public void displayAllUsers() {
        userDAO.getAllUsers();
    }

    public void searchUser(int userId) {
        userDAO.findUserById(userId);
    }

    public void deleteUser(int userId) {
        userDAO.deleteUser(userId);
    }
}