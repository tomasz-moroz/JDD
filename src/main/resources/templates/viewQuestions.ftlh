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
    <a href="/start" class="btn btn-primary btn-sm mb-3"> Przejdz do strony glownej </a>

    <table border="1" class="table table-striped table-responsive-md">
        <thead>
        <tr>
            <th>
                <a href="${page}?sortField=category&sortDir=${reverseSortDir}">Kategoria</a>
            </th>
            <th>Pytanie</th>
            <th>Odpowiedz</th>
            <th> Edycja </th>
        </tr>
        </thead>
        <tbody>
        <#list questionList as question>
            <tr>

                <td><#if question.getCategory()??>
                        ${question.getCategory()} </p>
                    <#else >
                    Category not found</#if></td>

                <td><#if question.getQuestion()??>
                        ${question.getQuestion()} </p>
                    <#else >
                    Question not found</#if></td>

                <td><#if question.getAnswer()??>
                        ${question.getAnswer()} </p>
                    <#else >
                    Answer not found</#if></td>

                <td><a href="/showFormForUpdate/${question.getId()}" class="btn btn-primary">Update</a></br></br>
                    <a href="/deleteQuestion/${question.getId()}" class="btn btn-danger">Delete</a>
                </td>
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
                <div class="col-sm-2">
                    <#if (page > 0)>
                        <a href="${page-1}?sortField=category&sortDir=${reverseSortDir}"> Poprzednia strona</a>
                    <#else >
                        <span>Poprzednia strona</span>
                    </#if>
                </div>
                <div class="col-sm-2">
                    <span>
                        <#list listOfNumbers>
                            <#items as pages>
                                <#if page != pages>
                                    <a href="${pages}?sortField=category&sortDir=${reverseSortDir}"> ${pages+1}</a>
                                <#else >
                                    <span>${pages+1}</span>
                                </#if>
                            </#items>
                        </#list>
                    </span>
                </div>

                <div class="col-sm-2">
                    <#if (page < totalPages)>
                        <a href="${page+1}?sortField=category&sortDir=${reverseSortDir}"> Nastepna strona</a>
                    <#else >
                        <span>Nastepna strona</span>
                    </#if>
                </div>

            </div>
        <#else >
            <a>-</a>
        </#if>
    </div>
</div>
</body>
</html>