public class Index{

	public static void main(String[] args){
	int g = 0;
	int row = 4;
	int col = 7;
           for (int s = 0; s < row; s++) {
               System.out.println("Row Pass");
               for (int c = 0; c < col; c++) {
                   System.out.println("Col Pass");
                   g++;
		   System.out.printf("g: %d s: %d c: %d\n", g, s, c);
               }
           }
	}

}

