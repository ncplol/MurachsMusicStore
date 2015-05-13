<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Product | Murach's Music Store</title>
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

        <script language="JavaScript">
            function validate(form) {
                if (form.code.value == "") {
                    alert("Please enter a product code.");
                    form.code.focus();
                } else if (form.description.value == "") {
                    alert("Please enter a product description.");
                    form.description.focus();
                } else if (form.price.value == "") {
                    alert("Please enter a product price.");
                    form.price.focus();
                } else {
                    form.submit();
                }
            }
        </script>

        <%if (code == null && description == null && price == null) {%>
        <h1>Add Product</h1>
    <td align=left>Required <font color=red>*</font></td>
    <form action="addProduct" method="post">
        <table cellspacing="5" border="1">
            <tr>
                <td>Product Code:</td>
                <td><input type="TEXT" name="code" value="">
                    <font color=red>*</font>
                </td>
            </tr>
            <tr>
                <td>Product Description:</td>
                <td><input type="TEXT" name="description" value="">
                    <font color=red>*</font>
                </td>
            </tr>
            <tr>
                <td>Product Price:</td>
                <td><input type="TEXT" name="price" value="">
                    <font color=red>*</font>
                </td>
            </tr>
        </table>
        <input type=submit value="Add Product" onClick="validate(this.form)">
    </form>
    <%} else {%>
    <h1>Edit Product</h1>
    <form action="editProduct" method="post">
        <table cellspacing="5" border="1">
            <tr>
                <td>Product Code:</td>
                <td><input type="TEXT" name="code" value=<%=code%>></td>
            </tr>
            <tr>
                <td>Product Description:</td>
                <td><input type="TEXT" name="description" value="<%=description%>"></td>
            </tr>
            <tr>
                <td>Product Price:</td>
                <td><input type="TEXT" name="price" value=<%=price%>></td>
            </tr>
        </table>
        <input type=submit value="Update Product" onClick="validate(this.form)">
    </form>
    <%}%>
    <form action="product_maintenance.jsp" method="post">
        <input type=submit value="View Products">
    </form>
</body>
</html>

