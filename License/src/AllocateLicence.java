

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AllocateLicence
 */
@WebServlet("/AllocateLicence")
public class AllocateLicence extends HttpServlet {
	private static final long serialVersionUID = 1L;
    LicenceDAO dao=new LicenceDAO();   
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllocateLicence() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int result=Integer.parseInt(request.getParameter("result"));
		System.out.print(result);
		int appl_id=Integer.parseInt(request.getParameter("appl_id"));
		
		if(result==1)
		{
			String rto=request.getParameter("rto");
			String l_type=request.getParameter("l_type");
			
			String splitStr[]=rto.split("-");
			String rto_code=splitStr[0];
			boolean status=dao.insert(appl_id,rto_code,l_type);
			if(status)
			{
				RequestDispatcher rs = request.getRequestDispatcher("ForAllocated");
				rs.forward(request,response);

			}
			else{
				
			}
		}else if(result==2)
		{
			new TestDAO().updateCount(appl_id);
			RequestDispatcher rs = request.getRequestDispatcher("ForNotAllocated");
			rs.forward(request,response);

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
