import java.util.ArrayList;
public class Main {

    public static void main(String[] args) {
        ArrayList<Book> books = new ArrayList<>();

        Book book1 = new Book(
                101,
                "Java Programming",
                "James Gosling"
        );
        Book book2 = new Book(102,"Python Basics","Guido van rossum");
        Book book3 = new Book(103,"SQL","John");
        books.add(book1);
        books.add(book2);
        books.add(book3);
        // Display all books
        for(Book book:books){
            book.displayBookDetails();
            System.out.println();
        }

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