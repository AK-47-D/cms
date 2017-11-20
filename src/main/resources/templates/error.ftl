<#include 'common/head.ftl'>
<#include 'common/nav.ftl'>

<h1>系统异常统一处理页面</h1>

<h3>异常消息: ${errorMessage!'异常消息'}</h3>

<h3>异常代码: ${errorCode!'异常消息'}</h3>

<h3>异常堆栈信息：</h3>
<code>

<#list stackTrace as line >
    <p>${line}</p>
</#list>

</code>

<#include 'common/foot.ftl'>
