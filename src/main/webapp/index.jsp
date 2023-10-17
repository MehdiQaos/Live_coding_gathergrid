<%@ page import="java.util.List" %>
<%@ page import="com.youcode.live_coding_gathergrid.model.User" %>


<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>User List</title>
</head>
<body>
<h1>User List</h1>
<table>
    <thead>
        <tr>
            <th>ID</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Email</th>
        </tr>
    </thead>
    <tbody>
        <%
            List<User> users = (List<User>) request.getAttribute("users");
            if (users != null && !users.isEmpty()) {
                for (User user : users) {
        %>
        <tr>
            <td><%= user.getId() %></td>
            <td><%= user.getFirstName() %></td>
            <td><%= user.getLastName() %></td>
            <td><%= user.getEmail() %></td>
        </tr>
        <%
                }
            } else {
        %>
        <tr>
            <td colspan="4">No users found</td>
        </tr>
        <%
            }
        %>
    </tbody>
</table>
<br>
<a href="create-user.jsp">Create User</a>
</body>
</html>