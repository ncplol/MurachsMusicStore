<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete Product | Murach's Music Store</title>
    </head>
    <body>
        <%
            String code = request.getParameter("code");
            String description = request.getParameter("description");
            String price = request.getParameter("price");

            System.out.println("Code is this: " + code);
            System.out.println("Decription is this: " + description);
            System.out.println("Price is this: " + price);
        %>

        <h1>Are you sure you want to delete this product?</h1>  

        <div style="width:400px;">
            <div style="float: left; width: 50px">

                <form action="deleteProduct" method="post">
                    <table cellspacing="5" cellpadding="5" border="1">
                        <tr>
                            <td align = "right"> Product code:</td>          
                            <td name="code"><%out.println(code);%> </td>
                        </tr>

                        <tr>
                            <td align = "right"> Description:</td>
                            <td name ="description"><%out.println(description);%> </td>
                        </tr>			

                        <tr>
                            <td align = "right"> Price:</td>
                            <td name ="price"><%out.println(price);%> </td>
                        </tr>	
                    </table> 
                    <input type="hidden" name = "code" value = <%=code%>>
                    <input type="hidden" name = "description" value = <%=description%>>
                    <input type="hidden" name = "price" value = <%=price%>>
                    <input type="submit" name="Delete" value="Yes">
                </form>

                <div style="width:400px;">
                    <div style="float: left; width: 50px">
                        <form action="product_maintenance.jsp" method="post">
                            <input type="submit" name="Index" value="No">
                        </form>
                        </body>
                        </html>

