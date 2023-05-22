<%@ page import="com.example.demo.Entity.eLibrary" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.ArrayList" %>

<!DOCTYPE html>
<%
    HashMap<String, List<eLibrary>> pdfMap = (HashMap<String, List<eLibrary>>) request.getAttribute("resultsMap");

%>

<html>
<head>
    <meta charset="UTF-8">
    <title>Ettihad eLibrary Page</title>
    <script src="../assets/js/color-modes.js"></script>
    <link href="css/pdf-viewer.css" rel="stylesheet">
</head>
<style>
    header {
        background-color: #2a3848;
        color: #fff;
        padding: 1rem;
        text-align: center;
        margin-bottom: 20px;
    }
    .pdf-category {
        margin-top: 40px;
        margin-bottom: 20px;
        font-size: 20px;
        font-weight: bold;
        text-transform: uppercase;
        color: #333;
        border-bottom: 2px solid #eee;
        padding-bottom: 10px;
        letter-spacing: 2px;
    }

</style>
<body>
<div><jsp:include page="../includes/header.jsp"></jsp:include></div>
<header><h3>PDF List</h3></header>
<%
    if (pdfMap.isEmpty()) {
%>
<div class="pdf-container">
    <H3>No Contents Found</H3>
</div>
<%
} else {
// Display PDFs by category
    for (String category : pdfMap.keySet()) {
%>
<div class="pdf-category"><%=category%></div>
<div class="pdf-container">
    <% for (eLibrary pdf : pdfMap.get(category)) { %>
    <div class="pdf-card">
        <img class="pdf-preview" src="<%=pdf.getPreview_url()%>" alt="PDF Preview">
        <div class="pdf-details">
            <div class="pdf-title"><%=pdf.getTitle()%></div>
            <div class="pdf-link"><a href="<%=pdf.getSrc_url()%>" target="_blank">View PDF</a></div>
            <div class="pdf-about"><%=pdf.getAbout()%></div>
        </div>
    </div>
    <% } %>
</div>
<%
        }
    }
%>

<jsp:include page="../includes/footer.jsp"></jsp:include>
</body>
</html>