// public class Percolation {
//    public Percolation(int n)                // create n-by-n grid, with all sites blocked
//    public    void open(int row, int col)    // open site (row, col) if it is not open already
//    public boolean isOpen(int row, int col)  // is site (row, col) open?
//    public boolean isFull(int row, int col)  // is site (row, col) full?
//    public     int numberOfOpenSites()       // number of open sites
//    public boolean percolates()              // does the system percolate?
// }


// You can implement the above API to solve the problem
import java.util.*;
class Solution{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = Integer.parseInt(sc.nextLine());
		percolate obj = new percolate(size);
		while(sc.hasNextLine()){
			String[] input = sc.nextLine().split(" ");
			obj.open(Integer.parseInt(input[0])-1, Integer.parseInt(input[1])-1);
		}
			System.out.println(obj.ispercolate());
	}
}


class percolate{
	int size;
	boolean[][] grid;
	WeightedQuickUnionUF obj;

	percolate(int size){
		this.size = size;
		grid = new boolean[size][size];
		obj = new WeightedQuickUnionUF(size*size + 2);
	}

	public void open(int i, int j){
		if(i == 0){
			obj.union(convert(i, j), size*size);
		}else if(i == size-1){
			obj.union(convert(i, j), size*size+1);
		}
		if(i < size - 1 && grid[i+1][j] == true){
			obj.union(convert(i,j), convert(i+1,j));
		}else if(i > 0 && grid[i-1][j] == true){
			obj.union(convert(i, j), convert(i-1,j));
		}else if(j > 0 && grid[i][j-1] == true){
			obj.union(convert(i, j), convert(i,j-1));
		}else if(j < size-1 && grid[i][j+1] == true){
			obj.union(convert(i, j), convert(i,j+1));
		}
	}
	public boolean ispercolate(){
		return obj.connected(size*size, size*size+1);
	}

	public int convert(int i, int j){
		return i * size + j;
	}
}