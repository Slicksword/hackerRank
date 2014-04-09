package problems.algorithms.warmup.chocolatefeast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public final class Solution {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int numTestCases = 0;

		try {
			numTestCases = Integer.parseInt(br.readLine());
		} catch (IOException e) {
			new RuntimeException("Could not read number of testcases.", e);
		}

		for (int i = 0; i < numTestCases; ++i) {
			int[] testCase = parseIntsFromString(readLineQuietly(br));
			int bill = testCase[0];
			int cost = testCase[1];
			int wrapperDiscount = testCase[2];

			int numBoughtChocolates = bill / cost;
			int numTotalChocolates = numBoughtChocolates
					+ calculateFreeChocolates(numBoughtChocolates,
							wrapperDiscount);
			System.out.println(numTotalChocolates);
		}

	}

	private static int calculateFreeChocolates(final int numWrappers,
			final int wrapperDiscount) {
		int numNewWrappers = numWrappers / wrapperDiscount;

		int totalRemainingWrappers = numWrappers % wrapperDiscount
				+ numNewWrappers;
		if (totalRemainingWrappers >= wrapperDiscount) {
			return calculateFreeChocolates(totalRemainingWrappers,
					wrapperDiscount) + numNewWrappers;
		} else {
			return numNewWrappers;
		}
	}

	private static String readLineQuietly(final BufferedReader br) {
		try {
			return br.readLine();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private static int[] parseIntsFromString(final String line) {
		String[] strings = line.split(" ");
		int[] integers = new int[strings.length];

		for (int stringIndex = 0; stringIndex < strings.length; ++stringIndex) {
			String intString = strings[stringIndex].trim();
			integers[stringIndex] = Integer.parseInt(intString);
		}

		return integers;
	}
}
