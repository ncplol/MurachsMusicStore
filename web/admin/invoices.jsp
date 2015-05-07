<jsp:include page="/includes/header.html" />
<jsp:include page="/includes/column_left_no_links.jsp" />

<!-- begin middle column -->

<td valign="top">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>Invoices to be processed:</h1>

<table>

<tr>
  <td width="100"></td>
  <td width="150"><b>Customer Name</b></td>
  <td><b>Invoice Date</b></td>
</tr>
    
<c:forEach var="invoice" items="${unprocessedInvoices}">
<tr>
  <td>
    <a href="displayInvoice?invoiceNumber=${invoice.invoiceNumber}">
      Click to View
    </a>
  </td>
  <td>${invoice.user.firstName} ${invoice.user.lastName}</td>
  <td>${invoice.invoiceDateDefaultFormat}</td>
</tr>
</c:forEach>

</table>

<br>

<form action="index.jsp" method="post">
    <input type=submit value="Go Back to Menu">
</form>

</td>

<!-- end middle column -->

<jsp:include page="/includes/footer.jsp" />