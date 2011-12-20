package model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LeafCell extends Cell {
	private Cell			neighbours[]	= new Cell[8];
	private Set<Particle>	particleSet		= new HashSet<Particle>();

	public LeafCell(int level, Cell parent, Simulation simulation) {
		super(level, parent, simulation);
	}

	@Override
	public void reset() {
		super.reset();
		Arrays.fill(neighbours, null);
	}

	public Cell[] getNeighbours() {
		return neighbours;
	}

	public Cell getNeighbour(int i) {
		return neighbours[i];
	}

	public void setNeighbour(int i, Cell neighbour) {
		neighbours[i] = neighbour;
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
