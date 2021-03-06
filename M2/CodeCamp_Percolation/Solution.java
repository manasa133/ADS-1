import java.util.*;
// public class Percolation {
//    public Percolation(int n)                // create n-by-n grid, with all sites blocked
//    public    void open(int row, int col)    // open site (row, col) if it is not open already
//    public boolean isOpen(int row, int col)  // is site (row, col) open?
//    public boolean isFull(int row, int col)  // is site (row, col) full?
//    public     int numberOfOpenSites()       // number of open sites
//    public boolean percolates()              // does the system percolate?
// }


// You can implement the above API to solve the probl class Percolation {
class Percolation{
private int[][] grid;
	private static final int OPEN = 1;
	private static final int FULL = 0;
	private int openSites = 0;
	// create n-by-n grid, with all sites blocked
	private int N;
	WeightedQuickUnionUF wuf ;
   public Percolation(int n)  {
   	grid = new int[n][n];
   	N = n;
   	wuf = new WeightedQuickUnionUF((n*n)+2);
   }
   // open site (row, col) if it is not open already
   public void open(int row1, int col1)
   {
   	int row = row1-1;
   	int col = col1-1;
        grid[row][col] = OPEN;
        openSites++;
        if(row == 0){
        	wuf. union(0, (((row*N) + col) + 1));
        }
        if (row == N - 1) {
            wuf.union((N*N)+1,(((row*N) + col) + 1));
        }

         if ((row) < N-1 ) {
            if (grid[row+1][col] == OPEN)
                wuf.union(xyTo1D(row, col), xyTo1D(row+1, col));
        }
        if (row > 0) {
            if (grid[row-1][col] == OPEN)
                wuf.union(xyTo1D(row, col), xyTo1D(row-1, col));
        }
        if (col < N-1) {
            if (grid[row][col+1] == OPEN)
                wuf.union(xyTo1D(row, col), xyTo1D(row, col+1));
        }
        if (col > 0) {
            if (grid[row][col-1] == OPEN)
                wuf.union(xyTo1D(row, col), xyTo1D(row, col-1));
        }

   }
   // is site (row, col) open?
   public boolean isOpen(int row, int col)
   {
        return grid[row][col] == OPEN;

   }
   // is site (row, col) full?
   public boolean isFull(int row, int col)
   {
   	return grid[row][col] == FULL;
   }
     // number of open sites
   public   int numberOfOpenSites()
   {
   	return openSites;
   }
   // does the system percolate?
   public boolean percolates()
   {
		return wuf.connected(0, (N*N)+1);
   }
    private int xyTo1D(int i, int j) {
        return ((i*N) + j) + 1;
    }
}

class Solution{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//int num = Integer.parseInt(sc.nextLine);
		int num = sc.nextInt();
		Percolation per = new Percolation(num);
		while(sc.hasNext()){
			int x = sc.nextInt();
			int y = sc.nextInt();
			per.open(x,y);
		}
		 System.out.println(per.percolates()); ;

	}
}