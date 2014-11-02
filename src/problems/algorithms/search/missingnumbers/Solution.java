package problems.algorithms.search.missingnumbers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.TreeMap;

public final class Solution {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int sizeOfA = Integer.parseInt(readLineQuietly(br));
		SortedMap<Integer, Integer> listA = parseIntsFromString(readLineQuietly(br));
		int sizeOfB = Integer.parseInt(readLineQuietly(br));
		SortedMap<Integer, Integer> listB = parseIntsFromString(readLineQuietly(br));

		for (Entry<Integer, Integer> value : listA.entrySet()) {
			int number = value.getKey();
			int numTimesAppearedInA = value.getValue();

			if (listB.containsKey(number)) {
				if (listB.get(number) <= numTimesAppearedInA) {
					listB.remove(number);
				} else {
					listB.put(number, listB.get(number) - numTimesAppearedInA);
				}
			}
		}

		StringBuilder answer = new StringBuilder();
		for (Entry<Integer, Integer> entry : listB.entrySet()) {
			answer.append(entry.getKey());
			answer.append(" ");
		}

		System.out.println(answer.toString().trim());
	}

	private static String readLineQuietly(final BufferedReader br) {
		try {
			return br.readLine();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private static SortedMap<Integer, Integer> parseIntsFromString(
			final String line) {
		String[] strings = line.split(" ");
		SortedMap<Integer, Integer> integers = new TreeMap<Integer, Integer>();

		for (int stringIndex = 0; stringIndex < strings.length; ++stringIndex) {
			String intString = strings[stringIndex].trim();
			int integer = Integer.parseInt(intString);

			if (integers.containsKey(integer)) {
				integers.put(integer, integers.get(integer) + 1);
			} else {
				integers.put(integer, 1);
			}
		}

		return integers;
	}
}
