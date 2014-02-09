import java.util.HashSet;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentLinkedQueue;


public class TarjanGraph extends AbstractGraph<TarjanNode>{

	protected HashSet<TarjanNode> nodes;
	protected ConcurrentLinkedQueue<NonBlockingHashMap<Long, TarjanNode>> solutions;
	
	@Override
	public void addNode(TarjanNode node) {
		nodes.add(node);
	}
	
	public HashSet<TarjanNode> getNodes(){
		return nodes;
	}
	
	TarjanGraph(){
		nodes = new HashSet<>();
		solutions = new ConcurrentLinkedQueue<>();
	}
	
	private LinkedList<TarjanNode> tarjanStack = new LinkedList<TarjanNode>();
	private int currentIndex = 0;
	public void start(){
		for(TarjanNode node: nodes){
			if(!node.isExplored()){
				explore(node);
			}
		}
	}
	
	protected void explore(TarjanNode node){		
		node.explored = true;
		node.index = currentIndex;
		node.lowlink = currentIndex;
		currentIndex += 1;

		tarjanStack.add(node);
		
		for(TarjanNode child: node.children){
			if(!child.isSCCd()){
				if(child.explored){
					node.lowlink = Math.min(node.lowlink, child.index);
				}
				else{
					explore(child);
					node.lowlink = Math.min(node.lowlink, child.lowlink);
				}
			}
		}
		
		if(node.lowlink == node.index){
			TarjanNode nextPopped;
			NonBlockingHashMap<Long, TarjanNode> solution = new NonBlockingHashMap<>();
			do{
				nextPopped = tarjanStack.removeLast();
				nextPopped.markSCCd();
				solution.put(nextPopped.getID(), nextPopped);
			} while (nextPopped != node);
			reportSolution(solution);
		}
		
		
	}
		
	@Override
	public ConcurrentLinkedQueue<NonBlockingHashMap<Long, TarjanNode>> getSolutions() {
		return solutions;
	}
	
	@Override
	public void reportSolution(NonBlockingHashMap<Long, TarjanNode> solution) {
		solutions.add(solution);
	}

}
