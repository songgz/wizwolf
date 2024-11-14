package com.wizwolf.model;

import com.wizwolf.util.ValueNamePair;

import java.io.Serializable;
import java.util.ArrayList;

public class MQuery implements Serializable {

    public MQuery() {
    }

    public MQuery(String TableName)
    {
        m_TableName = TableName;
    }	//	MQuery

//    public MQuery(int AD_Table_ID)
//    {
//        String sql = "SELECT TableName FROM AD_Table WHERE AD_Table_ID=?";
//        try
//        {
//            PreparedStatement pstmt = DB.prepareStatement(sql);
//            pstmt.setInt (1, AD_Table_ID);
//            ResultSet rs = pstmt.executeQuery();
//            if (rs.next())
//                m_TableName = rs.getString(1);
//            else
//                Log.error("MQuery - Did not find AD_Table_ID=" + AD_Table_ID);
//            rs.close();
//            pstmt.close();
//        }
//        catch (SQLException e)
//        {
//            Log.error("MQuery", e);
//        }
//    }	//	MQuery


    /**	Table Name					*/
    private String		m_TableName = "";
    /**	List of Restrictions		*/
    private ArrayList m_list = new ArrayList();


    /*************************************************************************/

    public static final String	EQUAL = "=";
    public static final int		EQUAL_INDEX = 0;
    public static final String	NOT_EQUAL = "!=";
    public static final String	LIKE = " LIKE ";
    public static final String	NOT_LIKE = " NOT LIKE ";
    public static final String	GREATER = ">";
    public static final String	GREATER_EQUAL = ">=";
    public static final String	LESS = "<";
    public static final String	LESS_EQUAL = "<=";
    public static final String	BETWEEN = " BETWEEN ";
    public static final int		BETWEEN_INDEX = 8;

    public static final ValueNamePair[]	OPERATORS = new ValueNamePair[] {
            new ValueNamePair (EQUAL,			" = "),		//	0
            new ValueNamePair (NOT_EQUAL,		" != "),
            new ValueNamePair (LIKE,			" ~ "),
            new ValueNamePair (NOT_LIKE,		" !~ "),
            new ValueNamePair (GREATER,			" > "),
            new ValueNamePair (GREATER_EQUAL,	" >= "),	//	5
            new ValueNamePair (LESS,			" < "),
            new ValueNamePair (LESS_EQUAL,		" <= "),
            new ValueNamePair (BETWEEN,			" >-< ")	//	8
    };

    /*************************************************************************/

    /**
     * 	Add Restriction
     * 	@param ColumnName ColumnName
     * 	@param Operator Operator, e.g. = != ..
     * 	@param Code Code, e.g 0, All%
     *  @param InfoName Display Name
     * 	@param InfoDisplay Display of Code (Lookup)
     */
    public void addRestriction (String ColumnName, String Operator,
                                Object Code, String InfoName, String InfoDisplay)
    {
        Restriction r = new Restriction (ColumnName, Operator,
                Code, InfoName, InfoDisplay);
        m_list.add(r);
    }	//	addRestriction

    /**
     * 	Add Restriction
     * 	@param ColumnName ColumnName
     * 	@param Operator Operator, e.g. = != ..
     * 	@param Code Code, e.g 0, All%
     */
    public void addRestriction (String ColumnName, String Operator,
                                Object Code)
    {
        Restriction r = new Restriction (ColumnName, Operator,
                Code, null, null);
        m_list.add(r);
    }	//	addRestriction

    /**
     * 	Add Restriction
     * 	@param ColumnName ColumnName
     * 	@param Operator Operator, e.g. = != ..
     * 	@param Code Code, e.g 0
     */
    public void addRestriction (String ColumnName, String Operator,
                                int Code)
    {
        Restriction r = new Restriction (ColumnName, Operator,
                new Integer(Code), null, null);
        m_list.add(r);
    }	//	addRestriction

