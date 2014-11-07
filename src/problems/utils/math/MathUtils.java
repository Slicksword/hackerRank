package problems.utils.math;

public final class MathUtils {

	/**
	 * Finds the greatest common factor (also known as the greatest common
	 * divisor) of two numbers.
	 *
	 * @param a
	 *            the first value
	 * @param b
	 *            the second value
	 * @return the greatest common factor of a and b
	 */
	public static int greatestCommonFactor(int a, int b) {
		int larger = a > b ? a : b;
		int smaller = a < b ? a : b;

		int remainder;

		while (smaller != 0) {
			remainder = larger % smaller;
			larger = smaller;
			smaller = remainder;
		}

		return larger;
	}

	/**
	 * Finds the least common multiple of two numbers.
	 *
	 * @param a
	 *            the first value
	 * @param b
	 *            the second value
	 * @return the least common multiple of a and b
	 */
	public static int leastCommonMultiple(int a, int b) {
		return a * b / greatestCommonFactor(a, b);
	}
}
