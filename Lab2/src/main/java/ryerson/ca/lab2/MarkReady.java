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
@WebServlet(name = "MarkReady", urlPatterns = {"/MarkReady"})
public class MarkReady extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // must be logged in
        if (request.getSession(false) == null || request.getSession().getAttribute("uname") == null) {
            RequestDispatcher rd = request.getRequestDispatcher("loginfailed.jsp");
            rd.forward(request, response);
            return;
        }

        String rxId = request.getParameter("rxId"); // from button value
        PharmacyData pdata = (PharmacyData) request.getSession().getAttribute("pdata");

        // find rx and set it ready
        for (Prescription p : pdata.getIncoming()) {
            // checking id
            if (p.getRxId().equals(rxId)) {
                p.setStatus("READY"); // update status
                break;
            }
        }

        request.setAttribute("msg", "Prescription " + rxId + " marked READY for pickup."); // message

        RequestDispatcher rd = request.getRequestDispatcher("markready.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}
