package problems.algorithms.dynamicprogramming.playgame;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public final class Solution {

	/**
	 * Represents playing the game from this
	 * {@link #Solution(int, Block, Block, Block)}. Computes the maximum score
	 * for a player playing optimally from this Block, given information
	 * contained in the 3 blocks below this block.
	 *
	 * @author jnguyen
	 *
	 */
	public static class Block {
		private long blockValue;
		private long playerFinalScore = 0;
		private Block otherPlayerBlock = null;

		public Block(long value, Block oneBelow, Block twoBelow, Block threeBelow) {
			this.blockValue = value;

			if (oneBelow == null) {
				this.playerFinalScore = value;
				return;
			} else if (oneBelow != null && twoBelow == null) {
				this.playerFinalScore = value + oneBelow.getBlockValue();
				return;
			} else if (oneBelow != null && twoBelow != null && threeBelow == null) {
				this.playerFinalScore = value + oneBelow.getBlockValue() + twoBelow.getBlockValue();
				return;
			}

			Block otherBlock = oneBelow.getOtherPlayerBlock();
			long scorePickOne = value + (otherBlock == null ? 0 : otherBlock.getPlayerFinalScore());

			otherBlock = twoBelow.getOtherPlayerBlock();
			long scorePickTwo = value + oneBelow.getBlockValue() + (otherBlock == null ? 0 : otherBlock.getPlayerFinalScore());

			otherBlock = threeBelow.getOtherPlayerBlock();
			long scorePickThree = value + oneBelow.getBlockValue() + twoBelow.getBlockValue() + (otherBlock == null ? 0 : otherBlock.getPlayerFinalScore());

			if (scorePickOne >= scorePickTwo && scorePickOne >= scorePickThree) {
				this.playerFinalScore = scorePickOne;
				this.otherPlayerBlock = oneBelow;
			} else if (scorePickTwo >= scorePickOne && scorePickTwo >= scorePickThree) {
				this.playerFinalScore = scorePickTwo;
				this.otherPlayerBlock = twoBelow;
			} else {
				this.playerFinalScore = scorePickThree;
				this.otherPlayerBlock = threeBelow;
			}
		}

		public long getBlockValue() {
			return blockValue;
		}

		public Block getOtherPlayerBlock() {
			return otherPlayerBlock;
		}

		public long getPlayerFinalScore() {
			return playerFinalScore;
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int numTests = in.nextInt();

		for (int index = 0; index < numTests; ++index) {
			int[] stack = getStack(in);
			System.out.println(computeMaximumScore(stack));
		}

	}

	private static long computeMaximumScore(int[] stack) {
		List<Block> blocks = new ArrayList<Block>();

		for (int i = 0; i < stack.length; ++i) {
			long currValue = stack[stack.length - 1 - i];

			Block one = i == 0 ? null : blocks.get(i - 1);
			Block two = i <= 1 ? null : blocks.get(i - 2);
			Block three = i <= 2 ? null : blocks.get(i - 3);

			blocks.add(new Block(currValue, one, two, three));
		}

		return blocks.get(blocks.size() - 1).getPlayerFinalScore();
	}

	private static int[] getStack(Scanner scan) {
		int height = scan.nextInt();
		int[] stack = new int[height];

		for (int i = 0; i < height; ++i) {
			stack[i] = scan.nextInt();
		}

		return stack;
	}
}