import java.util.Random;

public class Index{

	public static void main(String[] args){
		int[] x = new int[1000];
		Random r = new Random();
		for (int i = 0; i < 1000; i++){
			x[i] = r.nextInt();
		}
		for (int i = 0; i < 1000; i++)
			for (int j = i; j < 1000; j++)
				if (x[i] > x[j]){
					int temp = x[i];
					x[i] = x[j];
					x[j] = temp;
				}
		for (int i : x){
			System.out.println(i);
		}
	}

}

