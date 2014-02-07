

import java.util.ArrayList;
import java.util.Random;


public class GraphFactory<NodeType extends DeNode<?, ?>, GraphType extends SCCGraph<?>> {
    private GraphFactory(){};
    
    static ProblemLocales locales;
    
    static void setProblemLocales(ProblemLocales localesToSet){
        locales = localesToSet;
    }
    
    public static int sizeToCap(int size){
        return (int) ((size/(locales.loadFactor - 0.01)) + 1);
    }

    public static DataGraph makeRandomGraph(int size){
        Random generator = new Random();
        DataGraph dg = new DataGraph();
        Node[] nodes = new Node[size];
        for(int i = 0; i < size; i++){
            Node newNode = new Node(i + 1);
            nodes[i] = newNode;
            dg.addNode(newNode);
        }

        for(int i = 0; i < size; i++){
            for(int ii = 0; ii < size; ii++){
                if(generator.nextBoolean()){
                    nodes[i].connectChild(nodes[ii]);
                    //System.out.println("connected " + nodes[i].id + " with " + nodes[ii].id);
                }
            }
        }
        return dg; 
    }

    public static ArrayList<DataGraph> makeTwoRandomSparseGraphs(int size, int noChildren){
        Random generator = new Random();
        DataGraph dg1 = new DataGraph();
        DataGraph dg2 = new DataGraph();
        Node[] nodes1 = new Node[size];
        Node[] nodes2 = new Node[size];

        for(int i = 0; i < size; i++){
            Node newNode1 = new Node(i + 1);
            Node newNode2 = new Node(i + 1);
            nodes1[i] = newNode1;
            nodes2[i] = newNode2;
            dg1.addNode(newNode1);
            dg2.addNode(newNode2);
        }
        
        for(int i = 0; i < size; i++){
            for(int ii = 0; ii < noChildren; ii++){
            	int nextInt = generator.nextInt(size);
                nodes1[i].connectChild(nodes1[nextInt]);
                nodes2[i].connectChild(nodes2[nextInt]);
                //System.out.println("connected " + nodes[i].id + " with " + nodes[ii].id);
                
            }
        }
        ArrayList<DataGraph> arrayList = new ArrayList<DataGraph>();
        arrayList.add(dg1);
        arrayList.add(dg2);
        return arrayList;
    }
    public static DataGraph makeSanityCheckGraph(){
        DataGraph dg = new DataGraph();
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        Node n8 = new Node(8);
        Node n9 = new Node(9);
        Node n10 = new Node(10);
        Node n11 = new Node(11);

        dg.addNode(n1);
        dg.addNode(n2);
        dg.addNode(n3);
        dg.addNode(n4);
        dg.addNode(n5);
        dg.addNode(n6);
        dg.addNode(n7);
        dg.addNode(n8);
        dg.addNode(n9);
        dg.addNode(n10);
        dg.addNode(n11);

        n1.connectChild(n2);
        n2.connectChild(n3);
        n2.connectChild(n7);

        n3.connectChild(n4);
        n3.connectChild(n6);
        n4.connectChild(n5);
        n5.connectChild(n6);
        n6.connectChild(n4);
        n7.connectChild(n1);
        n7.connectChild(n2);
        n7.connectChild(n9);
        n8.connectChild(n6);
        n8.connectChild(n10);
        n8.connectChild(n11);
        n9.connectChild(n8);     
        n10.connectChild(n5);
        n10.connectChild(n11);
        n11.connectChild(n9);
        return dg;
    }

    public static TarjansGraph makeSanityCheckGraphTarjan(){
    	TarjansGraph dg = new TarjansGraph();
        TarjansNode n1 = new TarjansNode(1);
        TarjansNode n2 = new TarjansNode(2);
        TarjansNode n3 = new TarjansNode(3);
        TarjansNode n4 = new TarjansNode(4);
        TarjansNode n5 = new TarjansNode(5);
        TarjansNode n6 = new TarjansNode(6);
        TarjansNode n7 = new TarjansNode(7);
        TarjansNode n8 = new TarjansNode(8);
        TarjansNode n9 = new TarjansNode(9);
        TarjansNode n10 = new TarjansNode(10);
        TarjansNode n11 = new TarjansNode(11);

        dg.addNode(n1);
        dg.addNode(n2);
        dg.addNode(n3);
        dg.addNode(n4);
        dg.addNode(n5);
        dg.addNode(n6);
        dg.addNode(n7);
        dg.addNode(n8);
        dg.addNode(n9);
        dg.addNode(n10);
        dg.addNode(n11);

        n1.connectChild(n2);
        n2.connectChild(n3);
        n2.connectChild(n7);

        n3.connectChild(n4);
        n3.connectChild(n6);
        n4.connectChild(n5);
        n5.connectChild(n6);
        n6.connectChild(n4);
        n7.connectChild(n1);
        n7.connectChild(n2);
        n7.connectChild(n9);
        n8.connectChild(n6);
        n8.connectChild(n10);
        n8.connectChild(n11);
        n9.connectChild(n8);     
        n10.connectChild(n5);
        n10.connectChild(n11);
        n11.connectChild(n9);
        return dg;
    }

}
