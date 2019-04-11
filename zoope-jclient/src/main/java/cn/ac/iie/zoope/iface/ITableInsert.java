package cn.ac.iie.zoope.iface;

import org.apache.thrift.TException;
import org.apache.thrift.transport.TTransportException;

/**
 * 插入数据操作
 * @author zhangzhanqi
 */
public interface ITableInsert {

    /**
     * 按json格式插入数据
     * @param json 数据
     */
    void json(String json) throws TException;
}
