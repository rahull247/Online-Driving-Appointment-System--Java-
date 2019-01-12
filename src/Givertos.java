

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
 * Servlet implementation class Givertos
 */
@WebServlet("/Givertos")
public class Givertos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	VehicleDAO obj=new VehicleDAO();
	RtoDAO list=new RtoDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Givertos() {
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
		
		String state=(String) request.getParameter("state");
		String l_type=(String) request.getParameter("x");
		
		
		System.out.println("dlflag= "+l_type);
		
		int dlflag=0;
		if(l_type.equals("LL"))
		{
			dlflag=0;
		}
		else 
		{
			dlflag=1;
		}
		
		System.out.println("dlflag= "+dlflag);
		
			//"MH:Maharashtra";
		ArrayList temp=new ArrayList();
		temp.add(state);
		ArrayList state1=list.getState();
		//(String) request.getParameter("state")
		
			ArrayList rto_id=new ArrayList();
			ArrayList rto_name=new ArrayList();
		ArrayList rtos=list.giveRtos(state);
		for(int i=0;i<rtos.size();i++)
		{
			ArrayList f=(ArrayList) rtos.get(i);
			rto_id.add(f.get(0));
			rto_name.add(f.get(1));
		}
		
		
		
		
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
		
		
		
		
		System.out.println("State="+state);
		System.out.println("values"+rto_name);
		
		
		request.setAttribute("state", state1);
		request.setAttribute("namestate",temp );
		request.setAttribute("rtos", rto_name);
		request.setAttribute("id", rto_id);
		RequestDispatcher rs = request.getRequestDispatcher("LearningForm.jsp?dlflag="+dlflag);
		rs.forward(request,response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
