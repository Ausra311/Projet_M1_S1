package DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Vector;


public abstract class DAO<T> {
	protected Connection conn;
	
	protected DAO(Connection conn) {
		this.conn = conn;
	}
	
	public abstract boolean create(T obj, String type) throws SQLException;

	public abstract Vector<T> read (Object obj) throws SQLException;

	public abstract boolean update (T obj) throws SQLException;

	public abstract boolean delete(T obj) throws SQLException;

}