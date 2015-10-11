package DaGiac;

public class TamGiac extends DaGiac
{
	private double dienTich;
	
	public TamGiac()
	{
		this.soCanh = 3; // Tao thang tam giac cai, gan gia tri mac dinh canh cho no luon
	}
	
	
	@Override
	public void nhapCanhDG() 
	{
		
		dodaiCanh = new int[soCanh]; // Khoi tao mang do dai cac canh
		for(int i = 0; i < soCanh; i++)
		{
			System.out.println("Nhap vao canh thu "+(i+1)+" :");
			dodaiCanh[i] = Integer.parseInt(input.nextLine());
		}
	}

	public void hienThiDienTich()
	{
		double temp1,temp2;
		temp1 =(double)(dodaiCanh[0]+dodaiCanh[1]+dodaiCanh[2])/3;
		temp2 = (double)Math.sqrt(temp1*(temp1-dodaiCanh[0])*(temp1 - dodaiCanh[1]) * (temp1 - dodaiCanh[2]));
		System.out.println("Dien tich cua tam giac la: "+temp2);
		
	}
	
	public double getDienTich() {
		return dienTich;
	}
	public void setDienTich(double dienTich) {
		this.dienTich = dienTich;
	}
	
	
}
