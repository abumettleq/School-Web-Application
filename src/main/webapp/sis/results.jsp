<%@ page import="com.example.demo.Entity.Student" %>
<%@ page import="com.example.demo.Entity.Result" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>S.I.S Results</title>
    <script src="../assets/js/color-modes.js"></script>
    <link rel="stylesheet" href="css/all.css">
</head>
<script>
    function updateTime() {
        let now = new Date();
        let clock = document.getElementById('clock');
        clock.innerHTML = now.toLocaleTimeString();
    }
    function updateDate() {
        let now = new Date();
        let date = now.toLocaleDateString();
        let clock = document.getElementById('date');
        clock.innerHTML = date;
    }
    setInterval(updateTime, 1000);
    setInterval(updateDate, 1000);
</script>
<script src="js/vendor.js?id=0a5a5c465198b585a07e" type="text/javascript"></script>
<script src="js/app.js?id=9c082e4b2f63d36f0262" type="text/javascript"></script>
<body>

<div class="kt-grid kt-grid--hor kt-grid--root">
    <div class="kt-grid__item kt-grid__item--fluid kt-grid kt-grid--ver kt-page">
        <div class="kt-aside  kt-aside--fixed  kt-grid__item kt-grid kt-grid--desktop kt-grid--hor-desktop" id="kt_aside">
            <div class="kt-aside__brand kt-grid__item " id="kt_aside_brand" kt-hidden-height="65" style="">
                <div class="kt-aside__brand-logo">
                    <h3 class="kt--font-light">SIS</h3>
                </div>
                <div class="kt-aside__brand-tools">
                    <button class="kt-aside__brand-aside-toggler" id="kt_aside_toggler">
            <span><svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" width="24px" height="24px" viewBox="0 0 24 24" version="1.1" class="kt-svg-icon">
                    <g stroke="none" stroke-width="1" fill="none" fill-rule="evenodd">
                        <polygon points="0 0 24 0 24 24 0 24"></polygon>
                        <path d="M5.29288961,6.70710318 C4.90236532,6.31657888 4.90236532,5.68341391 5.29288961,5.29288961 C5.68341391,4.90236532 6.31657888,4.90236532 6.70710318,5.29288961 L12.7071032,11.2928896 C13.0856821,11.6714686 13.0989277,12.281055 12.7371505,12.675721 L7.23715054,18.675721 C6.86395813,19.08284 6.23139076,19.1103429 5.82427177,18.7371505 C5.41715278,18.3639581 5.38964985,17.7313908 5.76284226,17.3242718 L10.6158586,12.0300721 L5.29288961,6.70710318 Z" fill="#000000" fill-rule="nonzero" transform="translate(8.999997, 11.999999) scale(-1, 1) translate(-8.999997, -11.999999) "></path>
                        <path d="M10.7071009,15.7071068 C10.3165766,16.0976311 9.68341162,16.0976311 9.29288733,15.7071068 C8.90236304,15.3165825 8.90236304,14.6834175 9.29288733,14.2928932 L15.2928873,8.29289322 C15.6714663,7.91431428 16.2810527,7.90106866 16.6757187,8.26284586 L22.6757187,13.7628459 C23.0828377,14.1360383 23.1103407,14.7686056 22.7371482,15.1757246 C22.3639558,15.5828436 21.7313885,15.6103465 21.3242695,15.2371541 L16.0300699,10.3841378 L10.7071009,15.7071068 Z" fill="#000000" fill-rule="nonzero" opacity="0.3" transform="translate(15.999997, 11.999999) scale(-1, 1) rotate(-270.000000) translate(-15.999997, -11.999999) "></path>
                    </g>
                </svg></span>
                        <span><svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" width="24px" height="24px" viewBox="0 0 24 24" version="1.1" class="kt-svg-icon">
                    <g stroke="none" stroke-width="1" fill="none" fill-rule="evenodd">
                        <polygon points="0 0 24 0 24 24 0 24"></polygon>
                        <path d="M12.2928955,6.70710318 C11.9023712,6.31657888 11.9023712,5.68341391 12.2928955,5.29288961 C12.6834198,4.90236532 13.3165848,4.90236532 13.7071091,5.29288961 L19.7071091,11.2928896 C20.085688,11.6714686 20.0989336,12.281055 19.7371564,12.675721 L14.2371564,18.675721 C13.863964,19.08284 13.2313966,19.1103429 12.8242777,18.7371505 C12.4171587,18.3639581 12.3896557,17.7313908 12.7628481,17.3242718 L17.6158645,12.0300721 L12.2928955,6.70710318 Z" fill="#000000" fill-rule="nonzero"></path>
                        <path d="M3.70710678,15.7071068 C3.31658249,16.0976311 2.68341751,16.0976311 2.29289322,15.7071068 C1.90236893,15.3165825 1.90236893,14.6834175 2.29289322,14.2928932 L8.29289322,8.29289322 C8.67147216,7.91431428 9.28105859,7.90106866 9.67572463,8.26284586 L15.6757246,13.7628459 C16.0828436,14.1360383 16.1103465,14.7686056 15.7371541,15.1757246 C15.3639617,15.5828436 14.7313944,15.6103465 14.3242754,15.2371541 L9.03007575,10.3841378 L3.70710678,15.7071068 Z" fill="#000000" fill-rule="nonzero" opacity="0.3" transform="translate(9.000003, 11.999999) rotate(-270.000000) translate(-9.000003, -11.999999) "></path>
                    </g>
                </svg></span>
                    </button>

                </div>
            </div>
            <jsp:include page="includes/sis_sidebar.jsp"></jsp:include>
        </div>
        <div class="kt-grid__item kt-grid__item--fluid kt-grid kt-grid--hor kt-wrapper" id="kt_wrapper">

            <div id="kt_header" class="kt-header kt-grid__item  kt-header--fixed " style="background-color: #1e1e2e">
                <div class="kt-header-menu-wrapper" id="kt_header_menu_wrapper">
                </div>

                <!-- end:: Header Menu -->
                <jsp:include page="includes/sis_header.jsp"></jsp:include>

            </div>
            <div class="kt-content  kt-grid__item kt-grid__item--fluid kt-grid kt-grid--hor" id="kt_content">
                <div class="row">
                    <div class="col-xl-12">
                    </div>
                </div>
                <div class="kt-subheader  kt-grid__item" id="kt_subheader">
                    <div class="kt-container  kt-container--fluid ">
                        <div class="kt-subheader__main">
                            <h3 class="kt-subheader__title ">Dashboard</h3>
                        </div>
                    </div>
                </div>
                <div class="kt-container  kt-container--fluid  kt-grid__item kt-grid__item--fluid">
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="kt-portlet">
                                <div class="kt-portlet__body  kt-portlet__body--fit">
                                    <div class="row row-no-padding row-col-separator-lg">
                                        <div class="col-md-12 col-lg-6 col-xl-6">
                                            <!--begin::Total Profit-->
                                            <div class="kt-widget24">
                                                <div class="kt-widget24__details">
                                                    <div class="kt-widget24__info">
                                                        <h4 class="kt-widget24__title">Curent Date</h4>
                                                        <span class="kt-widget24__desc"></span>
                                                    </div>
                                                    <span id="date" class="kt-widget24__stats kt-font-brand"></span>
                                                </div>
                                                <div class="progress progress--sm">
                                                    <div class="progress-bar kt-bg-brand" role="progressbar" style="width: 100%;" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100"></div>
                                                </div>

                                            </div>

                                            <!--end::Total Profit-->
                                        </div>
                                        <div class="col-md-12 col-lg-6 col-xl-6">

                                            <!--begin::New Feedbacks-->
                                            <div class="kt-widget24">
                                                <div class="kt-widget24__details">
                                                    <div class="kt-widget24__info">
                                                        <h4 class="kt-widget24__title">Current Time</h4>
                                                        <span class="kt-widget24__desc"></span>
                                                    </div>
                                                    <span id="clock" class="kt-widget24__stats kt-font-success"></span>
                                                </div>
                                                <div class="progress progress--sm">
                                                    <div class="progress-bar kt-bg-success" role="progressbar" style="width: 100%;" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100"></div>
                                                </div>

                                            </div>

                                            <!--end::New Feedbacks-->
                                        </div>
                                        <!--end::New Orders-->
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="kt-portlet">
                        <div class="kt-portlet__body kt-portlet__body--fit">
                            <div class="row row-no-padding row-col-separator-xl">
                                <%
                                    Map<Integer, List<Result>> resultsMap = (Map<Integer, List<Result>>) request.getAttribute("resultsMap");
                                %>

                                <!--begin:: Widgets/Stats2-1 -->
                                <div class="container">
                                    <h2>Results</h2>
                                    <br>
                                    <%for(Integer classNum : resultsMap.keySet()) { %>
                                    <div class="panel panel-default">
                                        <div class="panel-heading">
                                            <h4 class="panel-title">
                                                <a data-toggle="collapse" href="#collapse<%=classNum%>">
                                                    Class <%=classNum%>
                                                </a>
                                            </h4>
                                        </div>
                                        <div id="collapse<%=classNum%>" class="panel-collapse collapse">
                                            <ul class="list-group">
                                                <% for(Result result : resultsMap.get(classNum)) { %>
                                                <li class="list-group-item">
                                                    <a data-toggle="collapse" href="#collapse<%=result.getResult_id()%>">
                                                        <%=result.getSubject_code()%>
                                                    </a>
                                                    <div id="collapse<%=result.getResult_id()%>" class="panel-collapse collapse">
                                                        <table class="table table-striped">
                                                            <thead>
                                                            <tr>
                                                                <th>Quiz 1 (15)</th>
                                                                <th>Quiz 2 (15)</th>
                                                                <th>Quiz 3 (15)</th>
                                                                <th>Quiz 4 (15)</th>
                                                                <th>Midterm (30)</th>
                                                                <th>Finalterm (60)</th>
                                                            </tr>
                                                            </thead>
                                                            <tbody>
                                                            <tr>
                                                                <td><%=result.getQuiz1()%></td>
                                                                <td><%=result.getQuiz2()%></td>
                                                                <td><%=result.getQuiz3()%></td>
                                                                <td><%=result.getQuiz4()%></td>
                                                                <td><%=result.getMidterm()%></td>
                                                                <td><%=result.getFinalterm()%></td>
                                                            </tr>
                                                            </tbody>
                                                        </table>
                                                    </div>
                                                </li>
                                                <% } %>
                                            </ul>
                                        </div>
                                    </div>
                                    <% } %>

                                </div>

                                    <!--end:: Widgets/Stats2-1 -->
                                </div>

                            </div>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </div>
</div>

<div class="footer"><jsp:include page="../includes/footer.jsp"></jsp:include></div>
</body>
</html>
