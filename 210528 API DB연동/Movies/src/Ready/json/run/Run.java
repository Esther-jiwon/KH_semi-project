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
			URL url = new URL(" http://www.kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieList.json?key="
		    				+ key + "&curPage=1&itemPerPage=100");
			BufferedReader bf;
			
			bf = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
			
			result = bf.readLine();
			
			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObject = (JSONObject)jsonParser.parse(result);
			JSONObject movieListResult = (JSONObject)jsonObject.get("movieListResult");
			JSONArray movieList = (JSONArray)movieListResult.get("movieList");
			
			JSONObject movies;
			List<Movie> movies2 = new ArrayList<Movie>();
			for(int i=0; i < movieList.size(); i++) {
				movies = (JSONObject) movieList.get(i);
				String movieNm = (String) movies.get("movieNm");
				String movieCd = (String) movies.get("movieCd");
				String openDt = (String) movies.get("openDt");
				String repGenreNm = (String) movies.get("repGenreNm");
				String nationAlt = (String) movies.get("nationAlt");
				String typeNm = (String) movies.get("typeNm");
				
				movies2.add(new Movie(movieNm, movieCd, openDt, repGenreNm, nationAlt, typeNm));

			}

		
			service.insertMovie(movies2);

       
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
