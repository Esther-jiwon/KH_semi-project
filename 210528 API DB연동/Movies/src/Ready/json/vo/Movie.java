package Ready.json.vo;

public class Movie {
	private String movieNm;
	private String movieCd;
	private String openDt;
	private String repGenreNm;
	private String nationAlt;
	private String typeNm;
	public Movie() {
		// TODO Auto-generated constructor stub
	}
	public Movie(String movieNm, String movieCd, String openDt, String repGenreNm, String nationAlt, String typeNm) {
		super();
		this.movieNm = movieNm;
		this.movieCd = movieCd;
		this.openDt = openDt;
		this.repGenreNm = repGenreNm;
		this.nationAlt = nationAlt;
		this.typeNm = typeNm;
	}
	public String getMovieNm() {
		return movieNm;
	}
	public void setMovieNm(String movieNm) {
		this.movieNm = movieNm;
	}
	public String getMovieCd() {
		return movieCd;
	}
	public void setMovieCd(String movieCd) {
		this.movieCd = movieCd;
	}
	public String getOpenDt() {
		return openDt;
	}
	public void setOpenDt(String openDt) {
		this.openDt = openDt;
	}
	public String getRepGenreNm() {
		return repGenreNm;
	}
	public void setRepGenreNm(String repGenreNm) {
		this.repGenreNm = repGenreNm;
	}
	public String getNationAlt() {
		return nationAlt;
	}
	public void setNationAlt(String nationAlt) {
		this.nationAlt = nationAlt;
	}
	public String getTypeNm() {
		return typeNm;
	}
	public void setTypeNm(String typeNm) {
		this.typeNm = typeNm;
	}
	@Override
	public String toString() {
		return "Movie [movieNm=" + movieNm + ", movieCd=" + movieCd + ", openDt=" + openDt + ", repGenreNm="
				+ repGenreNm + ", nationAlt=" + nationAlt + ", typeNm=" + typeNm + "]";
	}
	
}
