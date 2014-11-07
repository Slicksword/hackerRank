package problems.algorithms.warmup.cutthesticks;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public final class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int numSticksLeft = in.nextInt();

		Map<Integer, Integer> numCounts = new HashMap<Integer, Integer>();
		for (int index = 0; index < numSticksLeft; ++index) {
			int stickLength = in.nextInt();
			int count = numCounts.get(stickLength) != null ? numCounts.get(stickLength) + 1 : 1;
			numCounts.put(stickLength, count);
		}

		Solution solved = new Solution(numSticksLeft, numCounts);
		solved.cutSticks();
	}

	private int numSticksRemaining;

	private final TreeMap<Integer, Integer> lengthCounts;

	private Solution(int numSticks, Map<Integer, Integer> lengthCounts) {
		this.numSticksRemaining = numSticks;
		this.lengthCounts = new TreeMap<Integer, Integer>(lengthCounts);
	}

	public void cutSticks() {
		int numLengths = lengthCounts.size();

		// Note: Interesting bug - if I inlined lengthCounts.size() into the
		// for-loop instead of saving to a local variable, this solution will
		// fail because the length of lengthCounts is being modified within the
		// loop.
		for (int i = 0; i < numLengths; ++i) {
			System.out.println(numSticksRemaining);
			removeShortestLengthSticks();
		}
	}

	private void removeShortestLengthSticks() {
		int shortestLength = lengthCounts.firstKey();

		numSticksRemaining -= lengthCounts.get(shortestLength);
		lengthCounts.remove(shortestLength);
	}
}