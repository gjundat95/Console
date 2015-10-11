package ToanHoc;

public class ToanHoc
{

	/*
	 * Số hoàn hảo là số có tổng các ước < nó.
	 * Cộng lại == Chính nó
	 */
	public static boolean soHoanHao(int n)
	{
		int tong = 0;
		
		for(int i = 1 ; i < n; i++)
		{
			if(n%i==0)
				tong += i;
		}
		
		if(tong ==n )
			return true;
		return false;
	}
	
	/*
	 * Số chính phương là số (CanBac2(a))^2 = a
	 */
	public static boolean soChinhPhuong(int n)
	{
		int temp = 0;
		temp = (int)Math.sqrt(n);
		if(temp*temp == n)
			return true;
		return false;
	}
	
	// So chia het cho 2 va 5 la so tam cung == 0
	public static boolean chiaHet25(int n)
	{
		if(n==0)
			return false;
		else
			if(n % 10 == 0)
				return true;
		return false;
	}
	
	/*
	 * Dãy Fibolaci 
	 * n = 0 :f = 0
	 * n =1,2 :f = 1
	 * n >2 :f = f(n-1) +f(n-2)
	 */
	public static int tinhFibonacci(int n)
	{
		if(n == 0 ) return 0;
		if(n == 1 ) return 1;
		if(n == 2) return 1;
		return tinhFibonacci(n-1)+tinhFibonacci(n-2);
		
	}
}
