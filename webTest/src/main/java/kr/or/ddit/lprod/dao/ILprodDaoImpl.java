package kr.or.ddit.lprod.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.util.sqlMapClientFactory;
import kr.or.ddit.vo.LprodVO;

public class ILprodDaoImpl implements ILprodDao {
	private SqlMapClient smc;
	private static ILprodDaoImpl dao;
	
	private ILprodDaoImpl() {
		smc=sqlMapClientFactory.getSqlMapClient();
	}
	public static ILprodDaoImpl getInstance() {
		if(dao==null) dao=new ILprodDaoImpl();
		return dao;
	}
	@Override
	public List<LprodVO> getAllLprod() {
		List<LprodVO> lprodList=null;
		try {
			lprodList = smc.queryForList("Lprod.getAllLprod");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lprodList;
	}
	
}
