public class Main {

    public static void main(String[] args) {

        Book book1 = new Book(
                101,
                "Java Programming",
                "James Gosling"
        );

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