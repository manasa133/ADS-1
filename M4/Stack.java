class Stack{
	String array[];
	int n;

	Stack(){
		array = new String[10];
		n=0;
	}
	void push(String item){
		array[n++] = item;
	}

	String pop(){
		if(isEmpty()) return null;
		String s = array[n-1];
		n--;
		return s;
	}
	boolean isEmpty(){
		if(n==0){
			return  true;
		}
			return false;
	}

	int size(){
		return n;

	}


}