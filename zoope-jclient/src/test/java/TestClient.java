import cn.ac.iie.zoope.client.ZoopeClient;
import cn.ac.iie.zoope.exception.ZoopeException;
import cn.ac.iie.zoope.iface.*;
import org.apache.thrift.TException;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestClient {


    @Test
    public void test() throws ZoopeException {

        ZoopeClient client = ZoopeClient.builder().url("localhost:8000").user("zzq").password("zzq").build();

        client.insert("db", "1113table", "[{\"id\":123123, \"name\":\"zzq\"}]");

        client.search("db", "1113table", "id:123123 OR name:(zzq OR zzk)", 10, "id", "asc");

        client.update("db", "1113table", "id:123123", "{\"id\":123123, \"name\":\"zzk\"}");

        client.delete("db", "1113table", "id:123123");
    }
}
