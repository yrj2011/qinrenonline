package com.qinrenzaixian.web.vo.pagination;

import java.util.List;
import java.util.Map;

/**
 * 页信息
 * @author xiaoyang
 *
 * @param <T>
 */
public class PageInfo<T> {
    private Map<String, Object> aggregations;
    private int total;
    private List<T> list;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public Map<String, Object> getAggregations() {
        return aggregations;
    }

    public void setAggregations(Map<String, Object> aggregations) {
        this.aggregations = aggregations;
    }
}
