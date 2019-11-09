package uni.fmi.masters.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "comment")
public class CommentBean {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "city", length = 100, nullable = false)
	private String city;
	
	@Column(name = "comment", length = 1000)
	private String comment;
	
	@Column(name = "temp" , nullable = false, precision = 2)
	private double temp;
	
	@Column(name = "picture", nullable = true, length = 250)
	private String picture;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private UserBean user;
	
	public CommentBean() { }

	public CommentBean(String city, String comment, double temp, String picture, UserBean user) {
		super();
		this.city = city;
		this.comment = comment;
		this.temp = temp;
		this.picture = picture;
		this.user = user;
	}

	public CommentBean(String city, double temp, UserBean user) {
		super();
		this.city = city;
		this.temp = temp;
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public double getTemp() {
		return temp;
	}

	public void setTemp(double temp) {
		this.temp = temp;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public UserBean getUser() {
		return user;
	}

	public void setUser(UserBean user) {
		this.user = user;
	}	

}
