public class SingleLinkedList {
	Node head;
	Node tail;
	int size;

	public SingleLinkedList() {
		this.head = null;
		this.tail = null;
		size = 0;
	}

	public void addLast(int data) {
		Node newNode = new Node(data);
		if (tail == null) {
			head = tail = newNode;
		} else {
			tail.link(newNode);
			tail = newNode;
		}
		size++;
	}

	public void addFirst(int data) {
		Node newNode = new Node(data);
		if (head == null) {
			head = tail = newNode;
		} else {
			newNode.link(head);
			head = newNode;
		}
		size++;
	}

	public void removeFirst() {
		if (head == null) {
			return;
		}

		if (head == tail) {
			head = tail = null;
		} else {
			head = head.getNextNode();
		}
		size--;
	}

	public void removeLast() {
		if (tail == null) {
			return;
		}
		if (head == tail) {
			head = tail = null;
		} else {
			Node currentNode = head;
			for (Node n = head; n.getNextNode() != tail; n = n.getNextNode()) {
				currentNode = n;
			}
			currentNode.link(null);
			tail = currentNode;
		}
		size--;
	}

	public void print() {
		if (size == 0) {
			System.out.println("Empty linked list");
		} else {
			for (Node p = head; p != null; p = p.getNextNode()) {
				System.out.print(p.getElement() + "->");
			}
			System.out.println("null");
		}
	}

	public int getSize() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int getElementAt(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index out of bounds");
		}
		if (index == 0) {
			return head.getElement();
		} else if (index == size - 1) {
			return tail.getElement();
		} else {
			Node currentNode = head;
			for (int i = 0; i < index; i++) {
				currentNode = currentNode.getNextNode();
			}
			return currentNode.getElement();
		}

	}

	public void clear() {
		size = 0;
		head = tail = null;
	}

	public boolean findElement(int element) {
		for (Node p = head; p != null; p = p.getNextNode()) {
			if (p.getElement() == element) {
				return true;
			}
		}
		return false;
	}

	public int countElement(int element) {
		int count = 0;
		for (Node p = head; p != null; p = p.getNextNode()) {
			if (p.getElement() == element) {
				count++;
			}
		}
		return count;
	}

	public int sumElement() {
		int sum = 0;
		for (Node p = head; p != null; p = p.getNextNode()) {
			sum += p.getElement();
		}
		return sum;
	}

	public static void main(String[] args) {
		SingleLinkedList sll = new SingleLinkedList();
		sll.addFirst(2);
		sll.addLast(3);
		sll.addFirst(1);
		sll.print();
		sll.removeFirst();
		sll.print();
		sll.removeLast();
		sll.print();

		System.out.println("----------------------------");
		sll.removeLast();
		System.out.println("----------------------------");
		System.out.println("=== Empty SLL ===");
		System.out.println("Size = " + sll.getSize());
		System.out.println("Empty = " + sll.isEmpty());
		System.out.println();

		// add elements
		sll.addLast(11);
		sll.addLast(22);
		sll.addLast(11);
		System.out.println("=== After adding elements ===");
		System.out.println("Size = " + sll.getSize());
		System.out.println("Empty = " + sll.isEmpty());
		System.out.println("Element 0 = " + sll.getElementAt(0));
		System.out.println("Element 1 = " + sll.getElementAt(1));
		System.out.println("Element 2 = " + sll.getElementAt(2));
		System.out.println();

		// clear
		sll.clear();
		System.out.println("=== After clearing elements ===");
		System.out.println("Size = " + sll.getSize());
		System.out.println("Empty = " + sll.isEmpty());

		System.out.println("----------------------------");

		System.out.println("----------------------------");
		 sll.addFirst(11);
		 sll.addLast(22);
		 sll.addLast(11);
		 sll.print();

		 System.out.println();
		 System.out.println("Find element 11: "+sll.findElement(11));
		 System.out.println("Find element 22: "+sll.findElement(22));
		 System.out.println("Find element 33: "+sll.findElement(33));
		 System.out.println("Count element 11:"+sll.countElement(11));
		 System.out.println("Count element 22:"+sll.countElement(22));
		 System.out.println("Count element 33:"+sll.countElement(33));
		 System.out.println("Sum of all elements: "+sll.sumElement());
	}
}