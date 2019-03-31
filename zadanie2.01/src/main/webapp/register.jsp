<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<body>
<form action="register" method="post">
    <a href="index.jsp">Zaloguj</a>

    <title>Rejestracja</title>
    <h3>Rejestracja</h3>
    <table>
        Nazwa uzytkownika:<br/>
        <input name="user"><br/>
        Haslo :<br/>
        <input name="password" type="password"><br/>
        Potwierdz haslo:<br/>
        <input name="confPassword" type="password"><br/>
        E-mail:<br/>
        <input name="email"><br/>
        <td/>
        <br><input type="submit" value="Rejestruj" name="regis">
    </table>


</form>
</head>
</body>
</html>

