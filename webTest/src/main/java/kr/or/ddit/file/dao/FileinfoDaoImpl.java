package kr.or.ddit.file.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.util.sqlMapClientFactory;
import kr.or.ddit.vo.FileinfoVO;

public class FileinfoDaoImpl implements IFileinfoDao {
	private SqlMapClient smc;
	private static FileinfoDaoImpl dao;
	
	private FileinfoDaoImpl() {
		smc=sqlMapClientFactory.getSqlMapClient();
	}
	public static FileinfoDaoImpl getInstance() {
		if(dao==null) dao=new FileinfoDaoImpl();
		return dao;
	}
	@Override
	public int insertFileinfo(FileinfoVO fileinfoVo) {
		int cnt=0; //반환값이 저장될 변수
		
		try {
			if(smc.insert("fileinfo.insertFileinfo",fileinfoVo)==null) {
				cnt=1;
			}
		} catch (SQLException e) {
			cnt=0;
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public List<FileinfoVO> getAllFileinfo() {
		List<FileinfoVO> fileList = null;
		
		try {
			fileList=smc.queryForList("fileinfo.getAllFileinfo");
		} catch (SQLException e) {
			fileList=null;
			e.printStackTrace();
		}
		return fileList;
	}

	@Override
	public FileinfoVO getFileinfo(int fileNo) {
		FileinfoVO fileVo = null;
		
		try {
			fileVo=(FileinfoVO)smc.queryForObject("fileinfo.getFileinfo", fileNo);
		} catch (SQLException e) {
			fileVo=null;
			e.printStackTrace();
		}
		return fileVo;
	}

}
