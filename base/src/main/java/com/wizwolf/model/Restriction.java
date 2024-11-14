package com.wizwolf.model;

/*****************************************************************************/

import java.io.Serializable;
import java.sql.Timestamp;

/**
 *	Query Restriction
 */
class Restriction  implements Serializable {
    /**
     *  Package Strings for SQL command
     *  @param txt  String with text
     *  @return escaped string for insert statement (NULL if null)
     */
    public static String TO_STRING (String txt)
    {
        return TO_STRING (txt, 0);
    }   //  TO_STRING

    /**
     *	Package Strings for SQL command.
     *  <pre>
     *		-	include in '
     *		-	replace ' with ''
     *      -   replace \ with \\
     *  </pre>
     *  @param txt  String with text
     *  @param maxLength    Maximum Length of content or 0 to ignore
     *  @return escaped string for insert statement (NULL if null)
     */
    public static String TO_STRING (String txt, int maxLength)
    {
        if (txt == null)
            return "NULL";

        //  Length
        String text = txt;
        if (maxLength != 0 && text.length() > maxLength)
            text = txt.substring(0, maxLength);

        //  copy characters		(wee need to look through anyway)
        StringBuffer out = new StringBuffer("'");
        for (int i = 0; i < text.length(); i++)
        {
            char c = text.charAt(i);
            if (c == '\'')
                out.append("''");
            else if (c == '\\')
                out.append("\\\\");
            else
                out.append(c);
        }
        out.append("'");
        //
        return out.toString();
    }	//	TO_STRING

    /**
     *  Create SQL TO Date String from Timestamp
     *
     *  @param  time Date to be converted
     *  @param  dayOnly true if time set to 00:00:00
     *
     *  @return TO_DATE('2001-01-30 18:10:20',''YYYY-MM-DD HH24:MI:SS')
     *      or  TO_DATE('2001-01-30',''YYYY-MM-DD')
     */
    public static String TO_DATE (Timestamp time, boolean dayOnly)
    {
        if (time == null)
        {
            if (dayOnly)
                return "TRUNC(SysDate)";
            return "SysDate";
        }

        StringBuffer dateString = new StringBuffer("TO_DATE('");
        //  YYYY-MM-DD HH24:MI:SS.mmmm  JDBC Timestamp format
        String myDate = time.toString();
        if (dayOnly)
        {
            dateString.append(myDate.substring(0,10));
            dateString.append("','YYYY-MM-DD')");
        }
        else
        {
            dateString.append(myDate.substring(0, myDate.indexOf(".")));	//	cut off miliseconds
            dateString.append("','YYYY-MM-DD HH24:MI:SS')");
        }
        return dateString.toString();
    }   //  TO_DATE

    /**
     *  Create SQL TO Date String from Timestamp
     *  @param time time
     *  @return TO_DATE String
     */
    public static String TO_DATE (Timestamp time)
    {
        return TO_DATE(time, true);
    }   //  TO_DATE




    /**
     * 	Restriction
     * 	@param ColumnName ColumnName
     * 	@param Operator Operator, e.g. = != ..
     * 	@param Code Code, e.g 0, All%
     *  @param InfoName Display Name
     * 	@param InfoDisplay Display of Code (Lookup)
     */
    Restriction (String ColumnName, String Operator,
                 Object Code, String InfoName, String InfoDisplay)
    {
        this.ColumnName = ColumnName.trim();
        if (InfoName != null)
            this.InfoName = InfoName;
        else
            this.InfoName = this.ColumnName;
        //
        this.Operator = Operator;
        //	clean code
        this.Code = Code;
        if (this.Code instanceof String)
        {
            if (this.Code.toString().startsWith("'"))
                this.Code = this.Code.toString().substring(1);
            if (this.Code.toString().endsWith("'"))
                this.Code = this.Code.toString().substring(0, this.Code.toString().length()-2);
        }
        if (InfoDisplay != null)
            this.InfoDisplay = InfoDisplay.trim();
        else if (this.Code != null)
            this.InfoDisplay = this.Code.toString();
    }	//	Restriction

