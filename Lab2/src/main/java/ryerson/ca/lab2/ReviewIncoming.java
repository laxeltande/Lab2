/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ryerson.ca.lab2;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jeanie
 */
@WebServlet(name = "ReviewIncoming", urlPatterns = {"/ReviewIncoming"})
public class ReviewIncoming extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // session check, if no uname then they didnt login
        if (request.getSession(false) == null || request.getSession().getAttribute("uname") == null) {
            RequestDispatcher rd = request.getRequestDispatcher("loginfailed.jsp");
            rd.forward(request, response);
            return;
        }

        PharmacyData pdata = (PharmacyData) request.getSession().getAttribute("pdata"); // get list

        // send list to jsp using request attribute
        request.setAttribute("incomingPrescriptions", pdata.getIncoming());

        RequestDispatcher rd = request.getRequestDispatcher("incomingprescriptions.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}
