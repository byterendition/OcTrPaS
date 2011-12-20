package model;

import java.util.Arrays;

public class Cell {
	private int					level;
	private Cell				parent;
	private Cell				subcells[];

	private final Simulation	simulation;

	public Cell(int level, Cell parent, Simulation simulation) {
		this.simulation = simulation;
		this.subcells = new Cell[1 << simulation.getDim()]; // no more dimensions than 32, though that would kill your computer already anyway...
		init(level, parent);
	}

	public void init(int level, Cell parent) {
		this.level = level;
		this.parent = parent;
	}

	public void reset() {
		parent = null;
		Arrays.fill(subcells, null);
	}

	public Cell[] getSubcells() {
		return subcells;
	}

	public void setSubcell(int index, Cell cell) {
		subcells[index] = cell;
	}

	public int getLevel() {
		return level;
	}
}
