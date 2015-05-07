<jsp:include page="/includes/header.html" />
<jsp:include page="/includes/column_left_no_links.jsp" />

<!-- begin middle column -->

<td valign="top">

<h1>${param.reportTitle}</h1>
<p>Please enter dates using this format: yyyy-mm-dd.</p>

<form action="displayReport" method="post">

<!-- Note the use of hidden fields to pass parameters -->
<input type="hidden" name="reportName" value="${param.reportName}">
<input type="hidden" name="reportTitle" value="${param.reportTitle}">

<table cellspacing="5" border="0">
<tr>
    <td></td>
    <td align=left><p><font color=red>* </font>Required</td>
</tr>

<tr> 
    <td align=right><p>Start Date<font color=red> *</font></td>
    <td align=left>
        <input type="text" size="10" maxlength=10 
               name="startDate" value="${currentYear}-01-01">
    </td>
</tr>

<tr> 
    <td align=right><p>End Date<font color=red> *</font></td>
    <td align=left> 
        <input type="text" size="10" maxlength=10 
               name="endDate" value="${currentYear}-12-31">
    </td>
</tr>

<tr> 
    <td></td>
    <td align=left>
        <input type="submit" value="Continue">
    </td>
</tr>
</table>

</form>

</td>

<!-- end middle column -->

<jsp:include page="/includes/footer.jsp" />