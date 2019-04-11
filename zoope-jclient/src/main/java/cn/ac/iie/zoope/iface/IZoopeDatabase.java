package cn.ac.iie.zoope.iface;

/**
 * 数据库
 * @author zhangzhanqi
 * @date 2019-04-09
 */
public interface IZoopeDatabase {

    /**
     *
     */
    String name();

    /**
     * 创建库
     * 需要用户权限
     */
    void create();

    /**
     * 判断库是否存在
     * @return
     */
    boolean exist();

    /**
     * 获取当前库下表名为{$name}的表
     * @param name
     * @return
     */
    IZoopeTable table(String name);

}
