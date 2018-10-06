import java.util.*;
class Student implements Comparable<Student>{
	String name;
	String dob;
	int sub1;
	int sub2;
	int sub3;
	int total;
	String resrvtn;

	Student(String name,String dob,String subject1,String subject2,String subject3,
	String total,String reservation){
		this.name = name;
		this.dob = dob;
		this.sub1 = Integer.parseInt(subject1);
		this.sub2 = Integer.parseInt(subject2);
		this.sub3 =Integer.parseInt(subject3);
		this.total = Integer.parseInt(total);
		this.resrvtn =  reservation;
	}

	public int compareTo(Student other){
		if(this.total > other.total){
			return -1;
		}
		if(this.total < other.total){
			return 1;
		}
		if(this.sub3 > other.sub3){
			return -1;
		}
		if(this.sub3 < other.sub3){
			return 1;
		}
		if(this.sub2 > other.sub2){
			return -1;
		}
		if(this.sub2 < other.sub2){
			return 1;
		}
		if(compareDates(this.dob,other.dob)<0){
			return -1;
		}
		if(compareDates(this.dob,other.dob)>0){
			return 1;
		}

		return 0;

	}
	int compareDates(String one, String two){
		String onee[] = one.split("-");
		String twoo[] = two.split("-");
		if(Integer.parseInt(onee[2])>Integer.parseInt(twoo[2])){
			return -1;
		}
		if(Integer.parseInt(onee[2])<Integer.parseInt(twoo[2])){
			return 1;
		}
		if(Integer.parseInt(onee[1])>Integer.parseInt(twoo[1])){
			return -1;
		}
		if(Integer.parseInt(onee[1])<Integer.parseInt(twoo[1])){
			return 1;
		}if(Integer.parseInt(onee[0])>Integer.parseInt(twoo[0])){
			return -1;
		}
		if(Integer.parseInt(onee[0])<Integer.parseInt(twoo[0])){
			return 1;
		}
		return 0;

	}

	public String toString(){
		return this.name+","+this.total+","+this.resrvtn;
	}

}

class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numStudents = Integer.parseInt(sc.nextLine());
		int vacancies = Integer.parseInt(sc.nextLine());
		int unreservedCategory = Integer.parseInt(sc.nextLine());
		int bccategory =  Integer.parseInt(sc.nextLine());;
		int sccategory =  Integer.parseInt(sc.nextLine());;
		int stcategory =  Integer.parseInt(sc.nextLine());;
		Student array[] = new Student[numStudents];
		//Merge m = new Merge();
		for(int i =0 ;i <numStudents;i++){
			String s[] = sc.nextLine().split(",");
			array[i] = new Student(s[0],s[1],s[2],s[3],s[4],s[5],s[6]);
		}
		Merge.sort(array);
		Merge.show(array);
		Student reservation[] =  new Student[vacancies];
		int i = 0;
		for( i = 0;i< unreservedCategory;i++){
			reservation[i]  = array[i];
			array[i]=null;
		}
		int count2=0,j=0;
		while(count2!=bccategory){
			while(j<array.length && (array[j]==null || !array[j].resrvtn.equals("BC"))){
				j++;

			}
			if(j==array.length){
			break;
			}
			reservation[i++] = array[j];
			array[j] = null;
			j++;
			count2++;
		}
		int count4=0,j2=0;
		while(count4!=stcategory){
		while(j2<array.length &&(array[j2] ==null || !array[j2].resrvtn.equals("ST"))){

			j2++;

		}
		if(j2==array.length){
			break;
		}
		reservation[i++] = array[j2];
		array[j2] = null;
		j2++;
		count4++;
	}


		int count3=0,j1=0;
		while(count3!=sccategory){
			while(j1<array.length &&( array[j1] ==null || !array[j1].resrvtn.equals("SC"))){
				j1++;

			}
			if(j1==array.length){
			break;
		}
			reservation[i++] = array[j1];
			array[j1] = null;
			j1++;
			count3++;
		}
		int jj=0;
		if(i!=vacancies){
			if(array[jj]!=null){
		reservation[i++] = array[jj];
			}
			jj++;

		}

	System.out.println();
	//System.out.println(Arrays.toString(reservation));
	Merge.show(reservation);





	}
}