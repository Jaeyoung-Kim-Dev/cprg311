
public class ex6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[3];
		arr[0] = 1;
		arr[1] = 2;
		arr[2] = 4;
		int k = sum(arr, 3);
		System.out.print(k);
	}

	public static int sum(int a[], int n) {
		if(n <= 0) //base case
		return 0;
		else //reduce the problem size
		return a[n - 1] + sum(a, n - 1);
		} //sum()
}
