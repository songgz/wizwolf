package com.wizwolf.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public final class MLookupInfo implements Serializable {
    private static final Logger logger = LoggerFactory.getLogger(MLookupInfo.class);
    /**
     *  Cosntructor
     *  @param sqlQuery SQL query
     *  @param keyColumn key column
     *  @param zoomWindow zoom window
     *  @param zoomQuery zoom query
     */
    public MLookupInfo (String sqlQuery, String keyColumn, int zoomWindow, MQuery zoomQuery)
    {
        Query = sqlQuery;
        if (keyColumn == null)
            throw new IllegalArgumentException("MLookupInfo - sqlQuery is null");
        KeyColumn = keyColumn;
        if (keyColumn == null)
            throw new IllegalArgumentException("MLookupInfo - keyColumn is null");
        ZoomWindow = zoomWindow;
        ZoomQuery = zoomQuery;
    }   //  MLookupInfo

    /** Query           */
    public String       Query = null;
    /** Key Column      */
    public String       KeyColumn = "";
    /** Zoom Window     */
    public int          ZoomWindow;
    /** Zoom Query      */
    public MQuery       ZoomQuery = null;

    /** Direct Access Query */
    public String       QueryDirect = "";
    /** Parent Flag     */
    public boolean      IsParent = false;
    /** Validation code */
    public String       Validation = "";
    /** Validation flag */
    public boolean      IsValidated = true;

    public Properties ctx = null;
    public int          WindowNo;
    public int          AD_Column_ID;
    public boolean      IsProcess;
    public int          DisplayType;

    /**
     * 	String representation
     * 	@return info
     */
    public String toString()
    {
        StringBuffer sb = new StringBuffer ("MLookupInfo[")
                .append(KeyColumn).append(" - Direct=").append(QueryDirect)
                .append("]");
        return sb.toString();
    }	//	toString

    /*************************************************************************/

    /**
     *  Get first AD_Reference_ID of a matching Reference Name.
     *  Can have SQL LIKE placeholders.
     *  (This is more a development tool than used for production)
     *  @param referenceName reference name
     *  @return AD_Reference_ID
     */
//    public static int getAD_Reference_ID (String referenceName)
//    {
//        int retValue = 0;
//        String sql = "SELECT AD_Reference_ID,Name,ValidationType,IsActive FROM AD_Reference WHERE Name LIKE ?";
//        try
//        {
//            PreparedStatement pstmt = DB.prepareStatement(sql);
//            pstmt.setString(1, referenceName);
//            ResultSet rs = pstmt.executeQuery();
//            //
//            int i = 0;
//            int id = 0;
//            String refName = "";
//            String validationType = "";
//            boolean isActive = false;
//            while (rs.next())
//            {
//                id = rs.getInt(1);
//                if (i == 0)
//                    retValue = id;
//                refName = rs.getString(2);
//                validationType = rs.getString(3);
//                isActive = rs.getString(4).equals("Y");
//                Log.trace(Log.l3_Util, "AD_Reference Name=" + refName + ", ID=" + id + ", Type=" + validationType + ", Active=" + isActive);
//            }
//            rs.close();
//            pstmt.close();
//        }
//        catch (SQLException e)
//        {
//            Log.error("MLookupInfo.getAD_Reference_ID", e);
//        }
//        return retValue;
//    }   //  getAD_Reference_ID

    /**
     *  Get first AD_Column_ID of matching ColumnName.
     *  Can have SQL LIKE placeholders.
     *  (This is more a development tool than used for production)
     *  @param columnName column name
     *  @return AD_Column_ID
     */
//    public static int getAD_Column_ID (String columnName)
//    {
//        int retValue = 0;
//        String sql = "SELECT c.AD_Column_ID,c.ColumnName,t.TableName FROM AD_Column c, AD_Table t WHERE c.ColumnName LIKE ? AND c.AD_Table_ID=t.AD_Table_ID";
//        try
//        {
//            PreparedStatement pstmt = DB.prepareStatement(sql);
//            pstmt.setString(1, columnName);
//            ResultSet rs = pstmt.executeQuery();
//            //
//            int i = 0;
//            int id = 0;
//            String colName = "";
//            String tabName = "";
//            while (rs.next())
//            {
//                id = rs.getInt(1);
//                if (i == 0)
//                    retValue = id;
//                colName = rs.getString(2);
//                tabName = rs.getString(3);
//                Log.trace(Log.l3_Util, "AD_Column Name=" + colName + ", ID=" + id + ", Table=" + tabName);
//            }
//            rs.close();
//            pstmt.close();
//        }
//        catch (SQLException e)
//        {
//            Log.error("MLookupInfo.getAD_Column_ID", e);
//        }
//        return retValue;
//    }   //  getAD_Reference_ID

}
