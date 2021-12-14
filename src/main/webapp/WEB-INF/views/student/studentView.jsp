<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<h1>Edit Student</h1>

<table style="background-color: darkblue; color: chartreuse">
    <tr>
        <td>ID:</td>
        <td>${student.id}</td>
    </tr>
    <tr>
        <td>Name:</td>
        <td>${student.firstName}</td>
    </tr>
    <tr>
        <td>Surname:</td>
        <td>${student.lastName}</td>
    </tr>
    <tr>
        <td>Date of birth:</td>
        <td>${student.birthday}</td>
    </tr>
    <tr>
        <td>Email:</td>
        <td>${student.email}</td>
    </tr>
    <tr>
        <td>Phone:</td>
        <td>${student.phone}</td>
    </tr>
    <tr>
        <td>Group ID:</td>
        <td>${student.groupID}</td>
    </tr>
    <tr>
    <!-- Добавлена ссылка Edit -->
    <td colspan="2">
        <a href="${pageContext.request.contextPath}/students/${student.id}/edit">Edit</a>
    </td>
    </tr>
</table>

<form:form modelAttribute="student"
           action="${pageContext.request.contextPath}/students/delete">
    <form:hidden path="id" value="${student.id}" />
    <input type="submit" value="Delete" />
</form:form>