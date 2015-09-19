<!DOCTYPE html>

<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>ZUBRIK - the best appointment app</title>
</head>
    <body>
        <h2>
            Please enter your info and we will register you.<br/><br/>
        </h2>

        <form action="register" method="post">
             Login: <input name="username" type="text" /><br/><br/>
             Password: <input name="password" type="password" /><br/><br/>
             Repeat Password: <input name="repeatPassword" type="password" /><br/><br/>
            <input name="submit" value="Register now!" type="submit" /><br/>
        </form>


        <h3><font color="red">${messageMap.fieldIsEmpty}</font></h3>
        <h3><font color="red">${messageMap.usernameErrorMessage}</font></h3>
        <h3><font color="red">${messageMap.passwordErrorMessage}</font></h3>
        <h3><font color="red">${messageMap.repeatPasswordErrorMessage}</font></h3>
    </body>
</html>

