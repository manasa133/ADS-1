class Node{
	String data;
	Node next;
	Node(){

	}
	Node(String data){
		this.data = data;
	}
}

class LinkedList{
	Node first;
	Node last;
	int size;
	LinkedList(){
		first = new Node();
		last = new Node();
		size = 0;
	}
	void enque(String item){
		Node obj = new Node(item);
		if(size==0){
			first = obj;
			last = obj;
			size++;
			return;
		}
		last.next = obj;
		last = obj;
		size++;
	}

	String deque(){
		String data = first.data;
		first = first.next;
		size--;
		return data;
	}

	public boolean isEmpty(){
		if(size == 0){
			return true;
		}
		return false;
	}

	public String display(){
		if(size == 1){
			return first.data;
		}
		String res = "";
		Node temp = first;
		while(temp!=null){
			res += temp.data;
			temp = temp.next;
		}
		return res;

		// for(Node x = first; x!= null;x = x.next){
		// 	res += x.data;
		// }
	}
}

class Solution{
	public static void main(String[] args) {
		LinkedList queue = new LinkedList();
		String[] s = "it was - the best - of times - - - it was - the - -".split(" ");
		for(String s1 : s){
			if(s1.equals("-")){
				//if(!queue.isEmpty())System.out.println(queue.deque());

			}else{
				queue.enque(s1);
			}

		}
		// System.out.println("Remaining Elements");
		// while(!queue.isEmpty()){
		// 	System.out.println(queue.deque());
		// }
		System.out.println(queue.display());
	}
}