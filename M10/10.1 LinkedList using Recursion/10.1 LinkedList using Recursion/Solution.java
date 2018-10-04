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
		if(index < 0 || index > size){
			System.out.println("Can't insert at this position.");
			return;
		}
		if(index == 0){
			n.next = start;
			start = n;
			size++;
			return;
		}
		start =insertAt(index, start,n,0);
		display();
	}
	Node insertAt(int index,Node first, Node element,int count ){
		if(count == index){
			element.next = first;
			return element;
		}
		first.next = insertAt(index,first.next,element,count+1);
		size++;
		return first;
	}
	void reverse(){
		reverse(null,start);
	}
void reverse( Node prev, Node current)
{
   if(current!=null){
      reverse(current,current.next);
      current.next = prev;
    }else{
    	start = prev;
    }
}
	void display(){
		Node temp = start;
		String str="";
		while(temp !=null){
			str += temp.data+", ";
			temp = temp.next;
		}
		System.out.println(str.substring(0,str.length()-2));
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
				//display();
				break;
				case "reverse":
				ll.reverse();
				ll.display();
				break;

			}
		}
	}
}