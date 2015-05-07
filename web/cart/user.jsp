<jsp:include page="/includes/header.html" />
<jsp:include page="/includes/column_left_all_absolute.jsp" />

<!-- begin middle column -->

<td>

<script language="JavaScript">
function validate(form) 
{
    if (form.firstName.value=="") 
    {
            alert("Please fill in your first name");
            form.firstName.focus();
    }
    else if (form.lastName.value=="") 
    {
            alert("Please fill in your last name");
            form.lastName.focus();
    }
    else if (form.emailAddress.value=="") 
    {
            alert("Please fill in your email address");
            form.emailAddress.focus();
    }
    else if (form.address1.value=="") 
    {
            alert("Please fill in your street address line 1");
            form.address1.focus();
    }
    else if (form.city.value=="") 
    {
            alert("Please fill in your city name");
            form.city.focus();
    }
    else if (form.state.value=="") 
    {
            alert("Please fill in your state");
            form.state.focus();
    }
    else if (form.zip.value=="") 
    {
            alert("Please fill in your zip/postal code");
            form.zip.focus();
    }
    else if (form.country.value=="") 
    {
            alert("Please fill in your country");
            form.country.focus();
    }
    else 
    {
           form.submit();
    }
}
</script>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>Enter your name and contact information</h1>

<form action="<c:url value='/cart/processUser' />" method=post>
<table border="0" cellpadding="5">
  <tr>
    <td></td>
    <td align=left>Required <font color=red>*</font></td>
  </tr>
  <tr>
    <td align=right>First Name</td>
    <td><input type="text" name="firstName"  size="20" maxlength=20 
               value="${user.firstName}">
               <font color=red>*</font></td>
  </tr>
  <tr>
    <td align=right>Last Name</td>
    <td><input type=text name="lastName" size=20
               value="${user.lastName}">
               <font color=red>*</font></td>
  </tr>
  <tr>
    <td align=right>Email Address</td>
    <td><input type=text name="emailAddress" size=20
               value="${user.emailAddress}">
               <font color=red>*</font></td>
  </tr>
  <tr>
    <td align=right>Company</td>
    <td><input type=text name="companyName" size=20
               value="${user.companyName}"></td>
  </tr>
  <tr>
    <td align=right>Address1</td>
    <td><input type=text name="address1" size=20
               value="${user.address1}"> 
               <font color=red>*</font></td>
  </tr>
  <tr>
    <td align=right>Address2</td>
    <td><input type=text name="address2" size=20
               value="${user.address2}"></td>
  </tr>
  <tr>
    <td align=right>City</td>
    <td><input type=text name="city" size=20
               value="${user.city}">
               <font color=red>*</font></td>
  </tr>
  <tr>
    <td align=right>State</td>
    <td><input type=text name="state" size=20
               value="${user.state}">
               <font color=red>*</font></td>
  </tr>
  <tr>
    <td align=right>Zip Code</td>
    <td><input type=text name="zip" size=20
               value="${user.zip}">
               <font color=red>*</font></td>
  </tr>
  <tr>
    <td align=right>Country</td>
    <td><input type=text name="country" size=20
               value="${user.country}"> 
               <font color=red>*</font></td>
  </tr>
  <tr>
    <td align=right>&nbsp;</td>
    <td><input type="button" value="Continue" onClick="validate(this.form)"></td>
  </tr>
</table>

</form>

</td>

<!-- end middle column -->

<jsp:include page="/includes/footer.jsp" />