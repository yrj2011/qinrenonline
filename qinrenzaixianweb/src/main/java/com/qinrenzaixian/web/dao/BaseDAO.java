package com.qinrenzaixian.web.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.springframework.orm.ibatis.SqlMapClientCallback;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapExecutor;
import com.zhaoonline.web.util.ArrayUtils;
import com.zhaoonline.web.util.constants.Constants;
import com.zhaoonline.web.vo.pagination.Pagination;


@SuppressWarnings("all")
public class BaseDAO extends SqlMapClientDaoSupport implements IBaseDAO {
    @Inject
    private SqlMapClient sqlMapClient;
    
    /** 搜索关健字缓存数组 */
    private  static List<Object> keywords = null; 
    private  static List<Object> helpKeywords = null; 
    static{
    		keywords = new ArrayList<Object>();
    		helpKeywords = new ArrayList<Object>();
    }
    
    /** 
     * @see com.zhaoonline.web.dao.IBaseDAO#initSqlMapClient()
     */
    @PostConstruct
    public void initSqlMapClient() {
        super.setSqlMapClient(sqlMapClient);
    }
    
    /** 
     * @see com.zhaoonline.web.dao.IBaseDAO#count(java.lang.String, java.io.Serializable)
     */
    @Override
    public int count(String sqlId, Serializable id) {
        return (Integer) getSqlMapClientTemplate().queryForObject(sqlId, id);
    }

    /** 
     * @see com.zhaoonline.web.dao.IBaseDAO#queryForObject(java.lang.String, java.io.Serializable)
     */
    @Override
    public Object queryForObject(String sqlId, Serializable id) {
        return getSqlMapClientTemplate().queryForObject(sqlId, id);
    }
    
    /** 
     * @see com.zhaoonline.web.dao.IBaseDAO#queryForObject(java.lang.String, java.lang.Object)
     */
    @Override
    public Object queryForObject(String sqlId, Object params) {
        return getSqlMapClientTemplate().queryForObject(sqlId, params);
    }

    /** 
     * @see com.zhaoonline.web.dao.IBaseDAO#queryForObject(java.lang.String, java.util.Map)
     */
    @Override
    public Object queryForObject(String sqlId, Map<String, Object> bindParams) {
        return getSqlMapClientTemplate().queryForObject(sqlId, bindParams);
    }

    /** 
     * @see com.zhaoonline.web.dao.IBaseDAO#count(java.lang.String, java.lang.Object)
     */
    @Override
    public int count(String sqlId, Object entityObject) {
        return (Integer) getSqlMapClientTemplate().queryForObject(sqlId, entityObject);
    }

    /** 
     * @see com.zhaoonline.web.dao.IBaseDAO#findById(java.lang.String, java.io.Serializable)
     */
    @Override
    public <T> T findById(String sqlId, Serializable id) {
        return (T) getSqlMapClientTemplate().queryForObject(sqlId, id);
    }

    /** 
     * @see com.zhaoonline.web.dao.IBaseDAO#queryForList(java.lang.String)
     */
    @Override
    public <T> List<T> queryForList(String sqlId) {
        return getSqlMapClientTemplate().queryForList(sqlId, null);
    }

    /** 
     * @see com.zhaoonline.web.dao.IBaseDAO#queryForList(java.lang.String, java.util.Map)
     */
    @Override
    public <T> List<T> queryForList(String sqlId, Map<String, Object> bindParams) {
        return getSqlMapClientTemplate().queryForList(sqlId, bindParams);
    }

    /** 
     * @see com.zhaoonline.web.dao.IBaseDAO#queryForList(java.lang.String, java.lang.Object)
     */
    @Override
    public <T> List<T> queryForList(String sqlId, Object entityObject) {
        return getSqlMapClientTemplate().queryForList(sqlId, entityObject);
    }

    /** 
     * @see com.zhaoonline.web.dao.IBaseDAO#queryForList(java.lang.String, java.io.Serializable)
     */
    @Override
    public <T> List<T> queryForList(String sqlId, Serializable id) {
        return getSqlMapClientTemplate().queryForList(sqlId, id);
    }

    /** 
     * @see com.zhaoonline.web.dao.IBaseDAO#queryForPaginate(java.lang.String, com.zhaoonline.web.vo.pagination.Pagination)
     */
    @Override
    public <T> void queryForPaginate(String sqlId, Pagination<T> paginate) {
        //结果数配置的sqlid默认应该是sqlid后加-count
        int count = this.count(sqlId.concat("-count"), paginate);
        paginate.repaginate(count);
        if(count > 0) {
            List<T> list = this.queryForList(sqlId, paginate);
            paginate.setList(list);
        }
    }
    
