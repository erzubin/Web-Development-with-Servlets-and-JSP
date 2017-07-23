package quotations;

public class Quotation {

	int id;
	String author;
	String text;
	
	public Quotation(int id, String author, String text)
	{
	  this.id=id;
	  this.author=author;
      this.text=text;	  
	}

	public int getId() {
		return id;
	}

	public String getAuthor() {
		return author;
	}

	public String getText() {
		return text;
	}
	
}
