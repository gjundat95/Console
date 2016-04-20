package DiemCao;

public class Main {

	public static void main(String[] args) {
		
		// Đường dẫn lưu trữ file điểm cao
		String url = "/opt/lampp/htdocs/diemcao.dat";
		NguoiChoi nc1 = new NguoiChoi(5, "Tinh Tinh");
		NguoiChoi nc2 = new NguoiChoi(1,"Doan Tinh");
		NguoiChoi nc3 = new NguoiChoi(2,"Thi Tinh");
		NguoiChoi nc4 = new NguoiChoi(3,"Ngo Tinh");
		NguoiChoi nc5 = new NguoiChoi(9,"Ngo Tinh");
		NguoiChoi nc = new NguoiChoi(4,"Ngo Tinh");
		DiemCao obj = new DiemCao();
		obj.addDiem(nc1);
		obj.addDiem(nc2);
		obj.addDiem(nc3);
		obj.addDiem(nc4);
		obj.addDiem(nc5);
		
		// Khởi Tạo Đối tượng lưu trữ điểm 
		BestCore bestCore = new BestCore(url);	
		// Sau khi chơi thua thì lưu thằng điểm cao vào 
		bestCore.LuuDiemCao(nc);
		
	}

}
