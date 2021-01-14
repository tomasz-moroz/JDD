<!DOCTYPE html>
<html lang="pl">
<head>
    <link rel="stylesheet" href="styles/style.css"/>
    <meta charset="utf-8">
    <title>Wylosuj pytanie</title>
</head>
<body>

<div class="row">
    <div class="col">
        <h2>Kategoria:
            <p><#if category??>
                ${category} </p>
            <#else >
            Category not found</#if></p> </h2>
        <div class="tabs">
            <div class="tab">
                <input type="checkbox" id="chck1" >
                <label class="tab-label" for="chck1">Pytanie:</label>
                <div class="tab-content">
                    <p><#if question??>
                        ${question} </p>
                    <#else >
                    Question not found</#if></p>
                </div>
            </div>
            <div class="tab">
                <input type="checkbox" id="chck2" >
                <label class="tab-label" for="chck2">Odpowiedz</label>
                <div class="tab-content">
                    <p><#if answer??>
                        ${answer} </p>
                    <#else >
                    Answer not found</#if></p>
                </div>
            </div>
        </div>
    </div>

</div>


    <input action="/luckyShot" type="submit" name="save" value="Losuj kolejne">



<a href="/start">Powrot do strony glownej</a>

</body>
</html>

<#--

<div class="accordion">
    <h2>Kategoria:
        <p><#if category??>
            ${category} </p>
        <#else >
        Category not found</#if></p> </h2>
    <div id="one" class="section">
        <h3>
            <a href="#one">Pytanie: </a>
        </h3>
        <div>
            <p><#if question??>
                ${question} </p>
            <#else >
            Question not found</#if></p>
        </div>
    </div>
    <div id="two" class="section">
        <h3>
            <a href="#two">Odpowiedz: </a>
        </h3>
        <div>
            <p><#if answer??>
                ${answer} </p>
            <#else >
            Answer not found</#if></p>
        </div>
    </div>
</div>-->
