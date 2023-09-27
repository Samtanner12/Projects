public interface Array2DIntADT {

    public void set(int column, int row,int value,int[][] array);
    //inserts value aty specific position
    public boolean isEmpty(int[][] array);
    //checks if empty
    public void reinitialize(int[][] array);
    //reinitializes the array
    public void setElementToZero(int column, int row,int[][] array);
    //sets element to zero
    public int numInt(int[][] array);
    //checks the number of ints in the array
    public int get(int column, int row,int[][] array);
    //gets int at a specific position
    public void deleteInt(int column, int row,int[][] array);
    // deletes int at specific position
    public String printArray(int[][] array);
    //prints the array
    public String rowGet( int row,int[][] array);
    //gets row
    public void rowSet(int row, int val1, int val2, int val3,int[][] array);
    //sets row
    public String columnGet(int column,int[][] array);
    //gets column
    public void columnSet(int column, int val1, int val2, int val3,int[][] array);
    //sets column


}