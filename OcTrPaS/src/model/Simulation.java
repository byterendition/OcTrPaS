package model;

public class Simulation {
	private NDimTree	tree;
	private final int	nDim;

	public Simulation(double cellSize, int nDim) {
		this.nDim = nDim;
		tree = new NDimTree(cellSize, this);

		for (int i = 0; i < 1000000; i++) {
			Double[] randPos = new Double[nDim];
			for (int dim = 0; dim < nDim; dim++) {
				randPos[dim] = Math.random() * 65535 - 32768;
			}
			tree.addCell(new Vect<Double>(randPos));
		}
	}

	public int getDim() {
		return nDim;
	}
}
