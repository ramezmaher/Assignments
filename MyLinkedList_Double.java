package eg.edu.alexu.csd.datastructure.linkedList.cs29_cs79;

public class MyLinkedList_Double implements ILinkedList {
	Node_D head;
    Node_D tail;
public void add(int index, Object element) {
	Node_D node = new Node_D(element);
	if (index < 0 ) {
		System.out.println("Invalid index");
		return ;
	}
	if (head == null && index != 0) {
		System.out.println("Invalid index");
		return;
	}
	Node_D n = head;
	for (int i=0; i<index-1 ; i++) {
		if (n.next == null) {
			System.out.println("Invalid index");
			return;
		} 
		n=n.next;
	}
	if (head == null){
		head = node ;
		tail= node;
		return;
	}
	if (index == 0) {
		node.next = head;
		head=node;
	}
	else {
	node.next = n.next;
	n.next = node;
	node.prev = n;
	if (node.next == null) {
		tail=node;
	}
	}
	return;
}
public void add(Object element) {
	Node_D node = new Node_D(element);
	if (head == null) {
		head = node ;
		tail= node;
	}
	else {
		tail.next = node;
		node.prev = tail;
		tail = node;
	}
	return;
}
public Object get(int index) {
	if (head == null) {
		System.out.println("Empty list");
		return null;
	}
	if (index < 0 ) {
		System.out.println("Invalid index");
		return null;
	}
	Node_D n = head;
	for (int i=0; i<index ; i++) {
		if (n.next == null) {
			System.out.println("Invalid index");
			return null;
		}
		n.next.prev = n;
		n=n.next;
	}
	return n.value;
}
public void set(int index, Object element) {
	if (head == null) {
		System.out.println("Empty list");
		return ;
	}
	if (index < 0 ) {
		System.out.println("Invalid index");
		return ;
	}
	Node_D n = head;
	for (int i=0; i<index ; i++) {
		if (n.next == null) {
			System.out.println("Invalid index");
			return;
		}
		n.next.prev = n;
		n=n.next;
	}
	n.value= element;
	return;
}
public void clear() {
	Node_D node = head;
	if (head == null) {
		return;
	}
	node.next=null;
	node=null;
	tail=node;
	head=node;
	return;
}
public boolean isEmpty() {
	if (head == null) {
		return true;
	}
	else 
	return false;
}
public void remove(int index) {
	if (head == null) {
		System.out.println("Empty list");
		return ;
	}
	if (index < 0 ) {
		System.out.println("Invalid index");
		return ;
	}
	Node_D n = head;
	for (int i=0; i<index ; i++) {
		if (n.next == null) {
			System.out.println("Invalid index");
			return;
		}
		n=n.next;
	}
	if (index == 0) {
		head=n.next;
	}
	else {
	if(n.next != null) {
	n.prev.next=n.next;
	n.next.prev = n.prev;
	}
	else {
		n.prev.next = null;
	}
	}
	return;
}
public int size() {
	if (head == null) {
		return 0;
	}
	int count =0;
	Node_D n = head;
	Node_D t = tail;
	while (n != t && t.next != n) {
		count+=2;
		n=n.next;
		t=t.prev;
	}
	if (n == t) {
		count++;
	} 
	return count;
}
public ILinkedList sublist(int fromIndex, int toIndex) {
	MyLinkedList_Double l = new MyLinkedList_Double();
	Node_D n = head;
	if (fromIndex < 0 ) {
		System.out.println("Invalid index");
		l.head = null;
		return l;
	}
	for (int i=0; i<fromIndex ; i++) {
		if (n == null) {
			System.out.println("Invalid index");
			l.head = null;
			return l;
		}
		n.next.prev = n;
		n=n.next;
	}
	Node_D m =new Node_D(n);
	l.head = m;
	for (int i=fromIndex ; i< toIndex ; i++) {
		if (n.next  == null) {
			System.out.println("Invalid index");
			l.head = null ;
			return l;
		}
		m.next = n.next ;
		m = m.next;
		n=n.next;
	}
	m.next = null;
	l.tail = m;
	return l;
}
public boolean contains(Object o) {
	if (head == null) {
		return false;
	}
	Node_D n = head;
	Node_D t = tail;
	while (n != t && t.next != n) {
		if (n.value == o) {
			return true ;
		}
		if (t.value == o) {
			return true ;
		}
		n=n.next;
		t=t.prev;
	}
	if (n.value == o) {
		return true;
				}
	
	else
	return false; 
}

public void show() {
	if (head == null) {
			System.out.println("Empty");
			return;
	}
	int i = 0;
	int j = size();
	while (i != j) {
		System.out.print(get(i)+" ");
		i++;
	}
}
}
