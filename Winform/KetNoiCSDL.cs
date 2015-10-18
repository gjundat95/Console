using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Data.SqlClient;
using System.Data;

namespace QLBH
{
    class KetNoiCSDL
    {
        public static string strCon = @"Data Source=JUNDAT95-PC\SQLEXPRESS;Initial Catalog=QLBH;Integrated Security=True";

        public static void thuchienlenh(string _query){
            SqlConnection Con = new SqlConnection(strCon);
            Con.Open();
            SqlCommand commmad = new SqlCommand(_query,Con);
            commmad.ExecuteNonQuery();
            Con.Close();
            
        }

        public static DataTable getData(string _query) {
            SqlConnection Con = new SqlConnection(strCon);
            Con.Open();
            SqlDataAdapter da = new SqlDataAdapter(_query,Con);
            DataTable dt = new DataTable();
            da.Fill(dt);
            return dt;
        }
    }
}
