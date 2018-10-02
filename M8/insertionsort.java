import java.util.*;
class insertionsort{
	public static void main(String[] args) {
		int a[] = {7,4,6,-2,1};
		for(int i =0 ;i < a.length-1 ; i++){
			for(int j = i+1 ; j>0 ;j--){
				if(less(a,j-1,j)){
					exchange(a,j-1,j);
				}
				// //if(a[j-1]>a[j]){
				// 	int temp = a[j-1];
				// 	a[j-1] = a[j];
				// 	a[j] = temp;
				// }
			}
			System.out.println(Arrays.toString(a));
		}
	}

	public static boolean less(int arr[],int i,int j){
		//return (Integer)arr[i].compareTo((Integer)arr[j])<0;
		return arr[i]<arr[j];
	}
	public static void exchange(int[] a, int i,int j){

					int temp = a[j-1];
					a[j-1] = a[j];
					a[j] = temp;


	}

}