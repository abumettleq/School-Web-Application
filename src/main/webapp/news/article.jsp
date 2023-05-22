<%@ page import="com.example.demo.Entity.News" %><%
News news = (News) request.getAttribute("article");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Ettihad News Article</title>
    <script src="assets/js/color-modes.js"></script>
    <link rel="stylesheet" href="css/news.css">
</head>
<body>
<jsp:include page="../includes/header.jsp"></jsp:include>
<div class="container">
    <%
        if(news != null)
        {
    %>
                <h1><%=news.getTitle()%></h1>
                <p class="author"><%=news.getAuthor()%></p>
                <p class="published"><%=news.getPublishedAt()%></p>
                <p class="body">
                                    <%=news.getBody()%>
                </p>
    <%
        }
        else
        {
    %>
                <h3>Nothing Found!</h3>
    <%
        }
    %>
</div>
<div class="footer"><jsp:include page="../includes/footer.jsp"></jsp:include></div>
</body>
</html>
