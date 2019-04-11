package cn.ac.iie.zoope.client;

import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

public class ZoopeSocket {

    public TTransport getTTransport(int socketTimeout, int connectionTimeout) {
        return new TSocket("localhost", 8000, socketTimeout, connectionTimeout);
    }

    public static TTransport test() {
        return new TSocket("localhost", 8000, 30* 1000, 30 * 1000);
    }
}
