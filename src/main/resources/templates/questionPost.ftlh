<!DOCTYPE html>
<html>
<head>
    <title>Dodaj pytanie</title>
    <meta charset="UTF-8"/>
</head>
<body>Pytanie:</br></br>

<form action="/template/questionPost" method="post">

    <label> Pytanie: <input type="text" name="question" required> </label></br></br>
    <label> Odpowiedz: <input type="text" name="answer" required> </label></br></br>

    <label for="category">Kategoria</label>
    <select type="text" name="category" required>
        <option value="Java SE">Java SE</option>
        <option value="Java EE">Java EE</option>
        <option value="Spring">Spring</option>
        <option value="SQL">SQL</option>
        <option value="Rest Api">Rest Api</option>
        <option value="Hibernate">Hibernate</option>
    </select></br></br>

    <input type="submit" name="save" value="save">
</form>

</body>
</html>