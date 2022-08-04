package kr.or.ddit.file.dao;

import java.util.List;

import kr.or.ddit.vo.FileinfoVO;

public interface IFileinfoDao {
	/**
	 * FileinfoVO객체에 담겨진 자료를 DB에 insert하는 메서드
	 * 
	 * @param fileinfoVo: DB에 insert할 자료가 저장된 FIleinfoVO객체
	 * @return 작업성공: 1, 작업실패: 0
	 */
	public int insertFileinfo(FileinfoVO fileinfoVo);
	
	/**
	 * 전체 파일 목록을 가져와 List에 담아서 반환하는 메서드
	 * @return FileinfoVO객체가 저장된 List객체
	 */
	public List<FileinfoVO> getAllFileinfo();
	
	/**
	 * 파일 번호를 인수값으로 받아서 해당 파일 정보를 VO에 담아서 반환하는 메서드
	 * 
	 * @param fileNo: 가져올 file번호
	 * @return 검색된 파일 정보가 저장된 FileinfoVO객체
	 */
	public FileinfoVO getFileinfo(int fileNo);
}
