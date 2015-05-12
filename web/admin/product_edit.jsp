<%-- 
    Document   : product_edit
    Created on : May 7, 2015, 9:07:27 PM
    Author     : Nick
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Product | Murach's Music Store</title>
    </head>
    <body>
        <h1>Prodcut</h1>
        <i>You must enter a description for the product</i>
        <table border="1" width="100%">
            <tr>
                <td>Product Code:</td>
                <td>Product Description:</td>
                <td>Product Price:</td>
            </tr>
            <tr>
                <td><input type="TEXT" name="Product Code"</td>
                <td><input type="TEXT" name="Product Description"</td>
                <td><input type="TEXT" name="Product Price"</td>
            </tr>
        </table>

        <form action="product_edit.jsp" method="post">
            <input type=submit value="Update Product">
        </form>
        <form action="product_maintenance.jsp" method="post">
            <input type=submit value="View Products">
        </form>
    </body>
</html>
