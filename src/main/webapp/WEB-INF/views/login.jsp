<%@ page import="jakarta.servlet.http.Cookie" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="header.jsp"%>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <h1>Login</h1>
    <%
        if (request.getAttribute("message")!=null){
            //error
            out.println(request.getAttribute("message"));
        }
    %>
    <%
        Cookie[] allCookies = request.getCookies();
        String username = "", password = "", rememberMeVal = "";
        if (allCookies != null){
            for (Cookie c: allCookies){
                if ("cUsername".equals(c.getName())){
                    username = c.getValue();
                }
                if ("cPassword".equals(c.getName())){
                    password = c.getValue();
                }
                if ("cRememberMe".equals(c.getName())){
                    rememberMeVal = c.getValue();
                }
            }
        }
    %>
    <form action="<%=request.getContextPath()%>/login" method="post">
        UserName:<input type="text" name="username" value="<%=username%>"> <br>
        Password:<input type="password" name="password" value="<%=password%>"> <br>
        <input type="checkbox" name="rememberMe" value="1" <%="1".equals(rememberMeVal)?"checked":""%>>RememberMe <br>
        <input type="submit" value="Login">
    </form>
</body>
</html>

<%@include file="footer.jsp"%>