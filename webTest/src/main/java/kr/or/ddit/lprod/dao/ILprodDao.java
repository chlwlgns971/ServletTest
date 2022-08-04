package kr.or.ddit.lprod.dao;

import java.util.List;

import kr.or.ddit.vo.LprodVO;

public interface ILprodDao {
	/**
	 *DB의 LPROD테이블의 전체 내용을 가져와 List에 담아서 반환하는 메서드 
	 * @return LprodVO객체가 저장된 List객체
	 */
	public List<LprodVO> getAllLprod();
}
