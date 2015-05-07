<jsp:include page="/includes/header.html" />
<jsp:include page="/includes/column_left_all.jsp" />

<!-- start the middle column -->

<td>

  <script language="JavaScript">
    function validate(form) {
        if (form.firstName.value=="") {
            alert("Please fill in your first name");
            form.firstName.focus();
        }
        else if (form.lastName.value=="") {
            alert("Please fill in your last name");
            form.lastName.focus();
        }
        else if (form.emailAddress.value=="") {
            alert("Please fill in your email address");
            form.emailAddress.focus();
        }
        else {
            form.submit();
        }
    }
  </script>

  <h1>Download registration</h1>

  <p>Before you can download and listen to these sound files, 
  you must register with us by entering your name and email 
  address below.</p>

  <!-- Import the core JSTL library -->
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

  <!-- Use the JSTL url tag to encode the URL -->
  <form action="<c:url value='/catalog/registerUser'/>" 
        method="post">
    <table cellpadding="5" border="0">
      <tr>
        <td align="right"><p>First name:</td>
        <td><input type="text" name="firstName"></td>
      </tr>
      <tr>
        <td align="right"><p>Last name:</td>
        <td><input type="text" name="lastName"></td>
      </tr>
      <tr>
        <td align="right"><p>Email address:</td>
        <td><input type="text" name="emailAddress"></td>
      </tr>
      <tr>
        <td></td>
        <td><input type="button" value="Submit" 
                   onClick="validate(this.form)"></td>
      </tr>
    </table>
  </form>

</td>

<!-- end the middle column -->

<jsp:include page="/includes/column_right_buttons.jsp" />
<jsp:include page="/includes/footer.jsp" />