<%--
  Created by IntelliJ IDEA.
  User: 18720308580
  Date: 2022/4/16
  Time: 14:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp"%>

<%
    if (request.getAttribute("message")!=null){
        //error
        out.println(request.getAttribute("message"));
    }
%>

<%
    User u = (User)session.getAttribute("user");
%>

<form action="updateUser" method="post">
    <table>
        <tr>
            <td><label>Id</label></td>
            <td><input type="text" name="id" value="<%=u.getId()%>"></td>
        </tr>
        <tr>
            <td><label>Username</label></td>
            <td><input type="text" name="username" value="<%=u.getUsername()%>"></td>
        </tr>
        <tr>
            <td><label>Password</label></td>
            <td><input type="password" name="password" value="<%=u.getPassword()%>"></td>
        </tr>
        <tr>
            <td><label>Email</label></td>
            <td><input type="email" name="email" value="<%=u.getEmail()%>"></td>
        </tr>
        <tr>
            <td><label>Gender</label></td>
            <td><input type="radio" name="gender" value="male" <%="male".equals(u.getGender())?"checked":""%>> Male
                <input type="radio" name="gender" value="female"<%="female".equals(u.getGender())?"checked":""%>> Female
            </td>
        </tr>
        <tr>
            <td><label>Birthday</label></td>
            <td><input type="date" name="birthday" value="<%=u.getBirthDate()%>"></td>
        </tr>
        <tr>
            <td><input type="submit" value="Save Changes"></td>
        </tr>
    </table>
</form>


<%@ include file="footer.jsp"%>
