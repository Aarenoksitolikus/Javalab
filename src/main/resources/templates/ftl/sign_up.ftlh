<#ftl encoding="UTF-8"/>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <title>Sign Up</title>
</head>
<body>
<div class="signup">
    <div class="signup intro">
        <h1>Hello, visitor!</h1>
        <h3>Welcome to the our little club! To join us, fill out a short form, please</h3>
    </div>
    <div class="signup regform">
        <form method="post" action="/signup">
            <p><label for="username">Enter your nickname in BongoNet:</label></p>
            <p><input type="text" id="username" name="username" placeholder="Nickname"></p>
            <p><label for="email">Enter your email address:</label></p>
            <p><input type="text" id="email" name="email" placeholder="Email address"></p>
            <p><label for="password">Сome up with and enter your password:</label></p>
            <p><input type="password" id="password" name="password" placeholder="Password"></p>
            <p><label for="check_password">Enter your password once again:</label></p>
            <p><input type="password" id="check_password" name="check_password" placeholder="Password once again"></p>
            <p><input type="submit" value="Sign up!"></p>
        </form>
    </div>
</div>
</body>
</html>
