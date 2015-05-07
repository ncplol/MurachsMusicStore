<jsp:include page="/includes/header.html" />
<jsp:include page="/includes/column_left_no_links.jsp" />

<!-- begin middle column -->

<td valign="top">

<h1>Fresh Corn Records - Administration</h1>

<!-- these Form tags don't force a secure connection -->
<form action="displayInvoices" method="post">
   <input type="submit" value="Process Invoices">
</form>
<form action="reports.jsp" method="post">
    <input type="submit" value="Display Reports">
</form>

<!-- these Form tags force a secure connection -->
<!--
<form action="https://localhost:8443/musicStore/admin/displayInvoices"
      method="post">
   <input type="submit" value="Process Invoices">
</form>
<form action="https://localhost:8443/musicStore/admin/reports.jsp" 
    method="post">
    <input type="submit" value="Display Reports">
</form>
-->

</td>

<!-- end middle column -->

<jsp:include page="/includes/footer.jsp" />