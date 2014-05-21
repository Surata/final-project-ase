<%-- 
    Document   : index
    Created on : Mar 4, 2014, 8:47:31 PM
    Author     : edista
--%>

<%@page import="Bean.GRZUser"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="CSS/GRZStyle.css" rel="stylesheet"/>
        <title>Home Page</title>
    </head>
    <body>
        <%@include file="GRZHeader.jsp"%>
        <div class="homeHeader">
            <div id="slider">
                <div id="slideImage">  <!-- Slider container -->
                    <img src="Image/slider1.jpg" />
                    <img src="Image/slider2.jpg" />
                    <img src="Image/slider3.jpg" />
                    <img src="Image/BestPlace.jpg" />
                    <img src="Image/PizzaStore.jpg" />
                    <img src="Image/slider1.jpg" />
                </div>  <!-- End Slider Container -->
            </div>
            <div id="loginBoxOuter">
                <div id="loginBox">
                <%
                    String time = new SimpleDateFormat("hh:mm a").format(Calendar.getInstance().getTime());
                    int userCount = 0;
                    if(application.getAttribute("userCount")!= null){
                        userCount = Integer.parseInt(application.getAttribute("userCount").toString());
                    }
                    if(session.getAttribute("user") == null){
                %>
                <form action="./GRZLogin" method="post">
                    <table>
                        <tr>
                            <td>
                                <input type="text" name="usernameTxt" placeholder="Username"/>
                            </td>
                            <td>
                                <input type="password" name="passwordTxt" placeholder="Password"/>
                            </td>
                            <td>
                                <input type="submit" id="button" value="Login" />
                            </td>
                            <td>
                                <a style="color:red" href="GRZRegister.jsp">or Sign Up</a>
                            </td>
                            <td>
                                <%= userCount %> user(s) online | <%= time%>
                            </td>
                        </tr>
                        <tr>
                            <td></td>
                            <td style="font-size: 10px;"><input type="checkbox" name="rememberMeChk" value="true">Remember Me</td>
                            <td></td>
                            <td></td>
                            <td></td>
                        </tr>
                    </table>
                </form>
                
                <%
                }else {
                        GRZUser user = (GRZUser)session.getAttribute("user");
                        %>
                        <table>
                            <tr>
                                <td>
                                    Welcome, <%= user.getName() %> <a href="./GRZLogout">Logout</a>
                                </td>
                                <td>
                                    <p style="text-align:right "><%= userCount %> user(s) online | <%= time%></p>
                                </td>
                            </tr>
                        </table>
                        <%
                }
                %>
                </div>
            </div>
        </div>
        <div class="homeMenu">
            <div id="itemDiv">
                <div id="background1">
                    <img src="Image/HotPizza.jpg" />
                    <div id="item1">MENU</div>
                </div>
                <div id="background1">
                    <img src="Image/CSAgent.jpg" />
                    <div id="item1">ORDER NOW</div>
                </div>
            </div>
            <div id="itemDiv">
                <div id="background2">
                    <img src="Image/BestPlace.jpg" />
                    <div id="item2">CUSTOMER</div>
                </div>
                <div id="background2">
                    <img src="Image/PizzaStore.jpg" />
                    <div id="item2">CART</div>
                </div>
                <div id="background2">
                    <img src="Image/MapPizza.gif" />
                    <div id="item2">TRACK</div>
                </div>
            </div>
        </div>
        <%@include file="GRZFooter.jsp"%>
    </body>
</html>
