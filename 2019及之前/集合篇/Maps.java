import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class Maps {
	@Test
	public void fun() {
		Map<String , Object> map = new HashMap<>();
		map.put("1","a");
		map.put("2","b");
		map.put("3","c");
		map.put("4","d");

		
		//利用lambda表达式
		map.forEach((k,v)->System.out.println("key:"+k+" value:"+v));
	}
}
