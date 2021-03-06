/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.user;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dal.LoginSignupDAO;
import model.User;

/**
 *
 * @author Admin
 */
@WebServlet(name = "UsersLoginServlet", urlPatterns = {"/login"})
public class UserLoginServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UsersLoginServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UsersLoginServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        Cookie arr[] = request.getCookies();
        if (arr != null) {
            for (Cookie o : arr) {
                if (o.getName().equals("userC")) {
                    request.setAttribute("user", o.getValue());
                }
                if (o.getName().equals("passC")) {
                    request.setAttribute("pass", o.getValue());
                }
            }
        }
        //set sang form
        request.getRequestDispatcher("login.jsp").forward(request, response);
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
        String username = request.getParameter("user");
        String password = request.getParameter("pass");
        String remember = request.getParameter("remember");
        LoginSignupDAO dao = new LoginSignupDAO();
        User a = dao.login(username, password);
        if (a == null) {
            request.setAttribute("mess", "Wrong username or password!");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else {
            HttpSession session = request.getSession();
            if (a.getAdmin() != 1) {

                session.setAttribute("account", a);
                //luu tren Cookie
                Cookie u = new Cookie("userC", username);
                Cookie p = new Cookie("passC", password);
                //set age
                u.setMaxAge(24 * 60 * 60);

                if (remember != null) {
                    p.setMaxAge(24 * 60 * 60);
                } else {
                    p.setMaxAge(0);
                }
                //luu tren web
                response.addCookie(u);
                response.addCookie(p);
                response.sendRedirect("index.jsp");
            } else {
                session.setAttribute("admin", a);
                Cookie u = new Cookie("userC", username);
                Cookie p = new Cookie("passC", password);
                //set age
                u.setMaxAge(24 * 60 * 60);

                if (remember != null) {
                    p.setMaxAge(24 * 60 * 60);
                } else {
                    p.setMaxAge(0);
                }
                //luu tren web
                response.addCookie(u);
                response.addCookie(p);
                response.sendRedirect("index.jsp");
            }
        }
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
