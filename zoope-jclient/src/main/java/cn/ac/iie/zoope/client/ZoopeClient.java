package cn.ac.iie.zoope.client;

import cn.ac.iie.zoope.exception.ZoopeException;
import cn.ac.iie.zoope.iface.SearchStruct;
import cn.ac.iie.zoope.iface.Term;
import cn.ac.iie.zoope.iface.UpdateStruct;
import cn.ac.iie.zoope.server.ActionType;
import cn.ac.iie.zoope.server.Zoope;
import cn.ac.iie.zoope.server.ZoopeAck;
import cn.ac.iie.zoope.server.ZoopeAction;
import com.google.gson.Gson;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TTransport;

/**
 * zoppe 客户端
 * socket timeout 30s, connection timeout 30s
 *
 * @author zhangzhanqi
 * @date 2019-04-09
 */
public class ZoopeClient {
    private final static Gson gson = new Gson();

    private String url;

    private int socketTimeout = 30 * 1000;

    private int connectionTimeout = 30 * 1000;

    private String user;

    private String pass;

    /**
     * @param url 服务地址
     *            read timeout 30s, connection timeout 30s
     *            无用户密码
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

        private int socketTimeout = 30 * 1000;

        private int connectionTimeout = 30 * 1000;

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
     * 插入数据
     *
     * @param dbName
     * @param tableName
     * @param data
     */
    public ZoopeAck insert(String dbName, String tableName, String data) throws ZoopeException {
        try {
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
            return zoopeAck;
        } catch (TException e) {
            throw new ZoopeException(e);
        }
    }

    public ZoopeAck search(String dbName, String tableName, String term) throws ZoopeException {
        return search(dbName, tableName, term, -1, null, null);
    }

    public ZoopeAck search(String dbName, String tableName, Term term) throws ZoopeException {
        return search(dbName, tableName, term.content(), -1, null, null);
    }

    public ZoopeAck search(String dbName, String tableName, String term, int limit) throws ZoopeException {
        return search(dbName, tableName, term, limit, null, null);
    }

    public ZoopeAck search(String dbName, String tableName, Term term, int limit) throws ZoopeException {
        return search(dbName, tableName, term.content(), limit, null, null);
    }

    public ZoopeAck search(String dbName, String tableName, String term, int limit, String sortField) throws ZoopeException {
        return search(dbName, tableName, term, limit, sortField, "asc");
    }

    public ZoopeAck search(String dbName, String tableName, Term term, int limit, String sortField) throws ZoopeException {
        return search(dbName, tableName, term.content(), limit, sortField, "asc");
    }

    public ZoopeAck search(String dbName, String tableName, Term term, int limit, String sortField, String order) throws ZoopeException {
        return search(dbName, tableName, term.content(), limit, sortField, order);
    }

    public ZoopeAck search(String dbName, String tableName, String term, int limit, String sortField, String order) throws ZoopeException {
        try {
            TTransport transport = ZoopeSocket.test();
            TProtocol protocol = new TBinaryProtocol(transport);
            Zoope.Client client = new Zoope.Client(protocol);
            transport.open();
            ZoopeAction action = new ZoopeAction();
            action.setDb(dbName);
            action.setTable(tableName);
            action.setType(ActionType.SEARCH);
            SearchStruct content = new SearchStruct(term, limit, sortField, order);
            action.setMessage(gson.toJson(content));
            ZoopeAck zoopeAck = client.doSearch(action);
            transport.close();
            System.out.println(zoopeAck.status);
            System.out.println(zoopeAck.message);
            return zoopeAck;
        } catch (TException e) {
            throw new ZoopeException(e);
        }
    }

    public ZoopeAck update(String dbName, String tableName, Term term, String data) throws ZoopeException {
        return update(dbName, tableName, term.content(), data);
    }

    public ZoopeAck update(String dbName, String tableName, String term, String data) throws ZoopeException {
        try {
            TTransport transport = ZoopeSocket.test();
            TProtocol protocol = new TBinaryProtocol(transport);
            Zoope.Client client = new Zoope.Client(protocol);
            transport.open();
            ZoopeAction action = new ZoopeAction();
            action.setDb(dbName);
            action.setTable(tableName);
            action.setType(ActionType.UPDATE);
            UpdateStruct content = new UpdateStruct(term, data);
            action.setMessage(gson.toJson(content));
            ZoopeAck zoopeAck = client.doUpdate(action);
            transport.close();
            System.out.println(zoopeAck.status);
            System.out.println(zoopeAck.message);
            return zoopeAck;
        } catch (TException e) {
            throw new ZoopeException(e);
        }
    }


    public ZoopeAck delete(String dbName, String tableName, Term term) throws ZoopeException {
        return delete(dbName, tableName, term.content());
    }

    public ZoopeAck delete(String dbName, String tableName, String term) throws ZoopeException {
        try {
            TTransport transport = ZoopeSocket.test();
            TProtocol protocol = new TBinaryProtocol(transport);
            Zoope.Client client = new Zoope.Client(protocol);
            transport.open();
            ZoopeAction action = new ZoopeAction();
            action.setDb(dbName);
            action.setTable(tableName);
            action.setType(ActionType.DELETE);
            action.setMessage(term);//content -> field:term
            ZoopeAck zoopeAck = client.doDelete(action);
            transport.close();
            System.out.println(zoopeAck.status);
            System.out.println(zoopeAck.message);
            return zoopeAck;
        } catch (TException e) {
            throw new ZoopeException(e);
        }
    }

}
