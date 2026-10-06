public class TriangleDrawer {
   public static void drawTriangle(int N) {
	   int n = 1;
	   int i;
	   while(n <= N){
		   i = 1;
		   while(i <= n){
			   System.out.print("*");
			   i = i + 1;
		   }
		   System.out.println();
		   n = n + 1;
	   }
   }
   
   public static void main(String[] args) {
	   drawTriangle(10);
      
   }
}
