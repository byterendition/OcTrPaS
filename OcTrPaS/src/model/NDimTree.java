package model;

import java.util.LinkedList;
import java.util.Queue;

public class NDimTree {
	private Cell				root;
	private final double		cellSize;
	private final int			nDim;
	private Queue<Cell>			freeCells	= new LinkedList<Cell>();

	private final Simulation	simulation;

	public NDimTree(double cellSize, Simulation simulation) {
		this.cellSize = cellSize;
		this.nDim = simulation.getDim();
		this.simulation = simulation;
		root = new Cell(0, null, simulation);
		initFreeCells(10000);
	}

	public boolean isEmpty() {
		return root == null;
	}

	public double getCellSize() {
		return cellSize;
	}

	public Vect<Short> getCellPos(Vect<Double> pos) {
		return pos.divide(cellSize).toShort();
	}

	private void initFreeCells(int n) {
		for (int i = 0; i < n; i++) {
			freeCells.add(new Cell(0, null, simulation));
		}
	}

	private Cell getNewCell(int level, Cell parent) {
		if (freeCells.isEmpty()) {
			initFreeCells(1000);
		}

		Cell newCell = freeCells.remove();
		newCell.init(level, parent);

		return newCell;
	}

	public Cell addCell(Vect<Double> pos) throws RuntimeException {
		// System.out.println("X: " + cellXPos + ", Y: " + cellYPos);
		return traceCell(getCellPos(pos));
	}

	private LeafCell findCell(Vect<Short> cellPos) {
		Cell curCell = root;
		for (int i = 15; i >= 0; i--) {
			int subcell = 0;
			for (int dim = 0; dim < cellPos.vectArr.length; dim++) {
				subcell &= ((cellPos.vectArr[dim] >>> i) & 1) << dim;
			}
			curCell = curCell.getSubcells()[subcell];
			if (curCell == null) {
				return null;
			}
		}
		return (LeafCell) curCell;
	}

	private Cell traceCell(Vect<Short> cellPos) {
		Cell curCell = root;
		for (int i = 15; i >= 0; i--) {
			int subcell = 0;
			for (int dim = 0; dim < cellPos.vectArr.length; dim++) {
				subcell &= ((cellPos.vectArr[dim] >>> i) & 1) << dim;
			}
			Cell nextCell = curCell.getSubcells()[subcell];
			if (nextCell == null) {
				nextCell = getNewCell(i, curCell);
				curCell.setSubcell(subcell, nextCell);
				// System.out.println("Added new Cell with level " + i + " at index " + ind + ", while tracing for cell at position (" + cellXPos + ", " + cellYPos + ").");
			}
			curCell = nextCell;
		}
		return curCell;
	}
}
