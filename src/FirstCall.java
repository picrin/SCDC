//import static org.junit.Assert.assertTrue;

import java.util.ArrayList;


//import org.junit.Assert;


public class FirstCall {


	public static void main(String args[]){
		System.out.println("smierdze!");
		GraphFactory.setProblemLocales(ProblemLocales.exampleLocales());
		DataGraph dg = GraphFactory.makeSanityCheckGraph();
		Node firstCome = dg.remainder.values().iterator().next();
		System.out.println("focused node : " + firstCome);
		//System.out.println(firstCome.graph);
		//System.out.println(dg);
		ExplorePredecessors predecessors = new ExplorePredecessors(GraphFactory.locales.threads, firstCome, dg);
		ExploreDescendants descendants = new ExploreDescendants(GraphFactory.locales.threads, firstCome, dg);
		
		predecessors.startExploration();
		descendants.startExploration();

		predecessors.awaitExploration();
		descendants.awaitExploration();
		//ArrayList<UltimateRecurssion> tasks = new ArrayList<UltimateRecurssion>(3);
		//System.out.println(dg.remainder);
		//System.out.println(dg.scc);
		//System.out.println(dg.predecessors);
		//System.out.println(dg.descendants);
		System.out.println("predecessors" + dg.predecessors);
		System.out.println("descendants" + dg.descendants);
		System.out.println("remainder" + dg.remainder);
		System.out.println("scc" + dg.scc);
		//dg.reportSolution(dg.scc);
		
		DataGraph remainingPredecessors = new DataGraph(dg.predecessors, dg.rootGraph);
		DataGraph remainingDescendants = new DataGraph(dg.descendants, dg.rootGraph);
		DataGraph remainder = new DataGraph(dg.remainder, dg.rootGraph);
		//System.out.println(remainder.remainder);
		//System.out.println(remainingPredecessors.remainder);
		System.out.println(remainingDescendants.remainder);
		/*Node secondCome = remainingDescendants.remainder.values().iterator().next();
		System.out.println("focused node : " + secondCome);
		ExplorePredecessors predecessors = new ExplorePredecessors(GraphFactory.locales.threads, secondCome, remai);
		ExploreDescendants descendants = new ExploreDescendants(GraphFactory.locales.threads, firstCome, dg);
		
		predecessors.startExploration();
		descendants.startExploration();

		predecessors.awaitExploration();				
		descendants.awaitExploration();
		*/
		
	}
	
}
