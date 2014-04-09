package problems.algorithms.warmup.utopiantree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public final class Solution {
	private static final TreeMap<Integer, Integer> answers = new TreeMap<Integer, Integer>();
	static {
		answers.put(0, 1);
	}

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int numTestCases = 0;
		try {
			numTestCases = Integer.parseInt(br.readLine());
		} catch (IOException e) {
			new RuntimeException("Could not read number of testcases.", e);
		}

		for (int i = 0; i < numTestCases; ++i) {
			int numCycles = 0;
			try {
				numCycles = Integer.parseInt(br.readLine());
			} catch (IOException e) {
				new RuntimeException("Could not get number of cycles.", e);
			}

			Integer storedAnswer = answers.get(numCycles);
			if (storedAnswer != null) {
				System.out.println(storedAnswer);
			} else {
				Integer lastSeasonIndex = answers.lastKey();

				for (int cycleCount = lastSeasonIndex; cycleCount <= numCycles; ++cycleCount) {
					calculateGrowth(answers.get(cycleCount), cycleCount);
				}

				System.out.println(answers.get(numCycles));
			}
		}

	}

	private static void calculateGrowth(int startingGrowth, int season) {
		if (season % 2 == 1) {
			answers.put(season + 1, startingGrowth + 1);
		} else {
			answers.put(season + 1, startingGrowth * 2);
		}
	}
}
