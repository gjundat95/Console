package PhanSo;

public class XuLyPhanSo 
{
	private PhanSo ps1 = new PhanSo();
	private PhanSo ps2 = new PhanSo();
	
	public PhanSo Cong()
	{
		System.out.println("Cong hai phan so:");
		ps1.Nhap();
		ps2.Nhap();
		
		PhanSo ps = new PhanSo();
		ps.tu = ps1.mau*ps2.tu + ps1.tu*ps2.mau;
		ps.mau = ps1.mau*ps2.mau;
		int temp = UCLN(ps);
		if(temp == 1)
		return ps;
		else
		{
			ps.tu /= temp;
			ps.mau /= temp;
			return ps;
		}
	}
	
	public int UCLN(PhanSo ps)
	{
		int a,b;
		a = ps.mau;
		b = ps.tu;
		
		if(a == 0 || b ==0)
			return 1;
		
		while(a != b)
		{
			if(a > b)
				a -= b;
			else
				b -= a;
			
		}
		return a;
	}
	
}
