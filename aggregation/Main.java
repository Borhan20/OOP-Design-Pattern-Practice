import java.util.List;
import java.util.ArrayList;
public class Main{
    public static void main(String[] args){
        Book b1 = new Book();
        b1.setTitle("Java Programming");
        b1.setAuthor("James Gosling");
        Book b2 = new Book();
        b2.setTitle("C Programming");
        b2.setAuthor("Dennis Ritchie");
        Library l = new Library();
        l.setName("Central Library");
        l.addBook(b1);
        l.addBook(b2);
        System.out.println("Library: "+l.getName()+"\nBooks:" + l.getBooks().get(0).getTitle() 
        + " by " + l.getBooks().get(0).getAuthor() + ", " + l.getBooks().get(1).getTitle() + 
        " by " + l.getBooks().get(1).getAuthor());
    }
}

class Library{
    private String name;
    private List<Book> books = new ArrayList<Book>();
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void addBook(Book book){
        this.books.add(book);
    }
    public List<Book> getBooks(){
        return this.books;
    }
}

class Book{
    private String title;
    private String author;
    public void setTitle(String title){
        this.title = title;
    }
    public String getTitle(){
        return this.title;
    }
    public void setAuthor(String author){
        this.author = author;
    }
    public String getAuthor(){
        return this.author;
    }
}