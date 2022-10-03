
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
		//assert that the word exists in the dictionary
		assert !checkWord(word) : "The word " + word + " already exists in the dictionary";

		Node temp = new Node();
		temp.setNode(word);
		temp.setParent(null);
		temp.setleft(null);
		temp.setright(null);

		//BINARY SEARCH TREE
		if (this.root == null) {
			this.root = temp;
		} else {
			Node parentNode = null;
			Node nodeTemp = this.root;

			while (nodeTemp != null) {
				parentNode = nodeTemp;
				int compare = temp.getNode().compareTo(nodeTemp.getNode());

				if (compare <= 0) {
					nodeTemp = nodeTemp.getleft();
				} else {
					nodeTemp = nodeTemp.getright();
				}
			}

			temp.setParent(parentNode);

			if (temp.getNode().compareTo(parentNode.getNode()) <= 0) {
				parentNode.setleft(temp);
			} else {
				parentNode.setright(temp);
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
	public boolean checkWord(String search) {
		Node temp = this.root;

		while (temp != null && !temp.getNode().equals(search)) {
			if (search.compareTo(temp.getNode()) <= 0) {
				temp = temp.getleft();
			} else {
				temp = temp.getright();
			}
		}
		
		if (temp == null) {
			return false;
		}else{
			if (temp.getNode() == search) {
				return true;
			} else {
				return false;
			}
		}
	}
	
	public Node deleteWordNode(String key) {
		//assert that the word exists -> if not then return
		assert checkWord(key) && !isEmpty() : "the word " + key + " does not exist";
		
		Node parent = null;
		Node current = this.root;

		while (current != null && current.getNode() != key) {
			parent = current;

			if (current.getNode().compareTo(key) <= 0) {
				current = current.right;
			} else {
				current = current.left;
			}
		}
		
		if (current == null) {
			return this.root = null;
		}
		
		if (current.left == null && current.right == null) {
			if (current != root) {
				if (parent.left == current) {
					parent.left = null;
				} else {
					parent.right = null;
				}
			} else {
				root = null;
			}
		}else if (current.left != null && current.right != null) {
			Node heir = minWord(current.right);
			String val = heir.getNode();

			deleteWordNode(heir.getNode());
			current.setNode(val);

		}else {
			Node child = (current.left != null) ? current.left : current.right;

			if (current != root) {
				if (current == parent.left) {
					parent.left = child;
				} else {
					parent.right = child;
				}
			} else {
				root = child;
			}
		}
		//assert that the word is deleted -> if not then return
		assert checkWord(key) : "Error: The word you are trying to delete is still in the tree";
		return root;
	}

	/**
	 * Helper methods additional methods that will help with tasks Ex. searching for
	 * a node can be done with a helper method
	 */
	public boolean isEmpty() {
		return root == null;
	}

	public void setRoot(Node root) {
		this.root = root;
	}

	public Node getRoot() {
		return root;
	}

	public static Node minWord(Node curr) {
		while (curr.left != null) {
			curr = curr.left;
		}
		return curr;
	}
}