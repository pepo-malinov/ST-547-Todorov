package uni.fmi.masters;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import uni.fmi.masters.beans.UserBean;

/**
 * Servlet implementation class HelloWorldServlet
 */
@WebServlet("/HelloWorldServlet")
public class HelloWorldServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloWorldServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String router = request.getParameter("router");
		
		switch(router) {
			case "login":
				goToLogin(request, response);
			break;
			case "register":
				registerUser(request, response);
				break;
		}
		
		

	}

	private void registerUser(HttpServletRequest request, HttpServletResponse response) {
		
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String repeatPassword = request.getParameter("repeatPassword");
		
		if(password.equals(repeatPassword)) {
			UserBean user = new UserBean(username, email, password);
		
			if(insertUserIntoDatabase(user)) {
				request.setAttribute("user", user);			
				redirect("profile.jsp", request, response);
			}else {
				request.setAttribute("message", "Registration unsuccessfull");
				redirect("error.jsp", request, response);
			}
			
		}else {
			request.setAttribute("message", "Password missmatch!");
			redirect("error.jsp", request, response);			
		}		
		
	}
	
	private boolean insertUserIntoDatabase(UserBean user) {
		
		Connection con = null;

		try {
			con = openConnection();
			
			String query = "INSERT INTO USER ("
					+ "USERNAME,PASSWORD,EMAIL)"
					+ " VALUES (?,?,?)";
			
			PreparedStatement pst = con.prepareStatement(query);
			
			pst.setString(1, user.getUsername());
			pst.setString(2, user.getPassword());
			pst.setString(3, user.getEmail());
			
			int count = pst.executeUpdate();
								
			if(count > 0) {
				return true;
			}
			
		} catch (SQLException e) {			
			e.printStackTrace();			
		}finally {
			
			try {				
				if(con != null) {
					con.close();
				}
				
			} catch (SQLException e) {			
				e.printStackTrace();
			}
			
		}
		
		return false;			
	}
	
	private Connection openConnection() throws SQLException {
			
		try {
			Class.forName("org.h2.Driver");
		} catch (ClassNotFoundException e) {			
			e.printStackTrace();
		}
		
		return DriverManager.getConnection("jdbc:h2:~/weatherBook", "sa", "");
	
	}

	private void redirect(String page, HttpServletRequest request, HttpServletResponse response) {
		
		RequestDispatcher rd = request.getRequestDispatcher(page);
		
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void goToLogin(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		UserBean user = login(username, password);
		
		if(user != null) {
			request.setAttribute("user", user);
			redirect("home.html", request, response);
		}else {			
			request.setAttribute("message", "Wrong password information!");
			redirect("error.jsp", request, response);
		}
	}

	private UserBean login(String username, String password) {
		Connection con = null;
		ResultSet rs = null;
		
		try {
			con = openConnection();
			
			String query = "SELECT ID, email, image FROM USER WHERE "
					+ " username=? AND password=?";
			
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, username);
			pst.setString(2, password);
			
			rs = pst.executeQuery();
			
			if(rs.first()) {
				UserBean user = new UserBean();
				user.setUsername(username);
				
				user.setEmail(rs.getString("email"));
				user.setAvatar(rs.getString("image"));
				user.setId(rs.getInt("id"));
				
				return user;				
			}
			
		} catch (SQLException e) {		
			e.printStackTrace();
		}
		
		
		return null;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
