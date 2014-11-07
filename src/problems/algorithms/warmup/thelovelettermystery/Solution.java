package problems.algorithms.warmup.thelovelettermystery;

import java.util.Scanner;

public final class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int numTests = in.nextInt();
		in.nextLine();

		for (int test = 0; test < numTests; ++test) {
			numOperationsToPalindrome(in);
		}
	}

	private static void numOperationsToPalindrome(Scanner in) {
		char[] letters = in.nextLine().toCharArray();
		int numOps = 0;

		for (int strIndex = 0; strIndex < letters.length / 2; ++strIndex) {
			char front = letters[strIndex];
			char end = letters[letters.length - strIndex - 1];

			numOps += Math.abs(front - end);
		}

		System.out.println(numOps);
	}
}
