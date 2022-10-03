public class Node {
	private String word;
	public Node left;
	public Node right;
	
	public Node(String str) {
		this.word = str;
		left = null;
		right = null;
	}
	
	public String getWord() {
		return word;
	}
}