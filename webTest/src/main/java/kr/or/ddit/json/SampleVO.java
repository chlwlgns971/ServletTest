package kr.or.ddit.json;

public class SampleVO {
	private int id;
	private String name;
	
	public SampleVO() {
		super();
	}
	public SampleVO(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
