package problems.algorithms.search.closestnumbers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Vector;

public final class Solution {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int totalCount = Integer.parseInt(readLineQuietly(br));
		Vector<Integer> numbers = parseIntsFromString(readLineQuietly(br));
		Collections.sort(numbers);

		StringBuilder pairs = new StringBuilder(numbers.get(0) + " "
				+ numbers.get(1));
		int smallestDifference = numbers.get(1) - numbers.get(0);

		for (int i = 2; i < totalCount; ++i) {
			Integer curNum = numbers.get(i);
			Integer prevNum = numbers.get(i - 1);

			int currentDifference = curNum - prevNum;
			if (currentDifference < smallestDifference) {
				smallestDifference = currentDifference;
				pairs = new StringBuilder(prevNum + " " + curNum);
			} else if (currentDifference == smallestDifference) {
				pairs.append(" " + prevNum + " " + curNum);
			}
		}

		System.out.println(pairs.toString());
	}

	private static String readLineQuietly(final BufferedReader br) {
		try {
			return br.readLine();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private static Vector<Integer> parseIntsFromString(final String line) {
		String[] strings = line.split(" ");
		Vector<Integer> integers = new Vector<Integer>(strings.length);

		for (int stringIndex = 0; stringIndex < strings.length; ++stringIndex) {
			String intString = strings[stringIndex].trim();
			integers.add(Integer.parseInt(intString));
		}

		return integers;
	}
}