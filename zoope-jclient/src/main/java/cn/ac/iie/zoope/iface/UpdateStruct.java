package cn.ac.iie.zoope.iface;

public class UpdateStruct {

    //lucene 查询语法
    private String query;//title:"hello word" AND text:(go OR java)

    //更新数据
    private String data;

    public UpdateStruct(String query, String data) {
        this.query = query;
        this.data = data;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
