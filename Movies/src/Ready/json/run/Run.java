package Ready.json.run;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import Ready.json.service.Service;
import Ready.json.vo.Movie;

public class Run {
	public static void main(String[] args) {
		String key = "cd826e4140b09c42bd5c7877d852e8be";    

		String result = "";
		Movie movie = new Movie();
		Service service = new Service();
		try{
			
			// 지정 페이지 100행 불러오기
			URL url = new URL(" http://www.kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieList.json?key="
		    				+ key + "&curPage=15&itemPerPage=100");
			BufferedReader bf;
			
			bf = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
			
			result = bf.readLine();
			
			//JSON 정보를 JSONArray movieList에 넣어주기
			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObject = (JSONObject)jsonParser.parse(result);
			JSONObject movieListResult = (JSONObject)jsonObject.get("movieListResult");
			JSONArray movieList = (JSONArray)movieListResult.get("movieList");
			
			//JSON안에 배열 형태로 되어있는 정보들(directors/companys)
			JSONObject movies;
			JSONArray directors;
			JSONArray companys;
			JSONObject company = new JSONObject(); 
			JSONObject directors_peopleNm = new JSONObject();
			
			//JSON안에 있는 Movie정보 하나하나를 담아줄 List movies2 준비
			List<Movie> movies2 = new ArrayList<Movie>();
			
			//JSONArray movieList에 있는 배열 값을 for문을 이용해 하나씩 JSONObject에 저장하고 사용하기
			for(int i=0; i < movieList.size(); i++) {
				movies = (JSONObject) movieList.get(i);
				
				//JSON안에 배열 형태로 되어있는 정보들(directors/companys)이 null값일 때 "N" 넣어주는 처리
				directors = (JSONArray)movies.get("directors");
				if(directors.isEmpty()) {
					directors_peopleNm.put("peopleNm", "N");
				}else {
					directors_peopleNm = (JSONObject)directors.get(0);
				}
				
				companys = (JSONArray)movies.get("companys");
				if(companys.isEmpty()) {
					company.put("companyCd", "N");
					company.put("companyNm", "N");
					companys.add(company);

				} else {
					company = (JSONObject)companys.get(0);
				}
				
				//이외 정보들 String에 저장
				String movieCd = (String) movies.get("movieCd");
				String movieNm = (String) movies.get("movieNm");
				String movieNmEn = (String) movies.get("movieNmEn");
			    String prdtYear = (String) movies.get("prdtYear");
				String openDt = (String) movies.get("openDt");
				String typeNm = (String) movies.get("typeNm"); 
				String prdtStatNm = (String) movies.get("prdtStatNm");
				String repNationNm = (String) movies.get("repNationNm");
				String repGenreNm = (String) movies.get("repGenreNm");
				String directorNm = (String) directors_peopleNm.get("peopleNm");
				String companyCd = (String) company.get("companyCd");
				String companyNm = (String) company.get("companyNm");
				
				//List 안에 넣어주기
				movies2.add(new Movie(movieCd, movieNm, movieNmEn, prdtYear, openDt, typeNm, prdtStatNm, repNationNm, repGenreNm, directorNm, companyCd, companyNm));

			}

			service.insertMovie(movies2);

       
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
