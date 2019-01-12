import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RtoDetailsAdmin2
 */
@WebServlet("/RtoDetailsAdmin2")
public class RtoDetailsAdmin2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	VehicleDAO obj=new VehicleDAO();
	RtoDAO obj1=new RtoDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RtoDetailsAdmin2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		String state=request.getParameter("state");
		ArrayList arr=obj1.getRtoDetails(state);
		
		ArrayList th=new ArrayList();
		//th.add("RTO ID");
		th.add("RTO Code");
		th.add("RTO Name");
		th.add("RTO Address");
		th.add("Pincode");
		th.add("Phone No.");
		if(arr==null)
		{
			System.out.println("Null");
		}
		
		/*ArrayList rto_id=new ArrayList();
		ArrayList rto_name=new ArrayList();
		for(int i=0;i<arr.size();i++)
		{
			ArrayList f=(ArrayList) arr.get(i);
			rto_id.add(f.get(0));
			rto_name.add(f.get(1)+"-"+f.get(2));
		}
		request.setAttribute("state",state);
		request.setAttribute("id",rto_id);
		request.setAttribute("name",rto_name);*/
		
		request.setAttribute("state",arr);
		request.setAttribute("th",th);
		
		RequestDispatcher rs = request.getRequestDispatcher("DisplayRtoDetails.jsp");
		rs.forward(request,response);
	}
}
