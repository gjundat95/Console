//==============================================
// Author: jundat95
// Create date: 10/18/2015 9:38:56 PM
// Project: QuanLyKhachSan
// Description: coder jundat95
// Website: jundat95.blogspot.com
//==============================================
using System;
using System.Collections;
using System.Data;
using System.Data.SqlClient;
using AppCode.Connection;

namespace AppCode.DataAccess
{
    public abstract class SqlHelper
    {
 
        private static Hashtable parasCache = Hashtable.Synchronized(new Hashtable());
 
        public static void ExecuteNonQuery(CommandType cmdCommandType, string cmdCommandString, params SqlParameter[] cmdParameters)
        {
            SqlCommand cmdCommand = new SqlCommand();
            SqlConnection connect = new SqlConnection(ConnectionString.Text);
            try
            {
                PrepareCommand(cmdCommand, connect, null, cmdCommandType, cmdCommandString, cmdParameters);
                cmdCommand.ExecuteNonQuery();
                cmdCommand.Parameters.Clear();
                if (connect.State == ConnectionState.Open) connect.Close();
            }
            catch (SqlException ex)
            {
                if (connect.State == ConnectionState.Open)
                {
                    connect.Close();
                    SqlConnection.ClearPool(connect);
                }
                throw ex;
            }
        }
 
        public static DataTable ExecuteData(CommandType cmdCommandType, string cmdCommandString, params SqlParameter[] cmdParameters)
        {
            SqlCommand cmdCommand = new SqlCommand();
            SqlConnection connect = new SqlConnection(ConnectionString.Text);
            try
            {
                DataTable dattTopic = new DataTable();
                SqlDataAdapter dataTopic = new SqlDataAdapter(cmdCommand);
                PrepareCommand(cmdCommand, connect, null, cmdCommandType, cmdCommandString, cmdParameters);
                cmdCommand.ExecuteNonQuery();
                dataTopic.Fill(dattTopic);
                cmdCommand.Parameters.Clear();
                if (connect.State == ConnectionState.Open) connect.Close();
                return dattTopic;
            }
            catch (SqlException ex)
            {
                if (connect.State == ConnectionState.Open)
                {
                    connect.Close();
                    SqlConnection.ClearPool(connect);
                }
                throw ex;
            }
        }
 
        public static SqlDataReader ExecuteReader(CommandType cmdCommandType, string cmdCommandString, params SqlParameter[] cmdParameters)
        {
            SqlCommand cmdCommand = new SqlCommand();
            SqlConnection connect = new SqlConnection(ConnectionString.Text);
            try
            {
                PrepareCommand(cmdCommand, connect, null, cmdCommandType, cmdCommandString, cmdParameters);
                SqlDataReader datrDataReader = cmdCommand.ExecuteReader(CommandBehavior.CloseConnection);
                cmdCommand.Parameters.Clear();
                return datrDataReader;
            }
            catch (SqlException ex)
            {
                if (connect.State == ConnectionState.Open)
                {
                    connect.Close();
                    SqlConnection.ClearPool(connect);
                }
                throw ex;
            }
        }
 
        private static void PrepareCommand(SqlCommand cmdCommand, SqlConnection connConnection, SqlTransaction trasTransaction, CommandType cmdCommandType, string cmdCommandString, SqlParameter[] cmdParameters)
        {
            if (connConnection.State != ConnectionState.Open)
            {
                connConnection.Open();
            }
            cmdCommand.Connection = connConnection;
            cmdCommand.CommandText = cmdCommandString;
            if (trasTransaction != null)
            {
                cmdCommand.Transaction = trasTransaction;
            }
 
            cmdCommand.CommandType = cmdCommandType;
            if (cmdParameters != null)
            {
                foreach (SqlParameter para in cmdParameters)
                {
                    cmdCommand.Parameters.Add(para);
                }
            }
        }
 
        public static void PrepareCommand(SqlCommand cmdCommand, CommandType cmdCommandType, string cmdCommandString, SqlParameter[] cmdParameters)
        {
            cmdCommand.Parameters.Clear();
            cmdCommand.CommandType = cmdCommandType;
            cmdCommand.CommandText = cmdCommandString;
            if (cmdParameters != null)
                foreach (SqlParameter para in cmdParameters)
                    cmdCommand.Parameters.Add(para);
        }
 
        public static void CacheParameters(string cacheKey, params SqlParameter[] cmdParameters)
        {
            parasCache[cacheKey] = cmdParameters;
        }
 
        public static SqlParameter[] GetCachedParameters(string cacheKey)
        {
            SqlParameter[] cachedParms = (SqlParameter[])parasCache[cacheKey];
 
            if (cachedParms == null)
            {
                return null;
            }
            SqlParameter[] clonedParms = new SqlParameter[cachedParms.Length];
            for (int i = 0, j = cachedParms.Length; i < j; i++)
            {
                clonedParms[i] = (SqlParameter)((ICloneable)cachedParms[i]).Clone();
            }
            return clonedParms;
        }
 
    }
}
