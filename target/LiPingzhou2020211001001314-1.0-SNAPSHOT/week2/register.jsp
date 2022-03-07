<%--
  Created by IntelliJ IDEA.
  User: 18720308580
  Date: 2022/3/6
  Time: 22:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
    <script>
        window.onload = function () {
            //给表单绑定onsubmit事件
            document.getElementById("form").onsubmit = function () {
                return checkUsername() && checkPassword() &&checkEmail() && checkRename() && checkTelphone();
            }

            //给用户名和密码框、Email、姓名、手机号分别绑定离焦事件
            document.getElementById("username").onblur = checkUsername;
            document.getElementById("password").onblur = checkPassword;
            document.getElementById("Email").onblur = checkEmail;
        }

        //校验用户名
        function checkUsername() {
            //获取用户名的值
            var username = document.getElementById("username").value;

            //定义正则表达式
            var reg_username = /^([a-zA-Z0-9_-])/;
            //判断值是否符合正则表达式的规则
            var flag = reg_username.test(username);

            //提示信息
            var s_username = document.getElementById("s_username");

            if (flag) {
                //提示绿色对勾
                s_username.innerHTML = "ok";
            } else {
                //提示红色错误信息
                s_username.innerHTML = "error!";
            }
            return flag;
        }

        //校验密码
        function checkPassword(){
            //1.获取密码的值
            var password = document.getElementById("password").value;
            //2.定义正则表达式
            var reg_password = /^\w{8,20}$/;
            //3.判断值是否符合正则的规则
            var flag = reg_password.test(password);
            //4.提示信息
            var s_password = document.getElementById("s_password");

            if(flag){
                //提示绿色对勾
                s_password.innerHTML = "ok";
            }else{
                //提示红色错误信息
                s_password.innerHTML = "error!";
            }
            return flag;
        }
        //校验Email
        function checkEmail(){
            //1.获取Email的值
            var email = document.getElementById("Email").value;
            //2.定义正则表达式
            var reg_email = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(\.[a-zA-Z0-9_-])+/;
            //3.判断值是否符合正则的规则
            var flag = reg_email.test(email);
            //4.提示信息
            var s_email = document.getElementById("s_email");

            if(flag){
                //提示绿色对勾
                s_email.innerHTML = "ok";
            }else{
                //提示红色错误信息
                s_email.innerHTML = "error!";
            }
            return flag;
        }
    </script>
</head>
<body>
<form action="#" method="post" id="form">
    <table>
        <tr>
            <td><label for="username">Username</label></td>
            <td><input type="text" name="username" placeholder="请输入用户名(英文字符或数字)"
                                        id="username">
                <span id="s_username"></span>
            </td>
        </tr>
        <tr>
            <td><label for="password">Password</label></td>
            <td><input type="password" name="password" placeholder="请输入密码（长度在6~12位之间）"
                                        id="password">
                <span id="s_password"></span>
            </td>
        </tr>
        <tr>
            <td><label for="Email">Email</label></td>
            <td><input type="email" name="email" placeholder="请输入Email" id="Email">
                <span id="s_email" class="error"></span>
            </td>
        </tr>
        <tr>
            <td><label>Gender</label></td>
            <td><input type="radio" name="gender" value="male" checked> Male
                <input type="radio" name="gender" value="female"> Female
            </td>
        </tr>
        <tr>
            <td><label for="Birthday">Birthday</label></td>
            <td><input type="date" name="birthday" id="Birthday"></td>
        </tr>
        <tr>
            <td colspan="2" id="td_sub"><input type="submit" value="Register" id="btn_sub"></td>
        </tr>
    </table>
</form>
</body>
</html>
