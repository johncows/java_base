import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.RandomAccess;

import org.junit.Test;


@SuppressWarnings("unused")

public class Array_List {

	@Test
	public void fun1() {
		Collection<String> arrayList = new ArrayList<String>();
		arrayList.add("a");
		arrayList.add("b");
		arrayList.add("c");
		arrayList.add("d");
		Iterator<String> iterator = arrayList.iterator();

		/* 		
		 * 		迭代器在使用过程中 可以去理解为每一次的next 实质上就是指向下一个数据
		 *		返回经过数据的指针（对象的引用）
		 *		下段代码类似于for each循环
		 */


		
		
		while(iterator.hasNext()) {
			iterator.next();
		}
//		iterator.next();  	error!!!!
		

		/*
		 * 	利用 instanceof 判断实例是否具备快速访问
		 * 	实验可以发现数组具备随机访问但大小有所限制
		 * 	而链表不具备告诉访问 但能够随意添加或删除
		 */
		System.out.println(arrayList instanceof RandomAccess);
	}
}
