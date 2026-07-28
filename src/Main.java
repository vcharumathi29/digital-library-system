
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Create Library object
        Library library = new Library();

        // Create Scanner object
        Scanner sc = new Scanner(System.in);

        int choice = 0;

        do {

            // Display menu
            System.out.println();
            System.out.println("=========================================");
            System.out.println("        DIGITAL LIBRARY SYSTEM");
            System.out.println("=========================================");
            System.out.println("1. Add Book");
            System.out.println("2. View All Books");
            System.out.println("3. Search Book");
            System.out.println("4. Issue Book");
            System.out.println("5. Return Book");
            System.out.println("6. Add User");
            System.out.println("7. View All Users");
            System.out.println("8. Search User");
            System.out.println("9. Exit");
            System.out.println("=========================================");

            // Read menu choice safely
            try {

                System.out.print("Enter your choice: ");
                choice = sc.nextInt();

                switch (choice) {

                    // Add Book
                    case 1:

                        try {
                            System.out.print("Enter Book ID: ");
                            int bookId = sc.nextInt();

                            sc.nextLine();

                            System.out.print("Enter Book Title: ");
                            String title = sc.nextLine();

                            System.out.print("Enter Book Author: ");
                            String author = sc.nextLine();

                            Book book = new Book(bookId, title, author);

                            library.addBook(book);

                            System.out.println("Book added successfully.");

                        } catch (InputMismatchException e) {

                            System.out.println(
                                    "Invalid input. Book ID must be a number."
                            );

                            sc.nextLine();
                        }

                        break;


                    // View All Books
                    case 2:

                        System.out.println();
                        System.out.println("===== ALL BOOKS =====");

                        library.displayAllBooks();

                        break;


                    // Search Book
                    case 3:

                        try {

                            System.out.print("Enter Book ID to search: ");
                            int searchBookId = sc.nextInt();

                            library.searchBook(searchBookId);

                        } catch (InputMismatchException e) {

                            System.out.println(
                                    "Invalid input. Book ID must be a number."
                            );

                            sc.nextLine();
                        }

                        break;


                    // Issue Book
                    case 4:

                        try {

                            System.out.print("Enter Book ID to issue: ");
                            int issueBookId = sc.nextInt();

                            library.issueBook(issueBookId);

                        } catch (InputMismatchException e) {

                            System.out.println(
                                    "Invalid input. Book ID must be a number."
                            );

                            sc.nextLine();
                        }

                        break;


                    // Return Book
                    case 5:

                        try {

                            System.out.print("Enter Book ID to return: ");
                            int returnBookId = sc.nextInt();

                            library.returnBook(returnBookId);

                        } catch (InputMismatchException e) {

                            System.out.println(
                                    "Invalid input. Book ID must be a number."
                            );

                            sc.nextLine();
                        }

                        break;


                    // Add User
                    case 6:

                        try {

                            System.out.print("Enter User ID: ");
                            int userId = sc.nextInt();

                            sc.nextLine();

                            System.out.print("Enter User Name: ");
                            String name = sc.nextLine();

                            System.out.print("Enter User Email: ");
                            String email = sc.nextLine();

                            User user = new User(
                                    userId,
                                    name,
                                    email
                            );

                            library.addUser(user);

                            System.out.println(
                                    "User added successfully."
                            );

                        } catch (InputMismatchException e) {

                            System.out.println(
                                    "Invalid input. User ID must be a number."
                            );

                            sc.nextLine();
                        }

                        break;


                    // View All Users
                    case 7:

                        System.out.println();
                        System.out.println("===== ALL USERS =====");

                        library.displayAllUsers();

                        break;


                    // Search User
                    case 8:

                        try {

                            System.out.print("Enter User ID to search: ");
                            int searchUserId = sc.nextInt();

                            library.searchUser(searchUserId);

                        } catch (InputMismatchException e) {

                            System.out.println(
                                    "Invalid input. User ID must be a number."
                            );

                            sc.nextLine();
                        }

                        break;


                    // Exit
                    case 9:

                        System.out.println(
                                "Exiting Digital Library System..."
                        );

                        break;


                    // Invalid menu option
                    default:

                        System.out.println(
                                "Invalid choice. Please select 1 to 9."
                        );
                }

            } catch (InputMismatchException e) {

                System.out.println(
                        "Invalid input. Please enter a number from 1 to 9."
                );

                // Clear invalid input
                sc.nextLine();
            }

        } while (choice != 9);

        sc.close();

        System.out.println(
                "Thank you for using Digital Library System!"
        );
    }
   
   

}