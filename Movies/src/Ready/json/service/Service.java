package Ready.json.service;
import static Ready.json.JDBCTemplate.*;


import java.sql.Connection;
import java.util.List;

import Ready.json.dao.DAO;
import Ready.json.vo.Movie;

 

public class Service {
	private DAO dao = new DAO();
	
	public void insertMovie(List<Movie> movies) throws Exception{
		Connection conn = getConnection();
		int result = dao.insertMovie(conn, movies);
		if(result > 0) {
			commit(conn);
			System.out.println("성공!");
		} else {
			rollback(conn);
		}
		close(conn);
	}
}