    /** 
     * @see com.zhaoonline.web.dao.IBaseDAO#queryForPaginate(java.lang.String, java.util.Map)
     */
    @Override
    public <T> void queryForPaginate(String sqlId, Map<String, Object> paginate) {
        //结果数配置的sqlid默认应该是sqlid后加-count
        int count = this.count(sqlId.concat("-count"), paginate);
        if(paginate.get("pagination") == null) {
            throw new RuntimeException("pagination parameter is required!");
        }
        
        Pagination<T> pagination = (Pagination<T>)paginate.get("pagination");
        pagination.repaginate(count);
        if(count > 0) {
            paginate.put("start", pagination.getStart());
            paginate.put("end", pagination.getEnd());
            List<T> list = this.queryForList(sqlId, paginate);
            ((Pagination<T>)paginate.get("pagination")).setList(list);
        }
    }
    
    /** 
     * @see com.zhaoonline.web.dao.IBaseDAO#update(java.lang.String, java.lang.Object)
     */
    @Override
    public int update(String sqlId, Object entityObject) {
        return getSqlMapClientTemplate().update(sqlId, entityObject);
    }

    /** 
     * @see com.zhaoonline.web.dao.IBaseDAO#update(java.lang.String, java.util.Map)
     */
    @Override
    public int update(String sqlId, Map<String, Object> bindParams) {
        return getSqlMapClientTemplate().update(sqlId, bindParams);
    }

    /** 
     * @see com.zhaoonline.web.dao.IBaseDAO#delete(java.lang.String, java.io.Serializable)
     */
    @Override
    public int delete(String sqlId, Serializable id) {
        return getSqlMapClientTemplate().delete(sqlId, id);
    }

    /** 
     * @see com.zhaoonline.web.dao.IBaseDAO#delete(java.lang.String, java.lang.Object)
     */
    @Override
    public int delete(String sqlId, Object entityObject) {
        return getSqlMapClientTemplate().delete(sqlId, entityObject);
    }

    /** 
     * @see com.zhaoonline.web.dao.IBaseDAO#delete(java.lang.String, java.util.Map)
     */
    @Override
    public int delete(String sqlId, Map<String, Object> bindParams) {
        return getSqlMapClientTemplate().delete(sqlId, bindParams);
    }

    /** 
     * @see com.zhaoonline.web.dao.IBaseDAO#insert(java.lang.String, java.lang.Object)
     */
    @Override
    public int insert(String sqlId, Object entityObject) {
        getSqlMapClientTemplate().insert(sqlId, entityObject);
        return 1;
    }
    /** 
     * @see com.zhaoonline.web.dao.IBaseDAO#insert(java.lang.String, java.lang.Object)
     */
    @Override
    public int insertReturnValue(String sqlId, Object entityObject) {
        return Integer.valueOf(getSqlMapClientTemplate().insert(sqlId, entityObject).toString());
        
    }
	@Override
	public void execute(final String sqlId, final Object entityObject) {
		super.getSqlMapClientTemplate().execute(new SqlMapClientCallback() {
			@Override
			public Object doInSqlMapClient(SqlMapExecutor executor)
					throws SQLException {
				executor.startBatch();// 开始批处理
				keywords.add(entityObject);
				if (keywords.size() == Constants.cacheSize) {
					for (int i = 0; i < keywords.size(); i++) {
						executor.update(sqlId, keywords.get(i));
					}
					executor.executeBatch();// 执行批处理
					keywords.clear();// 执行完后清空数组
				}
				return null;
			}
		});
	}

	@Override
	public void executeHelpKeyword(final String sqlId, final Object entityObject) {
		super.getSqlMapClientTemplate().execute(new SqlMapClientCallback() {
			@Override
			public Object doInSqlMapClient(SqlMapExecutor executor)
					throws SQLException {
				executor.startBatch();// 开始批处理
				helpKeywords.add(entityObject);
				if (helpKeywords.size() == Constants.cacheSize) {
					for (int i = 0; i < helpKeywords.size(); i++) {
						executor.update(sqlId, helpKeywords.get(i));
					}
					executor.executeBatch();// 执行批处理
					helpKeywords.clear();// 执行完后清空数组
				}
				return null;
			}
		});
	}
	
    /** 
     * @see com.zhaoonline.web.dao.IBaseDAO#batchUpdate(java.lang.String, java.lang.Object[])
     */
    @Override
    public void batchUpdate(final String sqlId, final Object[] params) {
        if(ArrayUtils.hasLength(params)) {
            getSqlMapClientTemplate().execute(new SqlMapClientCallback() {
                @Override
                public Object doInSqlMapClient(SqlMapExecutor executor) throws SQLException {
                    executor.startBatch();
                    for(Object p : params) {
                        executor.update(sqlId, p);
                    }
                    return executor.executeBatch();
                    
                }
                
            });
        }
    }

    /** 
     * @see com.zhaoonline.web.dao.IBaseDAO#batchUpdate(java.lang.String, java.util.Collection)
     */
    @Override
    public <T> void batchUpdate(final String sqlId, final Collection<T> params) {
        if(ArrayUtils.hasLength(params)) {
            Object affect = getSqlMapClientTemplate().execute(new SqlMapClientCallback() {
                @Override
                public Object doInSqlMapClient(SqlMapExecutor executor) throws SQLException {
                    executor.startBatch();
                    for(Object p : params) {
                        executor.update(sqlId, p);
                    }
                    return executor.executeBatch();
                }
            });
        }
    }

} 