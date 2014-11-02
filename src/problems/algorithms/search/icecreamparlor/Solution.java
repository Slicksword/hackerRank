package problems.algorithms.search.icecreamparlor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public final class Solution {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int numTestCases = 0;

		numTestCases = Integer.parseInt(readLineQuietly(br));

		for (int testCase = 1; testCase <= numTestCases; ++testCase) {
			int totalDollars = Integer.parseInt(readLineQuietly(br));
			int numFlavors = Integer.parseInt(readLineQuietly(br));
			int[] prices = parseIntsFromString(readLineQuietly(br));

			int[] sortedPrices = Arrays.copyOf(prices, prices.length);
			Arrays.sort(sortedPrices);

			int firstPrice = 0, secondPrice = 0;
			int maxIndex = sortedPrices.length - 1;

			for (int firstIndex = 0; firstIndex < sortedPrices.length; ++firstIndex) {
				int firstCost = sortedPrices[firstIndex];
				for (int secondIndex = 0; secondIndex < maxIndex; ++secondIndex) {
					int secondCost = sortedPrices[secondIndex];
					int total = firstCost + secondCost;

					if (total == totalDollars) {
						firstPrice = firstCost;
						secondPrice = secondCost;
						break;
					} else if (total > totalDollars) {
						maxIndex = secondIndex;
						break;
					}
				}

				if (firstPrice != 0 && secondPrice != 0)
					break;
			}

			int firstAnswer = 0, secondAnswer = 0;

			for (int i = 0; i < prices.length; ++i) {
				if (prices[i] == firstPrice) {
					if (firstAnswer == 0) {
						firstAnswer = i + 1;
					} else {
						secondAnswer = i + 1;
					}
				} else if (prices[i] == secondPrice) {
					if (firstAnswer == 0) {
						firstAnswer = i + 1;
					} else {
						secondAnswer = i + 1;
					}
				}
				
				if (firstAnswer != 0 && secondAnswer != 0) break;
			}
			
			System.out.println(firstAnswer + " " + secondAnswer);
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