    /**
     * 	Range Restriction (BETWEEN)
     * 	@param ColumnName ColumnName
     * 	@param Code Code, e.g 0, All%
     * 	@param Code_to Code, e.g 0, All%
     *  @param InfoName Display Name
     * 	@param InfoDisplay Display of Code (Lookup)
     * 	@param InfoDisplay_to Display of Code (Lookup)
     */
    Restriction (String ColumnName,
                 Object Code, Object Code_to,
                 String InfoName, String InfoDisplay, String InfoDisplay_to)
    {
        this (ColumnName, MQuery.BETWEEN, Code, InfoName, InfoDisplay);

        //	Code_to
        this.Code_to = Code_to;
        if (this.Code_to instanceof String)
        {
            if (this.Code_to.toString().startsWith("'"))
                this.Code_to = this.Code_to.toString().substring(1);
            if (this.Code_to.toString().endsWith("'"))
                this.Code_to = this.Code_to.toString().substring(0, this.Code_to.toString().length()-2);
        }
        //	InfoDisplay_to
        if (InfoDisplay_to != null)
            this.InfoDisplay_to = InfoDisplay_to.trim();
        else if (this.Code_to != null)
            this.InfoDisplay_to = this.Code_to.toString();
    }	//	Restriction

    /**
     * 	Create Restriction with dircet WHERE clause
     * 	@param whereClause SQL WHERE Clause
     */
    Restriction (String whereClause)
    {
        DircetWhereClause = whereClause;
    }	//	Restriction

    /**	Direct Where Clause	*/
    protected String	DircetWhereClause = null;
    /**	Column Name			*/
    protected String 	ColumnName;
    /** Name				*/
    protected String	InfoName;
    /** Operator			*/
    protected String 	Operator;
    /** SQL Where Code		*/
    protected Object 	Code;
    /** Info				*/
    protected String 	InfoDisplay;
    /** SQL Where Code To	*/
    protected Object 	Code_to;
    /** Info To				*/
    protected String 	InfoDisplay_to;
    /** And/Or Condition	*/
    protected boolean	andCondition = true;

    /**
     * 	Return SQL construct for this restriction
     *  @param tableName optional table name
     * 	@return SQL WHERE construct
     */
    public String getSQL (String tableName)
    {
        if (DircetWhereClause != null)
            return DircetWhereClause;
        //
        StringBuffer sb = new StringBuffer();
        if (tableName != null && tableName.length() > 0)
        {
            //	Assumes - REPLACE(INITCAP(variable),'s','X') or UPPER(variable)
            int pos = ColumnName.lastIndexOf('(')+1;	//	including (
            int end = ColumnName.indexOf(')');
            //	We have a Function in the ColumnName
            if (pos != -1 && end != -1)
                sb.append(ColumnName.substring(0, pos))
                        .append(tableName).append(".").append(ColumnName.substring(pos, end))
                        .append(ColumnName.substring(end));
            else
                sb.append(tableName).append(".").append(ColumnName);
        }
        else
            sb.append(ColumnName);
        //
        sb.append(Operator);
        if (Code instanceof String)
            sb.append(TO_STRING(Code.toString()));
        else if (Code instanceof Timestamp)
            sb.append(TO_DATE((Timestamp)Code));
        else
            sb.append(Code);
        //	Between
        //	if (Code_to != null && InfoDisplay_to != null)
        if (MQuery.BETWEEN.equals(Operator))
        {
            sb.append(" AND ");
            if (Code_to instanceof String)
                sb.append(TO_STRING(Code_to.toString()));
            else if (Code_to instanceof Timestamp)
                sb.append(TO_DATE((Timestamp)Code_to));
            else
                sb.append(Code_to);
        }
        return sb.toString();
    }	//	getSQL

    /**
     * 	Get String Representation
     * 	@return info
     */
    public String toString()
    {
        return getSQL(null);
    }	//	toString

    /**
     * 	Get Info Name
     * 	@return Info Name
     */
    public String getInfoName()
    {
        return InfoName;
    }	//	getInfoName

    /**
     * 	Get Info Operator
     * 	@return info Operator
     */
    public String getInfoOperator()
    {
        for (int i = 0; i < MQuery.OPERATORS.length; i++)
        {
            if (MQuery.OPERATORS[i].getValue().equals(Operator))
                return MQuery.OPERATORS[i].getName();
        }
        return Operator;
    }	//	getInfoOperator

    /**
     * 	Get Display with optional To
     * 	@return info display
     */
    public String getInfoDisplayAll()
    {
        if (InfoDisplay_to == null)
            return InfoDisplay;
        StringBuffer sb = new StringBuffer(InfoDisplay);
        sb.append(" - ").append(InfoDisplay_to);
        return sb.toString();
    }	//	getInfoDisplay

}	//	Restriction

