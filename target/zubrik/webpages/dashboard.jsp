<!DOCTYPE html>

<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Your Dashboard</title>
</head>
    <body>
        <%String name = (String)request.getAttribute("name"); %>
        <h1>WELCOME <%= name%>!!! Thanks for logging in!<h1>

        Now you can do a lot of useful stuff. Well, after we finish this app :)
    </body>
</html>