import java.lang.*;
import java.util.*;
import java.io.*;

class Codechef
{
    static int sum = 0;
    public static BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
    static int gcd(int a, int b)
    {
        if(a<b)
        return gcd(b,a);
        if(a%b==0)
        return b;
        else
        return gcd(b,a%b);
    }
    static class Edge
    {
        int start;
        int end;
        int weight;
        Edge(int s, int e, int w)
        {
            this.start = s;
            this.end = e;
            this.weight = w;
        }
    }
    static class Graph
    { 
        int numvertices;
        ArrayList<ArrayList<Edge>> adj;
        Graph(int v)
        { 
            this.numvertices = v;
            this.adj = new ArrayList<ArrayList<Edge>>();
            for (int i=0; i<numvertices; ++i)
                this.adj.add(new ArrayList<Edge>());
        }
        void addEdge(int startEdge, int toEdge, int weight) 
        {
            this.adj.get(startEdge).add(new Edge(startEdge, toEdge, weight));
        }
    }
    // public static void graphPrinter(Graph g)
    // {
    //     Iterator vertexIterator = g.adj.iterator();
    //     Iterator adjacentIterator;
    //     Edge adjacentedgeforprinter;
    //     while(vertexIterator.hasNext())
    //     {
    //         adjacentIterator = ((ArrayList<ArrayList<Edge>>)vertexIterator.next()).iterator();
    //         while(adjacentIterator.hasNext())
    //         {
    //             adjacentedgeforprinter = (Edge)adjacentIterator.next();
    //             System.out.println(adjacentedgeforprinter.start+" to "+adjacentedgeforprinter.end);
    //         }
    //     }
    // }
    public static int max(int a, int b)
    {
        if(a>=b)
            return a;
        else
            return b;
    }
    public static int min(int a, int b)
    {
        if(a>b)
            return b;
        else
            return a;
    }
    void modifiedDFS(int startEdge, Graph g, int godParent, int incomingGCD,int parent)
    {
        Iterator it = g.adj.get(startEdge).iterator();
        Edge nextEdge;
        if(startEdge>godParent)
        {
            // System.out.println("adding gcd for "+startEdge+" from "+godParent);
            sum += incomingGCD;
        }
        while(it.hasNext())
        {
            nextEdge = (Edge) it.next();
            if(nextEdge.end!=parent)
            {
                // System.out.println("calling dfs for "+nextEdge.end+" from being adjacent to "+nextEdge.start);
                modifiedDFS(nextEdge.end,g,godParent, gcd(incomingGCD,nextEdge.weight), nextEdge.start);
            }
        }
        return;
    }
    void modifiedDFS(int startEdge, Graph g, int godParent)
    {
        Iterator it = g.adj.get(startEdge).iterator();
        Edge nextEdge;
        while(it.hasNext())
        {
            nextEdge = (Edge) it.next();
            modifiedDFS(nextEdge.end, g, godParent, nextEdge.weight, nextEdge.start);
        }
        return;
    }
    void solution(Graph g)
    {
        for(int i=0;i<g.numvertices;i++)
            modifiedDFS(i, g, i);
    }
    public static void main (String[] args) throws java.lang.Exception
    {
        String numTestString = br1.readLine();
        int numTest= Integer.parseInt(numTestString);

        // System.out.println("number of tests are "+numTest);
        for(int t=0;t<numTest;t++)
        {
            sum = 0;
            int n = Integer.parseInt(br1.readLine());
            Graph g = new Graph(n);
            String [] temp;
            for(int i=0;i<n-1;i++)
            {
                temp = br1.readLine().split(" ");
                g.addEdge(Integer.parseInt(temp[0])-1, Integer.parseInt(temp[1])-1, Integer.parseInt(temp[2]));
                g.addEdge(Integer.parseInt(temp[1])-1, Integer.parseInt(temp[0])-1, Integer.parseInt(temp[2]));
            }
            // graphPrinter(g);
            Codechef c = new Codechef();
            c.solution(g);
            System.out.println(sum);
        }
    }
}

