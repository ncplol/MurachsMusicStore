<jsp:include page="/includes/header.html" />
<jsp:include page="/includes/column_left_all_no_links.jsp" />

<!-- begin middle column -->

<td valign="top">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>Your invoice</h1>

<table border="0" cellspacing="5">
  <tr>
    <td><b>Date:</b></td>
    <td width="400">${invoice.invoiceDate}</td>
    <td></td>
  </tr>
  <tr valign="top">
    <td><b>Ship To:</b></td>
    <td>${user.addressHTMLFormat}</td>
    <td></td>
  </tr>
  <tr><td colspan="3"><hr></td></tr>
  <tr>
    <td><b>Qty</b></td>
    <td><b>Description</b></td>
    <td><b>Price</b></td>
  </tr>
  
  <c:forEach var="item" items="${invoice.lineItems}">
  <tr>
    <td>${item.quantity}</td>
    <td>${item.product.description}</td>
    <td>${item.totalCurrencyFormat}</td>
  </tr>
  </c:forEach>

  <tr><td colspan="3"><hr></td></tr>
  <tr>
    <td><b>Total:</b></td>
    <td></td>
    <td><p>${invoice.invoiceTotalCurrencyFormat}</td>
  </tr>      
  <tr>    
    <td><b>Payment information:</b></td>    
    <td>${user.creditCardType}: ${user.creditCardNumber} 
         (${user.creditCardExpirationDate})</td>
  </tr>
  <tr>
    <td><b>Email Address:</b></td>
    <td><p>${user.emailAddress}</td>
  </tr>
</table>
<form action="processInvoice" method="post">
  <input type="submit" value="Process Invoice">
</form>
<form action="invoices.jsp" method="post">
  <input type="submit" value="View Unprocessed Invoices">
</form>

</td>

<!-- end middle column -->

<jsp:include page="/includes/footer.jsp" />