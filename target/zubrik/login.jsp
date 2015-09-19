<!DOCTYPE html>

<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Log in to ZUBRIK</title>
</head>
    <body>
        <h2>
            Please login to our awesome website!<br/><br/>
        </h2>

        <form action="/zubrik/login" method="post">
             Login:    <input name="username" type="text" /><br/><br/>
             Password: <input name="password" type="password" /><br/><br/>
             <input name="submit" value="Login now!" type="submit" /><br/>
        </form>

        <h3><font color="red">${messageMap.fieldIsEmpty}</font></h3>
        <h3><font color="red">${messageMap.noUser}</font></h3>

        <h3>
           <a href="register.jsp">Register if you are new here!</a><br/><br/>
        </h3>
    </body>
</html>

