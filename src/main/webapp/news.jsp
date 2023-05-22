<%@ page import="com.example.demo.Entity.News" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Ettihad News Page</title>
    <script src="assets/js/color-modes.js"></script>
    <script src="assets/js/color-modes.js"></script>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<jsp:include page="includes/header.jsp"></jsp:include>

<div class="news-grid">
    <%
        List<News> newsList = (List<News>) request.getAttribute("newsList");
    %>
    <% for (int i = newsList.size() - 1; i >= 0; i--) { %>
        <div class="news-container">

            <img src="https://striveliving.ca/wp-content/uploads/2014/11/Newspaper-BIG-NEWS-300x200.jpg" alt="News Image">
            <h2><%= newsList.get(i).getTitle() %></h2>
            Published by: <p><%= newsList.get(i).getAuthor() %></p> on <p><%= newsList.get(i).getPublishedAt() %></p>
            <p><%= newsList.get(i).getContent() %></p>
            <a href="http://localhost:8080/news/article?article_id=<%=newsList.get(i).getId()%>">Read More</a>
        </div>
    <% } %>
</div>

<div class="footer"><jsp:include page="includes/footer.jsp"></jsp:include></div>
</body>
</html>
