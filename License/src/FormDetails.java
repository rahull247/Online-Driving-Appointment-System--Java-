

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FormDetails
 */
@WebServlet("/FormDetails")
public class FormDetails extends HttpServlet {
	
	public static int applicationId=00000;
	private static final long serialVersionUID = 1L;
	VehicleDAO obj=new VehicleDAO();
	RtoDAO obj1=new RtoDAO();
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub


		
		    Random r = new Random( System.currentTimeMillis() );
		   int applId=((1 + r.nextInt(2)) * 10000 + r.nextInt(10000));
		
		
		response.setContentType("text/html");
		ArrayList vehinfo=obj.dispVehicle();
		ArrayList state=obj1.getState();
		//ArrayList arr=obj1.getAllRtoDetails();
		//ArrayList rto_id=new ArrayList();
		//ArrayList rto_name=new ArrayList();
		/*for(int i=0;i<arr.size();i++)
		{
			ArrayList f=(ArrayList) arr.get(i);
			rto_id.add(f.get(0));
			rto_name.add(f.get(1)+"-"+f.get(2));
		}*/
		request.setAttribute("state",state);
		//request.setAttribute("id",rto_id);
		//request.setAttribute("name",rto_name);




		ArrayList v_id=new ArrayList();
		ArrayList cov=new ArrayList();
		for(int i=0;i<vehinfo.size();i++)
		{
			ArrayList f=(ArrayList) vehinfo.get(i);
			v_id.add(f.get(0));
			cov.add(f.get(2)+"("+f.get(1)+")");
		}
		request.setAttribute("v_id", v_id);
		request.setAttribute("cov", cov);
		request.setAttribute("applId", applId);
		
		
		RequestDispatcher rs = request.getRequestDispatcher("LearningForm.jsp");
		rs.forward(request,response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
