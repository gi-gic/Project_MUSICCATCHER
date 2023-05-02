package model;

public class musicDTO {
	
	private String title1;
	private String singer1;
	private String path1;

	public musicDTO(String title,String singer,String path) {
		this.title1 = title;
     	this.singer1 =singer;
     	this.path1 =path;
	}

	public String getPath() {
		return path1;
	}

	public String getTitle() {
		return title1;
	}

	public String getSinger() {
		return singer1;
	}

}

