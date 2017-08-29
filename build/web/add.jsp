<%-- 
    Document   : add
    Created on : Aug 29, 2017, 3:48:05 PM
    Author     : Thy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Add a new loai sp</h1>
        
        <form name="addForm" action="AddSP" method="get">
            <label>Ten loai:</label>
            <input type="text" name="ten_loai" value="" />
            <br>
            <label>Mo ta:</label>
            <input type="text" name="mo_ta" value="" />
            <br>
            <label>Ma loai cha:</label>
            <input type="text" name="ma_loai_cha" value="" />
            <br>
            <input type="submit" name="add"  value="add"/>
            
        </form>
    </body>
</html>
