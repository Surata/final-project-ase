<%-- 
    Document   : GRZUpdateProduct
    Created on : Jun 5, 2014, 7:33:26 PM
    Author     : edista
--%>

<%@page import="Bean.GRZProduct"%>
<%@page import="Helper.GRZApplicationHelper"%>
<%@page import="Helper.GRZAuthentication"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    GRZAuthentication auth = new GRZAuthentication();
    auth.onlyAdmin(request.getSession(), response);
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="CSS/GRZStyle.css" rel="stylesheet"/>
        <title>Update Product Page</title>
    </head>
    <body>
        <%@include file="GRZHeader.jsp" %>
        <div class="outer">
            <div class="addProductDiv">
                <h1>Add Product Data</h1>
                <%
                    int productID = Integer.parseInt(request.getParameter("id"));
                    GRZProduct product = GRZApplicationHelper.appService.getProductWithId(productID);
                %>
                <form action="./GRZUpdateProduct?id=<%= product.getProductID() %>" method="POST" >
                <table>
                    <tr>
                        <td><label>Name</label></td>
                        <td><input type="text" name="nameTxt" value="<%= product.getName() %>"/></td>
                        <td>
                            <%
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
                        <td><label>Description</label></td>
                        <td><textarea name="descriptionTxt"><%= product.getDescription() %></textarea></td>
                        <td>
                            <%
                        String errDesc = request.getParameter("errDesc");
                        if(errDesc != null ) {
                            %>
                            <div id="errorBox">
                            <%
                            out.print("<div id='errorBox'>" + errDesc+ "</div>");
                        }
                            %>
                        </td>
                    </tr>
                    <tr>
                        <td><lable>Price</label></td>
                        <td><input type="text" name="priceTxt" value="<%= String.format("%.0f",product.getPrice()) %>"/></td>
                        <td>
                            <%
                        String errPrice = request.getParameter("errPrice");
                        if(errPrice != null ) {
                            %>
                            <div id="errorBox">
                            <%
                            out.print("<div id='errorBox'>" + errPrice+ "</div>");
                        }
                            %>
                        </td>
                    </tr>
                    <tr>
                        <td><label>Image</label></td>
                        <td>
                            <select name="imageURL" id="browseImage">
                                <option value="">Browse</option>
                                <option value="pizza1.jpg">pizza1.jpg</option>
                                <option value="pizza2.jpg">pizza2.jpg</option>
                                <option value="pizza3.jpg">pizza3.jpg</option>
                                <option value="pizza4.jpg">pizza4.jpg</option>
                                <option value="pizza5.jpg">pizza5.jpg</option>
                                <option value="pizza6.jpg">pizza6.jpg</option>
                                <option value="drink1.jpg">drink1.jpg</option>
                                <option value="drink2.jpg">drink2.jpg</option>
                            </select>
                        </td>
                        <td>
                            <%
                        String errImage= request.getParameter("errImage");
                        if(errImage != null ) {
                            %>
                            <%
                            out.print("<div id='errorBox'>" + errImage + "</div>");
                        }
                            %>
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" id="addButton" value="Update Product" /></td>
                    </tr>
                </table>
                </form>
            </div>
        </div>
        <%@include file="GRZFooter.jsp"%>
    </body>
</html>
