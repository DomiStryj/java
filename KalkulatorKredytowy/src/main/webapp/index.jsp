<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Kredyt</title>
</head>
<body>
<form action="index" method="post"></form>
<h3>Kalkulator kredytowy: </h3>
<table>
    Wnioskowana kwota kredytu</br>
    <input type="number" min="1" name="kwota"><br/>
    Ilosc rat :<br/>
    <input type="number" min="3" max="50" name="raty">(minimum 3 maksimum 50)<br/>
    Oprocentowanie kredytu: <br/>
    <input type="number" min="0" name="oprocentowanie" ><br/>
    Oplata stala:<br/>
    <input name="oplataStala" type="number" ><br/>
    Rodzaj rat:<br/>
    <select name="rodzajRat">
        <option value="stala_wysokosc_rat">stala wysokosc rat</option>
        <option value="raty_malejace">raty malejace</option>
</table>
<br><input type="submit" value="Oblicz" name="oblicz">
</form>
</table>
</body>
</html>
