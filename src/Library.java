import java.util.ArrayList;
public class Library {
    private ArrayList<Book> books;
    // constructor
    public Library(){
        books = new ArrayList<>();
    }
    //add a book
    public void addBook(Book book){
        books.add(book);
    }
    //Display all the books
    public void displayAllBooks(){
        for(Book book:books){
            book.displayBookDetails();
            System.out.println();
        }
    }
}
