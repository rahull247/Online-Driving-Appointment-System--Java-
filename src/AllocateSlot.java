

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AllocateSlot
 */
@WebServlet("/AllocateSlot")
public class AllocateSlot extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllocateSlot() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
		int appId=Integer.parseInt(request.getParameter("appId"));
		int slotId=Integer.parseInt(request.getParameter("slot_id"));
		
		TimeSlotDAO dao=new TimeSlotDAO();
		try{
			
			if(dao.allocateSlot(appId, slotId))
			{
				RequestDispatcher rs = request.getRequestDispatcher("SlotSuccess.jsp");
				rs.forward(request,response);
			}
			
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
