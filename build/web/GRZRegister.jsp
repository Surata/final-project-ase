<%-- 
    Document   : register
    Created on : Mar 12, 2014, 3:38:46 PM
    Author     : edista
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="CSS/GRZStyle.css" rel="stylesheet"/>
        <title>Register Page</title>
    </head>
    <body>
       <%@include file="GRZHeader.jsp"%>
        <div class="outer">
            <div class="registerDiv">
                <h1 style="text-align: center">Register Customer Data</h1>
                <form action="./GRZRegisterUser" method="post" >
                <table>
                    <tr>
                        <td><label>Username</label></td>
                        <td><input type="text" name="usernameTxt" /></td>
                        <td><%
                        String errUsername = request.getParameter("errUsername");
                        if(errUsername != null ) {
                            %>
                            <div id="errorBox">
                            <%
                            out.print("<div id='errorBox'>" + errUsername+ "</div>");
                        }
                            %>
                        </td>
                    </tr>
                    <tr>
                        <td><label>Password</label></td>
                        <td><input type="password" name="passwordTxt" /></td>
                        <td><%
                        String errPassword = request.getParameter("errPassword");
                        if(errPassword != null ) {
                            %>
                            <div id="errorBox">
                            <%
                            out.print("<div id='errorBox'>" + errPassword+ "</div>");
                        }
                            %>
                        </td>
                    </tr>
                    <tr>
                        <td><label>Confirm Password</label></td>
                        <td><input type="password" name="confirmPassTxt" /></td>
                        <td>
                            <%
                            String errConfirmPass = request.getParameter("errConfirmPass");
                            if(errConfirmPass != null ) {
                            %>
                            <div id="errorBox">
                            <%
                            out.print("<div id='errorBox'>" + errConfirmPass+ "</div>");
                        }
                            %>
                        </td>
                    </tr>
                    <tr>
                        <td><label>Name</label></td>
                        <td><input type="text" name="nameTxt" /></td>
                        <td><%
                        String errName = request.getParameter("errName");
                        if(errName != null ) {
                            %>
                            <div id="errorBox">
                            <%
                            out.print("<div id='errorBox'>" + errName + "</div>");
                        }
                            %>
                        </td>
                    </tr>
                    <tr>
                        <td><label>Address</label></td>
                        <td><textarea name="addressTxt" ></textarea></td>
                        <td><%
                        String errAddress = request.getParameter("errAddress");
                        if(errAddress != null ) {
                            %>
                            <div id="errorBox">
                            <%
                            out.print("<div id='errorBox'>" + errAddress+ "</div>");
                        }
                            %>
                        </td>
                    </tr>
                    <tr>
                        <td><label>Email</label></td>
                        <td><input type="text" name="emailTxt" /></td>
                        <td><%
                        String errEmail = request.getParameter("errEmail");
                        if(errEmail != null ) {
                            %>
                            <div id="errorBox">
                            <%
                            out.print("<div id='errorBox'>" + errEmail+ "</div>");
                        }
                            %>
                        </td>
                    </tr>
                    <tr>
                        <td><label>Phone</label></td>
                        <td><input type="text" name="phoneTxt" /></td>
                        <td><%
                        String errPhone = request.getParameter("errPhone");
                        if(errPhone != null ) {
                            %>
                            <div id="errorBox">
                            <%
                            out.print("<div id='errorBox'>" + errPhone + "</div>");
                        }
                            %>
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input id="registerButton" type="submit" value="Register" /></td>
                    </tr>
                </table>
                </form>
            </div>
        </div>
        <%@include file="GRZFooter.jsp"%>
    </body>
</html>
