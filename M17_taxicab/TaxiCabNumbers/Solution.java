import java.util.*;
class Taxicab implements Comparable<Taxicab> {
	int i,j;
	long sum;
	public Taxicab(int i, int j) {
        this.sum = (long) i*i*i + (long) j*j*j;
        this.i = i;
        this.j = j;
    }
    public int compareTo(Taxicab that) {
        if      (this.sum < that.sum) return -1;
        else if (this.sum > that.sum) return +1;
        else if (this.i < that.i)     return -1;
        else if (this.i > that.i)     return +1;
        else                          return  0;
    }
    public String toString() {
        return i + "^3 + " + j + "^3";
    }

}
class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// MinPQ<Taxicab> pq = new MinPQ<Taxicab>();
		while(sc.hasNextLine()){
			String[] input = sc.nextLine().split(" ");
			int N = Integer.parseInt(input[0]);
			int M = Integer.parseInt(input[1]);
			int n = 500;
			MinPQ<Taxicab> pq = new MinPQ<Taxicab>();
	        	for (int i = 1; i <= n; i++) {
	            pq.insert(new Taxicab(i, i));
        	}
			 // enumerate sums in ascending order, look for repeated sums
        int run = 1;

        Taxicab prev = new Taxicab(0, 0);   // sentinel
        int pairCount = 1;
        int nth = 0;

        while (!pq.isEmpty()) {
            Taxicab curr = pq.delMin();
            // current sum is same as previous sum
            if (prev.sum == curr.sum) {
                run++;
                nth= nth+1;
                if (run == 2) System.out.println(prev.sum + " = " + prev);
                System.out.println(" = " + curr);
                pairCount = pairCount+1;
            }
            if(pairCount == M && nth == N){
            	System.out.println("SUM"+prev.sum);
            	break;
            }
            else {
                if (run > 1) //StdOut.println();
                run = 1;
            }
            prev = curr;

            if (curr.j < n) pq.insert(new Taxicab(curr.i, curr.j + 1));
        }
        if (run > 1) System.out.println();;
    }

		}

	}
