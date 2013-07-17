import java.lang.Comparable;
public class BinarySearchTree<Item extends Comparable<Item>>{
	private Node root;
	private class Node{
		Item item;
		Node left, right;
		int children;
		public Node(Item item, int children){
			this.item = item;
			this.children = children;
		}
	}
	public int size(){
		return size(root);
	}
	private int size(Node x){
		if (x==null) return 0;
		else return x.children;
	}
	public boolean isEmpty(){return (root==null);}
	public void insert(Item item){
		root = insert(root, item);
	}
	private Node insert(Node x, Item item){
		if(x==null) return new Node(item, 1);
		int cmp = item.compareTo(x.item);
		if (cmp==-1) x.left = insert(x.left,item);
		else if (cmp== 1) x.right = insert(x.right,item);
		else x.item = item;
		x.children = size(x.left) + size(x.right) +1;
		return x;
	}
	public void inOrderTraversal(){
		inOrderTraversal(root);
	}
	private void inOrderTraversal(Node toprint){
		if (toprint == null) return;
		inOrderTraversal(toprint.left);
		System.out.println("Node value: "+toprint.item + " children: "+ size(toprint));
		inOrderTraversal(toprint.right);
	}
	public int treeHeight(){
		return treeHeight(root);
	}
	private int treeHeight(Node currentNode){
		if (currentNode == null) return 0;
		return 1+ Math.max(treeHeight(currentNode.left), treeHeight(currentNode.right));
	}
	public Item getMin(){
		//Get to the smallest node, return value and delete the node
		return getMin(root);
	}
	private Item getMin(Node current){
		if (current.left.left == null){
			Item value = current.left.item;
			current.left = null;
			return value;}
		else return getMin(current.left);
	}

	public Item getMax(){
		return getMax(root);
	}
	private Item getMax(Node current){
		if (current.right.right == null){
			Item value = current.right.item;
			current.right = null;	
			return value;}
		else return getMax(current.right);
	}

	public void concatenate(BinarySearchTree concatTree, BinarySearchTree thatTree){
		// this is the smaller tree.
		// Root of the new tree is from the min/max element of the tallest tree
		int children = this.size() + thatTree.size() -1;
		Node newRoot;
		if (this.treeHeight() > thatTree.treeHeight()){
			Item max = (Item) this.getMax();
			newRoot = new Node(max, children);
		}
		else{
			Item min = (Item) thatTree.getMin();
			newRoot = new Node(min,children);
		}

		concatTree.root = newRoot;
		concatTree.root.left = this.root;
		concatTree.root.right = thatTree.root;

	}
}
