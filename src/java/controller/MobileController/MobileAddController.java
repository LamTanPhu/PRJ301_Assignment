package controller.MobileController;

import dto.User;
import dao.DAO;
import dto.Mobile;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
public class MobileAddController extends HttpServlet {
    protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        try{
                DAO dao = new DAO();
                String mobileId = req.getParameter("mobileId");
                String price = req.getParameter("price");
                String description = req.getParameter("description");
                String mobileName = req.getParameter("mobileName");
                String yearOfProduction = req.getParameter("yearOfProduction");
                String quantity = req.getParameter("quantity");
                String notSale = req.getParameter("notSale");
                String imageLink=req.getParameter("imageLink");
                int notSaleInt = 0;
                if (notSale != null && "true".equals(notSale)) {
                    notSaleInt = 1;
                }
                boolean response = dao.createMobile(new Mobile(mobileId, description, Float.parseFloat(price), mobileName, Integer.parseInt(yearOfProduction), Integer.parseInt(quantity), notSaleInt,imageLink));
                if (response == true) {
                    req.setAttribute("message", "Mobile created successfully.");
                } else {
                    req.setAttribute("message", "Failed to create mobile.");
                }
        }catch(Exception e){
            
        }finally{
            req.getRequestDispatcher("mobile.jsp").forward(req, resp);        
        }
        
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }
}
