package cn.ac.iie.zoope.iface;

import cn.ac.iie.zoope.client.ZoopeSocket;
import cn.ac.iie.zoope.server.ActionType;
import cn.ac.iie.zoope.server.Zoope;
import cn.ac.iie.zoope.server.ZoopeAck;
import cn.ac.iie.zoope.server.ZoopeAction;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TTransport;

public class TableInsert implements ITableInsert {

    private IZoopeTable table;

    TableInsert(IZoopeTable table) {
        this.table = table;
    }

    @Override
    public void json(String json) throws TException {
        TTransport transport = ZoopeSocket.test();
        TProtocol protocol = new TBinaryProtocol(transport);

        Zoope.Client client = new Zoope.Client(protocol);

        transport.open();
        ZoopeAction action = new ZoopeAction();
        action.setDb(table.getDatabase().name());
        action.setTable(table.name());
        action.setType(ActionType.INSERT);
        action.setMessage(json);
        ZoopeAck zoopeAck = client.doInsert(action);
        System.out.println(zoopeAck.status);
        System.out.println(zoopeAck.message);
    }
}
