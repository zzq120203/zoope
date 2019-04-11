package cn.ac.iie.zoope.server;

import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;

/**
 * 服务端启动
 * @author libing
 * @date 2019-04-09
 */
public class ZoopeServer {

    public void startServer() {
        try {
            System.out.println("HelloWorld Server start...");
            //定义传输的socket，设置服务端口
            TServerSocket serverTransport = new TServerSocket(6789);
            //关联处理器与Hello服务的实现
            TProcessor process = new Zoope.Processor<>(new ZoopeImpl());

            //设置协议工厂为TBinaryProtocol.Factory
            TBinaryProtocol.Factory portFactory = new TBinaryProtocol.Factory(true, true);

            //定义服务端的参数值
            TServer.Args args = new TServer.Args(serverTransport);
            args.processor(process);
            args.protocolFactory(portFactory);
            TServer server = new TSimpleServer(args);

            //启动服务
            server.serve();
        } catch (Exception e) {
            System.out.println("Server start error");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ZoopeServer server = new ZoopeServer();
        server.startServer();
    }
}
