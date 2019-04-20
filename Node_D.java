package eg.edu.alexu.csd.datastructure.linkedList.cs29_cs79;

public class Node_D {
    Object value;
	Node_D next;
	Node_D prev;
	Node_D(Object data){
		value = data;
		prev = null;
		next = null;
	}
	Node_D(Node_D head){
		value=head.value;
		next=head.next;
		prev=head.prev;
	}
}
