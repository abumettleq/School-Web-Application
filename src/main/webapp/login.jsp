<%@ page import="com.example.demo.Entity.Student" %>
<%@ page import="com.example.demo.Entity.UserType" %>
<%@ page import="com.example.demo.Entity.Teacher" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%
    if((UserType)session.getAttribute("user_type") == UserType.Student && (Student)session.getAttribute("userObject") != null)
    {
        response.sendRedirect("sis/home");
        return;
    }
    else if((UserType)session.getAttribute("user_type") == UserType.Teacher && (Teacher)session.getAttribute("userObject") != null)
    {
        response.sendRedirect("sms/home");
        return;
    }
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Ettihad Login Page</title>
    <script src="assets/js/color-modes.js"></script>
    <link rel="stylesheet" href="css/style.css">
</head>
<jsp:include page="includes/header.jsp"></jsp:include>
<body class="login-bg">
            <div class="login-container">
                <form method="post" action="authenticate" class="form">
                    <input name="username" type="text" placeholder="Enter Username" class="input" minlength="4" required>
                    <br>
                    <input name="password" type="password" placeholder="Enter Password" class="input" required minlength="4">
                    <br>
                    <input type="submit" value="Login" style="padding: 4px">
                </form>
            </div>

            <%
                if(request.getAttribute("error") != null)
                {
            %>
                    <div class="alert alert-danger alert-dismissible fade show" role="alert">
                        <strong>Holy guacamole! </strong> ${error}
                        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                    </div>
            <%
                }
            %>

            <%
                if(request.getAttribute("message") != null)
                {
            %>
                    <div class="alert alert-info alert-dismissible fade show" role="alert">
                        <strong>Message: </strong> ${message}
                        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                    </div>
            <%
                }
            %>
<div class="footer"><jsp:include page="includes/footer.jsp"></jsp:include></div>
</body>
</html>
