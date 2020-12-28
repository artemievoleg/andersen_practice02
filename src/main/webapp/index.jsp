<!doctype html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>
    <div class="container-fluid">
        <form action="/andersen_practice02/person" method="post">
            <table>
                <tr>
                    <td>
                        <input type="text" class="form-control" name="name" aria-describedby="passwordHelpBlock"
                               placeholder="Имя_">
                    </td>
                    <td>
                        <input type="text" class="form-control" name="lastname" aria-describedby="passwordHelpBlock"
                               placeholder="Фамилия">
                    </td>
                    <td>
                        <button type="submit" class="btn btn-secondary">Добавить</button>
                    </td>
                </tr>
            </table>
        </form>
    </div>

<table class="table table-dark">
    <thead>
    <tr>
        <th>Имя</th>
        <th>Фамилия</th>
    </tr>
    </thead>
    <c:forEach items="${personlist}" var="person">
        <tr>
            <td><c:out value="${person.getName()}"/></td>
            <td><c:out value="${person.getLastname()}"/></td>
            <td>
                 <form action="/andersen_practice02/person" method="post">
                    <input type="hidden" name="user_id" value="${person.getId()}">
                    <button style="position: center" type="submit" class="btn btn-secondary">Удалить</button>
                 </form>
            </td>
        </tr>
    </c:forEach>
</table>
