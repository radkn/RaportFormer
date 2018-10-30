<html>
<head>
    <title>Scenes</title>
</head>
<body>

<#list scenes as scene>
    <a href="/lines?scene=${scene.scene_id}"> ${scene.scene_id}</a><br>
</#list>

</body>
</html>