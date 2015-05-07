<jsp:include page="/includes/header.html" />
<jsp:include page="/includes/column_left_all_absolute.jsp" />

<!-- begin middle column -->

<td>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>Enter your credit card information</h1>

<form action="<c:url value='/cart/completeOrder' />" method="post">
   <table border="0" cellpadding="5">
   <tr> 
      <td align="right"><p>Credit card type</td>
      <td><select name="creditCardType" size="1">
            <option value="Visa">Visa</option>
            <option value="Mastercard">Mastercard</option>
            <option value="AmEx">American Express</option>
          </select>
      </td>
   </tr>
   <tr> 
      <td align="right">Card number</td>
      <td><input type="text" size="20" name="creditCardNumber" 
                 maxlength="25"></td>
   </tr>
   <tr> 
      <td align="right"><p>Expiration date (mm/yyyy)</td>
      <td><select name="creditCardExpirationMonth">
               <option value="01">01
               <option value="02">02
               <option value="03">03
               <option value="04">04 
               <option value="05">05
               <option value="06">06
               <option value="07">07
               <option value="08">08 
               <option value="09">09
               <option value="10">10
               <option value="11">11
               <option value="12">12 
          </select>
          /
          <select name="creditCardExpirationYear">
               <c:forEach var="year" items="${creditCardYears}">
                 <option value="${year}">${year}
               </c:forEach>
          </select>
      </td>
   </tr>
   <tr>
      <td></td>
      <td align="left"><input type="submit" value="Submit Order"></td>
   </tr>
   </table>
</form>

</td>

<!-- end middle column -->

<jsp:include page="/includes/footer.jsp" />