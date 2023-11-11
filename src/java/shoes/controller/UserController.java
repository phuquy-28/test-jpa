/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shoes.controller;

import java.io.IOException;
import java.util.HashSet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import shoes.business.User;
import shoes.data.UserDB;
import shoes.util.CookieUtil;

/**
 *
 * @author phuqu
 */
public class UserController extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException {

        String requestURI = request.getRequestURI();
        String url = "/";
        if (requestURI.endsWith("/register")) {
            url = register(request, response);
        } else if (requestURI.endsWith("/login")) {
            url = login(request, response);
        }
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }
    
    @Override
    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException {
        doPost(request, response);
    }

    private String register(HttpServletRequest request,
            HttpServletResponse response) {

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String phoneNumber = request.getParameter("phone");
        String password = request.getParameter("password");

        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setPhoneNumber(phoneNumber);
        user.setPassword(password);

        String url;
        String message;
        //check that email address doesn't already exist
        if (UserDB.emailExists(email)) {
            message = "This email address already exists. <br>"
                    + "Please enter another email address.";
            request.setAttribute("message", message);
            request.setAttribute("user", user);
            url = "/account/login.jsp";
        } else {
            UserDB.insert(user);
            message = "Registrantion Successful. Now you can log in";
            request.setAttribute("message", message);
            url = "/account/login.jsp";
        }
        return url;
    }

    private String login(HttpServletRequest request,
            HttpServletResponse response) {

//        String productCode = request.getParameter("productCode");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();
//        session.setAttribute("productCode", productCode);
        User user = (User) session.getAttribute("user");

        String url;
        // if User object doesn't exist, check email cookie
        if (user == null) {
            Cookie[] cookies = request.getCookies();
            String emailAddress = CookieUtil.getCookieValue(cookies, "emailCookie");
            // if cookie doesn't exist, create cookie and login
            if (emailAddress == null || emailAddress.equals("")) {
                String message;
                //check that email address doesn't already exist
                if (!UserDB.accountExists(email, password)) {
                    message = "Wrong email or password. <br>"
                            + "Please re-try again.";
                    request.setAttribute("message", message);
                    url = "/account/login.jsp";
                } else {
                    Cookie emailNewCookie = new Cookie("emailCookie", email);
                    Cookie passNewCookie = new Cookie("passwordCookie", password);
                    if (request.getParameter("remeberPassword") != null){
                        emailNewCookie.setMaxAge(60 * 60 * 24 * 365 * 2);   //2 years
                        passNewCookie.setMaxAge(60 * 60 * 24 * 365 * 2);
                    } else{
                        emailNewCookie.setMaxAge(0);
                        passNewCookie.setMaxAge(0);
                    }
                    response.addCookie(emailNewCookie);
                    response.addCookie(passNewCookie);
                    message = "";
                    request.setAttribute("message", message);
                    user = UserDB.selectUser(emailAddress);
                    session.setAttribute("user", user);
                    url = "/index.jsp";
                }
            } // if cookie exists, create User object and go to Main page
            else { 
                user = UserDB.selectUser(emailAddress);
                session.setAttribute("user", user);
                request.setAttribute("user", user);
                url = "/index.jsp";
            }
        } // if User object exists, go to Main page
        else {
            url = "/index.jsp";
        }
        return url;
    }
}
