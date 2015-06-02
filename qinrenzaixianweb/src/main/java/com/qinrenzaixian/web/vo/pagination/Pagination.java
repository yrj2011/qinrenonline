package com.qinrenzaixian.web.vo.pagination;

import java.io.Serializable;
import java.util.List;

import com.qinrenzaixian.core.util.string.StringUtils;

/**
 * 分页对象
 * @author yangrenjiang
 */
public class Pagination<T> extends Result implements Cloneable, Serializable {
    /**  */
    private static final long serialVersionUID = 1L;
    /**
     * 
     */
    protected int             page             = 1;
    /**
     * 
     */
    protected int             pageSize         = 10;    
    /**
     * 分页开始位置
     */
    protected int             start            = 0;     
    /**
     * 分页结果位置
     */
    protected int             end              = 10;    
    /**
     * 总记录数
     */
    protected int             totalCount       = 0;    
    /**
     * 总页数
     */
    protected int             totalPage        = 0;     
    /**
     * 列表
     */
    protected List<T>         list;                   
    /**
     * 返回结果PAGE:分页,ALL:全部
     */
    protected String          returnFlag       = "PAGE"; 
    protected String          dbOrderName        = "";
    protected String          dbOrderType        = "";
    public static String      ALL              = "ALL";
    public static String      PAGE             = "PAGE";
    

    /**
     * 获取总数
     * 
     * @return
     */
    public int getTotalCount() {
        return totalCount;
    }

    /**
     * 分页大小
     * 
     * @return
     */
    public int getPageSize() {
        return pageSize;
    }

    public Pagination<T> setPageSize(int pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    public long getNextPage() {
        return Math.min(page==0?2:page + 1, totalPage);
    }

    public long getPrevPage() {
        return Math.max(page - 1, 1);
    }

    public boolean getHasNextPage() {
        return page == 0 ? page + 2 == totalPage : page + 1 == totalPage;
    }

    public boolean hasNextPage() {
        return getHasNextPage();
    }

    public boolean getHasPrevPage() {
        return page - 1 == 0 ? false : true;
    }

    public boolean hasPrevPage() {
        return getHasPrevPage();
    }

    /**
     * 获取当前页
     * 
     * @return
     */
    public int getPage() {
        page = Math.max(page, 1);
        page = Math.min(page, totalPage);
        return page;
    }
    
    public int getCurrentPage() {
        return page == 0 ? 1 : page;
    }

    public void setPage(String page) {
        this.page = StringUtils.parseInt(page,1);
    }

    public void setCurrentPage(int page) {
        this.page = Math.max(page, 1);
    }

    /**
     * 跳转到XX页
     * 
     * @param page
     */
    public void gotoPage(int page) {
        if (page <= 0) {
            this.page = 1;
        } else {
            this.page = Math.min(page, totalPage);
        }
    }

    /**
     * 总页数
     * 
     * @return
     */
    public int getTotalPage() {
        return totalPage;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    /**
     * 重置分页
     * 
     * @param numTotalHits
     */
    public void repaginate(int numTotalHits) {
        totalPage = numTotalHits % pageSize == 0 ? numTotalHits / pageSize : numTotalHits
                                                                             / pageSize + 1;// 总页数
        totalCount = numTotalHits;
        start = Math.min(Math.max(0, page - 1) * pageSize, Math.max((totalPage - 1), 0) * pageSize);// 需要返回结果的开始位置
        end = Math.min(start + pageSize, numTotalHits);// 结束位置
        end = end == 0 ? start + pageSize : end;
    }

    /**
     * 重置分页,设置偏移量
     * @param page
     * @param offset
     */
    public void repaginateWithoutFirstPage(int numTotalHits, int firstPageSize, int pageSize) {
        if (numTotalHits > firstPageSize) {
            int withoutFirstPage = numTotalHits - firstPageSize;
            int withoutFirstPageCount = withoutFirstPage % pageSize == 0 ? withoutFirstPage
                                                                           / pageSize
                : withoutFirstPage / pageSize + 1;
            totalPage = withoutFirstPageCount + 1;
        } else {
            totalPage = numTotalHits % pageSize == 0 ? numTotalHits / pageSize : numTotalHits
                                                                                 / pageSize + 1;// 总页数
        }
        totalCount = numTotalHits;

        if (page == 1) {
            start = 0;
            end = firstPageSize;
        } else if (totalPage <= 1) {
            start = 0;
            end = totalCount;
        } else if (totalPage > 1) {
            start = Math.max(0, firstPageSize + (page - 2) * pageSize);
            end = Math.min(start + pageSize, numTotalHits);// 结束位置
            end = end == 0 ? start + pageSize : end;
        }

    }

    /**
     * 分页开始位置
     * 
     * @return
     */
    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    /**
     * 分页结束位置
     * 
     * @return
     */
    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public Object clone() {
        Object o = null;
        try {
            o = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return o;
    }

    public String getReturnFlag() {
        return returnFlag;
    }

    public void setReturnFlag(String returnFlag) {
        this.returnFlag = returnFlag;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }
    
    public String getDbOrderName() {
        return dbOrderName;
    }

    public void setDbOrderName(String dbOrderName) {
        this.dbOrderName = dbOrderName;
    }
    
    public String getDbOrder() {
        return dbOrderName;
    }

    public String getDbOrderType() {
        return dbOrderType;
    }

    public void setDbOrderType(String dbOrderType) {
        this.dbOrderType = dbOrderType;
    }


}
