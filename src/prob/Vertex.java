package prob;

import java.util.LinkedList;

public class Vertex {
	
	private LinkedList<Vertex> links;
	private boolean visited;
	private int steps;

	public Vertex(int[] l) {
		this.visited = false;
		links = new LinkedList<Vertex>();
		steps = 1;
	}

	public LinkedList<Vertex> getList() {
		return links;
	}

	public void addLink(Vertex vert) {
		links.add(vert);
	}

	public boolean hasLink(Vertex vert) {
		return links.contains(vert);
	}

	public boolean isVisited() {
		return visited;
	}

	public void visit() {
		visited = true;
	}

	public int getSteps() {
		return steps;
	}

	public void addSteps(Vertex father) {
		this.steps += father.getSteps();
	}

	public void oneStep() {
		this.steps++;
	}
}