    /**
     * 	Add Range Restriction (BETWEEN)
     * 	@param ColumnName ColumnName
     * 	@param Code Code, e.g 0, All%
     * 	@param Code_to Code, e.g 0, All%
     *  @param InfoName Display Name
     * 	@param InfoDisplay Display of Code (Lookup)
     * 	@param InfoDisplay_to Display of Code (Lookup)
     */
    public void addRangeRestriction (String ColumnName,
                                     Object Code, Object Code_to,
                                     String InfoName, String InfoDisplay, String InfoDisplay_to)
    {
        Restriction r = new Restriction (ColumnName, Code, Code_to,
                InfoName, InfoDisplay, InfoDisplay_to);
        m_list.add(r);
    }	//	addRestriction

    /**
     * 	Add Range Restriction (BETWEEN)
     * 	@param ColumnName ColumnName
     * 	@param Code Code, e.g 0, All%
     * 	@param Code_to Code, e.g 0, All%
     */
    public void addRangeRestriction (String ColumnName,
                                     Object Code, Object Code_to)
    {
        Restriction r = new Restriction (ColumnName, Code, Code_to,
                null, null, null);
        m_list.add(r);
    }	//	addRestriction

    /**
     * 	Add Restriction
     * 	@param r Restriction
     */
    protected void addRestriction (Restriction r)
    {
        m_list.add(r);
    }	//	addRestriction

    /**
     * 	Add Restriction
     * 	@param whereClause SQL WHERE clause
     */
    public void addRestriction (String whereClause)
    {
        if (whereClause == null || whereClause.trim().length() == 0)
            return;
        Restriction r = new Restriction (whereClause);
        m_list.add(r);
    }	//	addRestriction

    /*************************************************************************/

    /**
     * 	Create the resulting Query WHERE Clause
     * 	@return Where Clause
     */
    public String getWhereClause ()
    {
        return getWhereClause(false);
    }	//	getWhereClause

