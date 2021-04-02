<#ftl encoding="UTF-8"/>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Users</title>
</head>
<body>
<#--<form method="post" action="/users">-->
<#--    <input type="text" name="username" placeholder="Enter username">-->
<#--    <input type="text" name="email" placeholder="Enter email">-->
<#--    <input type="submit" value="Add">-->
<#--</form>-->
<table>
    <tr>
        <th>Username</th>
        <th>Email</th>
    </tr>
    <#list users as user>
        <tr>
            <td>
                <#if user.username??>
                    ${user.username}
                <#else>
                    username
                </#if >
            </td>
            <td>
                <#if user.email??>
                    ${user.email}
                <#else>
                    email
                </#if>
            </td>
        </tr>
    </#list>
</table>
</body>
</html>
