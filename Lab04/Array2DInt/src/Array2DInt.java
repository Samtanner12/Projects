import java.util.Arrays;

public class Array2DInt implements Array2DIntADT {
        //int[][] array = new int[3][3];

        public void set(int column, int row,int value,int[][] array){
            array[row][column]=value;
        }


    public boolean isEmpty(int[][] array) {
          int  num =0;
        for(int i =0; i<3; i++){
            for(int j=0; j<3;j++){
                if(array[i][j]!=0){
                    num++;
                }
            }
        }
        if(num!=0){
            return false;
        }
        else{
            return true;
        }
    }


    public void reinitialize(int[][] array) {
         for(int i =0; i<3; i++){
             for(int j=0; j<3;j++){
                 array[i][j]=0;
             }
         }

    }


    public void setElementToZero(int column, int row,int[][] array) {
        array[row][column]=0;
    }


    public int numInt(int[][] array) {
           int arrayLen = 0;
            for(int i=0;i<3;i++) {
                arrayLen+= array[i].length;
            }
            return arrayLen;
    }


    public int get(int column, int row,int[][] array) {
        return array[row][column];
    }


    public void deleteInt(int column, int row,int[][] array) {
        array[row][column] = 0;
    }

    public String printArray(int[][] array) {
        return(Arrays.deepToString(array).replace("], ", "]\n").replace("[[", "[").replace("]]", "]"));
    }


    public String rowGet( int row,int[][] array) {

            String rowContents ="";
            rowContents = rowContents +", "+array[row][0];
            rowContents = rowContents +", "+array[row][1];
            rowContents = rowContents +", "+array[row][2];
            return rowContents;

    }


    public void rowSet( int row, int val1, int val2, int val3,int[][] array) {
            array[row][0]=val1;
            array[row][1]=val2;
            array[row][2]=val3;

    }


    public String columnGet(int column,int[][] array) {
        String columnContents ="";
        columnContents = columnContents +", "+array[0][column];
        columnContents = columnContents +", "+array[1][column];
        columnContents = columnContents +", "+array[2][column];
        return columnContents;

    }


    public void columnSet(int column, int val1, int val2, int val3,int[][] array) {
        array[0][column]=val1;
        array[1][column]=val2;
        array[2][column]=val3;
    }

    public static void main(String[] args){
            Array2DInt myArray = new Array2DInt();
            int[][] array = new int[3][3];
            System.out.println(myArray.printArray(array));
        System.out.println();
        System.out.println(myArray.columnGet(2,array));
        myArray.columnSet(2,1,2,3,array);
        System.out.println();
        System.out.println(myArray.printArray(array));
        System.out.println();
        System.out.println(myArray.columnGet(2,array));
        myArray.set(1,1,69,array);
        System.out.println();
        System.out.println(myArray.printArray(array));
        myArray.rowSet(0,12,13,14,array);
        myArray.deleteInt(0,0,array);
        System.out.println();
        System.out.println(myArray.printArray(array));
        System.out.println();
        System.out.println(myArray.get(0,0,array));
        System.out.println();
        System.out.println(myArray.rowGet(0,array));
        System.out.println();
        System.out.println(myArray.numInt(array));
        System.out.println();
        System.out.println(myArray.isEmpty(array));

        myArray.reinitialize(array);
        System.out.println();
        System.out.println(myArray.printArray(array));
        System.out.println();
        System.out.println(myArray.isEmpty(array));



    }
}
