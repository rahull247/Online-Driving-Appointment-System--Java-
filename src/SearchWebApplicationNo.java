

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchWebApplicationNo
 */
@WebServlet("/SearchWebApplicationNo")
public class SearchWebApplicationNo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ApplicantDAO app=new ApplicantDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchWebApplicationNo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		String fname=request.getParameter("fname");
		String lname=request.getParameter("lname");
		String dob=request.getParameter("dob");
		
		ArrayList AppId=new ArrayList();
		
		int appid=app.searchWebId(fname, lname, dob);
		System.out.println(fname+" "+lname+" "+dob+" "+appid);
		request.setAttribute("appid", appid );
		RequestDispatcher rs = request.getRequestDispatcher("WebIdNo.jsp");
		rs.forward(request,response);
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
