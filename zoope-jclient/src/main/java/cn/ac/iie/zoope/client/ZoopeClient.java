package cn.ac.iie.zoope.client;

import cn.ac.iie.zoope.iface.IZoopeDatabase;
import cn.ac.iie.zoope.iface.IZoopeTable;
import cn.ac.iie.zoope.iface.IZoopeTerm;
import cn.ac.iie.zoope.iface.ZoopeDatabase;
import cn.ac.iie.zoope.server.ActionType;
import cn.ac.iie.zoope.server.Zoope;
import cn.ac.iie.zoope.server.ZoopeAck;
import cn.ac.iie.zoope.server.ZoopeAction;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TTransport;

/**
 * zoppe 客户端
 * socket timeout 30s, connection timeout 30s
 * @author zhangzhanqi
 * @date 2019-04-09
 */
public class ZoopeClient {
    private String url;

    private int socketTimeout = 30* 1000;

    private int connectionTimeout = 30* 1000;

    private String user;

    private String pass;

    /**
     *
     * @param url 服务地址
     *     read timeout 30s, connection timeout 30s
     *     无用户密码
     */
    public ZoopeClient(String url) {
        this.url = url;
    }

    public ZoopeClient(Builder builder) {
        this(builder.url, builder.socketTimeout, builder.connectionTimeout, builder.user, builder.pass);
    }

    private ZoopeClient(String url, int socketTimeout, int connectionTimeout, String user, String pass) {
        this.url = url;
        this.socketTimeout = socketTimeout;
        this.connectionTimeout = connectionTimeout;
        this.user = user;
        this.pass = pass;

        //TODO 连接master认证用户名密码是否正确
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private String url;

        private int socketTimeout = 30* 1000;

        private int connectionTimeout = 30* 1000;

        private String user;

        private String pass;

        public ZoopeClient build() {
            return new ZoopeClient(this);
        }

        public Builder url(String url) {
            this.url = url;
            return this;
        }

        public Builder socketTimeout(int socketTimeout) {
            this.socketTimeout = socketTimeout;
            return this;
        }

        public Builder connectionTimeout(int connectionTimeout) {
            this.connectionTimeout = connectionTimeout;
            return this;
        }

        public Builder user(String user) {
            this.user = user;
            return this;
        }

        public Builder password(String password) {
            this.pass = password;
            return this;
        }

    }

    /**
     * 获取名为default的数据库
     * @return
     */
    public IZoopeDatabase database() {
        return new ZoopeDatabase();
    }

    /**
     * 获取名为{$dbName}的数据库
     * @return
     */
    public IZoopeDatabase database(String dbName) {
        return new ZoopeDatabase(dbName);
    }

    /**
     *
     * @param dbName
     * @param tName
     * @return
     */
    public IZoopeTable table(String dbName, String tName) {
        return new ZoopeDatabase(dbName).table(tName);
    }

    /**
     *
     * @param tName
     * @return
     */
    public IZoopeTable table(String tName) {
        return new ZoopeDatabase().table(tName);
    }


    /**
     * 插入数据
     * @param dbName
     * @param tableName
     * @param data
     * @return
     * @throws TException
     */
    public ZoopeAck insert(String dbName, String tableName, String data) throws TException {
        TTransport transport = ZoopeSocket.test();
        TProtocol protocol = new TBinaryProtocol(transport);
        Zoope.Client client = new Zoope.Client(protocol);
        transport.open();
        ZoopeAction action = new ZoopeAction();
        action.setDb(dbName);
        action.setTable(tableName);
        action.setType(ActionType.INSERT);
        action.setMessage(data);
        ZoopeAck zoopeAck = client.doInsert(action);
        transport.close();
        System.out.println(zoopeAck.status);
        System.out.println(zoopeAck.message);
        return null;
    }

    public ZoopeAck search(String dbName, String tableName, IZoopeTerm term){
        return null;
    }

    public ZoopeAck update(String dbName, String tableName, String data){
        return null;
    }

    public ZoopeAck delete(String dbName, String tableName, String data){
        return null;
    }

}
