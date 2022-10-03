public class Dictionary {
	/**
	 * Data members
	 */
	public Node root;

	/**
	 * Constructor
	 */
	public Dictionary() {
		root = null;
	}

	/**
	 * insertWordNode() A public method to insert a value into the BST (if it does
	 * not already exist). Inserts must occur at a leaf and the respective child
	 * pointers should be assigned correctly.
	 */
	public void insertWordNode(String word) {
		//CREATE TEMP WORD
		Node temp = new Node(word);
		
		//assert if the tree is empty
		assert(root == null): "Tree is empty";
		//IF TREE IS EMPTY
		if(root == null) {
			root = temp;
		}
		//USE INSERT TO INSERT AT CORRECT LOCATION
		else {
			insertNode(root, temp);
		}
	}
	
	public void insertNode(Node myRoot, Node temp) {
		//asserts that there is something to push
		assert(true);
		
		while(true) {
			//IGNORE DUPLICATE WORDS
			if(temp.getWord().compareTo(myRoot.getWord()) == 0) {
				return;
			}
			
			//TRAVEL TO THE LEFT SIDE
			if(temp.getWord().compareTo(myRoot.getWord()) <= 1) {
				if(myRoot.left != null) {
					myRoot = myRoot.left;
				}else {
					myRoot.left = temp;
					break;
				}
			}
			//TRAVEL TO RIGHT SIDE
			else {
				if(myRoot.right != null) {
					myRoot = myRoot.right;
				}else {
					myRoot.right = temp;
					break;
				}
			}
		}
	}
	
	/*
	 * checkWord() Public method that removes a specified node from the BST.
	 * Possible scenarios for deletion: 
	 * (1)the node is not in the tree 
	 * (2)the node to be removed has no children 
	 * (3)node to be removed had one child 
	 * (4)the node to be removed has two children 
	 * Following a deleted node, respective node pointers must be correctly reassigned.
	 */
	public void checkWord(String str, Node root) {
		if(root != null) {
			if(str.compareTo(root.getWord()) == 0) {
				System.out.println("True");
			}
			if(str.compareTo(root.getWord()) < 0) {
				checkWord(str, root.left);
			}
			if(str.compareTo(root.getWord()) > 0) {
				checkWord(str, root.right);
			}
		}else {
			System.out.println("False");
		}
	}

	/**
	 * Helper methods additional methods that will help with tasks Ex. searching for
	 * a node can be done with a helper method
	 */
	public boolean isEmpty() {
		return root == null;
	}
}