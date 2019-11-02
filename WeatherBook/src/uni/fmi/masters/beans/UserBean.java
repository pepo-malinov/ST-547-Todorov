package uni.fmi.masters.beans;

public class UserBean {
	
	private String username;
	private String email;
	private String password;
	private String avatar;
	private int id;
	
	public UserBean(String username, String email, String password) {
		this.email = email;
		this.password = password;
		this.username = username;		
	}

	
	
	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public UserBean() {
		// TODO Auto-generated constructor stub
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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
