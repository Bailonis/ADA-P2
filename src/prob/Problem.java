package prob;

public class Problem {
	private static final String N = "N";
	private static final String S = "S";
	private static final String E = "E";
	private static final String W = "W";
	Graph g;
	int[] vec = new int[2];
	Vertex prev = null;
	Vertex f;
	Position p;

	public Problem() {
		g = new Graph();
		vec[0] = 0;
		vec[1] = 0;
		p = new Position(vec[0], vec[1]);
		f = new Vertex(vec);
		g.addVertex(f, p);
		prev = f;
	}

	public void addVertex(String direction) {

		switch (direction) {
		case N:
			vec[1]++;
			break;
		case S:
			vec[1]--;
			break;
		case E:
			vec[0]++;
			break;
		case W:
			vec[0]--;
			break;
		}

		Position aux = new Position(vec[0], vec[1]);

		Vertex temp = g.getVertex(aux);

		if (temp == null) {
			temp = new Vertex(vec);
			g.addVertex(temp, aux);
		}
		if (!g.hasEdge(aux, prev))
			g.addEdge(temp, prev);
		prev = temp;

	}

	public int solve() {
		Vertex end = prev;
		return g.solve(p, end);
	}
}
