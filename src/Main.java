import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        // Create Library object
        Library library = new Library();

        Book book1 = new Book(
                101,
                "Java Programming",
                "James Gosling");
        Book book2 = new Book(102, "Python Basics", "Guido van rossum");
        Book book3 = new Book(103, "SQL", "John");
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        // Display all books
        library.displayAllBooks();
        // search book by id
        System.out.println("Searching for book ID: 102");
        library.searchBook(102);
        System.out.println();
        System.out.println("Issuing Book ID: 101");
        library.issueBook(101);
        System.out.println();
        System.out.println("After Issuing:");
        library.searchBook(101);
        // return a book
        System.out.println();
        System.out.println("Returning Book ID: 101");

        library.returnBook(101);

        System.out.println();
        System.out.println("After Returning:");

        library.searchBook(101);

        // Get book details using getters
        System.out.println("Book ID: " + book1.getBookId());
        System.out.println("Title: " + book1.getTitle());
        System.out.println("Author: " + book1.getAuthor());
        System.out.println("Available: " + book1.isAvailable());

        // Change book availability
        book1.setAvailable(false);

        System.out.println();
        System.out.println("After issuing the book:");

        System.out.println("Available: " + book1.isAvailable());
    }
}