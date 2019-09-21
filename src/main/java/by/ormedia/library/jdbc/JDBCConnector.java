package by.ormedia.library.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import by.ormedia.library.core.IReader;
import by.ormedia.library.domain.Reader;

public class JDBCConnector {
	
	private static final String DRIVER = "org.postgresql.Driver";
	private static final String URL = "jdbc:postgresql://localhost/library";
	private static final String LOGIN = "postgres";
	private static final String PASSWORD = "1111";

	private Connection connection;
	{
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			connection = (Connection) DriverManager.getConnection(URL, LOGIN, PASSWORD);
		} catch (SQLException e) {
			System.out.println("Ooops... I`m sorry... I can`t find out this database...");
			e.printStackTrace();
		}
	}
	
	public boolean saveReader(Reader reader){
		Statement st = null;
		try {
			st = this.connection.createStatement();
			return st.execute("insert into readers (name) values ('"+reader.getName()+"')");
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public List<IReader> getReaders(){
		List<IReader>list = new ArrayList<>();
		Statement statement = null;
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			return list;
		}
		ResultSet rs;
		try {
			rs = statement.executeQuery("select * from readers;");
			while (rs.next()) {
				String name = rs.getString("name");
				long id = rs.getLong("id");
				list.add(new Reader(id,name));
			}
		} catch (SQLException e) {
		};
		return list;
	}
}
