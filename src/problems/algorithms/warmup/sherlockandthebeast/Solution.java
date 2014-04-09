package problems.algorithms.warmup.sherlockandthebeast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public final class Solution {

	private static final String noSolution = "-1";
	private static final List<Integer> noSolutions = new ArrayList<Integer>(5);
	static {
		noSolutions.add(0);
		noSolutions.add(1);
		noSolutions.add(2);
		noSolutions.add(4);
		noSolutions.add(7);
	}

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int numTestCases = Integer.parseInt(readLineQuietly(br));

		for (int testCase = 0; testCase < numTestCases; ++testCase) {
			int numDigits = Integer.parseInt(readLineQuietly(br));

			if (noSolutions.contains(numDigits)) {
				System.out.println(noSolution);
				continue;
			}

			StringBuilder builder;
			int numberOfFives;
			switch (numDigits % 3) {
			case 0:
				builder = new StringBuilder(numDigits);
				for (int i = 0; i < numDigits; ++i) {
					builder.append("5");
				}
				System.out.println(builder.toString());
				continue;
			case 1:
				builder = new StringBuilder(numDigits);
				numberOfFives = (numDigits - 10);
				for (int i = 0; i < numberOfFives; ++i) {
					builder.append("5");
				}
				for (int i = 0; i < 10; ++i) {
					builder.append("3");
				}
				System.out.println(builder.toString());
				continue;
			case 2:
				builder = new StringBuilder(numDigits);
				numberOfFives = (numDigits - 5);
				for (int i = 0; i < numberOfFives; ++i) {
					builder.append("5");
				}
				for (int i = 0; i < 5; ++i) {
					builder.append("3");
				}
				System.out.println(builder.toString());
				continue;
			default:
				throw new RuntimeException("Should be impossible to get here.");
			}
		}
	}

	public static String readLineQuietly(final BufferedReader br) {
		try {
			return br.readLine();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
