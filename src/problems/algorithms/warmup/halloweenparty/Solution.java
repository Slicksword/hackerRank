package problems.algorithms.warmup.halloweenparty;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public final class Solution {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int numTestCases = Integer.parseInt(readLineQuietly(br));

		for (int testCase = 0; testCase < numTestCases; ++testCase) {
			BigInteger numCuts = new BigInteger(readLineQuietly(br));
			BigInteger one = new BigInteger("1");
			BigInteger two = new BigInteger("2");
			
			BigInteger numPieces = new BigInteger("0");
			if (numCuts.mod(two).intValue() == 0) {
				numPieces = ((numCuts.divide(two).add(one)).multiply(numCuts.divide(two))).subtract(numCuts.divide(two));
			} else {
				numPieces = (numCuts.divide(two).add(one)).multiply(numCuts.divide(two));
			}

			System.out.println(numPieces);
		}
	}

	public static String readLineQuietly(final BufferedReader br) {
		try {
			return br.readLine();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
