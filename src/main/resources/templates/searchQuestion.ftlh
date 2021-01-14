<!DOCTYPE html>
<html lang="en">
<head>


</head>
<body>
<div>
    <#if foundList??>
        <#list foundList>
            <ul>
                <#items as question>
                <li>
                        <p>${question.getQuestion()}</p>
                </li>
                </#items>
            </ul>
        </#list>
    <#else >
        <p>Question not found</p>
    </#if>
</div>
</body>
</html>