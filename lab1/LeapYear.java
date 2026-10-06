public class LeapYear{
	public static void main(String[] args){
		/**
		 * receive arguments to judge is a leap year or not.
		 */
		int year = Integer.parseInt(args[0]);
		boolean sign = checkLeapYear.isLeapYear(year);
		if(sign){
			System.out.println(year + " is a leap year.");
			return;
		}
		System.out.println(year + " is not a leap year");
	}
}

