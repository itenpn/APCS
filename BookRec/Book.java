public class Book{

	private String title, author;
	
	public Book(String t, String a){
		title = t;
		author = a;
	}

	public String getTitle(){
		return title;
	}

	public String getAuthor(){
		return author;
	}

	public String toString(){
		return author + ", " + title;
	}

}
