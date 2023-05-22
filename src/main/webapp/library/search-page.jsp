<%@ page import="com.example.demo.Entity.eLibrary" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<%
    List<eLibrary> libraryList = (List<eLibrary>) request.getAttribute("filteredList");
%>
<html>
<head>
    <meta charset="UTF-8">
    <title>Search in Ettihad WebApp</title>
    <script src="../assets/js/color-modes.js"></script>
    <style>
        /* Style the container */
        .pdf-container {
            display: flex;
            flex-wrap: wrap;
            justify-content: center;
            align-items: stretch;
            padding: 20px;
        }

        /* Style the card */
        .pdf-card {
            display: flex;
            flex-direction: column;
            justify-content: space-between;
            align-items: center;
            margin: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            padding: 10px;
            width: 300px;
            height: 400px;
        }

        /* Style the PDF preview */
        .pdf-preview {
            width: 100%;
            height: 200px;
            object-fit: cover;
            margin-bottom: 10px;
        }

        /* Style the PDF title */
        .pdf-title {
            font-size: 24px;
            font-weight: bold;
            text-align: center;
            margin-bottom: 10px;
        }

        /* Style the PDF link */
        .pdf-link {
            font-size: 18px;
            text-align: center;
            margin-bottom: 10px;
        }

        /* Style the PDF about */
        .pdf-about {
            font-size: 16px;
            text-align: justify;
            margin-bottom: 10px;
        }

         header {
             background-color: #2a3848;
             color: #fff;
             padding: 1rem;
             text-align: center;
             margin-bottom: 20px;
         }
    </style>
</head>
<body>
<div><jsp:include page="../includes/header.jsp"></jsp:include></div>
<header><h2>Results found for "<%=(String)request.getAttribute("input-to-search")%>"</h2></header>

<div class="pdf-container">



    <%
        if(libraryList != null){

            for(eLibrary pdf : libraryList)
            {
    %>
                <div class="pdf-card">
                    <img class="pdf-preview" src="<%=pdf.getPreview_url()%>" alt="PDF Preview">
                    <div class="pdf-details">
                        <div class="pdf-title"><%=pdf.getTitle()%></div>
                        <div class="pdf-link"><a href="<%=pdf.getSrc_url()%>" target="_blank">View PDF</a></div>
                        <div class="pdf-about"><%=pdf.getAbout()%></div>
                    </div>
                </div>
    <%
            }
    %>
    <%
        }
    %>

    <%
        if(libraryList == null)
        {
    %>
    <div class="pdf-card"><h3>Nothing Found</h3></div>
    <%
        }
    %>

</div>
<div class="footer"><jsp:include page="../includes/footer.jsp"></jsp:include></div>
</body>
</html>
