package cnt4714_project2;

import java.sql.*;
import java.util.Vector;

public class RunQuery {
	
	private Connection c;
	private Vector<String> columns;
	private ResultSetMetaData metaData;
	
	public RunQuery(Connection c)
	{
		this.c = c;
	}
	
	public Vector<Vector<String>> runQuery(String query) throws SQLException {
		
		Vector<Vector<String>> results = new Vector<Vector<String>>();
		
		Statement statement = (Statement) this.c.createStatement();
		ResultSet resultSet = statement.executeQuery(query);
		
		metaData = resultSet.getMetaData();
		
		int numColumns = metaData.getColumnCount();
		
		setColumns(numColumns, metaData);
		
		while(resultSet.next())
		{
			Vector<String> row = new Vector<String>();
			
			for(int i = 1; i <= numColumns; i++)
			{
				row.add(resultSet.getString(i));
			}
			
			results.add(row);
		}
		return results;
	}
	

	public int update(String query) throws SQLException
	{		
		return this.c.createStatement().executeUpdate(query);
	}
	
	/*GET METHODS*/
	public Vector<String> getColumns() throws SQLException
	{
		return this.columns;
	}
	
	/*SET METHODS*/
	public void setColumns(int numColumns, ResultSetMetaData metaData) throws SQLException
	{
		columns = new Vector<String>();
		
		for(int i = 1; i <= numColumns; i++)
		{
			columns.add(metaData.getColumnName(i));
		}
	}
	

}
