import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import prob.Problem;
public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		int numLines = Integer.parseInt(input.readLine());
		Problem prob = new Problem();
		for (int i = 0; i < numLines; i++) {
			String tokens = input.readLine();
			for (int j = 0; j < tokens.length(); j++) {
				String direction = tokens.substring(j, j + 1);
				prob.addVertex(direction);	
			}
		}
		System.out.println(prob.solve());	
	}
}
