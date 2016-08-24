/* Dijkstra's Algorithm */

public class DijkstraAlgo{
	ArrayList<GraphNode> nodeList;


	public GraphNode addNode(int id){
		GraphNode node = new GraphNode(id);
		nodeList.add(0,node);
		return nodeList.get(0);
	}

	public void addEdge(int id1, int id2){
		boolean node1_found = false, node_found = false;

		GraphNode node1 = null, node2 = null;

		for(int i = 0; i < nodeList.size(); i++){
			if(nodeList.get(i).node_id == id1){
				node1_found = true;
				node1 = nodeList.get(i);
			}

			if(nodeList.get(i).node_id == id2){
				node2_found = true;
				node2 = nodeList.get(i);
			}

			if(node1_found && node2_found) break;
		}

		if(!node1_found){
			node1 = this.addNode(id1);
		}

		if(!node2_found){
			node2 = this.addNode(id2);
		}

		GraphNode temp = new GraphNode(id2);
		temp.next = node1.next;
		node1.next = temp;
	}

	public GraphNode getNode(int id){
		for(int i = 0; i < nodeList.size(); i++){
			if(id == nodeList.get(i).node_id)
				return nodeList.get(i);
		}
		return null;
	}

	public void printGraph(){
		for(int i = 0; i < nodeList.size(); i++){
			GraphNode temp = nodeList.get(i);

			while(temp != null){
				System.out.prin(" ->" + temp.node_id);
				temp = temp.next;
			}
			System.out.println();
		}
	}


	class GraphNode{
		int node_id;
		GraphNode next;

		public GraphNode(int id){
			this.node_id = id;
		}
	}
}