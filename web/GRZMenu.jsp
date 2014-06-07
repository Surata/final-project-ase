<%--
    Document   : menu
    Created on : Mar 12, 2014, 4:03:14 PM
    Author     : edista
--%>

<%@page import="Helper.GRZApplicationHelper"%>
<%@page import="java.util.List"%>
<%@page import="Bean.GRZProduct"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="CSS/GRZStyle.css" rel="stylesheet"/>
        <title>Menu Page</title>
    </head>
    <body>
        <%@include file="GRZHeader.jsp" %>
        <div class="outer">
           <div class="menuDiv">
                <div class="searchBar">
                    <%
                    String searchTxt = request.getParameter("searchTxt");
                    String filter = request.getParameter("filter");
                    if(searchTxt == null)
                        searchTxt = "";
                    %>
                    <form action="GRZMenu.jsp" method="POST">
                    <div id="searchDiv">             
                            <%
                                out.print("<input id='input' type='text' name='searchTxt' value='" + searchTxt + "'/>");
                            %>
                            <input id="searchButton" type="submit" value="Search" />   
                    </div>
                    <div id="searchDiv">
                            <select name="filter" id="input">
                                <option value="0">all price</option>
                                <option value="1">Rp. 0 - Rp. 35.000</option>
                                <option value="2">Rp. 35.000 - Rp. 70.000</option>
                                <option value="3">Rp. 70.000 - Rp. 105.000</option>
                                <option value="4">Rp. 105.000 - Rp. 140.000</option>
                                <option value="5">more than Rp. 140.000</option>
                            </select>
                            <input id="searchButton" type="submit" value="Filter" />
                    </div>
                    </form>
                </div>
                <div class="itemList">
                    <%
                    List products;
                    if(searchTxt != null && filter != null){
                        products = GRZApplicationHelper.appService.searchProdcutWithNameAndPriceKey(searchTxt, Integer.parseInt(filter));
                    }else if(searchTxt!= null){
                        products = GRZApplicationHelper.appService.searchProductWithNameKey(searchTxt);
                    }else if(filter != null){
                        products = GRZApplicationHelper.appService.getProductForPriceRange(Integer.parseInt(filter));
                    }else{
                        products = GRZApplicationHelper.appService.getAllProduct();
                    }

                    int pageCount = 0;
                    if(request.getParameter("pageCount") != null){
                        pageCount = Integer.parseInt(request.getParameter("pageCount"));
                    }

                    int startIndex = pageCount * 6;
                    int endIndex = startIndex + 6;
                    int dataCount = 0;

                    for(int i=0; i<products.size(); i++){
                        dataCount ++;
                        if(i >= startIndex && i <= endIndex){
                            GRZProduct product = (GRZProduct)products.get(i); 
                    %>
                    <div id="description">
                        <label id="desc"><%= product.getDescription()%></label>
                        <%
                            GRZUser user = GRZApplicationHelper.getCurrentUser(request);
                            if(user != null){
                                %>
                                <a id="ordernow" href="<%= GRZConstant.ORDER_PAGE %>">Order Now</a>
                                <%
                            }else{
                                %>
                                <label id="info">Please register to order</label>
                                <%
                            }
                        %>
                        <div class="productView">
                        <%
                        out.print("<img src='" + product.getImage() + "' />");
                        %>
                        <table>
                            <tr>
                                <td style="width: 170px; color: red;"><%= product.getName() %></td>
                                <td style="width: 80px; text-align: right;">Rp. <%= String.format("%.0f",product.getPrice()) %></td>
                            </tr>
                        </table>
                    </div>
                    </div>

                    <% 
                        }
                    }
                    %>
                </div>
                <div class="paging">
                    <%
                        int numberOfPage = (dataCount / 6) + 1;
                        for(int i =1 ; i<= numberOfPage;i++){
                            int index = i - 1;
                            String params = "pageCount=" + index;
                            if(searchTxt != null && !searchTxt.equals("")){
                                params += "&searchTxt=" + searchTxt;
                            }

                            if(filter != null && !filter.equals("0")){
                                params += "&filter=" + filter;
                            }

                            out.print("<a href='GRZMenu.jsp?"+ params + "'>  " + i + "  </a> ");

                        }
                    %>
                </div>
            </div>
        </div>
        <%@include file="GRZFooter.jsp"%>
    </body>
</html>

