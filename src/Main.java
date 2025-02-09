import java.util.Scanner;
class BookNotAvailableException extends Exception{
    public BookNotAvailableException(String message){
        super(message);
    }
}
class InvalidOperationException extends Exception{
    public InvalidOperationException(String message){
        super(message);
    }
}
class Library{
    private String bookTitle;
    private String author;
    private boolean isAvailable;

    public Library(String bookTitle, String author, boolean isAvailable) {
        this.bookTitle = bookTitle;
        this.author = author;
        this.isAvailable = isAvailable;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public void borrowBook() throws BookNotAvailableException{
        if(!isAvailable)
            throw new BookNotAvailableException("Book is currently unavailable");
        else
        {
            isAvailable=false;
            System.out.println("Book borrowed successfully!");
        }
    }

    public void returnBook() throws InvalidOperationException{
        if(isAvailable)
            throw new InvalidOperationException("Book is already available");
        else
        {
            isAvailable=true;
            System.out.println("Book returned successfully");
        }
    }

    public void checkAvailability(){
        System.out.println("Availability : "+(isAvailable ? "available" :"not available"));
    }
}
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Library lib = new Library("xyz", "abc", true);
        while (true) {
            System.out.println("Hello and welcome to Library Management System!");
            System.out.println("Select your choice :");
            System.out.println("1 - Borrow book");
            System.out.println("2 - Return book");
            System.out.println("3 - Check Availability");
            System.out.println("4 - exit");
            int input = Integer.parseInt(sc.nextLine());
            try {
                switch (input) {
                    case 1:
                        lib.borrowBook();
                        break;
                    case 2:
                        lib.returnBook();
                        break;
                    case 3:
                        lib.checkAvailability();
                        break;
                    case 4:
                        return;
                }
            }catch(InvalidOperationException | BookNotAvailableException e){
                System.out.println(e.getMessage());
            }
        }
    }
}