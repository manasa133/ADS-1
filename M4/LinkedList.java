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
	}

	void delete(String value){
		if(start.data.equals(value)){
			start = start.next;
			return;
		};
		Node temp = start;
		Node prev = null;
		while(temp!=null){
			if(temp.data.equals(value)){
				prev.next = temp.next;
			}
			prev = temp;
			temp = temp.next;
		}
	}

	void removeAfter(String value){
		if(start.data.equals(value)){
			start.next = start.next.next;
		}

	}
	void deleteAfter(){

	}


}