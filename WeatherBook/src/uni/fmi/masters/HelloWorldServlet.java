package uni.fmi.masters;

import java.io.IOException;

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
			request.setAttribute("user", user);
			
			redirect("profile.jsp", request, response);
			
		}else {
			request.setAttribute("message", "Password missmatch!");
			redirect("error.jsp", request, response);			
		}		
		
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
		
		if(username.equalsIgnoreCase("gotin") && password.equals("gotin321")) {
			redirect("home.html", request, response);
		}else {			
			request.setAttribute("message", "Wrong password information!");
			redirect("error.jsp", request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
