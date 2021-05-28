package Ready.json;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCTemplate {
	/* DB 연결, JDBC 자원 반환 등의 JDBC 관련 공통 내용을 모아둔 클래스
	 * getConnection() : 커넥션을 반환하는 메소드
	 * close(stmt | pstmt | rs | conn); : 자원 반환 메소드
	 * commit() / rollback() : 트랜잭션 처리용 메소드
	 * */
	
	private static Connection conn = null;
	// 프로그램에서 나오는 Connection의 개수를 한 개로 제한해줘야 한다. 
	// 작업할 때마다 Connection을 만들면 무한히 만들어져서 부하가 걸림.
	
	// DB 연결을 위한 커넥션 반환 메소드
	public static Connection getConnection() {
		
		try {
			if(conn == null || conn.isClosed()) {
				// isClosed() : 자원이 반환되어 있으면 true, 아니면 false
				
				
				// 외부 파일에서 정보를 읽어와 이를 저장할 Properties 객체 생성 
				Properties prop = new Properties();
				// Properties : K, V가 String으로 제한된 Map 
				// --> 파일 입출력에 특화되어 있음.
				// inputStream -> read() 한 글자씩 가져옴 -> while(read()) -> 하나의 String에 저장
				
				// driver.xml 파일을 읽어와서 prop에 저장
				prop.loadFromXML(new FileInputStream("driver.xml")); // -> 읽어온 상태 
				
				// 중간확인 
				// System.out.println(prop);
				
				
				/* 이렇게 하면 id 하나 pwd 하나 바뀔 때마다 자바 코드를 바꿔줘야 하고 
				 * 컴파일 시간이 오래 걸린다. 
				Class.forName("oracle.jdbc.driver.OracleDriver");
				String url = "jdbc:oracle:thin:@localhost:1521:xe";
				conn = DriverManager.getConnection(url, "abcd", "1234");
				*/
				
				// 새로운 커넥션 생성 -> 변수들을 xml 파일에서 가져오기 
				//                -> xml파일 안의 값이 바뀌면 자동으로 자바의 변수 값도 바뀌어 있어서 
				//				  -> 자바 코드를 손댈 필요가 없다. 
				//                -> 코드의 능동성, 유지보수성 업업
				Class.forName(prop.getProperty("driver"));
				String url = prop.getProperty("url");
				String user = prop.getProperty("user");
				String pass = prop.getProperty("pass");
				conn = DriverManager.getConnection(url, user, pass);
				conn.setAutoCommit(false); // SQL 구문 수행 후 자동 Commit 기능 끔
				// 이걸 컴파일을 한 번 하면 수정하고 또 컴파일하기 오래걸리니까 
				// 얘네는 외부파일에서 얻어와서 컴파일 안하고 수정할 수 있도록 만든다.
				
				// 드라이버, url, 이이디, 비밀번호는 바뀔 가능성이 많아서 
				// 바뀔 때마다 자바 코드를 다시 컴파일 하는 것은 너무 비효율적임. 
				// --> 외부 파일에 내용을 작성해 읽어오는 방법으로 문제 해결 가능. 
				// xml => 어떤 파일 형식에서도 읽어올 수 있는 파일 형식
				
				
				
			}
		} catch(Exception e ) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	
	// Connection 반환 메소드
	public static void close(Connection conn) {
		try {
			if(conn != null && !conn.isClosed()) {
				// conn이 참조하는 Connection 객체가 있고 
				// 그 객체가 반환되지 않았을 때 
				conn.close();
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	// Statement 반환 메소드 +(다형성을 이용해 PreparedStatement도 같이 반환 가능)
	public static void close(Statement stmt) {
		try {
			if(stmt != null && !stmt.isClosed()) {
				// stmt이 참조하는 Statement 객체가 있고 
				// 그 객체가 반환되지 않았을 때 
				stmt.close();
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	// Resultset 반환 메소드
	public static void close(ResultSet rs) {
		try {
			if(rs != null && !rs.isClosed()) {
				// rs이 참조하는 ResultSet 객체가 있고 
				// 그 객체가 반환되지 않았을 때 
				rs.close();
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	// commit용 메소드  
	// 우리가 commit/rollback을 하기 위해서 Connection 이 필요함
	public static void commit(Connection conn) {
		try {
			if(conn != null && !conn.isClosed()) {
				// conn이 참조하는 Connection 객체가 있고 
				// 그 객체가 반환되지 않았을 때 
				conn.commit();
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	// rollback용 메소드  
	// 우리가 commit/rollback을 하기 위해서 Connection 이 필요함
	public static void rollback(Connection conn) {
		try {
			if(conn != null && !conn.isClosed()) {
				// conn이 참조하는 Connection 객체가 있고 
				// 그 객체가 반환되지 않았을 때 
				conn.rollback();
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
