import java.util.*;
class Percolates{
	int[][] grid;
	int openSites;
	WeightedQuickUnionUF wqu;
	int size ;
	Percolates(int size){
		grid = new int[size][size];
		openSites = 0;
		wqu = new WeightedQuickUnionUF((size*size)+2);
		size = size;
	}
	void open(int row,int col){
		row = row - 1;
		col = col - 1;
		grid[row][col] = 1;
		openSites++;
		if(row==0){
			wqu.union(0,component(row,col));
		}
		if(row == size -1){
			wqu.union(((size*size)+1),component(row,col));
		}
		if(row > 0){
			if(grid[row+1][col]==1){
				wqu.union(component(row,col) , component(row+1,col));
			}
		}
		if(row <=size-1){
			if(grid[row-1][col]==1){
				wqu.union(component(row,col) , component(row-1,col));
			}
		}
		if(col > 0){
			if(grid[row][col+1]==1){
				wqu.union(component(row,col) , component(row,col+1));
			}
		}
		if(col <= size-1){
			if(grid[row][col-1]==1){
				wqu.union(component(row,col) , component(row,col-1));
			}
		}
	}
	int component(int i,int j){
		return ((i*size)+j)+1;
	}

	boolean isOpen(int row,int col){
		return grid[row-1][col-1]==1;
	}
	boolean isFull(int row,int col){
		return grid[row-1][col-1]==0;
	}
	int numberOfOpensites(){
		return openSites;
	}
	boolean percolates(){
		return wqu.connected(0,(size*size)+1);
	}

}

class Solution{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		Percolates per = new Percolates(size);
		while(sc.hasNext()){
			per.open( sc.nextInt(), sc.nextInt());
		}
		System.out.println(	per.percolates());
	}
}