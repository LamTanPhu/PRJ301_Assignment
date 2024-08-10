/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.MobileController;

import dao.DAO;
import dto.Mobile;
import dto.User;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Tony
 */
public class MobileUpdateController extends HttpServlet {

    protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        String url = "SearchController";
        try {
                DAO dao = new DAO();
                String mobileId = req.getParameter("mobileId");
                String price = req.getParameter("price");
                String description = req.getParameter("description");
                String quantity = req.getParameter("quantity");
                String notSale = req.getParameter("notSale");
                int notSaleInt = 0;

                if (notSale != null && "true".equals(notSale)) {
                    notSaleInt = 1;
                }

                boolean response = dao.updateMobile(mobileId, Float.parseFloat(price), description, Integer.parseInt(quantity), notSaleInt);
                if (response == true) {
                    req.setAttribute("message", "Mobile created successfully.");
                } else {
                    req.setAttribute("message", "Failed to create mobile.");
                }
                req.getRequestDispatcher("mobile.jsp").forward(req, resp);
        }catch(Exception ex){
            
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
