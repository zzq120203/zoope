package cn.ac.iie.zoope.master;

import com.google.gson.Gson;
import zzq.dolls.redis.RedisPool;

public class MetaUtils {

    private static RedisPool pool;

    private static Gson gson;

    public Table getTable(String name) {
        String json = pool.jedis(r -> r.hget("zoope.tables", name));
        return gson.fromJson(json, Table.class);
    }


}
