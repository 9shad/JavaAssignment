package Assignment3;

public class LinkedList<V> {

	private int counter = 0;
	private Node<V> head;
	private Node<V> tail;
	
	//add to the end of the list
	public void add(V data) {
		
		Node<V> node = new Node<>(data);
		
		if(head == null && tail == null) {
			head = tail = node;
			counter++;
			return;
		}
		
		tail.next = node;
		tail = node;
		counter++;
	}
	
	
	//add next to a node in existing linked list
	public void add(V data, Node<V> oldNode) {
		
		Node<V> newNode = new Node<>(data);
		
		if(head == null && tail == null) {
			head = tail = newNode;
			counter++;
			return;
		}
		
		Node<V> nextNode = oldNode.getNext();
		if(nextNode != null) {
			newNode.setNext(nextNode);
			oldNode.setNext(newNode);
			counter++;
		}else {
			oldNode.setNext(newNode);
			counter++;
		}
	}
		
	//add node to this index in existing linked list
	public void add(V data, int index) {
		
		if(index > counter) {
			return;
		}
		
		Node<V> newNode = new Node<>(data);
		
		if(head == null && tail == null) {
			head = tail = newNode;
			counter++;
			return;
		}
		
		Node<V> temp = head;
		
		for (int i=0;i<index-1;i++) {
			temp = temp.getNext();
		}
		
		Node<V> currentNode = temp;
		newNode.setNext(currentNode.getNext());
		currentNode.setNext(newNode);
		counter++;
	}
		
	public V get(int index) {
		
		if(index < 0 || index > counter) {
			return null;
		}
		
		Node<V> temp = head;
		
		for (int i=0;i<index;i++) {
			temp = temp.getNext();
		}
		
		return temp.getData();
	}
		
	public V remove(int index) {
		
		if(index < 0 || index >= counter) {
			return null;
		}
		
		Node<V> temp = head;
		if(counter == 0) {
			V value = temp.getData();
			head = null;
			counter --;
			return value;
		}
		
		for (int i=0;i<index-1;i++) {
			temp = temp.getNext();
		}
		
		Node<V> previousNode = temp;
		Node<V> nodeToRemove = previousNode.getNext();
		
		if(nodeToRemove.getNext()==null) { //means the node to remove is the last node
			previousNode.setNext(null);	
		}else {
			Node<V> nextNode = nodeToRemove.getNext();
			previousNode.setNext(nextNode);
		}
		
		counter --;
		return nodeToRemove.getData();
	}
	
	@Override
	public String toString() {
		Node<V> temp = head;
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		
		while(temp!=null) {
			if(temp.getNext() == null)
				sb.append(temp.getData());
			else {
				sb.append(temp.getData()+",");
			}
			temp = temp.getNext();
		}
		sb.append("]");
		return sb.toString();
	}


	public int getCounter() {
		return counter;
	}



	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<>();
		
		list.add("Hello");
		list.add("World");
		
		System.out.println(list);
		
		list.add("test");
		
		System.out.println(list);
		
		list.add("test1", 1);
		
		System.out.println(list);
		
		System.out.println(list.get(2));
		
		System.out.println(list);
		System.out.println(list.remove(2));
		System.out.println(list);
		System.out.println(list.remove(2));
		System.out.println(list);
		System.out.println(list.remove(2));
		System.out.println(list);
		

	}

}

class Node<K>{

	Node<K> next;
	K data;
	
	public Node(K data) {
		super();
		this.data = data;
		this.next = null;
	}
	public Node<K> getNext() {
		return next;
	}
	public void setNext(Node<K> next) {
		this.next = next;
	}
	public K getData() {
		return data;
	}
	public void setData(K data) {
		this.data = data;
	}
		
}
