<#if prevBlog?? >
  <p>上一篇：<a href="./${prevBlog.id}.do">${prevBlog.title}</a></p>
<#else>
  <p>上一篇：无</P>
</#if> 


<#if nextBlog?exists >
  <p>下一篇：<a href="./${nextBlog.id}.do">${nextBlog.title}</a></p>
<#else>
  <p>下一篇：无</P>
</#if> 