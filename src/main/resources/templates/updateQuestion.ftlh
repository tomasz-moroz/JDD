<!DOCTYPE html>
<html>
<head>
    <title>Edytuj pytanie</title>
    <meta charset="UTF-8"/>
</head>
<body>Edytuj pytanie:</br></br>

<form action="/showFormForUpdate/${id}/edit" method="post">

    <label > Pytanie: <input type="text" name="question" required style="width: 1000px"> </label></br></br>
    <label> Odpowiedz: <input type="text" name="answer" required style="width: 1000px"> </label></br></br>

    <label for="category">Kategoria</label>
    <select type="text" name="category" required style="margin-left: auto; margin-right: auto">
        <option selected value=null></option>
        <option value="Java SE">Java SE</option>
        <option value="Java EE">Java EE</option>
        <option value="Spring">Spring</option>
        <option value="SQL">SQL</option>
        <option value="Rest Api">Rest Api</option>
        <option value="Hibernate">Hibernate</option>
        <option value="Maven">Maven</option>
        <option value="Git">Git</option>
        <option value="Front-end">Front-end</option>
        <option value="Unit-test">Unit-test</option>
        <option value="Linux">Linux</option>
        <option value="Scrum">Scrum</option>
    </select></br></br>

    <input type="submit" name="update" value="update" >
</form>
<a href="/start">Powrot</a>
</body>
</html>