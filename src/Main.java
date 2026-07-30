import model.Book;
import model.User;
import service.Library;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Library library = new Library();
        Scanner sc = new Scanner(System.in);

        int choice = 0;

        do {

            System.out.println();
            System.out.println("=========================================");
            System.out.println("        DIGITAL LIBRARY SYSTEM");
            System.out.println("=========================================");
            System.out.println("1. Add Book");
            System.out.println("2. View All Books");
            System.out.println("3. Search Book");
            System.out.println("4. Issue Book");
            System.out.println("5. Return Book");
            System.out.println("6. Delete Book");
            System.out.println("7. Add User");
            System.out.println("8. View All Users");
            System.out.println("9. Search User");
            System.out.println("10. Delete User");
            System.out.println("11. Exit");
            System.out.println("=========================================");

            System.out.print("Enter your choice: ");
            choice = readInt(sc);

            switch (choice) {

                case 1:

                    System.out.print("Enter Book ID: ");
                    int bookId = readPositiveInt(sc);

                    sc.nextLine();

                    String title = readNonEmpty(
                            sc,
                            "Enter Book Title: "
                    );

                    String author = readNonEmpty(
                            sc,
                            "Enter Book Author: "
                    );

                    Book book = new Book(
                            bookId,
                            title,
                            author
                    );

                    library.addBook(book);

                    break;


                case 2:

                    System.out.println();
                    System.out.println("===== ALL BOOKS =====");

                    library.displayAllBooks();

                    break;


                case 3:

                    System.out.print("Enter Book ID to search: ");
                    int searchBookId = readPositiveInt(sc);

                    library.searchBook(searchBookId);

                    break;


                case 4:

                    System.out.print("Enter Book ID to issue: ");
                    int issueBookId = readPositiveInt(sc);

                    library.issueBook(issueBookId);

                    break;


                case 5:

                    System.out.print("Enter Book ID to return: ");
                    int returnBookId = readPositiveInt(sc);

                    library.returnBook(returnBookId);

                    break;


                case 6:

                    System.out.print("Enter Book ID to delete: ");
                    int deleteBookId = readPositiveInt(sc);

                    library.deleteBook(deleteBookId);

                    break;


                case 7:

                    System.out.print("Enter User ID: ");
                    int userId = readPositiveInt(sc);

                    sc.nextLine();

                    String name = readNonEmpty(
                            sc,
                            "Enter User Name: "
                    );

                    String email = readValidEmail(sc);

                    User user = new User(
                            userId,
                            name,
                            email
                    );

                    library.addUser(user);

                    break;


                case 8:

                    System.out.println();
                    System.out.println("===== ALL USERS =====");

                    library.displayAllUsers();

                    break;


                case 9:

                    System.out.print("Enter User ID to search: ");
                    int searchUserId = readPositiveInt(sc);

                    library.searchUser(searchUserId);

                    break;


                case 10:

                    System.out.print("Enter User ID to delete: ");
                    int deleteUserId = readPositiveInt(sc);

                    library.deleteUser(deleteUserId);

                    break;


                case 11:

                    System.out.println(
                            "Exiting Digital Library System..."
                    );

                    break;


                default:

                    System.out.println(
                            "Invalid choice. Please select 1 to 11."
                    );
            }

        } while (choice != 11);

        sc.close();

        System.out.println(
                "Thank you for using Digital Library System!"
        );
    }


    // Read integer safely
    private static int readInt(Scanner sc) {

        while (true) {

            try {

                return sc.nextInt();

            } catch (InputMismatchException e) {

                System.out.println(
                        "Invalid input. Please enter a number."
                );

                sc.nextLine();
            }
        }
    }


    // Read positive integer
    private static int readPositiveInt(Scanner sc) {

        while (true) {

            int number = readInt(sc);

            if (number > 0) {

                return number;

            } else {

                System.out.println(
                        "ID must be greater than 0. Please try again."
                );
            }
        }
    }


    // Read non-empty text
    private static String readNonEmpty(
            Scanner sc,
            String message) {

        while (true) {

            System.out.print(message);

            String input = sc.nextLine().trim();

            if (!input.isEmpty()) {

                return input;
            }

            System.out.println(
                    "Input cannot be empty. Please try again."
            );
        }
    }


    // Read valid email
    private static String readValidEmail(Scanner sc) {

        while (true) {

            System.out.print("Enter User Email: ");

            String email = sc.nextLine().trim();

            if (email.isEmpty()) {

                System.out.println(
                        "Email cannot be empty. Please try again."
                );

                continue;
            }

            if (email.contains("@")
                    && email.contains(".")
                    && !email.startsWith("@")
                    && !email.endsWith("@")
                    && !email.startsWith(".")
                    && !email.endsWith(".")) {

                return email;

            } else {

                System.out.println(
                        "Invalid email format. Please try again."
                );
            }
        }
    }
}