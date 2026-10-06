public class ClassNameHere {
    /** Returns the maximum value from m. */
    public static int max(int[] m) {
	    int n = m[0];
	    int i = 1;
	    while(i < m.length){
		if(n < m[i])
			n = m[i];
		i = i + 1;
	    }
	    return n;
    }
    public static void main(String[] args) {
       int[] numbers = new int[]{9, 2, 15, 2, 22, 10, 6};      
       System.out.print(max(numbers));
    }
}
