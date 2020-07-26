import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import org.junit.Test;

public class Link_List {
	@Test
	public void fun() {
		List<String> linkedList = new LinkedList<String>();
		linkedList.add("a");
		linkedList.add("c");
		linkedList.add("d");
		linkedList.add("e");

		// 如何插入b到ac之间呢？

//		 linkedList.add("b");
//		 System.out.println(linkedList);
//		 [a, c, d, e, b]

		// LinkList中添加了add(int i,Object object) 这在父类collection中是无法被引用的

		ListIterator<String> iterator = linkedList.listIterator();
		iterator.next();
		// iterator.add("b");
		linkedList.add(1, "b");
		System.out.println(linkedList);

	}
}
