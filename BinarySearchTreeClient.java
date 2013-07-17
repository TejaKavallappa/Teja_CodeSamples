public class BinarySearchTreeClient{
	public static void main(String[] args){
		BinarySearchTree<Integer> firstTree = new BinarySearchTree<Integer>();
		BinarySearchTree<Integer> secondTree = new BinarySearchTree<Integer>();
		firstTree.insert(5);
		firstTree.insert(6);
		firstTree.insert(4);
		firstTree.insert(3);
		firstTree.insert(7);
		firstTree.insert(1);
		System.out.println("");
		firstTree.inOrderTraversal();	
		System.out.println("Small tree height = " +firstTree.treeHeight());
		System.out.println("");
		secondTree.insert(23);	
		secondTree.insert(17);	
		secondTree.insert(25);	
		secondTree.insert(20);	
		secondTree.insert(15);	
		secondTree.insert(22);	
		System.out.println("");
		secondTree.inOrderTraversal();
		System.out.println("Large tree height = " +secondTree.treeHeight());
		//Assume firstTree has smaller elements than secondTree
		
		BinarySearchTree<Integer> bigTree = new BinarySearchTree<Integer>();
		firstTree.concatenate(bigTree, secondTree);
		bigTree.inOrderTraversal();
	}
	
}
