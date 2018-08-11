#### 这几天一直没有git,但天天晚上看今日头条推送的博客,忽然发现自己对java的基本数据类型和相应的包装类的底层实现有些疑惑 这边写一篇文档来复习一下  
1. 包装类与包装类   

```
        Integer o1 = new Integer(12); // 手动的将一个整形进行封装
		Integer o2 = new Integer(12);
		System.out.println(o1.equals(o2));  //true
		System.out.println(o1==o2);         //false
```

2. 包装类与基本类型
```
        Integer o1 = new Integer(12);
		int o2 = 12;
		System.out.println(o1==o2);//true
```

#### 结论：
　　  从上面的代码可以发现
1. 包装类之间比较,如果使用 == 则比较的是2个对象的地址 也就是说除非是同一个new的对象引用 否则其返回结果都是false  
2. 包装类与基本类型比较则包装类会自动转换为基本类型 这时候使用==则返回就是true(值比较)  

#### 那当我们需要比较2个对象的值时 应该怎么比较呢？ 这时候我们需要去重写equal方法，注意所有对象的父类object中的equal方法 实际也是通过判断对象的地址来返回boolean值(重写equal部分见源码)

```
public boolean equals(Object obj) {
       return (this == obj);//Object的equal方法
   }

 public boolean equals(Object anObject) {//String重写的方法
         if (this == anObject) {
             return true;
         }
         if (anObject instanceof String) {
             String anotherString = (String)anObject;
             int n = value.length;
             if (n == anotherString.value.length) {
                 char v1[] = value;
                 char v2[] = anotherString.value;
                 int i = 0;
                 while (n-- != 0) {
                     if (v1[i] != v2[i])
                         return false;
                     i++;
                 }
                 return true;
             }
         }
         return false;
     }
```
　　  我们可以发现当我们需要去比较某个非基本类型的对象时 都需要重写equal方法
那就免不了提到hashcode方法  [hashcode的具体介绍](../集合篇/Maps.java)  

###　扩展  
　　  当我们去生成一个hash容器时 会添加不同的对象 为了提高查找速度就需要去生成一个代表自己对象的一个hashcode值(或自己重写或系统) 当object1与object2所生成的hashcode相同时且不能重复对象插入时 系统就会调用equal方法来比较2个对象是否相同 如果相同 则放弃插入 如果不同就会自动的追加到相应桶的前面(头插法)!
