import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRU {

	private Deque<Integer> cache;
	private Map<Integer, Integer> map;
	private int size;
	private int capacity;
	
	LRU(int capacity) {
		cache = new LinkedList<Integer>();
		map = new HashMap<Integer, Integer>();
		size = 0;
		this.capacity = capacity;
	}
	
	public void add(int page){
		if(map.containsKey(page)){
			cache.remove(page);			
			cache.addFirst(page);
		}
		else if(map.size() != capacity) {
			cache.add(page);
			map.put(page, page);
			size++;
		}
		else {
			int head = cache.remove();
			map.remove(head);
			cache.add(page);
			map.put(page, page);
			size++;
		}
	}
	
	public void add(int []pages) {
		for(int page: pages)
			add(page);
	}
	
	public String toString() {
		StringBuilder result = new StringBuilder();
		for(int page: cache) {
			result.append(page+", ");
		}
		return result.toString();
	}
	
	public static void main(String[] args) {
		LRU memory = new LRU(5);
		int []pages = {1,2, 3, 4, 5};		
		memory.add(pages);
		System.out.println("After adding all pages: "+memory.toString());
		memory.add(3);
		System.out.println("After adding already present page: "+memory.toString());
		memory.add(10);
		System.out.println("After adding new page: "+memory.toString());
	}

}