    /**
     * 	Create the resulting Query WHERE Clause
     * 	@param fullyQualified fully qualified Table.ColumnName
     * 	@return Where Clause
     */
    public String getWhereClause (boolean fullyQualified)
    {
        boolean qualified = fullyQualified;
        if (qualified && (m_TableName == null || m_TableName.length() == 0))
            qualified = false;
        //
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < m_list.size(); i++)
        {
            Restriction r = (Restriction)m_list.get(i);
            if (i != 0)
                sb.append(r.andCondition ? " AND " : " OR ");
            if (qualified)
                sb.append(r.getSQL(m_TableName));
            else
                sb.append(r.getSQL(null));
        }
        return sb.toString();
    }	//	getWhereClause

    /**
     * 	Create Query WHERE Clause.
     *  Not fully qualified
     * 	@param index restriction index
     * 	@return Where Clause or "" if not valid
     */
    public String getWhereClause (int index)
    {
        StringBuffer sb = new StringBuffer();
        if (index >= 0 && index < m_list.size())
        {
            Restriction r = (Restriction)m_list.get(index);
            sb.append(r.getSQL(null));
        }
        return sb.toString();
    }	//	getWhereClause

    /**
     * 	Get Restriction Count
     * 	@return number of restricctions
     */
    public int getRestrictionCount()
    {
        return m_list.size();
    }	//	getRestrictionCount

    /**
     * 	Is Query Active
     * 	@return true if number of restricctions > 0
     */
    public boolean isActive()
    {
        return m_list.size() != 0;
    }	//	isActive

    /**
     * 	Get Table Name
     * 	@return Table Name
     */
    public String getTableName ()
    {
        return m_TableName;
    }	//	getTableName

    /**
     * 	Set Table Name
     * 	@param TableName Table Name
     */
    public void setTableName (String TableName)
    {
        m_TableName = TableName;
    }	//	setTableName

    /*************************************************************************/

    /**
     * 	Get ColumnName of index
     * 	@param index index
     * 	@return ColumnName
     */
    public String getColumnName (int index)
    {
        if (index < 0 || index >= m_list.size())
            return null;
        Restriction r = (Restriction)m_list.get(index);
        return r.ColumnName;
    }	//	getColumnName

    /**
     * 	Set ColumnName of index
     * 	@param index index
     *  @param ColumnName new column name
     */
    protected void setColumnName (int index, String ColumnName)
    {
        if (index < 0 || index >= m_list.size())
            return;
        Restriction r = (Restriction)m_list.get(index);
        r.ColumnName = ColumnName;
    }	//	setColumnName

    /**
     * 	Get Operator of index
     * 	@param index index
     * 	@return Operator
     */
    public String getOperator (int index)
    {
        if (index < 0 || index >= m_list.size())
            return null;
        Restriction r = (Restriction)m_list.get(index);
        return r.Operator;
    }	//	getOperator

    /**
     * 	Get Restriction Display of index
     * 	@param index index
     * 	@return Restriction Display
     */
    public String getInfoDisplay (int index)
    {
        if (index < 0 || index >= m_list.size())
            return null;
        Restriction r = (Restriction)m_list.get(index);
        return r.InfoDisplay;
    }	//	getOperator

    /**
     * 	Get TO Restriction Display of index
     * 	@param index index
     * 	@return Restriction Display
     */
    public String getInfoDisplay_to (int index)
    {
        if (index < 0 || index >= m_list.size())
            return null;
        Restriction r = (Restriction)m_list.get(index);
        return r.InfoDisplay_to;
    }	//	getOperator

    /**
     * 	Get Info Name
     * 	@param index index
     * 	@return Info Name
     */
    public String getInfoName(int index)
    {
        if (index < 0 || index >= m_list.size())
            return null;
        Restriction r = (Restriction)m_list.get(index);
        return r.InfoName;
    }	//	getInfoName

    /**
     * 	Get Info Operator
     * 	@param index index
     * 	@return info Operator
     */
    public String getInfoOperator(int index)
    {
        if (index < 0 || index >= m_list.size())
            return null;
        Restriction r = (Restriction)m_list.get(index);
        return r.getInfoOperator();
    }	//	getInfoOperator

    /**
     * 	Get Display with optional To
     * 	@param index index
     * 	@return info display
     */
    public String getInfoDisplayAll (int index)
    {
        if (index < 0 || index >= m_list.size())
            return null;
        Restriction r = (Restriction)m_list.get(index);
        return r.getInfoDisplayAll();
    }	//	getInfoDisplay

    /**
     * 	String representation
     * 	@return info
     */
    public String toString()
    {
        if (isActive())
            return getWhereClause(true);
        return "MQuery[" + m_TableName + "]";
    }	//	toString

    /**
     * 	Clone Query
     * 	@return Query
     */
    public MQuery deepCopy()
    {
        MQuery newQuery = new MQuery(m_TableName);
        for (int i = 0; i < m_list.size(); i++)
            newQuery.addRestriction((Restriction)m_list.get(i));
        return newQuery;
    }	//	clone

    /*************************************************************************/

    /**
     * 	Create simple Equal Query.
     *  Creates columnName=value or columnName='value'
     * 	@param columnName columnName
     * 	@param value value
     * 	@return quary
     */
    public static MQuery getEqualQuery (String columnName, Object value)
    {
        MQuery query = new MQuery();
        query.addRestriction(columnName, EQUAL, value);
        return query;
    }	//	getEqualQuery

    /**
     * 	Create simple Equal Query.
     *  Creates columnName=value
     * 	@param columnName columnName
     * 	@param value value
     * 	@return quary
     */
    public static MQuery getEqualQuery (String columnName, int value)
    {
        MQuery query = new MQuery();
        query.addRestriction(columnName, EQUAL, new Integer(value));
        return query;
    }	//	getEqualQuery

}	//	MQuery

