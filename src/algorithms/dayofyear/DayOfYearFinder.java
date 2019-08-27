package algorithms.dayofyear;

public class DayOfYearFinder {
	
	public static void main(String[] args) {
		System.out.println("Day of Year is : "+dayOfYear(10, 30, 2001));

	}

	static int[] daysOfMonthInRegularYearArray = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	static int[] daysOfMonthInLeapYearArray = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public static int dayOfYear(int month, int dayOfMonth, int year) {
		try {
			validateInputs(month, dayOfMonth, year);
			while (month > 1) {
				month--;
				return dayOfMonth += dayOfYear(month, getDaysOfMonthArray(isLeapYear(year))[month - 1], year);
			}
			return dayOfMonth;
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return 0;
		}
	}

	private static boolean isLeapYear(int year) {
		return year % 4 == 0;
	}

	private static int[] getDaysOfMonthArray(boolean isLeapYear) {
		if (isLeapYear) {
			return daysOfMonthInLeapYearArray;
		} else {
			return daysOfMonthInRegularYearArray;
		}
	}

	public static void validateInputs(int month, int dayOfMonth, int year) throws InvalidInputException {
		if (month < 1 || month > 12 || dayOfMonth < 1 || dayOfMonth > 31 || year < 1) {
			throw new InvalidInputException("Invalid input valus");
		}
	}

	public static class InvalidInputException extends Exception {
		public InvalidInputException(String errorMessage) {
			super(errorMessage);
		}
	}

}
