package problems.algorithms.warmup.fillingjars;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public final class Solution {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] firstLine = parseIntsFromString(readLineQuietly(br));
		int numJars = firstLine[0];
		int numOperations = firstLine[1];
		
		BigInteger totalCandies = new BigInteger("0");
		
		for(int operation = 0; operation < numOperations; ++operation) {
			int[] operationValues = parseIntsFromString(readLineQuietly(br));
			int startingJar = operationValues[0];
			int endingJar = operationValues[1];
			BigInteger candiesPerJar = BigInteger.valueOf(operationValues[2]);
			
			BigInteger numJarsToFill = BigInteger.valueOf(endingJar - startingJar + 1);
			totalCandies = totalCandies.add(candiesPerJar.multiply(numJarsToFill));
		}

		System.out.println(totalCandies.divide(BigInteger.valueOf(numJars)));
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
