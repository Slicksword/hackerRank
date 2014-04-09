package problems.algorithms.dynamicprogramming.stockmaximize;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public final class Solution {

	public static void main(String[] args) throws FileNotFoundException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int numTestCases = Integer.parseInt(readLineQuietly(br));

		for (int i = 0; i < numTestCases; ++i) {
			int numDays = Integer.parseInt(readLineQuietly(br));

			int[] prices = parseIntsFromString(readLineQuietly(br));

			BigInteger totalProfit = new BigInteger("0");
			BigInteger currentMaxPrice = new BigInteger(String.valueOf(prices[numDays - 1]));
			
			for (int priceIndex = numDays - 2; priceIndex >= 0; --priceIndex) {
				BigInteger todaysPrice = new BigInteger(String.valueOf(prices[priceIndex]));

				if (todaysPrice.compareTo(currentMaxPrice) == 1) {
					currentMaxPrice = todaysPrice;
				} else if (todaysPrice.compareTo(currentMaxPrice) == -1) {
					totalProfit = totalProfit.add((currentMaxPrice.subtract(todaysPrice)));
				}
			}

			System.out.println(totalProfit);
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
