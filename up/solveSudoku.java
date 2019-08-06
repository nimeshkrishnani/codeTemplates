
import java.lang.*;
import java.util.*;
import java.io.*;

class Codechef
{
	static BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
	static Scanner sc = new Scanner(System.in);

	static void printSudoku(int [][] sudoku)
	{
		for(int i=0;i<9;i++)
		{
			for(int j=0;j<9;j++)
				System.out.print(sudoku[i][j]+" ");
// 			System.out.println("");
		}
		return;
	}

	static boolean columnChecker(int [][] sudoku, int row, int col)
	{
		for(int i=0;i<9;i++)
			if(i!=row&&sudoku[i][col]==sudoku[row][col])
				return false;
		return true;
	}
	static boolean rowChecker(int [][] sudoku, int row, int col)
	{
		for(int i=0;i<9;i++)
			if(i!=col&&sudoku[row][i]==sudoku[row][col])
				return false;
		return true;
	}
	static boolean boxChecker(int [][] sudoku, int row, int col)
	{
		int i = (row/3)*3;
		int j = (col/3)*3;
		// System.out.println(" box checking row is "+i+" and column is "+j);
		// System.out.println("incoming row and column are "+row+" and "+col);
		for(int k=i;k<i+3;k++)
			for(int l=j;l<j+3;l++)
				if(sudoku[row][col]==sudoku[k][l])
					if(!(k==row&&l==col))
					{
						// System.out.println("checked for "+k+","+l);
						return false;
					}
		return true;
	}
	
	static boolean sudokuChecker(int [][] sudoku, int row, int col)
	{
		boolean complete = true;
		if(!columnChecker(sudoku,row,col)||!rowChecker(sudoku,row,col)||!boxChecker(sudoku,row,col))
					return false;
		for(int i=0;i<9;i++)
			for(int j=0;j<9;j++)
				if(sudoku[i][j]==0)
					if(find(sudoku, i, j))
						return true;
					else
						return false;
		return true;
	}

	static boolean find(int [][] sudoku, int i, int j)
	{
		boolean sudokuComplete = false;
		for(int trying = 1;trying<10;trying++)
		{
			// System.out.println("trying "+trying+" at "+i+","+j);
			sudoku[i][j] = trying;
			if(sudokuChecker(sudoku,i,j))
			{
				sudokuComplete = true;
				break;
			}
			if(!sudokuComplete)
			sudoku[i][j] = 0;
		}
		if(sudokuComplete)
			return true;
		else
			return false;
	}

	public static void main (String[] args) throws java.lang.Exception
	{
		int numTest= sc.nextInt();
	    // System.out.println("number of tests are "+numTest);
	    int [][] sudoku = new int[9][9];
	    boolean initialized = false;
	    for(int t=0;t<numTest;t++)
	    {
	    	initialized = false;
	    	for(int i=0;i<9;i++)
	    		for(int j=0;j<9;j++)
	    			sudoku[i][j] = sc.nextInt();

	    	for(int i=0;i<9&&!initialized;i++)
	    		for(int j=0;j<9&&!initialized;j++)
	    			if(sudoku[i][j]==0)
	    			{
	    				initialized = true;
	    				find(sudoku, i, j);
	    			}
			printSudoku(sudoku);
		}
	}
}
