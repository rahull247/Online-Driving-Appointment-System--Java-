

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddNewRTO
 */
@WebServlet("/AddNewRTO")
public class AddNewRTO extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNewRTO() {
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
		// TODO Auto-generated method stub
		String state =request.getParameter("state");
		String rto_code=request.getParameter("rto_code");
		String rto_name=request.getParameter("rto_name");
		String rto_addr=request.getParameter("rto_addr");
		String rto_pin=request.getParameter("rto_pin");
		String rto_phone=request.getParameter("rto_phone");
		RtoDAO rto=new RtoDAO(); 
		if(rto.insertRtoDetails(state, rto_code, rto_name, rto_addr, rto_pin, rto_phone))
		{
			PrintWriter out=response.getWriter();
			out.println("<html><head><title></title></head><%@include file=\"a_header.jsp\"%><body>RTO Added Successfully</body></html>");
		}
		PrintWriter out=response.getWriter();
		out.println("<html><head><title></title></head><%@include file=\"a_header.jsp\"%><body>RTO Added Successfully</body></html>");
		
	}

}
