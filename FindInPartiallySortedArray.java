/*In a 2-D matrix, every row is increasingly sorted from left to right, and every column is
increasingly sorted from top to bottom. Please implement a function to check whether a number is in such a
matrix or not. For example, all rows and columns are increasingly sorted in the following matrix. It returns true if it
tries to find number 7, but it returns false if it tries to find number 5.
1 2 8 9
2 4 9 12
4 7 10 13
6 8 11 15*/

public class FindInPartiallySortedArray{
	
	private static void test(String testName, int [][] matrix, int key, boolean expected){
		System.out.println(testName + " begins: ");

		if(find(matrix, key) == expected)
			System.out.print("Passed\n");
		else
			System.out.print("FAILED\n");
	}

	 private static void test1(){
        int matrix[][] = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        test("Test1", matrix, 7, true);
    }

    //  1   2   8   9
    //  2   4   9   12
    //  4   7   10  13
    //  6   8   11  15
    // The value to be found, 5, is not in the matrix;
    private static void test2(){
        int matrix[][] = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        test("Test2", matrix, 5, false);
    }
    
    //  1   2   8   9
    //  2   4   9   12
    //  4   7   10  13
    //  6   8   11  15
    // The value to be found, 1, is the minimum in the matrix
    private static void test3(){
        int matrix[][] = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        test("Test3", matrix, 1, true);
    }
    
    //  1   2   8   9
    //  2   4   9   12
    //  4   7   10  13
    //  6   8   11  15
    // The value to be found, 15, is the maximum in the matrix
    private static void test4(){
        int matrix[][] = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        test("Test4", matrix, 15, true);
    }
    
    //  1   2   8   9
    //  2   4   9   12
    //  4   7   10  13
    //  6   8   11  15
    // The value to be found, 0, is less than the minimum in the matrix
    private static void test5(){
        int matrix[][] = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        test("Test5", matrix, 0, false);
    }
    
    //  1   2   8   9
    //  2   4   9   12
    //  4   7   10  13
    //  6   8   11  15
    // The value to be found, 16, is greater than the maximum in the matrix
    private static void test6(){
        int matrix[][] = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        test("Test6", matrix, 16, false);
    }
    
    //  1   2   8   9   14  15
    //  2   4   9   12  16  23
    //  4   7   10  13  21  25
    //  6   8   11  15  23  27
    // The value to be found, 21, is in the matrix
    private static void test7(){
        int matrix[][] = {{1, 2, 8, 9, 14, 15}, {2, 4, 9, 12, 16, 23}, {4, 7, 10, 13, 21, 25}, {6, 8, 11, 15, 23, 27}};
        test("Test7", matrix, 21, true);
    }
    
    //  1   2   8   9
    //  2   4   9   12
    //  4   7   10  13
    //  6   8   11  15
    //  8   10  13  20
    //  12  13  17  25
    //  19  22  25  30
    // The value to be found, 18, is not in the matrix
    private static void test8(){
        int matrix[][] = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}, {8, 10, 13, 20}, {12, 13, 17, 25}, {19, 22, 25, 30}};
        test("Test8", matrix, 18, false);
    }
    
    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
        test7();
        test8();
    }

	private static boolean find(int [][] matrix, int key){
		boolean found = false;
		int row = 0;
		int col = matrix[0].length - 1;

		while(row < matrix.length && col >= 0){
			if(matrix[row][col] == key){
				found = true; 
				break;
			}

			if(matrix[row][col] > key){
				--col;
			}
			else{
				++row;
			}
		}
	return found;
	}
}