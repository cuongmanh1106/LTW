

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    
    <% String table  = (String)request.getAttribute("table"); %>
    <body>
        <h1>Hello World!</h1>
        <%= table %>
        <br><br>
        
        <a href="add">Add loại sản phẩm</a>
        <a href="Search.jsp">Search Loai San Pham</a>
        
    </body>
</html>
