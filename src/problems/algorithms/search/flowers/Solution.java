package problems.algorithms.search.flowers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Vector;

public final class Solution {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Vector<Integer> nAndK = parseIntsFromString(readLineQuietly(br));
		int numPeople = nAndK.get(1);

		Vector<Integer> prices = parseIntsFromString(readLineQuietly(br));
		Collections.sort(prices);

		long totalCost = 0;
		int numFlowersPerPerson = 0;
		int numFlowersBought = 0;
		for (int i = prices.size() - 1; i >= 0; --i) {
			totalCost += (numFlowersPerPerson + 1) * prices.get(i);
			
			++numFlowersBought;
			if(numFlowersBought % numPeople == 0) {
				++numFlowersPerPerson;
			}
		}

		System.out.println(totalCost);
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
