package problems.algorithms.search.lonelyinteger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public final class Solution {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int numIntegers = 0;
		int[] numbers = {};
		try {
			numIntegers = Integer.parseInt(br.readLine());
			numbers = parseIntsFromString(readLineQuietly(br));
		} catch (IOException e) {
			new RuntimeException("Could not read number of testcases.", e);
		}

		Set<Integer> uniqueIntegers = new HashSet<Integer>(numIntegers);

		for (int i = 0; i < numbers.length; ++i) {
			int currentInteger = numbers[i];
			if (uniqueIntegers.contains(currentInteger)) {
				uniqueIntegers.remove(currentInteger);
			} else {
				uniqueIntegers.add(currentInteger);
			}
		}

		System.out.println(uniqueIntegers.iterator().next());
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
