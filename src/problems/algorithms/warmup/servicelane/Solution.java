package problems.algorithms.warmup.servicelane;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

public final class Solution {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] firstLine = parseIntsFromString(readLineQuietly(br));
		int freewayLength = firstLine[0];
		int numTestCases = firstLine[1];

		int[] widths = parseIntsFromString(readLineQuietly(br));
		
		// Map<End Index, Map<Start Index, WidestPath>>
		Map<Integer, Map<Integer, Integer>> storedPossibleVehicles;
		
		for(int testCase =0; testCase < numTestCases; ++testCase) {
			int[] startAndEnd = parseIntsFromString(readLineQuietly(br));
			int start = startAndEnd[0];
			int end = startAndEnd[1];
			
			int maxWidth = 3;
			for(int index = end; index >= start; --index) {
				if(widths[index] < maxWidth) {
					maxWidth = widths[index];
				}
				
				if(maxWidth == 1) break;
			}
			
			System.out.println(maxWidth);
		}
	}

	public static String readLineQuietly(final BufferedReader br) {
		try {
			return br.readLine();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static int[] parseIntsFromString(final String line) {
		String[] strings = line.split(" ");
		int[] integers = new int[strings.length];

		for (int stringIndex = 0; stringIndex < strings.length; ++stringIndex) {
			String intString = strings[stringIndex].trim();
			integers[stringIndex] = Integer.parseInt(intString);
		}

		return integers;
	}
}
