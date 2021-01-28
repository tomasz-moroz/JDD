<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Registration</title>

    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
          crossorigin="anonymous">
</head>
<body>
<!-- create navigation bar ( header) -->
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed"
                    data-toggle="collapse" data-target="#navbar" aria-expanded="false"
                    aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span> <span
                        class="icon-bar"></span> <span class="icon-bar"></span> <span
                        class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/">Registration and
                Login Module</a>
        </div>
    </div>
</nav>
<br>
<br>
<!-- Create HTML registration form -->
<div class="container">
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <!-- success message -->
            <div>

                <h1>Registration</h1>
                <div>
                    <form action="/registration" method="post" value="${user}">
                        <div class="form-group">
                            <label class="control-label" for="firstName"> First Name </label>
                            <input id="firstName" class="form-control" value="${user.setFirstName(user.getFirstName())}"
                            required autofocus="autofocus"/>
                        </div>

                        <div class="form-group">
                            <label class="control-label" for="lastName"> Last Name </label> <input
                                    id="lastName" class="form-control" value="${user.lastName}"
                            required autofocus="autofocus"/>
                        </div>

                        <div class="form-group">
                            <label class="control-label" for="email"> Email </label> <input
                                    id="email" class="form-control" value="${user.email}" required
                                    autofocus="autofocus"/>
                        </div>

                        <div class="form-group">
                            <label class="control-label" for="password"> Password </label> <input
                                    id="password" class="form-control" type="password"
                                    value="${user.password}" required autofocus="autofocus"/>
                        </div>

                        <div class="form-group">
                            <button type="submit" class="btn btn-success">Register</button>
                            <span>Already registered? <a href="/start" >
								here</a></span>
                        </div>
                    </form>
                </div>
                <#if user??>
                    <div class="alert alert-info">You've successfully registered
                        to our awesome app!
                    </div>
                <#else >
                    <div class="alert alert-info"> error</div>
                </#if>
            </div>
        </div>
    </div>
</body>
</html>