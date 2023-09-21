package entities;


import java.util.Date;

public class Client {

	private String name;
	private String email;
	private Date bithrDate;
	
	public Client() {
	}

	public Client(String name, String email, Date bithrDate) {
		super();
		this.name = name;
		this.email = email;
		this.bithrDate = bithrDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBithrDate() {
		return bithrDate;
	}

	public void setBithrDate(Date bithrDate) {
		this.bithrDate = bithrDate;
	}
	
	
}
