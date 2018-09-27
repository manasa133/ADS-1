class rec {
	public static void main(String[] args) {
		recursion(10);
	}

	static void recursion(int n){
		if(n==0){
			return ;
		}
		recursion(9);
		recursion(8);
		recursion(8);
		recursion(8);
		recursion(3-1);
		//recursion(2-1);
		//recursion(1-1);
		System.out.println(n);
	}
}