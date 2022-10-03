
public class Node {
	private String Node;
	public Node left;
	public Node right;
	public Node parent;
	
	public Node(String str) {
		this.Node = str;
		left = null;
		right = null;
	}
	
	public Node() {
		Node = "";
		left = null;
		right = null;
	}
	
	
	/**
	 * Setters and Getters
	 */
	public String getNode() {
		return Node;
	}
	public void setNode(String Node) {
		this.Node = Node;
	}
	public Node getParent() {
		return parent;
	}
	public void setParent(Node p) {
		this.parent = p;
	}
	public Node getleft() {
		return left;
	}
	public void setleft(Node l) {
		this.left = l;
	}
	public Node getright() {
		return right;
	}
	public void setright(Node r) {
		this.right = r;
	}
}
