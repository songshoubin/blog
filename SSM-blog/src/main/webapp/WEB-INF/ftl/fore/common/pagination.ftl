 <ul class="pagination">
    <#assign pp=page.total%page.pageSize >
    <#assign totalPage=(page.total/page.pageSize)?int >
    <#if pp != 0 >
       <#assign totalPage=totalPage+1 >
    </#if>
    
    <#-- 拼接查询参数 -->
    <#assign paramurl="" >
   <#list RequestParameters?keys as key>
       <#if key != 'page'>
         <#assign paramurl+="&"+key+"="+RequestParameters[key] />
        </#if>
	</#list>
   
	<#if page.currentPage gt 1>
		<li><a href="${request.requestURL}?page=1${paramurl}">首页</a></li>
		<li><a href="${request.requestURL}?page=${page.currentPage-1}${paramurl}">上一页</a></li>			
	<#else>
		<li class='disabled'><a>首页</a></li>
		<li class='disabled'><a>上一页</a></li>		
	</#if>
	
	<#list page.currentPage-5 .. page.currentPage+5 as i >
	  <#if i == currentPage >
		  <li class='active'><a href="${request.requestURL}?page=${i}${paramurl}">${i}</a></li>	
	  <#elseif (i gte 1) && (i lte totalPage) >
		  <li><a href="${request.requestURL}?page=${i}${paramurl}">${i}</a></li>
	  </#if>	
	</#list>
	
	<#if page.currentPage lt totalPage >
        <li><a href="${request.requestURL}?page=${page.currentPage+1}${paramurl}">下一页</a></li>
		<li><a href="${request.requestURL}?page=${totalPage}${paramurl}">尾页</a></li>
	<#else>
		<li class='disabled'><a>下一页</a></li>
		<li class='disabled'><a>尾页</a></li>	
	</#if>	

</ul>
