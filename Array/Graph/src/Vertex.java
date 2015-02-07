import java.util.ArrayList;
import java.util.List;


public class Vertex {
	private int id;
	private ArrayList<Vertex> connectedTo;
	
	Vertex(int id){
		this.id = id;
		this.connectedTo = new ArrayList<Vertex>();
	}
	public void addNeighbour(int neighbour){
		this.connectedTo.add(new Vertex(neighbour));
	}
}
