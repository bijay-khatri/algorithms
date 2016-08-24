/* Island Counter */
/* Given a 2D matrix M, filled with either 0s or 1s, count the number of islands of 1s in M.
An island is a group of adjacent values that are all 1s. Every cell in M can be adjacent to the 4 cells that are next to it on the same row or column.

Explain and code the most efficient solution possible and analyze its runtime complexity.

Example: the matrix below has 6 islands:

        0  1  0  1  0
        0  0  1  1  1
        1  0  0  1  0
        0  1  1  0  0
        1  0  1  0  1

*/
public class IslandCounter{
	public static void main(String [] args){
		IslandCounter obj = new IslandCounter();
		obj.test1();
		obj.test2();
		obj.test3();
		obj.test4();

	}

	private void test(String testName, int [][] matrix, int noOfIsland, boolean expected){
		System.out.print(testName + " Begins...");

		if(expected == (noOfIsland == islandCounter(matrix))) print("pass");
		else print("FAIL");
	}

	private int islandCounter(int [][] matrix){
		if(matrix == null) throw new NullPointerException("Null is not allowed");
		if(matrix.length == 0) return 0;
	
		int counter = 0;
		int rows = matrix.length; //2
		int cols = matrix[0].length;//2
	
		for(int i = 0; i < rows; i++){
			for(int j = 0; j < cols; j++){
				if(matrix[i][j] == 1){
					counter++; //1
					discoverIsland(matrix, i, j); // dfs call 1 per connected components
				}
			}
		}
		return counter;
	}

	private void discoverIsland(int [][] matrix, int r, int c){ //r =1, c = 1
		int rows = matrix.length; //2
		int cols = matrix[0].length; //2
		
		//base case
		if(r < 0 || r > rows - 1 || c < 0 || c > cols - 1 || matrix[r][c] <=0) return;
		
		matrix[r][c] = -1 ; // setting a flag as visited
		discoverIsland(matrix, r + 1, c); // (matrix, 1, 0)
		discoverIsland(matrix, r - 1, c); // (matrix, -1,0)
		discoverIsland(matrix, r, c +1); // matrix(0, 1)
		discoverIsland(matrix, r, c - 1); //matrix(0,-1)
	}

	private void test1(){
		test("Test1", new int[][]{{0,1},{1,0}}, 2, true);
	}

	private void test2(){
		test("Test2", new int[][]{{1,1},{1,0}}, 2, false);
	}

	private void test3(){
		test("Test3", new int[][]{{1,1},{1,0}}, 1, true);
	}

	private void test4(){
		int [][] matrix = {
							{1, 1, 0, 0, 1},
							{0 ,0 ,0 ,1 ,1},
							{1 ,0 ,1 ,0 ,1},
							{1, 0, 0 ,1 ,1}
	};
		test("Test4", matrix, 4, true);
	}
	private static void print(Object o){
		System.out.println(o);
	}
}