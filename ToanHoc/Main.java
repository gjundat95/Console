package ToanHoc;

public class Main {

	public static void main(String[] args)
	{
		boolean isTrue1, isTrue2, isTrue3;
		int temp;
		
		isTrue1 = ToanHoc.soHoanHao(9);
		isTrue2 = ToanHoc.soChinhPhuong(9);
		isTrue3 = ToanHoc.chiaHet25(9);
		temp = ToanHoc.tinhFibonacci(9);
		System.out.println("So 9 La So : Chinh Phuong:"+isTrue2+"\nSo Hoan Hao:"+isTrue1+"\nChia het cho 2&5:"+isTrue3+"\nGia Tri Fibonacci"+temp);
	}

}
