public class Node {
	int data;
	Node next;

	public Node(int data) {
		this.data = data;
		this.next = null;
	}

	public void link(Node node) {
		this.next = node;
	}

	public int getElement() {
		return this.data;
	}

	public Node getNextNode() {
		return this.next;
	}
	
	public String print() {
		return "value: " + data;
	}
}