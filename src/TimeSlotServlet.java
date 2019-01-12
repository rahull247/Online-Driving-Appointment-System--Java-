

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TimeSlotServlet
 */
@WebServlet("/TimeSlotServlet")
public class TimeSlotServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TimeSlotServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int appId=Integer.parseInt(request.getParameter("appId"));
		String l_type=request.getParameter("l_type");
		String slot_date=request.getParameter("date");
		
		TimeSlotDAO dao=new TimeSlotDAO();
		ArrayList slots=dao.getTimeSlots(slot_date);
		
		if(slots!=null)
		{
			request.setAttribute("appId", appId);
			request.setAttribute("l_type", l_type);
			request.setAttribute("slot_date", slot_date);
			request.setAttribute("slots", slots);
			RequestDispatcher rs = request.getRequestDispatcher("TimeSlotBooking.jsp");
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
