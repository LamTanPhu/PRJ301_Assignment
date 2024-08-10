/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class MobileDeleteController extends HttpServlet {
    protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        try {
                DAO dao = new DAO();
                String mobileId = req.getParameter("mobileId");
                boolean response = dao.deleteMobile(mobileId);
                if (response == true) {
                    req.setAttribute("message", "Delete mobile successfully.");
                } else {
                    req.setAttribute("message", "Failed to delete mobile.");
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