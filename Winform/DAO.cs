using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Data;
using System.Data.SqlClient;
using DTO;

namespace DAO
{   
    public class SqlConnectionData
    {   
        public static SqlConnection HamKetNoi(){

            SqlConnection Conn = new SqlConnection(@"Data Source=JUNDAT\SQLEXPRESS;Initial Catalog=QuanLyThuVien;Integrated Security=True");
            return Conn;
        }
    }

    public class tblSach_DAO
    {
        /// <summary>
        /// Dung de lay du lieu tu DataBase
        /// </summary>
        /// <returns>Tra lai gia tri la mot Table</returns>
        public static DataTable getData() {

            SqlConnection Conn = SqlConnectionData.HamKetNoi();
            SqlCommand command = new SqlCommand("SPHienThiSach",Conn);
            command.CommandType = CommandType.StoredProcedure;
            Conn.Open();
            SqlDataAdapter da = new SqlDataAdapter();
            da.SelectCommand = command;
            DataTable dt = new DataTable();
            da.Fill(dt);
            Conn.Close();
            return dt;
        }

        /// <summary>
   /// Dung de them vao bang sach, qua Proc
   /// </summary>
   /// <param name="sach">Su dung Parameter de truyen bien vao Proc</param>
        public static void ThemSach(tblSach sach) {

            SqlConnection Conn = SqlConnectionData.HamKetNoi();
            SqlCommand cmd = new SqlCommand("SPThemSach",Conn);
            cmd.CommandType = CommandType.StoredProcedure;

            cmd.Parameters.Add("@MaS", SqlDbType.NVarChar, 50);
            cmd.Parameters.Add("@MaTL", SqlDbType.NVarChar, 50);
            cmd.Parameters.Add("@TenS", SqlDbType.NVarChar, 50);
            cmd.Parameters.Add("@DonGia", SqlDbType.Int);
            cmd.Parameters.Add("@SoLuongTon", SqlDbType.Int);
            cmd.Parameters.Add("@TacGia", SqlDbType.NVarChar, 50);
            cmd.Parameters["@MaS"].Value = sach.MaS;
            cmd.Parameters["@MaTL"].Value = sach.MaTL;
            cmd.Parameters["@TenS"].Value = sach.TenS;
            cmd.Parameters["@DonGia"].Value = sach.DonGia;
            cmd.Parameters["@SoLuongTon"].Value = sach.SoLuongTon;
            cmd.Parameters["@TacGia"].Value = sach.TacGia;

            Conn.Open();
            cmd.ExecuteNonQuery();
            Conn.Close();
        }

        /// <summary>
        /// Dung de ban mot cuon sach, kiem tra xem con sach de ban khong
        /// </summary>
        /// <param name="_MaS">Truyen vao bien _MaS</param>
        /// <param name="_SoLuongTon">Truyen vao bien _Soluongsach</param>
        public static void BanSach(string _MaS, int _SoLuongTon) {

            SqlConnection Conn = SqlConnectionData.HamKetNoi();
            SqlCommand cmd = new SqlCommand("SPBanSach",Conn);
            cmd.CommandType = CommandType.StoredProcedure;

            cmd.Parameters.Add("@MaS", SqlDbType.NVarChar, 50);
            cmd.Parameters.Add("@SoLuongton", SqlDbType.Int);
            cmd.Parameters["@MaS"].Value = _MaS;
            cmd.Parameters["@SoLuongTon"].Value = _SoLuongTon;

            Conn.Open();
            cmd.ExecuteNonQuery();
            Conn.Close();

        }

        /// <summary>
        /// Xoa mot dau sach
        /// </summary>
        /// <param name="_MaS">Truyen vao mot ma sach</param>
        public static void Xoa(string _MaS) {

            SqlConnection Conn = SqlConnectionData.HamKetNoi();
            SqlCommand cmd = new SqlCommand("SPXoaSach",Conn);
            cmd.CommandType = CommandType.StoredProcedure;

            cmd.Parameters.Add("@MaS", SqlDbType.NVarChar, 50);
            cmd.Parameters["@MaS"].Value = _MaS;
            Conn.Open();
            cmd.ExecuteNonQuery();
            Conn.Close();
        }

        /// <summary>
        /// Tim Sach theo ma sach
        /// </summary>
        /// <param name="_MaS">Truyen vao bien Ma Sach</param>
        /// <returns>Tra ve gia tri la mot bang.</returns>
        public static DataTable TimMaSach(string _MaS){
            
            SqlConnection Conn = SqlConnectionData.HamKetNoi();
            SqlCommand cmd = new SqlCommand("SPTimMaSach",Conn);
            cmd.CommandType =CommandType.StoredProcedure;

            cmd.Parameters.Add("@MaS", SqlDbType.NVarChar, 50);
            cmd.Parameters["@MaS"].Value = _MaS;
            Conn.Open();
            SqlDataAdapter da = new SqlDataAdapter();
            DataTable dt = new DataTable();
            da.SelectCommand = cmd;
            da.Fill(dt);
            Conn.Close();

            return dt;
        }
        /// <summary>
        /// Tim theo ten sach 
        /// </summary>
        /// <param name="_TenS">Truyen vao bien ten sach</param>
        /// <returns>Tra lai gia tri la mot bang</returns>
        public static DataTable TimTenSach(string _TenS) {

            SqlConnection Conn = SqlConnectionData.HamKetNoi();
            SqlCommand cmd = new SqlCommand("SPTimTenSach", Conn);
            cmd.CommandType = CommandType.StoredProcedure;

            cmd.Parameters.Add("@TenS", SqlDbType.NVarChar, 50);
            cmd.Parameters["@TenS"].Value = _TenS;
            Conn.Open();
            SqlDataAdapter da = new SqlDataAdapter();
            DataTable dt = new DataTable();
            da.SelectCommand = cmd;
            da.Fill(dt);
            Conn.Close();

            return dt;
        
        }

