package cn.ac.iie.zoope.iface;

/**
 * 数据更新操作
 * @author zhangzhanqi
 */
public interface ITableUpdate {

    /**
     * 按json格式更新数据
     * @param json 数据
     */
    void json(String json);
}
