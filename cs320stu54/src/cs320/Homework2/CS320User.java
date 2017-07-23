package cs320.Homework2;

public class CS320User {

	private String first;
	private String last;
	private String email;
	private String password;
	
	public CS320User(String first, String last, String email, String password)
	{
		this.first = first;
		this.last = last;
		this.email = email;
		this.password = password;
	}
	
	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public String getLast() {
		return last;
	}

	public void setLast(String last) {
		this.last = last;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	
	
	
}
