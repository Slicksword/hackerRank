package problems.contests.week1.volleyballmatch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public final class Solution {
	private final static Map<IntegerPair, Long> possibleCombinations = new HashMap<IntegerPair, Long>();

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int scoreA = Integer.parseInt(readLineQuietly(br));
		int scoreB = Integer.parseInt(readLineQuietly(br));

		boolean negativeScore = scoreA < 0 || scoreB < 0;
		boolean didNotReachGamePoint = scoreA < 25 && scoreB < 25;
		boolean impossibleFinalScore = scoreA == 25 && scoreB == 25;
		boolean impossibleFinalScoreTwo = (scoreA == 25 && scoreB == 24) || (scoreA == 24 && scoreB == 25);
		boolean impossibleOvertimeScore = (scoreA > 25 && scoreB != (scoreA - 2)) || (scoreB > 25 && scoreA != (scoreB - 2));
		if (negativeScore || didNotReachGamePoint || impossibleFinalScore || impossibleFinalScoreTwo || impossibleOvertimeScore) {
			System.out.println(0);
		} else {
			long numCombinations = getNumberOfCombinations(scoreA, scoreB);
			System.out.println(numCombinations % (1000000000 + 7));
		}
	}

	private static long getNumberOfCombinations(int scoreA, int scoreB) {
		int higherScore, lowerScore;
		if (scoreA > scoreB) {
			higherScore = scoreA;
			lowerScore = scoreB;
		} else {
			higherScore = scoreB;
			lowerScore = scoreA;
		}

		// Base case
		if (lowerScore == 0) {
			return 1;
		} else {
			// Check for existing calculation. Should always catch since we're
			// inputing IntegerPairs with highest score first in the pair
			Long existingCombination = possibleCombinations.get(new IntegerPair(higherScore, lowerScore));
			if (existingCombination != null) {
				return existingCombination;
			} else {
				long totalCombinations = 0;

				if (higherScore == 26 && lowerScore == 24) {
					return getNumberOfCombinations(24, 24);
				} else if (higherScore > 25 && lowerScore == (higherScore - 2)) {
					long power = higherScore - 26;
					long multiplier = 1;
					for (int i = 0; i < power; i++) {
						multiplier *= 2;
					}
					
					return getNumberOfCombinations(24, 24) * multiplier;
				}
				if (higherScore == 25) {
					totalCombinations = getNumberOfCombinations(higherScore - 1, lowerScore);
				} else {
					totalCombinations = getNumberOfCombinations(higherScore - 1, lowerScore) + getNumberOfCombinations(higherScore, lowerScore - 1);
				}
				possibleCombinations.put(new IntegerPair(higherScore, lowerScore), totalCombinations);
				return totalCombinations;
			}
		}
	}

	public static String readLineQuietly(final BufferedReader br) {
		try {
			return br.readLine();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private static class IntegerPair {

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + valueA;
			result = prime * result + valueB;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			IntegerPair other = (IntegerPair) obj;
			if (valueA != other.valueA)
				return false;
			if (valueB != other.valueB)
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "IntegerPair [valueA=" + valueA + ", valueB=" + valueB + "]";
		}

		private final int valueA;
		private final int valueB;

		public IntegerPair(int a, int b) {
			this.valueA = a;
			this.valueB = b;
		}
	}
}
