package model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LeafCell extends Cell {
	private Cell			neighbourArr[];
	private Set<Particle>	particleSet	= new HashSet<Particle>();

	public LeafCell(int level, Cell parent, Simulation simulation) {
		super(level, parent, simulation);
		neighbourArr = new Cell[1 << simulation.getDim()];
	}

	@Override
	public void reset() {
		super.reset();
		Arrays.fill(neighbourArr, null);
	}

	public Cell[] getAllNeighbours() {
		return neighbourArr;
	}

	public Cell getNeighbour(int i) {
		return neighbourArr[i];
	}

	public void setNeighbour(int i, Cell neighbour) {
		neighbourArr[i] = neighbour;
	}

	public Set<Particle> getParticleSet() {
		return particleSet;
	}

	public void addParticle(Particle particle) {
		particleSet.add(particle);
	}

	public void removeParticle(Particle particle) {
		particleSet.remove(particle);
	}
}
