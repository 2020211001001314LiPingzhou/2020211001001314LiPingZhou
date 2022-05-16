<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>MyJsp</title>
</head>
<body>
    <form method="post" action=<%=request.getContextPath()%>/lab1/MyDearJsp.jsp>
        <h3>I am MyJsp.jsp <br>
        name <input type="text" name="name"><br>
        class <input type="text" name="aclass"><br>
        ID <input type="text" name="id"><br>
        <input type="submit" value="Send data to server" name="submit">
        </h3>
    </form>
</body>
</html>
