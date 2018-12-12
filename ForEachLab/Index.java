import java.util.Random;
public class Index{
	public static void main(String[] args){
		Random r = new Random();
		int[][] x = new int [1000][1000];
		for (int i = 0; i < 1000; i++)
			for (int j = 0; j < 1000; j++)
				x[i][j] = r.nextInt();
		int sum = 0;
		for (int[] i : x)
			for (int j : i)
				sum += j;
		System.out.printf("Sum: %d\n", sum);
	}
}
