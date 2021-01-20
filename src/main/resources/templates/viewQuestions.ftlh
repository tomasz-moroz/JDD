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

    <a href="/addQuestion" class="btn btn-primary btn-sm mb-3"> Dodaj Pytanie </a>

    <table border="1" class="table table-striped table-responsive-md">
        <thead>
        <tr>
            <th>Kategoria</th>
            <th>Pytanie</th>
            <th>Odpowiedz</th>
        </tr>
        </thead>
        <tbody>
        <#list questionList as question>
            <tr>
                <td>${question.getCategory()}</td>
                <td>${question.getQuestion()}</td>
                <td>${question.getAnswer()}</td>
            </tr>
        </#list>
        </tbody>
    </table>

    <div>
        <#if (totalPages > 1)>
            <div class="row col-sm-10">
                <div class="col-sm-2">
                    Ilosc stron: ${totalPages}
                </div>
                <div class="col-sm-1">
                    <span>
                        <#list listOfNumbers>
                            <#items as pages>
                            <#if page != pages>
                                <a href="'/page/'+${page}"> ${page}</a>
                                <span>${page}</span>
                            </#if>
                            </#items>
                        </#list>
                    </span>
                </div>
                <div class="col-sm-1">
                    <#if (page < totalPages)>
                        <a href="'/page/'+${page+1}"> Next</a>
                    <#else >
                        <span>Next</span>
                    </#if>
                </div>
                <div class="col-sm-1">
                    <#if (page < totalPages)>
                        <a href="'/page/'+${totalPages}"> Last</a>
                    <#else >
                        <span>Last</span>
                    </#if>
                </div>
            </div>
        </#if>
    </div>


</div>
</body>
</html>