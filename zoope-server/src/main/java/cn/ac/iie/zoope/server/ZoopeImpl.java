package cn.ac.iie.zoope.server;

import org.apache.thrift.TException;

/**
 * 服务接口实现
 * @author libing
 */
public class ZoopeImpl implements Zoope.Iface {

    /**
     * 插入数据
     * @param action
     * @return
     * @throws TException
     */
    @Override
    public ZoopeAck doInsert(ZoopeAction action) throws TException {
        return null;
    }

    /**
     * 查询数据
     * @param action
     * @return
     * @throws TException
     */
    @Override
    public ZoopeAck doSearch(ZoopeAction action) throws TException {
        return null;
    }

    /**
     * 删除数据
     * @param action
     * @return
     * @throws TException
     */
    @Override
    public ZoopeAck doDelete(ZoopeAction action) throws TException {
        return null;
    }

    /**
     * 更新数据
     * @param action
     * @return
     * @throws TException
     */
    @Override
    public ZoopeAck doUpdate(ZoopeAction action) throws TException {
        return null;
    }
}
