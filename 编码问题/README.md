#### 在web开发的过程中 我们经常会遇到提交表单的业务 post get 有时候会利用ajax获取标签值进行提交 因此就会遇到一个棘手的问题 如何编解码  



<td>客户名称：</td>
<td><INPUT class=textbox id=sChannel2
style="WIDTH: 180px" maxLength=50 name="cust_name">
</td>

```
<td>客户名称：</td>
<INPUT class=textbox id=sChannel2
style="WIDTH: 180px" maxLength=50 name="cust_name">
```
 　　当点击submit提交时可能服务器段收到的可能就是乱码  查询了网上的教程多部分的回答都是  
  _get使用转码,post直接setcharacterEncode_

　　然而在实际操作的过程中 至少在本人电脑上出现了截然相反的情况 即post反倒是转码  
而get有时候甚至不需要设置setcharacter就能正确获取value值  

#### 多次实验后发现了一些规律
1. 无论是get还是post 既然利用了String转码 变成正确的中文值 就说明转码操作是正确的
> String value= new String(request.getParameter("cust_name").getBytes("ISO8859-1"),"UTF-8");

　　该代码中发送的request请求中就是将中文先转码成UTF-8的数据发送到服务器端 然而服务器段的默认设置以iso8859的解码形式编码 不可避免出现了乱码 这时候将乱码以iso的编码形式重新编回去 再以原先发送的utf-8的方式解码 就能获取正确的value  

2. post/get 所发送的数据的编码方式 服务器段的编解码格式 都是可以设置的

** 总结: **
* 每当遇到编解码问题 首先去查找解决问题的方法 之后最好去了解其原理 在编解码问题中 不断调试就发现 我的eclipse明显都是以ios8859的方式解码的 应该是可以设置的（不确定）
* get与post的提交 至少在我现在看来 请求体是无法用setcharacter来设置的 而get有乱码时就可以用该语句解决　　


#### 学习编程我觉得最大的问题 同一个问题可能是好几种原因触发出来的 网上查到的答案往往都是基于回答者自己的环境所结合给出的答案 如果能够解决 可能就是一个环境相仿 二就是这个原因所导致的 而不能够解决就当去查看自己的配置 比如jsp的头文件的格式 以及eclipse的windowns下的配置  

　　  一年前也写过[编解码的笔记](https://github.com/johncows/Javaweb/tree/master/%E8%BF%87%E6%BB%A4%26%E7%BC%96%E8%A7%A3%E7%A0%81) 现在看来也还是囫囵吞枣
