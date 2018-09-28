import java.util.*;
class Node{
	String data;
	Node next;
	Node(){

	}
	Node(String data){
		this.data = data;
	}

}
//stacks
class LinkedList{
	Node start;
	int size;
	LinkedList(){
		start = new Node();
		size = 0;
	}

	void insert(String item){
		Node obj = new Node();
		obj.data = item;
		if(size == 0){
			start = obj;
			size++;
			return;
		}
		obj.next = start;
		start = obj;
	}



	String delete(){
		String data = start.data;
		start = start.next;
		size--;
		return data;
	}

	boolean isEmpty(){
		if(size ==0){
			return true;
		}
		return false;
	}

	int size(){
		return size;
	}
}

class Stack{
	LinkedList ll ;
	Stack (){
		ll = new LinkedList();
	}

	void push(String item){
		ll.insert(item);
	}
	String pop(){
		return ll.delete();
	}
	boolean isEmpty(){
		return ll.isEmpty();
	}
	int size(){
		return ll.size();
	}
}

class Solution{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int lines =  Integer.parseInt(sc.nextLine());
		Stack obj = new Stack();
		boolean flag = true;
		while(lines>0){
			String line  = sc.nextLine();
			for(int i = 0; i< line.length() ; i++){
				String c =  line.charAt(i)+"";
				if(c.equals("(") || c.equals("{") ||c.equals("[") ){
					obj.push(c);
				}
				if(c.equals(")")){
					String out =  obj.pop();
					if(out.equals("(")){
						continue;
					}
					else{
						flag = false;
						System.out.println("No");
						break;
					}

				}
				if(c.equals("}")){
					String out =  obj.pop();
					if(out.equals("{")){
						continue;
					}
					else{
						flag = false;
						System.out.println("No");
						break;
					}

				}
				if(c.equals("]")){
					String out =  obj.pop();
					if(out.equals("[")){
						continue;
					}
					else{
						flag = false;
						System.out.println("No");
						break;
					}

				}
			}
			if(flag){
				System.out.println("Yes");
			}

			lines--;
		}
	}
}