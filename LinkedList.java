public class LinkedList<Item>{
	private Node first;
	private int size;
	public LinkedList(){
		size = 0;
	}
	private class Node{
		Item item;
		Node next;
		public Node(Item item){
			this.item = item;
		}
	}
	public void insert(Item item){
		Node newguy = new Node(item);
		newguy.next = first;
		first = newguy;
		size++;
	}
	public Item remove(){
		if (!isEmpty()){
			Item item = first.item;
			first = first.next;// first in first out
			size--;
			return item;
		}
		else return null;
	}
	public boolean isEmpty(){
		return (first==null);
	}
	public int size(){
		return size;
	}

	private Node reverseList(int i){
		Node behind, current, forward;
		behind = first;
		current = first.next;
		forward = first.next.next;
		first.next = null;
		while(true){
			current.next = behind;
			if (forward.next == null){
				forward.next = current;
				break;
			}
			else{		
			behind = current;
			current = forward;
			forward = forward.next;
			}
		}
		return forward;
	}

	public void reverseList(){
		this.first = reverseList(1);
	}

	public Node findMiddleNode(){
		Node behind = first, front = first;
		if (first == null) return null; // Empty list
		int behindIdx = 1, frontIdx = 1;
		while(front!=null){
			frontIdx = 2*behindIdx;
			int diff = frontIdx-behindIdx;
			for(int i = 0; i<diff; i++){
				if(front.next == null) break;
				front = front.next;
			}
			if (front.next == null) break;
			behind = behind.next;
			behindIdx += 1;

		
		}
		return behind;
	}

	public void printMiddleNode(){
		System.out.println("Middle Node: " + findMiddleNode().item);
	}
}
