<%-- 
    Document   : add
    Created on : Aug 29, 2017, 3:48:05 PM
    Author     : Thy
--%>

<%@page import="model.loai_san_pham"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% loai_san_pham l = (loai_san_pham) request.getAttribute("loai_san_pham");%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Update a new loai sp</h1>
        
        <form name="UpdateForrm" action="UpdateSP" method="get">
            <label>Ma loai:</label>
            <input type="text" name="ma_loai" value="<%= l.getMa_loai()%>" />
            <br>
            <label>Ten loai:</label>
            <input type="text" name="ten_loai" value="<%= l.getTen_loai()%>" />
            <br>
            <label>Mo ta:</label>
            <input type="text" name="mo_ta" value="<%= l.getMo_ta()%>" />
            <br>
            <label>Ma loai cha:</label>
            <input type="text" name="ma_loai_cha" value="<%= l.getMa_loai_cha()%>" />
            <br>
            <input type="submit" name="add"  value="Update"/>
            
        </form>
    </body>
</html>
