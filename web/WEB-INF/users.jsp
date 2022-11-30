<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JDBC</title>
    </head>
    <body>
    <div>
        <h2>Add User</h2>
        <form action="user" method="post">
            <input type="hidden" name="action" value="add">
            <input type="text" id="email" name="email">
            <input type="text" id="fname" name="fname">
            <input type="text" id="lname" name="lname">
            <input type="text" id="password" name="password">
            <select name="roleId">
                <option value="1">System admin</option>
                <option value="2">Regular user</option>
                <option value="3">Company admin</option>
            </select>
            <input type="submit" name="action" value="Save">
        </form>
    </div>
    <div>
        <h2>Manage Users</h2>
        <table>
            <tr>
                <th>Email</th>
                <th>Active</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Role</th>
            </tr>
            <c:forEach items="${users}" var="user">
                <tr>
                    <td>${user.email}</td>
                    <td>${user.active ? "Active" : "Inactive"}</td>
                    <td>${user.fname}</td>
                    <td>${user.lname}</td>
                    <td>${user.roleId}</td>
                <td>
                <a href="user?action=edit&email=${user.email}">Edit</a>
                <a href="user?action=delete&email=${user.email}">Delete</a>
                </td>
                </tr>
                </c:forEach>
        </table>
    </div>
    <div>
        <h2>Edit User</h2>
        <form action="user" method="post">
            <input type="hidden" name="action" value="update">
            <input type="hidden" name="email" value="${user.email}">
            <input type="text" name="fname" value="${user.fname}">
            <input type="text" name="lname" value="${user.lname}">
            <input type="text" name="password" value="${user.password}">
            <select name="role">
                <option value="1">System admin</option>
                <option value="2">Regular user</option>
                <option value="3">Company admin</option>
            </select>
            <input type="submit" name="action" value="Save">
        </form>
    </div>
    </body>
</html>
