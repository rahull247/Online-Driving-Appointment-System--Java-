

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SlotServlet1
 */
@WebServlet("/SlotServlet1")
public class SlotServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SlotServlet1() {
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
		String appid=request.getParameter("appId");
		String flag=request.getParameter("slotFlag");
		
		if(flag.equals("LLBook") ) 
		{
			request.setAttribute("appId",appid);
			request.setAttribute("l_type", "LL");
			RequestDispatcher rs = request.getRequestDispatcher("SlotMarch.jsp");
			rs.forward(request,response);
		}
		if(flag.equals("DLBook"))
		{
			request.setAttribute("appId",appid);
			request.setAttribute("l_type", "DL");
			RequestDispatcher rs = request.getRequestDispatcher("SlotMarch.jsp");
			rs.forward(request,response);
		}
		if(flag.equals("LLCancel") || flag.equals("DLCancel"))
		{
			TimeSlotDAO dao=new TimeSlotDAO();
			if(dao.cancelSlot(Integer.parseInt(appid)))
			{
				RequestDispatcher rs = request.getRequestDispatcher("CancelSlotSuccess.jsp");
				rs.forward(request,response);
			}
		}
	}
}
