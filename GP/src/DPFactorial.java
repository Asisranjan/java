
public class DPFactorial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(factorial(7));
	}
	
	private static int factorial(int x) {
		if (x == 0 )
			return 1;
			
		return x * factorial(x - 1);
	}

}
