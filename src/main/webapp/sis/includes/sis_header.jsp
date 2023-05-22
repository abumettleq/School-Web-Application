<%@ page import="com.example.demo.Entity.User" %>
<%@ page import="com.example.demo.Service.UserService" %>
<%@ page import="com.example.demo.Entity.Student" %>
<%
Student student = (Student) session.getAttribute("userObject");
    if (student == null) {
        response.sendRedirect("/login");
        return;
    }
%>
<!-- begin:: Header Topbar -->




<div class="kt-header__topbar">
    <!--begin: User Bar -->
    <div class="kt-header__topbar-item kt-header__topbar-item--user">
        <div class="kt-header__topbar-wrapper" data-toggle="dropdown" data-offset="0px,0px">
            <div class="kt-header__topbar-user">
                <span class="kt-header__topbar-welcome kt-hidden-mobile">Hi,</span>
                <span class="kt-header__topbar-username kt-hidden-mobile"><%=student.getId()%></span>
                <img class="kt-hidden" alt="Pic" src="https://sis.iutoic-dhaka.edu/assets/media/users/300_25.jpg">

                <!--use below badge element instead the user avatar to display username's first letter(remove kt-hidden class to display it) -->
                <span class="kt-badge kt-badge--username kt-badge--unified-success kt-badge--lg kt-badge--rounded kt-badge--bold">S</span>
            </div>
        </div>
        <div class="dropdown-menu dropdown-menu-fit dropdown-menu-right dropdown-menu-anim dropdown-menu-top-unround dropdown-menu-xl">

            <!--begin: Head -->
            <div class="kt-user-card kt-user-card--skin-dark kt-notification-item-padding-x" style="background-image: url(https://sis.iutoic-dhaka.edu/assets/media/misc/bg-1.jpg)">
                <div class="kt-user-card__avatar">
                    <img class="kt-hidden" alt="Pic" src="https://sis.iutoic-dhaka.edu/assets/media/users/300_25.jpg">

                    <!--use below badge element instead the user avatar to display username's first letter(remove kt-hidden class to display it) -->
                    <span class="kt-badge kt-badge--lg kt-badge--rounded kt-badge--bold kt-font-success">S</span>
                </div>
                <div class="kt-user-card__name">
                    <%=student.getId()%>
                </div>

            </div>

            <!--end: Head -->

            <!--begin: Navigation -->
            <div class="kt-notification">


                <div class="kt-notification__custom kt-space-between p-2">
                    <a href="logout" class="btn btn-label btn-label-brand btn-sm btn-bold">Log
                        Out</a>
                </div>
            </div>

            <!--end: Navigation -->
        </div>
    </div>

    <!--end: User Bar -->
</div>

<!-- end:: Header Topbar -->

