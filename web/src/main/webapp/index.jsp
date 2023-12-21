<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2023-12-14
  Time: 오후 2:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Super Hero Story</title>
    <link rel="stylesheet" type="text/css" href="css/mainpagestyle.css"/>
</head>
<body>
<div id="wrap">
    <header id="header">
        <h1>
            <a href="${pageContext.request.contextPath}/index.do"><img src="img/mainlogo.png"></a>
        </h1>

        <div class="inner">
        <ul class="login">
            <% if(session.getAttribute("userId") == null) { %>
            <li><a href="member1/Login.jsp">로그인</a></li> <!-- Login -->
            <li><a href="member1/Join.jsp">회원가입</a></li> <!-- Sign Up -->
            <% } else { %>
            <li><a href="logout">로그아웃</a></li> <!-- Logout -->
            <li><a href="mypage/MyPage.jsp">마이페이지</a></li>
            <% } %>
        </ul>

        <nav id="menu">
            <ul>
                <li><a href="jsp/profilePage.jsp">소개</a></li>
                <li><a href="jsp/goods.jsp">상점</a></li>
                <li><a href="jsp/CommunityPage.jsp">상품후기</a></li>
                <li><a href="jsp/faqPage.jsp">FAQ</a></li>
            </ul>
        </nav>
        </div>
    </header>

    <main id="main">
        <div></div>

    </main>

    <footer id="footer">Copyright (c) 2023 Re-Coder</footer>

</div>
</body>
</html>