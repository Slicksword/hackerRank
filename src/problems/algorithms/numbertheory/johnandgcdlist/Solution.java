package problems.algorithms.numbertheory.johnandgcdlist;

import java.util.Scanner;

public final class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int numTests = in.nextInt();

		Solution solution = new Solution();

		for (int i = 0; i < numTests; ++i) {
			solution.getSolution(in);
		}
	}

	private int[] getBFromA(int[] A) {
		int[] B = new int[A.length + 1];
		int prev;
		int curr;

		for (int i = 0; i < B.length; ++i) {
			prev = i == 0 ? 1 : A[i - 1];
			curr = i == A.length ? 1 : A[i];

			B[i] = leastCommonMultiple(prev, curr);
		}

		return B;
	}

	private int[] getListA(Scanner scan) {
		int listSize = scan.nextInt();
		int[] A = new int[listSize];

		for (int i = 0; i < listSize; ++i) {
			A[i] = scan.nextInt();
		}

		return A;
	}

	private void getSolution(Scanner scan) {
		int[] A = getListA(scan);
		int[] B = getBFromA(A);

		StringBuilder builder = new StringBuilder();

		for (int value : B) {
			builder.append(value + " ");
		}

		builder.deleteCharAt(builder.length() - 1);

		System.out.println(builder.toString());
	}

	private int greatestCommonFactor(int a, int b) {
		int larger = a > b ? a : b;
		int smaller = a < b ? a : b;

		int remainder;

		while (smaller != 0) {
			remainder = larger % smaller;
			larger = smaller;
			smaller = remainder;
		}

		return larger;
	}

	private int leastCommonMultiple(int a, int b) {
		return a * b / greatestCommonFactor(a, b);
	}
}
