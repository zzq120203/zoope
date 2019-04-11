package cn.ac.iie.zoope.iface;

/**
 *
 * @author zhangzhanqi
 */
public class ZoopeDatabase implements IZoopeDatabase {

    private String name = "default";

    public ZoopeDatabase() {
    }

    public ZoopeDatabase(String name) {
        this.name = name;
    }

    @Override
    public String name() {
        return name;
    }

    /**
     * 需要用户权限
     */
    @Override
    public void create() {

    }

    @Override
    public boolean exist() {
        if (name != null) {
            return true;
        }
        return false;
    }

    @Override
    public IZoopeTable table(String tableName) {
        return new ZoopeTable(this, tableName);
    }


}
