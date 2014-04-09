package problems.algorithms.search.pairs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

public final class Solution {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Vector<Integer> nAndK = parseIntsFromString(readLineQuietly(br));
		Vector<Integer> numbers = parseIntsFromString(readLineQuietly(br));
		Set<Integer> numberSet = new HashSet<Integer>(numbers);

		int k = nAndK.get(1);
		int pairCount = 0;

		for (Integer number : numberSet) {
			if (numberSet.contains(number + k)) {
				++pairCount;
			}
		}
		
		System.out.println(pairCount);
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
