<#-- 调用数据模版 -->
<#macro data
 websiteId = 0   <#-- 站点ID -->
 channelId = 0   <#-- 栏目ID -->
>
    <#local dataTemplate=ftlTemplateService.findDataTemplate(websiteId,channelId)>
    ${dataTemplate!''}
</#macro>