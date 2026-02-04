<%-- 
    Document   : incomingprescriptions
    Created on : Feb 3, 2026, 8:48:39 PM
    Author     : Jeanie
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8" import="ryerson.ca.lab2.Prescription"%>

<html>
<head>
    <title>Incoming Prescriptions</title>
</head>

<style>
/* same styling as other pages */
body { background-color: #f4f6fb; font-family: Arial, sans-serif; margin: 0; }
.topbar { background: white; padding: 16px 20px; border-bottom: 1px solid #ddd; display:flex; justify-content: space-between; }
.card { background: white; border: 1px solid #ddd; border-radius: 12px; padding: 18px; max-width: 950px; margin: 22px auto; }
a { color:#2563eb; font-weight:bold; text-decoration:none; }
button { padding: 8px 10px; border: none; border-radius: 10px; background: #2563eb; color: white; font-weight: bold; cursor: pointer; }
.small { color:#555; }
</style>

<body>

<%
    // list from servlet
    ArrayList<Prescription> rxList = (ArrayList) request.getAttribute("incomingPrescriptions");
%>

<div class="topbar">
    <div>
        <!-- display username from session -->
        <b>Hello <%=session.getAttribute("uname")%></b>
    </div>
    <div>
        <!-- logout servlet -->
        <a href="Logout">Logout</a>
    </div>
</div>

<div class="card">
    <center><h2>Incoming Prescriptions</h2></center>
    <center><p class="small"><!-- basic instructions -->Review and mark ready when done.</p></center>

    <!-- use 1 form and pass rxId using button value -->
    <form action="MarkReady" method="post">
        <table border="2" align="center" cellpadding="5" cellspacing="5">
            <tr>
                <th>Rx ID</th>
                <th>Patient</th>
                <th>Medication</th>
                <th>Received</th>
                <th>Status</th>
                <th>Action</th>
            </tr>

            <%
                // loop 
                for (Prescription p : rxList) {
            %>
            <tr>
                <td><%=p.getRxId()%></td>
                <td><%=p.getPatientName()%></td>
                <td><%=p.getMedication()%></td>
                <td><%=new SimpleDateFormat("yyyy-MM-dd").format(p.getReceivedDate())%></td>
                <td><%=p.getStatus()%></td>
                <td>
                    <!-- sending rx id -->
                    <button type="submit" name="rxId" value="<%=p.getRxId()%>">Mark Ready</button>
                </td>
            </tr>
            <%
                }
            %>

        </table>
    </form>
</div>

</body>
</html>
