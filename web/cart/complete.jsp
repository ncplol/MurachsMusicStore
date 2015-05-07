<jsp:include page="/includes/header.html" />
<jsp:include page="/includes/column_left_all_absolute.jsp" />

<!-- begin middle column -->

<td valign="top">

<h1>Thank you, ${user.firstName}</h1>

<!-- store email address as a global variable and use EL to display it -->

<p>Your order has been submitted. We'll begin processing your 
order right away. If you have any questions about your order, 
please feel free to contact us at 
<a href="mailto:${custServEmail}">${custServEmail}</a></p>

</td>

<!-- end middle column -->

<jsp:include page="/includes/column_right_news.jsp" />
<jsp:include page="/includes/footer.jsp" />