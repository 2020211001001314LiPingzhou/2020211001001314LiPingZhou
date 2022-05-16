<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>MyDearJsp</title>
</head>
<body>
<h3>
    name:<%=request.getParameter("name")%><br>
    submit:<%=request.getParameter("submit")%><br>
    class:<%=request.getParameter("class")%><br>
    id:<%=request.getParameter("id")%><br>

    name:${param.name}<br>
    submit:${param.submit}<br>
    class:${param.aclass}<br>
    id:${param.id}<br>
</h3>
</body>
</html>