        public static bool KiemTraKhoaChinh(string _textBox) {
            bool check = false;
         
            string cPrimaryKey = "Select *From tblSach Where MaS = '"+_textBox+"' ";
            SqlConnection Conn = SqlConnectionData.HamKetNoi();
            SqlCommand cmd = new SqlCommand(cPrimaryKey,Conn);
            cmd.CommandType = CommandType.Text;
            Conn.Open();
            SqlDataReader dr = cmd.ExecuteReader();
            while (dr.Read()) {
                check = true;
            }

            return check;
        }

    }

    public class tblTheLoai_DAO 
    {
        /// <summary>
        /// Hien thi danh sach tat ca cac the loai
        /// </summary>
        /// <returns> Tra lai gia tri la mot bang</returns>
        public static DataTable getData() {
            SqlConnection Conn = SqlConnectionData.HamKetNoi();
            SqlCommand cmd = new SqlCommand("SPHienTheLoai",Conn);
            cmd.CommandType = CommandType.StoredProcedure;
            Conn.Open();
            SqlDataAdapter da = new SqlDataAdapter();
            DataTable dt = new DataTable();
            da.SelectCommand = cmd;
            da.Fill(dt);
            Conn.Close();
            return dt;
        }

        /// <summary>
        /// Them mot the loai vao tblTheLoai
        /// </summary>
        /// <param name="tl">Truyen Bien Vao Proc</param>
        public static void ThemTheLoai(tblTheLoai tl) {

            SqlConnection Conn = SqlConnectionData.HamKetNoi();
            SqlCommand cmd = new SqlCommand("SPThemTheLoai1",Conn);
            cmd.CommandType = CommandType.StoredProcedure;

            cmd.Parameters.Add("@MaTL", SqlDbType.NVarChar, 50);
            cmd.Parameters.Add("@TenTL", SqlDbType.NVarChar, 50);
            cmd.Parameters["@MaTL"].Value = tl.MaTL;
            cmd.Parameters["@TenTL"].Value = tl.TenTL;

            Conn.Open();
            cmd.ExecuteNonQuery();
            Conn.Close();
        }

        public static void XoaTheLoai(string _MaTL) {

            SqlConnection Conn = SqlConnectionData.HamKetNoi();
            SqlCommand cmd = new SqlCommand("SPXoaTheLoai", Conn);
            cmd.CommandType = CommandType.StoredProcedure;

            cmd.Parameters.Add("@MaTL", SqlDbType.NVarChar, 50);
            cmd.Parameters["@MaTL"].Value = _MaTL;
            Conn.Open();
            cmd.ExecuteNonQuery();
            Conn.Close();
        }

        /// <summary>
        /// Tim theo ma the loai
        /// </summary>
        /// <param name="_MaTL">Truyen vao mot bien ma the loai</param>
        /// <returns>Tra ve gia tri la mot bang</returns>
        public static DataTable TimMaTL(string _MaTL) {

            SqlConnection Conn = SqlConnectionData.HamKetNoi();
            SqlCommand cmd = new SqlCommand("SPTimMaTL",Conn);
            cmd.CommandType = CommandType.StoredProcedure;

            cmd.Parameters.Add("@MaTL", SqlDbType.NVarChar, 50);
            cmd.Parameters["@MaTL"].Value = _MaTL;
            Conn.Open();
            SqlDataAdapter da = new SqlDataAdapter();
            DataTable dt = new DataTable();
            da.SelectCommand = cmd;
            da.Fill(dt);
            Conn.Close();
            return dt;
        }

        public static DataTable TimTenTL(string _TenTL) {

            SqlConnection Conn = SqlConnectionData.HamKetNoi();
            SqlCommand cmd = new SqlCommand("SPTimTenTL",Conn);
            cmd.CommandType = CommandType.StoredProcedure;

            cmd.Parameters.Add("@TenTL", SqlDbType.NVarChar, 50);
            cmd.Parameters["@TenTL"].Value = _TenTL;
            Conn.Open();
            SqlDataAdapter da = new SqlDataAdapter();
            DataTable dt = new DataTable();
            da.SelectCommand = cmd;
            da.Fill(dt);
            Conn.Close();
            return dt;
        }
    }

}
