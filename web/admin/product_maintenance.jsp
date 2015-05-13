<%@page import="java.nio.file.Paths"%>
<jsp:include page="/includes/header.html" />

<!-- begin middle column -->


<%@ page import="java.util.ArrayList" %>
<%@ page import="music.Product" %>
<%@ page import="music.ProductIO" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.nio.file.Path" %>



<%
    //Path path = Paths.get("C:\\Users\\Nick\\Documents\\NetBeansProjects\\music\\MurachsMusicStore\\web\\WEB-INF\\products.txt");
    ArrayList<Product> products = ProductIO.getProducts("C:\\Users\\Nick\\Documents\\NetBeansProjects\\music\\MurachsMusicStore\\web\\WEB-INF\\products.txt");
%>

<table border="1" width="100%">
    <tr>
        <th>Code</th>
        <th>Description</th>
        <th>Price</th>
        <th></th>
        <th></th>
    </tr>

    <%
        for (int i = 0; i < products.size(); i++) {
    %>
    <tr>
        <td>
            <%out.println(products.get(i).getCode());%> 
        </td>

        <td>
            <%out.println(products.get(i).getDescription());%>
        </td>

        <td>
            <%out.println(products.get(i).getPrice());%>
        </td>

        <td>
            <a href="product_edit.jsp?code=<%=products.get(i).getCode()%>&description=<%=products.get(i).getDescription()%>&price=<%=products.get(i).getPrice()%>">Edit</a>
        </td>

        <td>
            <a href="product_delete.jsp?code=<%=products.get(i).getCode()%>&description=<%=products.get(i).getDescription()%>&price=<%=products.get(i).getPrice()%>">Delete</a>
        </td>
    </tr>
    <%}%>

</table>

<form action="product_edit.jsp" method="post">
    <input type=submit value="Add Product">
</form>
<form action="index.jsp" method="post">
    <input type=submit value="Go Back to Menu">
</form>

</td>

<!-- end middle column -->

<jsp:include page="/includes/footer.jsp" />
