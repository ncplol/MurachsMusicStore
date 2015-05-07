<jsp:include page="/includes/header.html" />
<jsp:include page="/includes/column_left_order.jsp" />

<!-- begin middle column -->

<td width="570" valign="top" colspan="2">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>Quick order an album</h1>

<table cellpadding="5" border="0">
  <tr valign="bottom">
    <th align="left">Description</th>
    <th align="left">Price</th>
    <th align="left">&nbsp;</th>
  </tr>
  
  <c:forEach var="product" items="${products}"> 
  <tr valign="top">
    <td>
      <a href="
      <c:url value='/catalog/displayProduct?productCode=${product.code}'/>">
      ${product.description}
     </a>
    </td>
    <td>${product.priceCurrencyFormat}</td>
    <td>
      <a href="
      <c:url value='/cart/displayCart?productCode=${product.code}'/>">
      Add To Cart
    </a></td>
  </tr>
  </c:forEach>

</table>

</td>

<!-- end middle column -->

<jsp:include page="/includes/footer.jsp" />