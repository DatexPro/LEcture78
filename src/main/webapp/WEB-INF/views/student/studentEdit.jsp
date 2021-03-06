<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<h1>Create Student</h1>

<form:form modelAttribute="student"
           action="${pageContext.request.contextPath}/students/save">
    <table style="background-color: black; color: aliceblue">
        <tr>
            <td>First name:</td>
            <td><form:input path="firstName"/></td>
        </tr>
        <tr>
            <td>Last name:</td>
            <td><form:input path="lastName"/></td>
        </tr>
        <tr>
            <td>Date of birth:</td>
            <td><form:input path="birthday"/></td>
        </tr>
        <tr>
            <td>email:</td>
            <td><form:input path="email"/></td>
        </tr>
        <tr>
            <td>phone:</td>
            <td><form:input path="phone"/></td>
        </tr>
        <tr>
            <td>groupID:</td>
            <td><form:input path="groupID"/></td>
        </tr>
        <td colspan="2">
            <input type="submit" value="Save" />
        </td>
    </table>
</form:form>