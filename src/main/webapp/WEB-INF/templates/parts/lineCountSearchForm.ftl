<#macro getCountForm path>
    <form action="${path}" method="post">
        <select name="lineTitle">

        <#list lines as line>
            <option>${line.lineTitle}</option>
        <#else>
            Not found any line
        </#list>

        </select>
        <input name="scene" type="hidden" value=${scene}/>

        <select name="status">
            <option>in</option>
            <option>out</option>
        </select>

        <select name="date">
        <#list dates as date>
            <option>${date}</option>
        <#else>
            Not found any line
        </#list>
        </select>

        <select name="timeStart">

        <#list 0..23 as hour>
            <option>${hour}</option>
        </#list>
        </select>

        <select name="timeEnd">

        <#list 0..23 as hour>
            <option>${hour}</option>
        </#list>
        </select>
        <input type="submit">
    </form>
</#macro>