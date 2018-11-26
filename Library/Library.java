import java.util.Scanner;

public class Library{

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        System.out.println("What is the title and author of the first book?");
        String t = s.next();
        String a = s.next();
        Book b1 = new Book(t,a);
        System.out.println("What is the title and author of the second book?");
        t = s.next();
        a = s.next();
        Book b2 = new Book(t,a);
        System.out.println("What is the title and author of the third book?");
        t = s.next();
        a = s.next();
        Book b3 = new Book(t,a);
        System.out.println("These are your new books: ");
        System.out.println(b1.toString());
        System.out.println(b2.toString());
        System.out.println(b3.toString());

        Patron bob = new Patron("Bob");
        Patron joe = new Patron("Joe");
        System.out.println("Giving out the books");
        bob.addBook(b1);
        joe.addBook(b2);
        joe.addBook(b3);
        System.out.println("Checking if Bob has " + b1.toString());
        System.out.println(bob.hasBook(b1.getTitle()));
        System.out.println("Taking the book back from Bob");
        bob.removeBook(b1.getTitle());
        System.out.println("Checking if Bob still has the book");
        System.out.println(bob.hasBook(b1.getTitle()));
        System.out.println("Here's the current patron holdings");
        System.out.println(bob.toString());
        System.out.println(joe.toString());
        s.close();

    }

}