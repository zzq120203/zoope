package cn.ac.iie.zoope.iface;

public class SearchStruct {

    //lucene 查询语法
    private String query;//title:"hello word" AND text:(go OR java)

    //返回个数
    private int limit;

    //排序字段
    private String sortField;

    //默认正序
    private String order = "asc"; //ASC\DESC

    public SearchStruct(String query) {
        this.query = query;
    }

    public SearchStruct(String query, int limit) {
        this.query = query;
        this.limit = limit;
    }

    public SearchStruct(String query, int limit, String sortField, String order) {
        this.query = query;
        this.limit = limit;
        this.sortField = sortField;
        if (order != null) {
            this.order = order;
        }
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public String getSortField() {
        return sortField;
    }

    public void setSortField(String sortField) {
        this.sortField = sortField;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }
}
