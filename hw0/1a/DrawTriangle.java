public class DrawTriangle{
	public static void main(String[] args){
		int n = 1;
		int i;
		while(n <= 5){
			i = 1;
			while(i <= n){
				System.out.print("*");
				i = i + 1;
			}
			System.out.println();
			n = n + 1;
		}
	}
}



