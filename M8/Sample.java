class Name implements Comparable<Name>{
	String firstName;
	String lastName;
	Name(String a, String b){
		this.firstName = a;
		this.lastName = b;
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
		return 0;

	}

}
class Sample{
	public static void main(String[] args) {
		Name name1 = new Name("abc","def");
		Name name2 = new Name("abc","dgh");
		Name name3 = new Name("abc","def");
		System.out.println(name1.compareTo(name2));//-1
		System.out.println(name2.compareTo(name3));//1
		System.out.println(name3.compareTo(name1));//0
		Name arr[] = {name1,name2,name3};


	}
}