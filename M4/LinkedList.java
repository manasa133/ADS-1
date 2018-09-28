class Node{
	String data;
	Node next;

	Node(String value){
		data = value;
		next = null;
	}
}
class LinkedList {
	Node start;
	int n;
	LinkedList(){
		n =0;
	}

	void insert(String value){
		Node obj = new Node(value);
		if(n==0){
			start = obj;
			n++;
			return ;
		}
		Node temp = start;
		while(temp.next!=null){
			temp = temp.next;
		}
		temp.next = obj;
		n++;
	}

	void delete(String value){
		if(start.data.equals(value)){
			start = start.next;
			n--;
			return;
		};
		Node temp = start;
		Node prev = null;
		while(temp!=null){
			if(temp.data.equals(value)){
				prev.next = temp.next;
				n--;
				return;
			}
			prev = temp;
			temp = temp.next;
		}
	}

	void removeAfter(String value){
		if(start.data.equals(value)){
			start.next = start.next.next;
			n--;
			return;
		}
		Node temp = start;
		while (temp!=null) {
			if(temp.data.equals(value)){
				Node del = temp.next;
				delete(del.data);
			}
			temp = temp.next;
		}
	}
	void insertAfter(String value){
		Node obj = new Node(value);
		// if(start.data.equals(value)){
		// 	Node temp = start.next;
		// 	start.next = obj;
		// 	obj.next = temp;
		// 	n++;
		// 	return;
		// }
		Node temp = start;
		while(temp != null){
			if(temp.data.equals(value)){
				Node t1 = temp.next;
				temp.next =	obj;
				obj.next =t1;
				return;
			}
			temp = temp.next;
		}
		if(temp.data.equals(value)){
			temp.next = obj;
		}
	}


}