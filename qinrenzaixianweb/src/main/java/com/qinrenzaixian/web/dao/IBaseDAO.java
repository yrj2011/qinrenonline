package com.qinrenzaixian.web.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.qinrenzaixian.web.vo.pagination.Pagination;

/**
 * 基本dao接口
 * @author yrj
 */
public interface IBaseDAO {

    public int count(String sqlId, Serializable id);

    public Object queryForObject(String sqlId, Serializable id);

    public Object queryForObject(String sqlId, Object params);

    public Object queryForObject(String sqlId, Map<String, Object> bindParams);

    public int count(String sqlId, Object entityObject);

    public <T> T findById(String sqlId, Serializable id);

    public <T> List<T> queryForList(String sqlId);

    public <T> List<T> queryForList(String sqlId, Map<String, Object> bindParams);

    public <T> List<T> queryForList(String sqlId, Object entityObject);

    public <T> List<T> queryForList(String sqlId, Serializable id);

    /** 
     * 分页查询
     * @param <T>
     * @param sqlId
     * @param paginate
     */
    public <T> void queryForPaginate(String sqlId, Pagination<T> paginate);

    /**
     * 分页查询
     * @param <T>
     * @param sqlId
     * @param paginate
     */
    public <T> void queryForPaginate(String sqlId, Map<String, Object> paginate);

    public int update(String sqlId, Object entityObject);

    public int update(String sqlId, Map<String, Object> bindParams);
    
    public void batchUpdate(String sqlId, Object[] params);
    
    public <T> void batchUpdate(String sqlId, Collection<T> array);

    public int delete(String sqlId, Serializable id);

    public int delete(String sqlId, Object entityObject);

    public int delete(String sqlId, Map<String, Object> bindParams);

    public int insert(String sqlId, Object entityObject);
    
    public void execute(String sqlId, Object entityObject);
    
    public void executeHelpKeyword(String sqlId, Object entityObject);
    /**
     * 返回插入的id
     * @param sqlId
     * @param entityObject
     * @return
     */
    public int insertReturnValue(String sqlId, Object entityObject);
}