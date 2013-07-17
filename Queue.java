public class Queue<Item>{
	private Node first,last;
	private int size;
	public Queue(){
		size = 0;
	}
	private class Node{
		Item item;
		Node next;
		public Node(Item item){
			this.item = item;
		}
	}
	public void enqueue(Item item){
		Node oldlast = last;
		last = new Node(item);
		last.next = null;
		if (isEmpty()) first = last;
		else oldlast.next = last;	
		size++;
	}
	public Item dequeue(){
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

}
