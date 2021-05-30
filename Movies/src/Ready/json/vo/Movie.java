package Ready.json.vo;

public class Movie {
	private String movieCd;
	private String movieNm;
	private String movieNmEn;
	private String prdtYear;
	private String openDt;
	private String typeNm;
	private String prdtStatNm;
	private String repNationNm;
	private String repGenreNm;
	private String directorNm;
	private String companyCd;
	private String companyNm;
	
	public Movie() {
		// TODO Auto-generated constructor stub
	}

	public Movie(String movieCd, String movieNm, String movieNmEn, String prdtYear, String openDt, String typeNm,
			String prdtStatNm, String repNationNm, String repGenreNm, String directorNm, String companyCd,
			String companyNm) {
		super();
		this.movieCd = movieCd;
		this.movieNm = movieNm;
		this.movieNmEn = movieNmEn;
		this.prdtYear = prdtYear;
		this.openDt = openDt;
		this.typeNm = typeNm;
		this.prdtStatNm = prdtStatNm;
		this.repNationNm = repNationNm;
		this.repGenreNm = repGenreNm;
		this.directorNm = directorNm;
		this.companyCd = companyCd;
		this.companyNm = companyNm;
	}

	public String getMovieCd() {
		return movieCd;
	}

	public void setMovieCd(String movieCd) {
		this.movieCd = movieCd;
	}

	public String getMovieNm() {
		return movieNm;
	}

	public void setMovieNm(String movieNm) {
		this.movieNm = movieNm;
	}

	public String getMovieNmEn() {
		return movieNmEn;
	}

	public void setMovieNmEn(String movieNmEn) {
		this.movieNmEn = movieNmEn;
	}

	public String getPrdtYear() {
		return prdtYear;
	}

	public void setPrdtYear(String prdtYear) {
		this.prdtYear = prdtYear;
	}

	public String getOpenDt() {
		return openDt;
	}

	public void setOpenDt(String openDt) {
		this.openDt = openDt;
	}

	public String getTypeNm() {
		return typeNm;
	}

	public void setTypeNm(String typeNm) {
		this.typeNm = typeNm;
	}

	public String getPrdtStatNm() {
		return prdtStatNm;
	}

	public void setPrdtStatNm(String prdtStatNm) {
		this.prdtStatNm = prdtStatNm;
	}

	public String getRepNationNm() {
		return repNationNm;
	}

	public void setRepNationNm(String repNationNm) {
		this.repNationNm = repNationNm;
	}

	public String getRepGenreNm() {
		return repGenreNm;
	}

	public void setRepGenreNm(String repGenreNm) {
		this.repGenreNm = repGenreNm;
	}

	public String getDirectorNm() {
		return directorNm;
	}

	public void setDirectorNm(String directorNm) {
		this.directorNm = directorNm;
	}

	public String getCompanyCd() {
		return companyCd;
	}

	public void setCompanyCd(String companyCd) {
		this.companyCd = companyCd;
	}

	public String getCompanyNm() {
		return companyNm;
	}

	public void setCompanyNm(String companyNm) {
		this.companyNm = companyNm;
	}

	@Override
	public String toString() {
		return "Movie [movieCd=" + movieCd + ", movieNm=" + movieNm + ", movieNmEn=" + movieNmEn + ", prdtYear="
				+ prdtYear + ", openDt=" + openDt + ", typeNm=" + typeNm + ", prdtStatNm=" + prdtStatNm
				+ ", repNationNm=" + repNationNm + ", repGenreNm=" + repGenreNm + ", directorNm=" + directorNm
				+ ", companyCd=" + companyCd + ", companyNm=" + companyNm + "]";
	}

	



	
}