import java.util.*;
class Node {
	String data;
	Node next;
	Node(String val){
		data = val;

	}
}
class LinkedList{
	Node start;
	int size;
	LinkedList(){
		start = null;
		size = 0;
	}
	void insert(Node i){
		if(size == 0){
			start = i;
			return;
		}
	}
	void insertAt(int index,Node n){
		if(index == 0){
			n.next = start;
			start = n;
			return;
		}
		start =insertAt(index, start,n,0);
	}
	Node insertAt(int index,Node first, Node element,int count ){
		if(count == index){
			element.next = first;
			return element;
		}
		first.next = insertAt(index,first.next,element,count+1);
		return first;
	}
	void display(){
		Node temp = start;
		String str="";
		while(temp !=null){
			str += temp.data+", ";
			temp = temp.next;
		}
		System.out.println(str);
	}
}
class Solution{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		LinkedList ll = new LinkedList();
		while(sc.hasNextLine()){
			String[] values = sc.nextLine().split(" ");
			switch (values[0]) {
				case "insertAt":
				ll.insertAt(Integer.parseInt(values[1]), new Node(values[2]));
				ll.display();
				break;

			}
		}
	}
}