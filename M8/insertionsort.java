import java.util.*;
class insertionsort{
	public static void main(String[] args) {
		int a[] = {7,4,6,-2,1};
		for(int i =0 ;i < a.length-1 ; i++){
			for(int j = i+1 ; j>0 ;j--){
				if(a[j-1]>a[j]){
					int temp = a[j-1];
					a[j-1] = a[j];
					a[j] = temp;
				}
			}
			System.out.println(Arrays.toString(a));
		}
	}

}