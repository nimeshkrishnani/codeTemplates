import java.lang.*;
import java.util.*;
import java.io.*;


class Codechef
{
	static BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
	static Scanner sc = new Scanner(System.in);
	static int callcount = 0;

	void printArrayList(ArrayList<String> inp)
	{
		for(int i=0;i<inp.size();i++)
				System.out.print(inp.get(i));
		System.out.print(" ");
		return;
	}

	void moveRat(int [][] maze, boolean[][] currentVisits, int currentRow, int currentCol, ArrayList<String> moves, int n)
	{
		// System.out.println("call count "+(++callcount));
		if(currentRow==n-1&&currentCol==n-1)
		{
			printArrayList(moves);
			return;
		}
		// System.out.println("current row and current column are "+currentRow+" and "+currentCol);
		currentVisits[currentRow][currentCol]= true;
		for(int i=1;i<=4;i++)
			switch(i)
		{
			case 1:
				if(currentCol<n-1&&currentVisits[currentRow][currentCol+1]==false&&maze[currentRow][currentCol+1]==1)
				{
					moves.add("R");
					moveRat(maze, currentVisits, currentRow,currentCol+1, moves, n);
					moves.remove(moves.size()-1);
				}
				continue;
			case 2:
				if(currentRow<n-1&&currentVisits[currentRow+1][currentCol]==false&&maze[currentRow+1][currentCol]==1)
				{
					moves.add("D");
					moveRat(maze,currentVisits,currentRow+1,currentCol, moves, n);
					moves.remove(moves.size()-1);
				}
				continue;
			case 3:
				if(currentCol>0&&currentVisits[currentRow][currentCol-1]==false&&maze[currentRow][currentCol-1]==1)
				{
					moves.add("L");
					moveRat(maze,currentVisits,currentRow,currentCol-1, moves, n);
					moves.remove(moves.size()-1);
				}
				continue;
			case 4:
				if(currentRow>0&&currentVisits[currentRow-1][currentCol]==false&&maze[currentRow-1][currentCol]==1)
				{
					moves.add("U");
					moveRat(maze,currentVisits,currentRow-1,currentCol, moves, n);
					moves.remove(moves.size()-1);
				}
				continue;
		}
	}
	public static void main (String[] args) throws java.lang.Exception
	{
		int numTest= sc.nextInt();
	    int [][] maze;
	    int n;
	    boolean [][] currentVisits;
	    Codechef c = new Codechef();
	    for(int t=0;t<numTest;t++)
	    {
	    	n = sc.nextInt();
	    	maze = new int[n][n];
	    	currentVisits = new boolean[n][n];
	    	for(int i=0;i<n;i++)
	    		for(int j=0;j<n;j++)
	    			maze[i][j] = sc.nextInt();
	    	// currentVisits[0][0] = true;
	    		// System.out.println(Arrays.deepToString(maze));
	    	ArrayList<String> inp = new ArrayList<String>();
	    	c.moveRat(maze, currentVisits, 0, 0, inp, n);
	    	System.out.println("");
		}
	}
}
