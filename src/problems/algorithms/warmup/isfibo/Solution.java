package problems.algorithms.warmup.isfibo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;

public final class Solution {
	private static final String isFibo = "IsFibo";
	private static final String isNotFibo = "IsNotFibo";
	private static final ArrayList<BigInteger> fibonacciNumbers = new ArrayList<BigInteger>();
	static {
		fibonacciNumbers.add(new BigInteger("0"));
		fibonacciNumbers.add(new BigInteger("1"));
	}

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int numTestCases = Integer.parseInt(readLineQuietly(br));

		for (int testCase = 0; testCase < numTestCases; ++testCase) {
			BigInteger testNumber = new BigInteger(readLineQuietly(br));
			if (fibonacciNumbers.contains(testNumber)) {
				System.out.println(isFibo);
				continue;
			} else {
				BigInteger largestFibonacci = fibonacciNumbers
						.get(fibonacciNumbers.size() - 1);
				if (testNumber.compareTo(largestFibonacci) < 0) {
					System.out.println(isNotFibo);
					continue;
				} else {
					calculateIsFiboacci(testNumber);

				}
			}
		}
	}

	private static void calculateIsFiboacci(BigInteger testNumber) {
		BigInteger newFibonacci = calculateNextFibonacci();
		if (testNumber.equals(newFibonacci)) {
			System.out.println(isFibo);
		} else if (newFibonacci.compareTo(testNumber) > 0) {
			System.out.println(isNotFibo);
		} else {
			calculateIsFiboacci(testNumber);
		}
	}

	private static BigInteger calculateNextFibonacci() {
		int lastIndex = fibonacciNumbers.size() - 1;
		BigInteger lastNum = fibonacciNumbers.get(lastIndex);
		BigInteger secondLastNum = fibonacciNumbers.get(lastIndex - 1);

		BigInteger newFibonacci = lastNum.add(secondLastNum);
		fibonacciNumbers.add(newFibonacci);
		return newFibonacci;
	}

	private static String readLineQuietly(final BufferedReader br) {
		try {
			return br.readLine();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
