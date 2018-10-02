class Name implements Comparable<Name>{
	String firstName;
	String lastName;
	int age;
	Name(String a, String b,int b1){
		this.firstName = a;
		this.lastName = b;
		age = b1;
	}
	public int compareTo(Name obj){
		if(this.firstName.compareTo(obj.firstName) > 0){
			return 1;
		}
		if(this.firstName.compareTo(obj.firstName) < 0){
			return -1;
		}
		if (this.lastName.compareTo(obj.lastName) > 0) {
			return 1;
		}
		if (this.lastName.compareTo(obj.lastName) < 0) {
			return -1;
		}
		if(this.age < obj.age){
			return -1;
		}
		if(this.age > obj.age){
			return 1;
		}
		return 0;

	}
	public String toString(){
		return this.firstName+" "+this.lastName+ " "+ this.age;
	}

}
class Sample{
	public static void main(String[] args) {
		Name name1 = new Name("abc","def",1);
		//Name name2 = new Name("abc","dgh",2);
		Name name3 = new Name("abc","def",3);
		Name name4 = new Name("abc","def",2);
		// System.out.println(name1.compareTo(name2));//-1
		// System.out.println(name2.compareTo(name3));//1
		System.out.println(name3.compareTo(name1));//0
		Name arr[] = {name1,name3,name4};

		for(int i= 0; i< arr.length; i++){
			int min = i;
			for(int j = i+1;j<arr.length;j++){
				if(arr[j].compareTo(arr[min])<0){
					min = j;
				}
			}
			Name temp = arr[min];
			arr[min] = arr[i];
			arr[i] = temp;

		}

		for(Name n:arr){
			System.out.println(n);
		}



	}
}