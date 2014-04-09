package problems.algorithms.warmup.angrychildren;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Solution {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int numPackets = 0;
		int numChildren = 0;

		numPackets = Integer.parseInt(readLineQuietly(br));
		numChildren = Integer.parseInt(readLineQuietly(br));

		List<Integer> packetSizes = new ArrayList<Integer>(numPackets);

		for (int i = 0; i < numPackets; ++i) {
			packetSizes.add(Integer.parseInt(readLineQuietly(br)));
		}

		Collections.sort(packetSizes);
		int minUnfairness = Integer.MAX_VALUE;

		for (int i = 0; i < numPackets - numChildren; ++i) {
			int unfairness = packetSizes.get(i + numChildren - 1)
					- packetSizes.get(i);
			if (unfairness < minUnfairness)
				minUnfairness = unfairness;
		}

		System.out.println(minUnfairness);
	}

	private static String readLineQuietly(final BufferedReader br) {
		try {
			return br.readLine();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
