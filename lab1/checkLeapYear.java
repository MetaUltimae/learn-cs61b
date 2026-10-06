public class checkLeapYear{
	public static boolean isLeapYear(int year){
		/**
		 * check this year is leap year or not.
		 */
		if(year % 400 == 0 || year % 4 == 0 && year % 100 != 0){
			return true;
		}
		return false;
	}
}

