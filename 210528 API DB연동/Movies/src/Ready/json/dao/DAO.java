package Ready.json.dao;

import static Ready.json.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Properties;

import Ready.json.vo.Movie;


public class DAO {
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private Properties prop = null;
	
	public DAO() {
		try {
			prop = new Properties();
			prop.loadFromXML(new FileInputStream("board-query.xml"));
		}catch(Exception e) {
			e.printStackTrace();;
		}
	}
	public int insertMovie(Connection conn, List<Movie> movies) throws SQLException {
		int result = 0;
		System.out.println(movies);
		try {
			for(int i=0; i <movies.size(); i++) {
				String sql = prop.getProperty("insertMovie");
				
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, movies.get(i).getMovieCd());
				pstmt.setString(2, movies.get(i).getMovieNm());
				pstmt.setString(3, movies.get(i).getOpenDt());
				pstmt.setString(4, movies.get(i).getRepGenreNm());
				pstmt.setString(5, movies.get(i).getTypeNm());
				pstmt.setString(6, movies.get(i).getNationAlt());
				
				result = pstmt.executeUpdate();
				System.out.println(i+"추가성공");
			}

		}finally {
			close(pstmt);
		}
		return result;
	}

}
