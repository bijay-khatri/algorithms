/* Find in Sorted Array */
/*In a 2-D matrix, every row is increasingly sorted from left to right, and the last number in each
row is not greater than the first number of the next row. A sample matrix follows. Please implement a function to
check whether a number is in such a matrix or not. It returns true if it tries to find the number 7 in the sample
matrix, but it returns false if it tries to find the number 12.
1 3 5
7 9 11
13 15 17*/
public class FindInSortedArray{
	private static void test1(){
		int [][] matrix = {{1, 3, 5}, {7, 9, 11}, {13, 15, 17}};
		test("Test1",matrix, 7, true);
	} 

	private static void test2(){
		int [][] matrix = {{1, 3, 5}, {7, 9, 11}, {13, 15, 17}};
		test("Test2",matrix, 1, true);
	}

	private static void test3(){
		int [][] matrix = {{1, 3, 5}, {7, 9, 11}, {13, 15, 17}};
		test("Test3",matrix, 17, true);
	}

	private static void test4(){
        int matrix[][] = {{1, 3, 5}, {7, 9, 11}, {13, 15, 17}};
        test("Test4", matrix, 6, false);
    }

     private static void test5(){
        int matrix[][] = {{1, 3, 5}, {7, 9, 11}, {13, 15, 17}};
        test("Test5", matrix, 0, false);
    }
    
    //  1   3   5
    //  7   9   11
    //  13  15  17
    // The value to be found, 18, is not in the matrix;
    private static void test6(){
        int matrix[][] = {{1, 3, 5}, {7, 9, 11}, {13, 15, 17}};
        test("Test6", matrix, 18, false);
    }

    private static void test7(){
        int matrix[][] ={{1}};
        test("Test7", matrix, 1, true);
    }
    
    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
        test7();
    }
    
    private static void test(String testName, int matrix[][], int value, boolean expected){
        System.out.print(testName + " begins: ");

        if(find(matrix, value) == expected)
            System.out.print("passed.\n");
        else
            System.out.print("FAILED.\n");
    }

    private static boolean findLinear(int[][] matrix, int key){
    	int row = matrix.length;
    	int col = matrix[0].length;

    	for(int i = 0; i < row; i++){
    		for(int j = 0; j < col; j++){
    			if(matrix[i][j] == key) return true;
    		}
    	}
    	return false;
    }

    public static boolean find(int [][]matrix, int key){
        int rows = matrix.length; //3
        int cols = matrix[0].length; //3
        int start = 0;
        int end = rows * cols - 1; //8

        while(start <= end){
            int mid = start + (end - start) / 2;
            int row = mid / cols; // 4 / 3 => 1
            int col = mid % cols; // 4 % 3 => 1

            if(matrix[row][col] == key) return true;
            if(matrix[row][col] < key) start = mid + 1;
            else end = mid - 1;
        }
        return false;
    }
}