package prob;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Graph {

	// Hashmap para guardar os vertices do grafo
	private Map<Position, Vertex> map = new HashMap<>();
	private Queue<Vertex> fifo = new LinkedList<Vertex>();

	// Adiciona um vertice ao grafo
	public void addVertex(Vertex vert, Position pos) {
		map.put(pos, vert);
	}

	// Adiciona uma aresta entre dois vertices
	public void addEdge(Vertex source, Vertex destination) {
		source.addLink(destination);
		destination.addLink(source);
	}

	//Retorna o vertice com a Key pos
	public Vertex getVertex(Position pos) {
		return map.get(pos);
	}

	// Dando dois vertices, ve se existe uma aresta entre os dois
	public boolean hasEdge(Position pos, Vertex d) {
		return map.get(pos).hasLink(d);
	}

	//Procura em largura
	public int solve(Position pos, Vertex end) {
		Vertex start = map.get(pos);
		start.visit();
		fifo.add(start);

		while (!fifo.isEmpty()) {

			Vertex v = fifo.element();
			for (Vertex w : v.getList()) {
				if (!w.isVisited()) {
					w.visit();
					w.addSteps(v);
					if (end.isVisited())
						return end.getSteps() - 1;
					fifo.add(w);
				}
			}
			fifo.remove(v);
		}
		return 0;
	}

}
