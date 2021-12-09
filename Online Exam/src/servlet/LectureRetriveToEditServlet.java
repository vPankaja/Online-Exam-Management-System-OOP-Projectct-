package servlet;

import model.Lecturer;
import service.LecturerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

@WebServlet("/LectureRetriveToEditServlet")
public class LectureRetriveToEditServlet extends HttpServlet {
    public static final Logger logger = Logger.getLogger(LectureRetriveToEditServlet.class.getName());
    private LecturerService LecRec1;
    public void init() {
        this.LecRec1  = new LecturerService();
    }




        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        }

        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            int userId = Integer.parseInt(request.getParameter("userId"));
            Lecturer p =  LecRec1.selectRecord(userId);

            request.setAttribute("userId",p.getUserId());
            request.setAttribute("staffId",p.getStaffId());
            request.setAttribute("NIC",p.getNIC());
            request.setAttribute("name",p.getName());
            request.setAttribute("section",p.getSection());
            request.setAttribute("email",p.getEmail());
            request.setAttribute("username",p.getUsername());
            request.setAttribute("password",p.getPassword());

            request.getRequestDispatcher("updateLecturer.jsp").forward(request,response);
    }



}
