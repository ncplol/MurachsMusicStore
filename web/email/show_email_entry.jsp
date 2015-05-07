<jsp:include page="/includes/header.html" />
<jsp:include page="/includes/column_left_email.jsp" />

<td width="404" valign="top">
    
<h1>Thanks for joining our email list</h1>
<p>Here is the information that you entered:</p>

<table cellpadding="5" border="0">
    <tr>
        <td align="right">First name:</td>
        <td>${user.firstName}</td>
    </tr>
    <tr>
        <td align="right">Last name:</td>
        <td>${user.lastName}</td>
    </tr>
    <tr>
        <td align="right">Email address:</td>
        <td>${user.emailAddress}</td>
    </tr>
</table>
    
</td>

<jsp:include page="/includes/column_right_news.jsp" />
<jsp:include page="/includes/footer.jsp" />