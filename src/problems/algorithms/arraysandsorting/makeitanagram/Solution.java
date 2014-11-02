package problems.algorithms.arraysandsorting.makeitanagram;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public final class Solution {

	private static HashMap<Character, Integer> createCharMap(String inputString) {
		HashMap<Character, Integer> charCounts = new HashMap<Character, Integer>();

		for (char c : inputString.toCharArray()) {
			if (charCounts.containsKey(c)) {
				charCounts.put(c, charCounts.get(c) + 1);
			} else {
				charCounts.put(c, 1);
			}
		}
		return charCounts;
	}

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String strOne = readLineQuietly(br);
		String strTwo = readLineQuietly(br);

		HashMap<Character, Integer> charCounts = createCharMap(strOne);
		int numDeletionsRequired = 0;

		numDeletionsRequired += removingCommonChars(strTwo, charCounts);

		for (Integer remainingCount : charCounts.values()) {
			numDeletionsRequired += remainingCount;
		}

		System.out.print(numDeletionsRequired);
	}

	private static String readLineQuietly(final BufferedReader br) {
		try {
			return br.readLine();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private static int removingCommonChars(String comparisonString, HashMap<Character, Integer> currentCounts) {
		int numRemoved = 0;
		for (char c : comparisonString.toCharArray()) {
			Integer letterCount = currentCounts.get(c);

			if (letterCount == null) {
				// Character in comparison string is not in map count
				++numRemoved;
			} else if (letterCount > 1) {
				currentCounts.put(c, letterCount - 1);
			} else if (letterCount == 1) {
				currentCounts.remove(c);
			} else {
				throw new IllegalStateException("Should never have character count less than 1");
			}
		}
		return numRemoved;
	}
}
