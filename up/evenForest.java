import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

 class Solution {
    static int count = 0;
    static boolean [] visited;
    static int dfs(ArrayList<ArrayList<Integer>> edges, int startEdge, int parent)
    {
        Iterator it = edges.get(startEdge).iterator();
        int nextNode = 0;
        int numChild = 0;
        int currentEdgeChild = 0;
        while(it.hasNext())
        {
            nextNode = (int) it.next();
            if(nextNode!=parent)
            {
                // System.out.println("calling dfs on "+nextNode+" from parent "+parent);
                currentEdgeChild = dfs(edges, nextNode, startEdge);
                numChild += currentEdgeChild;
                if(currentEdgeChild%2==0)
                    count++;
            }
        }
        // System.out.println("number of children of "+parent+" are "+numChild);
        return numChild+1;
    }
    static void dfs(ArrayList<ArrayList<Integer>> edges)
    {
            int numchildrenparent = dfs(edges, 0, 0);
            return;
    }

    // Complete the evenForest function below.
    static void evenForest(int nodes, int numEdges, List<Integer> from, List<Integer> to) {
        ArrayList<ArrayList<Integer>> edges = new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<nodes;i++)
            edges.add(new ArrayList<Integer>());
        for(int i=0;i<from.size();i++)
        {
            edges.get(from.get(i)-1).add(to.get(i)-1);
            edges.get(to.get(i)-1).add(from.get(i)-1);
        }
        visited = new boolean[nodes];
        dfs(edges);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] tNodesEdges = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int tNodes = Integer.parseInt(tNodesEdges[0]);
        int tEdges = Integer.parseInt(tNodesEdges[1]);

        List<Integer> tFrom = new ArrayList<>();
        List<Integer> tTo = new ArrayList<>();

        IntStream.range(0, tEdges).forEach(i -> {
            try {
                String[] tFromTo = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                tFrom.add(Integer.parseInt(tFromTo[0]));
                tTo.add(Integer.parseInt(tFromTo[1]));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        evenForest(tNodes, tEdges, tFrom, tTo);

        System.out.println(count);

        bufferedReader.close();
    }
}
