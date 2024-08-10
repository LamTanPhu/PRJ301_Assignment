/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.CartController;

import dao.DAO;
import dto.Cart;
import dto.Mobile;
import dto.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
public class SearchCartController extends HttpServlet {

    protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User session = (User) req.getSession().getAttribute("user");
        if (session == null) {
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
        resp.setContentType("text/html;charset=UTF-8");
          String minPrice = req.getParameter("minPrice");
            String maxPrice = req.getParameter("maxPrice"); 
            
            if (minPrice.equalsIgnoreCase("") || maxPrice.equalsIgnoreCase("")) {
                List<Mobile> mobiles = new ArrayList<>();
                if (minPrice.equalsIgnoreCase("") && !maxPrice.equalsIgnoreCase("")) {
                    mobiles.addAll(new DAO().getAllMobilesWithCondition(-1, Float.parseFloat(maxPrice)));
                } else if (!minPrice.equalsIgnoreCase("") && maxPrice.equalsIgnoreCase("")) {
                    mobiles.addAll(new DAO().getAllMobilesWithCondition(Float.parseFloat(minPrice), -1));
                } else {
                    mobiles.addAll(new DAO().getAllMobilesWithCondition(-1, -1));
                }
                req.setAttribute("mobiles", mobiles);
                req.getRequestDispatcher("cart.jsp").forward(req, resp);
            } else {
                List<Mobile> mobiles = new DAO().getAllMobilesWithCondition(Float.parseFloat(minPrice), Float.parseFloat(maxPrice));
                req.setAttribute("mobiles", mobiles);
                req.getRequestDispatcher("cart.jsp").forward(req, resp);    
            }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
