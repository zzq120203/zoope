package cn.ac.iie.zoope.iface;

/**
 * 数据删除操作
 * @author zhangzhanqi
 */
public interface ITableDelete {

    /**
     * 按json格式删除数据
     * @param json 数据
     */
    void json(String json);
}
