package PhanSo;

import java.util.Scanner;

public class PhanSo
{
	private Scanner input = new Scanner(System.in);
	public int tu;
	public int mau;
	
	public PhanSo(int tu, int mau) {
		super();
		this.tu = tu;
		this.mau = mau;
	}
	public PhanSo(){}
	
	public void Nhap()
	{
		System.out.print("Nhap phan so duoi dang A/B: ");
		String temp = input.nextLine();
		String ps[]  = temp.split("/");
		this.tu = Integer.parseInt(ps[0].toString());
		this.mau = Integer.parseInt(ps[1].toString());
	}
	
	public void Xuat()
	{
		if(mau==1)
			System.out.print("Phan So La: "+this.tu);	
		else
			System.out.print("Phan So La: "+this.tu+"/"+this.mau);
	}
	
	public void Cong(PhanSo ps)
	{
		this.tu = this.mau*ps.tu + this.tu*ps.mau;
		this.mau = this.mau*ps.mau;
		int temp = UCLN(tu,mau);
		if(temp == 1)
			return;
		else
		{
			this.tu /= temp;
			this.mau /= temp;
		}
	}
	
	public int UCLN(int a, int b)
	{
		
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
