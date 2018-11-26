

public class Book{
    private String title;
    private String author;
    private boolean borrowed;
    private String owner;

    public Book(){
        title = "";
        author = "";
        borrowed = false;
        owner = "Library";
    }

    public Book(String t, String a){
        title = t;
        author = a;
        borrowed = false;
        owner = "Library";
    }

    public String getTitle(){
        return title;
    }

    public String getAuthor(){
        return author;
    }

    public void setTitle(String t){
        title = t;
    }

    public void setAuthor(String a){
        author = a;
    }

    public boolean isRented(){
        return borrowed;
    }

    public String whoHas(){
        return owner;
    }

    public void rented(String o){
        borrowed = true;
        owner = o;
    }

    public void returned(){
        borrowed = false;
        owner = "Library";
    }

    public String toString(){
        String str = title + ", " + author;
        return str;
    }

}