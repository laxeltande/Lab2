/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ryerson.ca.lab2;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = (String) request.getParameter("username"); // from html
        String password = (String) request.getParameter("password"); // from html

        // hardcoded login just for demo
        if (!("pharm".equals(username) && "123".equals(password))) {
            // login wrong so go to fail page
            RequestDispatcher rd = request.getRequestDispatcher("loginfailed.jsp");
            rd.forward(request, response);
            return;
        }

        // make session and store username
        request.getSession().setAttribute("uname", username); // session var

        // create data only once and store in session
        PharmacyData pdata = (PharmacyData) request.getSession().getAttribute("pdata");
        if (pdata == null) {
            pdata = new PharmacyData(); // new list holder

            try {
                // add some sample incoming prescriptions
                pdata.addPrescription(new Prescription("RX1001", "Sam", "Amoxicillin 500mg",
                        new SimpleDateFormat("yyyy-MM-dd").parse("2026-02-01"), "RECEIVED"));
                pdata.addPrescription(new Prescription("RX1002", "Lina", "Ibuprofen 200mg",
                        new SimpleDateFormat("yyyy-MM-dd").parse("2026-02-02"), "RECEIVED"));
                pdata.addPrescription(new Prescription("RX1003", "Omar", "Metformin 500mg",
                        new SimpleDateFormat("yyyy-MM-dd").parse("2026-02-03"), "RECEIVED"));
            } catch (ParseException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                // if date parsing breaks its fine
                System.out.println("date parse error");
            }

            request.getSession().setAttribute("pdata", pdata); // save in session
        }

        // go to incoming prescriptions servlet
        RequestDispatcher rd = request.getRequestDispatcher("ReviewIncoming");
        rd.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // reuse post so both work
        doPost(request, response);
    }
}
