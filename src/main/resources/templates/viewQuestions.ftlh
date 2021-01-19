<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="ISO-8859-1">
    <title>Employee Management System</title>

    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
          crossorigin="anonymous">

</head>
<body>

<div class="container my-2">
    <h1>Lista Pytan</h1>

    <a href = "/addQuestion" class="btn btn-primary btn-sm mb-3"> Dodaj Pytanie </a>

    <table border="1" class = "table table-striped table-responsive-md">
        <thead>
        <#list questionList as question>
        <tr><td>${question.getCategory()}</td><td>${question.getQuestion()}</td><td>${question.getAnswer()}</td></tr>
        </thead>
        </#list>
        <tbody>
        <tr >
        </tr>
        </tbody>
    </table>


</div>
</body>
</html>