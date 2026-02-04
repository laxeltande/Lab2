<%-- 
    Document   : loginfailed
    Created on : Feb 3, 2026, 8:48:24 PM
    Author     : Jeanie
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Login Failed</title>
</head>

<style>
/* same basic style as other pages */
body { background-color: #f4f6fb; font-family: Arial, sans-serif; }
.box { background: white; border: 1px solid #ddd; border-radius: 12px; padding: 18px; max-width: 700px; margin: 60px auto; }
a { color:#2563eb; font-weight:bold; text-decoration:none; }
</style>

<body>
<div class="box">
    <!-- user gets here if login wrong or session missing -->
    <h2>Login Failed / Access Denied.</h2>
    <p>Please go back and try again.</p>
    <a href="index.html">Back to login.</a>
</div>
</body>
</html>