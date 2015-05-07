<jsp:include page="/includes/header.html" />
<jsp:include page="/includes/column_left_catalog.jsp" />

<!-- start the middle column -->

<!-- If necessary, this page could be generated from the database. 
However, this format gives more control to the web designers. -->

<td width="404" valign="top">
    <h1>The Fresh Corn Records Catalog</h1>

    <h4>86 (the band)</h4>
    <p><a href="displayProduct?productCode=8601">True Life Songs and Pictures</a></p>

    <h4>Paddlefoot</h4>
    <p><a href="displayProduct?productCode=pf01">Paddlefoot (the first album)</a><br>
     <a href="displayProduct?productCode=pf02">Paddlefoot (the second album)</a></p>

    <h4>Joe Rut</h4>
    <p><a href="displayProduct?productCode=jr01">Genuine Wood Grained Finish</a></p>    
</td>

<!-- end the middle column -->

<jsp:include page="/includes/column_right_news.jsp" flush="true" />
<jsp:include page="/includes/footer.jsp" />