package kr.or.ddit.vo;

public class LprodVO {
	private int lprod_id;
	private String lprod_gu;
	private String lprod_nm;
	
	//다른 생성자 만들 때 기본생성자도 꼭 만들어 주어야 한다. 왜?
	public LprodVO() {
	
	}

	public LprodVO(int lprod_id, String lprod_gu, String lprod_nm) {
		super();
		this.lprod_id = lprod_id;
		this.lprod_gu = lprod_gu;
		this.lprod_nm = lprod_nm;
	}
	

	public int getLprod_id() {
		return lprod_id;
	}

	public void setLprod_id(int lprod_id) {
		this.lprod_id = lprod_id;
	}

	public String getLprod_gu() {
		return lprod_gu;
	}

	public void setLprod_gu(String lprod_gu) {
		this.lprod_gu = lprod_gu;
	}

	public String getLprod_nm() {
		return lprod_nm;
	}

	public void setLprod_nm(String lprod_nm) {
		this.lprod_nm = lprod_nm;
	}

}
