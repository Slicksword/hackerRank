package problems.algorithms.search.thegridsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public final class Solution {
	private static class Grid {
		private final int numRows;
		private final int numColums;
		private final int[][] grid;

		public Grid(int[][] grid) {
			this.grid = grid;
			this.numRows = grid.length;
			this.numColums = numRows == 0 ? 0 : grid[0].length;
		}

		public boolean containsSubGrid(Grid subGrid) {
			for (int row = 0; row <= getNumRows() - subGrid.getNumRows(); ++row) {
				for (int col = 0; col <= getNumCols() - subGrid.getNumCols(); ++col) {
					if (hasSubGridAt(row, col, subGrid)) {
						return true;
					}
				}
			}
			return false;
		}

		public int getNumCols() {
			return numColums;
		}

		public int getNumRows() {
			return numRows;
		}

		public int getValueAt(int row, int col) {
			return grid[row][col];
		}

		private boolean hasSubGridAt(int startRow, int startCol, Grid subGrid) {
			int numSubGridRows = subGrid.getNumRows();
			int numSubGridCols = subGrid.getNumCols();

			if ((startRow + numSubGridRows > getNumRows()) || (startCol + numSubGridCols > getNumCols())) {
				// Not enough rows/columns to fit the sub-grid starting at index
				// [startRow, startCol]
				return false;
			}

			// Match all elements of the sub-grid element by element,
			// left-to-right and top-to-bottom
			for (int row = 0; row < numSubGridRows; ++row) {
				for (int col = 0; col < numSubGridCols; ++col) {
					if (getValueAt(startRow + row, startCol + col) != subGrid.getValueAt(row, col)) {
						return false;
					}
				}
			}

			return true;
		}
	}

	private static Grid createGrid(BufferedReader reader) {
		String[] gridBounds = readLineQuietly(reader).split(" ");
		int numGridRows = Integer.parseInt(gridBounds[0]);
		int numGridCols = Integer.parseInt(gridBounds[1]);

		int[][] values = new int[numGridRows][numGridCols];

		for (int i = 0; i < numGridRows; ++i) {
			values[i] = parseIntsFromString(readLineQuietly(reader));
		}

		return new Grid(values);

	}

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int numTests = Integer.parseInt(readLineQuietly(br));
		for (int test = 0; test < numTests; ++test) {
			searchGrid(br);
		}
	}

	private static int[] parseIntsFromString(final String line) {
		int[] integers = new int[line.length()];
		for (int index = 0; index < line.length(); ++index) {
			integers[index] = Character.getNumericValue(line.charAt(index));
		}

		return integers;
	}

	private static String readLineQuietly(final BufferedReader br) {
		try {
			return br.readLine();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private static void searchGrid(BufferedReader reader) {
		Grid mainGrid = createGrid(reader);
		Grid subGrid = createGrid(reader);

		if (mainGrid.containsSubGrid(subGrid)) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}
}
