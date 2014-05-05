<%--
    Document   : menu
    Created on : Mar 12, 2014, 4:03:14 PM
    Author     : edista
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="Bean.GRZProduct"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
                    GRZProduct products = new GRZProduct();

                    ResultSet rs;
                    if(searchTxt != null && filter != null){
                        rs = products.searchWithTextAndFilter(getServletContext(), searchTxt, Integer.parseInt(filter));
                    }else if(searchTxt!= null){
                        rs = products.searchWithText(getServletContext(), searchTxt);
                    }else if(filter != null){
                        rs = products.searchWithFilter(getServletContext(), Integer.parseInt(filter));
                    }else{
                        rs  = products.searchAll(getServletContext());
                    }

                    int pageCount = 0;
                    if(request.getParameter("pageCount") != null){
                        pageCount = Integer.parseInt(request.getParameter("pageCount"));
                    }

                    int startIndex = pageCount * 6;
                    int endIndex = startIndex + 6;
                    int dataCount = 0;

                    while(rs.next()){
                        dataCount ++;
                        if(rs.getRow() > startIndex && rs.getRow() <= endIndex){
                    %>
                    <div id="description">
                        <label id="desc"><%= rs.getString("Description")%></label>
                        <div class="productView">
                        <%
                        out.print("<img src='" + rs.getString("Image") + "' />");
                        %>
                        <table>
                            <tr>
                                <td style="width: 170px; color: red;"><%= rs.getString("Name") %></td>
                                <td style="width: 80px; text-align: right;">Rp. <%= rs.getString("Price") %></td>
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
        <%@include file="GRZFooter.html"%>
    </body>
</html>
