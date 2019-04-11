import cn.ac.iie.zoope.client.ZoopeClient;
import cn.ac.iie.zoope.iface.*;
import org.apache.thrift.TException;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestClient {


    @Test
    public void test() throws TException {

        ZoopeClient client = ZoopeClient.builder().url("").user("zzq").password("zzq").build();

        IZoopeDatabase db = client.database("mydb");

        if (!db.exist()) {
            db.create();
        }
        IZoopeTable table = db.table("test");

        if (!table.exist()) {
            List<IZoopeField> fields = new ArrayList<>();
            fields.add(new ZoopeField("id", FieldType.STRING, true, false));
            fields.add(new ZoopeField("name", FieldType.STRING, true, true));
            ZoopeField create_time = new ZoopeField("create_time", FieldType.LONG, true);
            //TODO 时间精确度
            create_time.setPartition(true);
            fields.add(create_time);
            table.create(fields);
            //TODO 分区规则
        }

        ITableInsert insert = table.insert();

        insert.json("{\"id\":\"123123\", \"name\":\"zzq\", \"create_time\": " + System.currentTimeMillis() + "}");

        ITableSearch search = table.search();

        String json = search.and("id","123123", "=").or("name", new ZoopeTerm("zzq").or("zzk"), "=").time("2019-01-01 00:00:00", ">=").time("2019-01-02 00:00:00", "<").run();

    }
}
