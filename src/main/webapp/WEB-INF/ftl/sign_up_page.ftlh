<#ftl encoding="UTF-8"/>
<!doctype html>
<html lang="en">
<#import "spring.ftl" as spring/>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <title><@spring.message 'sign_up_page.registration.title'/></title>
    <style>
        .error {
            color: red;
        }
    </style>
</head>
<body>
<a href="?lang=ru">Ru</a>
<a href="?lang=en">En</a>
<@spring.bind "userForm"/>
<div class="signup">
    <div class="signup intro">
        <h1><@spring.message 'sign_up_page.registration.hello'/></h1>
        <h3><@spring.message 'sign_up_page.registration.greeting'/></h3>
    </div>
    <div class="signup regform">
        <form method="post" action="/signup">
            <p><label for="username">Enter your nickname in BongoNet:</label></p>
            <p><@spring.formInput "userForm.username" "placeholder='Username'"/></p>
            <@spring.showErrors "<br>" "error"/>
            <p><label>Enter your email address:</label></p>
            <p><@spring.formInput "userForm.email" "placeholder='Email'"/></p>
            <@spring.showErrors "<br>" "error"/>
            <p><label>Сome up with and enter your password:</label></p>
            <p><@spring.formPasswordInput "userForm.password" "placeholder='Password'"/></p>
            <@spring.showErrors "<br>" "error"/>
            <p><label>Enter your password once again:</label></p>
            <p><@spring.formPasswordInput "userForm.checkPassword" "placeholder='Password once again'"/></p>
            <@spring.showErrors "<br>" "error"/>
            <p><input type="submit" value="Sign up!"></p>
        </form>
    </div>
</div>
</body>
</html>
