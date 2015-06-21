package com.qinrenzaixian.web.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.qinrenzaixian.web.vo.pagination.Pagination;

public class BaseDAO implements IBaseDAO {
	@Autowired
	private SqlSessionTemplate sqlSession;

	/* *//** 搜索关健字缓存数组 */
	/*
	 * private static List<Object> keywords = null; private static List<Object>
	 * helpKeywords = null;
	 */
	/*
	 * static{ keywords = new ArrayList<Object>(); helpKeywords = new
	 * ArrayList<Object>(); }
	 */

	@Override
	public int count(String sqlId, Serializable id) {
		return getSqlSession().selectOne(sqlId, id);
	}

	public SqlSessionTemplate getSqlSession() {
		return sqlSession;
	}

	@Override
	public Object queryForObject(String sqlId, Serializable id) {
		return getSqlSession().selectOne(sqlId, id);
	}

	@Override
	public Object queryForObject(String sqlId, Object params) {
		return getSqlSession().selectOne(sqlId, params);
	}

	@Override
	public Object queryForObject(String sqlId, Map<String, Object> bindParams) {
		return getSqlSession().selectOne(sqlId, bindParams);
	}

	@Override
	public int count(String sqlId, Object entityObject) {
		return (Integer) getSqlSession().selectOne(sqlId, entityObject);
	}

	@Override
	public <T> T findById(String sqlId, Serializable id) {
		return (T) getSqlSession().selectOne(sqlId, id);
	}

	@Override
	public <T> List<T> queryForList(String sqlId) {
		return getSqlSession().selectList(sqlId, null);
	}

	@Override
	public <T> List<T> queryForList(String sqlId, Map<String, Object> bindParams) {
		return getSqlSession().selectList(sqlId, bindParams);
	}

	@Override
	public <T> List<T> queryForList(String sqlId, Object entityObject) {
		return getSqlSession().selectList(sqlId, entityObject);
	}

	@Override
	public <T> List<T> queryForList(String sqlId, Serializable id) {
		return getSqlSession().selectList(sqlId, id);
	}

	@Override
	public <T> void queryForPaginate(String sqlId, Pagination<T> paginate) {
		// 结果数配置的sqlid默认应该是sqlid后加Count
		int count = this.count(sqlId.concat("Count"), paginate);
		paginate.repaginate(count);
		if (count > 0) {
			List<T> list = this.queryForList(sqlId, paginate);
			paginate.setList(list);
		}
	}

	@Override
	public <T> void queryForPaginate(String sqlId, Map<String, Object> paginate) {
		// 结果数配置的sqlid默认应该是sqlid后加-count
		int count = this.count(sqlId.concat("-count"), paginate);
		if (paginate.get("pagination") == null) {
			throw new RuntimeException("pagination parameter is required!");
		}

		Pagination<T> pagination = (Pagination<T>) paginate.get("pagination");
		pagination.repaginate(count);
		if (count > 0) {
			paginate.put("start", pagination.getStart());
			paginate.put("end", pagination.getEnd());
			List<T> list = this.queryForList(sqlId, paginate);
			((Pagination<T>) paginate.get("pagination")).setList(list);
		}
	}

	@Override
	public int update(String sqlId, Object entityObject) {
		return getSqlSession().update(sqlId, entityObject);
	}

	@Override
	public int update(String sqlId, Map<String, Object> bindParams) {
		return getSqlSession().update(sqlId, bindParams);
	}

	@Override
	public int delete(String sqlId, Serializable id) {
		return getSqlSession().delete(sqlId, id);
	}

	@Override
	public int delete(String sqlId, Object entityObject) {
		return getSqlSession().delete(sqlId, entityObject);
	}

	@Override
	public int delete(String sqlId, Map<String, Object> bindParams) {
		return getSqlSession().delete(sqlId, bindParams);
	}

	@Override
	public int insert(String sqlId, Object entityObject) {
		getSqlSession().insert(sqlId, entityObject);
		return 1;
	}

	@Override
	public int insertReturnValue(String sqlId, Object entityObject) {
		return getSqlSession().insert(sqlId, entityObject);
	}

	@Override
	public void batchUpdate(String sqlId, Object[] params) {
		// TODO Auto-generated method stub

	}

	@Override
	public <T> void batchUpdate(String sqlId, Collection<T> array) {
		// TODO Auto-generated method stub

	}

	@Override
	public void execute(String sqlId, Object entityObject) {
		// TODO Auto-generated method stub

	}

	@Override
	public void executeHelpKeyword(String sqlId, Object entityObject) {
		// TODO Auto-generated method stub

	}

	/*
	 * @Override public void execute(final String sqlId, final Object
	 * entityObject) { super.getSqlSession().execute(new SqlMapClientCallback()
	 * {
	 * 
	 * @Override public Object doInSqlMapClient(SqlMapExecutor executor) throws
	 * SQLException { executor.startBatch();// 开始批处理 keywords.add(entityObject);
	 * if (keywords.size() == Constants.cacheSize) { for (int i = 0; i <
	 * keywords.size(); i++) { executor.update(sqlId, keywords.get(i)); }
	 * executor.executeBatch();// 执行批处理 keywords.clear();// 执行完后清空数组 } return
	 * null; } }); }
	 * 
	 * @Override public void executeHelpKeyword(final String sqlId, final Object
	 * entityObject) { super.getSqlMapClientTemplate().execute(new
	 * SqlMapClientCallback() {
	 * 
	 * @Override public Object doInSqlMapClient(SqlMapExecutor executor) throws
	 * SQLException { executor.startBatch();// 开始批处理
	 * helpKeywords.add(entityObject); if (helpKeywords.size() ==
	 * Constants.cacheSize) { for (int i = 0; i < helpKeywords.size(); i++) {
	 * executor.update(sqlId, helpKeywords.get(i)); } executor.executeBatch();//
	 * 执行批处理 helpKeywords.clear();// 执行完后清空数组 } return null; } }); }
	 */

	/*
	 * @Override public void batchUpdate(final String sqlId, final Object[]
	 * params) { if(ArrayUtils.hasLength(params)) {
	 * getSqlMapClientTemplate().execute(new SqlMapClientCallback() {
	 * 
	 * @Override public Object doInSqlMapClient(SqlMapExecutor executor) throws
	 * SQLException { executor.startBatch(); for(Object p : params) {
	 * executor.update(sqlId, p); } return executor.executeBatch();
	 * 
	 * }
	 * 
	 * }); } }
	 */
	/*
	 * @Override public <T> void batchUpdate(final String sqlId, final
	 * Collection<T> params) { if(ArrayUtils.hasLength(params)) { Object affect
	 * = getSqlMapClientTemplate().execute(new SqlMapClientCallback() {
	 * 
	 * @Override public Object doInSqlMapClient(SqlMapExecutor executor) throws
	 * SQLException { executor.startBatch(); for(Object p : params) {
	 * executor.update(sqlId, p); } return executor.executeBatch(); } }); } }
	 */

}