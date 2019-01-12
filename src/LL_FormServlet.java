

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LL_FormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	VehicleDAO obj=new VehicleDAO();
	RtoDAO obj1=new RtoDAO();
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pr=response.getWriter();
		pr.println("HelloWorld");	
		response.setContentType("text/html");
		ArrayList vehinfo=obj.dispVehicle();
		ArrayList arr=obj1.getAllRtoDetails();
		ArrayList rto_id=new ArrayList();
		ArrayList rto_name=new ArrayList();
		for(int i=0;i<arr.size();i++)
		{
			ArrayList f=(ArrayList) arr.get(i);
			rto_id.add(f.get(0));
			rto_name.add(f.get(1)+"-"+f.get(2));
		}
		request.setAttribute("state",arr);
		request.setAttribute("id",rto_id);
		request.setAttribute("name",rto_name);
		response.sendRedirect("Sample.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
