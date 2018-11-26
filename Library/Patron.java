import javax.lang.model.util.ElementScanner6;

public class Patron{
    private String name;
    private Book[] book = new Book[3];

    public Patron(String n){
        name = n;
        book[0] = new Book();
        book[1] = new Book();
        book[2] = new Book();
    }

    public Patron(String n, Book b1, Book b2, Book b3){
        name = n;
        book[0] = b1;
        book[1] = b2;
        book[2] = b3;
    }

    public Book[] getBooks(){
        return book;
    }

    public String getName(){
        return name;
    }

    public int booksBorrowed(){
        int x = 0;
        for (int i = 0; i < 3; i++){
            if (!book[i].getTitle().equals("")){
                x++;
            }
        }
        return x;
    }

    public boolean hasBook(String SI){
        for (int i = 0; i < booksBorrowed(); i++){
            if (book[i].getTitle().equals(SI)){
                return true;
            }
        }
        return false;
    }

    public void addBook(Book b){
        if (booksBorrowed() < 3 && b.whoHas().equals("Library")){
            book[booksBorrowed()] = b;
            b.rented(name);
        }
        else if(booksBorrowed() == 3){
            System.out.println("Error, patron has too many books");
        }
        else{
            System.out.println("Error, book is already checked out");
        }
        
    }

    public void removeBook(String b){
        int pos = 0;
        for (int i = 0; i < book.length; i++){
            if (book[i].getTitle().equals(b)){
                book[i].returned();
                book[i] = new Book();
                pos = i;
                break;
            }
        }
        switch (pos){
            case 0: book[pos] = book[pos + 1];
                book[pos + 1] = book[pos + 2];
                book[pos + 2] = new Book();
                break;
            case 1: book[pos] = book[pos + 1];
                book[pos + 1] = new Book();
                break;
            case 2: book[pos] = new Book();
                break;
        }


    }

    public String toString(){
        String str = name + "\n";
        for (int i = 0; i < booksBorrowed(); i++)
            str += book[i].toString() + "\n";
        if (booksBorrowed() == 0)
            str += "null\n";
        return str;
    }
}