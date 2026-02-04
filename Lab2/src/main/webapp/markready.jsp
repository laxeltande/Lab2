<%-- 
    Document   : markready
    Created on : Feb 3, 2026, 8:48:48 PM
    Author     : Jeanie
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Update Result</title>
</head>

<style>
/* keep it consistent */
body { background-color: #f4f6fb; font-family: Arial, sans-serif; }
.box { background: white; border: 1px solid #ddd; border-radius: 12px; padding: 18px; max-width: 800px; margin: 60px auto; }
a { color:#2563eb; font-weight:bold; text-decoration:none; }
</style>

<body>
<div class="box">
    <h2>Update Result</h2>

    <!-- msg from servlet -->
    <p><%= request.getAttribute("msg") %></p>

    <!-- back to list -->
    <a href="ReviewIncoming">Back to Incoming Prescriptions</a>
</div>
</body>
</html>