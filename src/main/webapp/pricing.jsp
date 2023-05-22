<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Ettihad School Pricing</title>
    <script src="assets/js/color-modes.js"></script>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
        }
        header {
            background-color: #2a3848;
            color: #fff;
            padding: 1rem;
            text-align: center;
            margin-bottom: 20px;
        }
        ttn {
            display: flex;
            flex-wrap: wrap;
            justify-content: center;
            padding: 1rem;
        }
        .card {
            background-color: #f9f9f9;
            border-radius: 0.5rem;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            margin: 1rem;
            padding: 1rem;
            text-align: center;
            width: 20rem;
        }
        .card h2 {
            font-size: 2rem;
            margin-top: 0;
        }
        .card p {
            margin-top: 0;
        }
    </style>
</head>
<body>
<jsp:include page="includes/header.jsp"></jsp:include>
<header>
    <h1>Our School Pricing</h1>
</header>
<ttn>
    <div class="card">
        <h2>Admission</h2>
        <p>$500</p>
        <p>One-time fee</p>
    </div>
    <div class="card">
        <h2>Registration</h2>
        <p>$100</p>
        <p>Annual fee</p>
    </div>
    <div class="card">
        <h2>Tuition</h2>
        <p>$1,000</p>
        <p>Per semester</p>
    </div>
    <div class="card">
        <h2>Books and Supplies</h2>
        <p>$300</p>
        <p>Per semester</p>
    </div>
</ttn>
<div class="footer"><jsp:include page="includes/footer.jsp"></jsp:include></div>
</body>
</html>
