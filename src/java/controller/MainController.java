/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Tony
 */
public class MainController extends HttpServlet {
    
    private static final String LOGIN_PAGE = "login.jsp";
    private static final String LOGIN = "Login";
    private static final String LOGIN_CONTROLLER = "LoginController";
    private static final String ADD = "Add";
    private static final String ADD_CONTROLLER = "MobileAddController";
    private static final String SEARCH = "search";
    private static final String SEARCH_CONTROLLER = "MobileSearchController";
    private static final String DELETE = "delete";
    private static final String DELETE_CONTROLLER = "MobileDeleteController";
    private static final String UPDATE = "update";
    private static final String UPDATE_CONTROLLER = "MobileUpdateController";
    private static final String LOGOUT = "LOGOUT";
    private static final String LOGOUT_CONTROLLER = "LogoutController";
    private static final String AddUSER = "AddUSER";
    private static final String AddUserController = "AddUserController";
    private static final String addToCart = "addToCart";
    private static final String AddCartController = "AddCartController";
    private static final String removeFromCart = "removeFromCart";
    private static final String SearchCartController = "SearchCartController";
    private static final String viewCart = "viewCart";
    private static final String ViewCartController = "ViewCartController";
    private static final String searchCart = "searchCart";
    private static final String DeleteFromCartController = "DeleteFromCartController";
    
    protected void processRequets(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        String url = LOGIN_PAGE;
        try {
            String action = req.getParameter("action");

            if (action == null) {
                url = LOGIN_PAGE;
            }else if (action.equalsIgnoreCase(LOGIN)) {
                url = LOGIN_CONTROLLER;
            } else if (action.equalsIgnoreCase(ADD)) {
                url = ADD_CONTROLLER;
            } else if (action.equalsIgnoreCase(SEARCH)) {
                url = SEARCH_CONTROLLER;
            } else if (action.equalsIgnoreCase(DELETE)) {
                url = DELETE_CONTROLLER;
            } else if (action.equalsIgnoreCase(UPDATE)){
                url = UPDATE_CONTROLLER;
            }else if (action.equalsIgnoreCase(LOGOUT)){
                url = LOGOUT_CONTROLLER;
            }else if (action.equalsIgnoreCase(AddUSER)){
                url = AddUserController;
            }else if (action.equalsIgnoreCase(addToCart)) {
                url = AddCartController;
            } else if (action.equalsIgnoreCase(removeFromCart)){
                url = DeleteFromCartController;
            }else if (action.equalsIgnoreCase(viewCart)){
                url = ViewCartController;
            }else if (action.equalsIgnoreCase(searchCart)){
                url = SearchCartController;
            }
        } catch (Exception e) {
            log("Error at MainController: " + e.toString());
        } finally {
            req.getRequestDispatcher(url).forward(req, resp);
        }     

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequets(req, resp); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequets(req, resp); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
}
