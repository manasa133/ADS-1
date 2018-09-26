import java.io.BufferedInputStream;
import java.util.Scanner;

public class List {
    //Implement all the methods mentioned to build a ListADT

    public List() {

    }

    //Inserts the specified element at the end of the list.
    public void add(int item) {

    }

    // Returns the number of elements in this list.
    public int size() {
        return -1;
    }

    // Remove an element at given index in list.
    public void remove(int index) {

    }

    // Returns the element at the given index.
    public int get(int index) {
        return -1;
    }

    // Converts and Returns the current list as a String value.
    public String toString() {
        return "print the list";
    } 

    // Returns true, if given element is in list.
    public boolean contains(int item) {
        return true;
    }

    // Returns the index of the first occurrence 
    // of the specified element in this list,
    // or -1 if this list does not contain the element.
    public int indexOf(int item) {
        return -1;
    }

	public static void main(String[] args) {
        // create an object of the list to invoke methods on it
        List l = new List();

        // code to read the test cases input file
        Scanner stdin = new Scanner(new BufferedInputStream(System.in));
        // check if there is one more line to process
        while (stdin.hasNext()) {
            // read the line
            String line = stdin.nextLine();
            // split the line using space
            String[] tokens = line.split(" ");
            // based on the list operation invoke the corresponding method
            switch (tokens[0]) {
                case "add":
                l.add(Integer.parseInt(tokens[1]));
                break;
                case "size":
                // invoke size method and print the list size
                // BTW, list size is not the array size
                // it is the number of items in the list
                System.out.println(l.size());
                break;
                case "print":
                // print the list (implement toString for this to work)
                // expected format is [item-1,item-2,...,item-n]
                // review the output testcase file
                System.out.println(l);
                break;
                case "remove":
                l.remove(Integer.parseInt(tokens[1]));
                break;
                case "indexOf":
                System.out.println(l.indexOf(Integer.parseInt(tokens[1])));
                break;
                case "get":
                System.out.println(l.get(Integer.parseInt(tokens[1])));
                break;
                case "contains":
                System.out.println(l.contains(Integer.parseInt(tokens[1])));
                break;
            }
        }
	}
}
