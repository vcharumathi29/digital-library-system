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
        //search book by id
        public void searchBook(int bookId){
            for(Book book:books){
                if(book.getBookId() ==  bookId){
                    System.out.println("BOOK FOUND!");
                    book.displayBookDetails();
                    return;
                }
            }
            System.out.println("BOOK NOT FOUND.");
        }
        // issue a book
        public void issueBook(int bookId){
            for(Book book:books){
                if(book.getBookId() == bookId){
                    if(book.isAvailable()){
                        book.setAvailable(false);
                        System.out.println("Book issued successfully.");
                        }
                        else{
                            System.out.println("Book is already issued.");
                        }
                        return;
                }
            }
          System.out.println("Book not found.");  
        }
        // return a book
        public void returnBook(int bookId){
            for(Book book:books){
                if(book.getBookId() == bookId){
                    if(!book.isAvailable()){
                        book.setAvailable(true);
                        System.out.println("Book returned sucessfully.");

                    }else{
                        System.out.println("Book is already available.");
                    }
                    return;
                }
            }
            System.out.println("Book not found.");
        }

    }
