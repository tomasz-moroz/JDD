<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<p>luckyShot</p>
<label> Draw a question: <input type="submit" name="luckyShot" value="shot"></label>
<p> Question:
    <#if question??>
    ${question} </p>
<#else >
    Question not found</#if>
<p> Category:
    <#if category??>
    ${category} </p>
<#else >
    Category not found</#if>
<a href="/start">Powrot</a>
</body>
</html>