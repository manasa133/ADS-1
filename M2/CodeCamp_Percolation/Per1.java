import java.util.*;
class Per1 {
	int[][] grid;
	int OPEN = 1;
	int FULL = 0;
	int N;
	WeightedQuickUnionUF wuf;
	Per1(int n){
		grid  =  new int[n][n];
		N = n;
		wuf = new WeightedQuickUnionUF((n*n)+2);
	}

	void open(int i, int j){
		int row = i-1;
		int col = j-1;
		grid[row][col] = OPEN;
		if(row==0){
			wuf.union(0,xyto1D(row,col));
		}
		if(row==N-1){
			wuf.union((N*N)+1,xyto1D(row,col));
		}
		if(row < N-1){
			if(grid[row+1][col]==OPEN){
				wuf.union(xyto1D(row+1,col),xyto1D(row,col));
			}
		}
		if(row > 0){
			if(grid[row-1][col]==OPEN){
				wuf.union(xyto1D(row-1,col),xyto1D(row,col));
			}
		}
		if(col > 0){
			if(grid[row][col-1]==OPEN){
				wuf.union(xyto1D(row,col-1),xyto1D(row,col));
			}
		}
		if(col<N-1){
			if(grid[row][col+1]==OPEN){
				wuf.union(xyto1D(row,col+1),xyto1D(row,col));
			}
		}
	}

	int xyto1D(int i, int j){
		return ((i * N) + j)+1;
	}
	boolean percolates(){
		return wuf.connected(0,(N*N)+1);
	}

}
class Solution{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//int num = Integer.parseInt(sc.nextLine);
		int num = sc.nextInt();
		Per1 per = new Per1(num);
		while(sc.hasNext()){
			int x = sc.nextInt();
			int y = sc.nextInt();
			per.open(x,y);
		}
		 System.out.println(per.percolates()); ;

	}
}