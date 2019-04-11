package cn.ac.iie.zoope.iface;

import java.util.List;

/**
 * 数据表
 * @author zhangzhanqi
 * @date 2019-04-09
 */
public interface IZoopeTable {

    /**
     *
     */
    IZoopeDatabase getDatabase();

    String name();

    /**
     * 创建表
     * 需要用户权限
     * @param fields
     * @return
     */
    boolean create(List<IZoopeField> fields);

    /**
     * 指定分区创建表？？？
     * 需要用户权限
     * @param fields
     * @param timePartition
     * @return
     */
    boolean create(List<IZoopeField> fields, String timePartition);

    /**
     * 判断表是否存在
     * @return
     */
    boolean exist();

    /**
     * 添加字段
     * 需要用户权限
     * @param field
     * @return
     */
    IZoopeTable alter(IZoopeField field);

    /**
     * 删除表
     * 需要用户权限
     * @return
     */
    boolean drop();

    /**
     * 插入数据
     * @return
     */
    ITableInsert insert();

    /**
     * 查询数据
     * @return
     */
    ITableSearch search();

    /**
     * 插入数据
     * @return
     */
    ITableDelete delete();

    /**
     * 查询数据
     * @return
     */
    ITableUpdate update();

    /**
     * 获取表字段
     * @return
     */
    List<IZoopeField> fields();

    /**
     * 获取名为{$name}的字段
     * @param name
     * @return
     */
    IZoopeField field(String name);
}
