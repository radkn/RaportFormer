<#import "parts/lineCountSearchForm.ftl" as l>
<html>
<head>
    <title>Lines</title>
</head>
<body>

<@l.getCountForm "/lines/bytitledate"/>

<table border="1">
    <#list count?keys as time>
        <tr>
            <td>${time}</td>
            <td>${count[time]}</td>
        </tr>
    <#else>
            Not found any line
    </#list>
</table>

</body>
</html>