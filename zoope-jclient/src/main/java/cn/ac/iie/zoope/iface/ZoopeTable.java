package cn.ac.iie.zoope.iface;

import java.util.List;

public class ZoopeTable implements IZoopeTable {

    private IZoopeDatabase db;

    private String name;

    /**
     *
     * @param db 数据库
     * @param name 表名
     */
    ZoopeTable(IZoopeDatabase db, String name) {
        this.db = db;
        this.name = name;
    }

    @Override
    public IZoopeDatabase getDatabase() {
        return db;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public boolean create(List<IZoopeField> fields) {
        return false;
    }

    @Override
    public boolean create(List<IZoopeField> fields, String timePartition) {
        return false;
    }

    @Override
    public boolean exist() {
        return false;
    }

    @Override
    public IZoopeTable alter(IZoopeField field) {

        return this;
    }

    @Override
    public boolean drop() {
        return false;
    }

    @Override
    public ITableInsert insert() {
        return new TableInsert(this);
    }

    @Override
    public ITableSearch search() {
        return new TableSearch(this);
    }

    @Override
    public ITableDelete delete() {
        return null;
    }

    @Override
    public ITableUpdate update() {
        return null;
    }

    @Override
    public List<IZoopeField> fields() {
        return null;
    }

    @Override
    public IZoopeField field(String fieldName) {
        return null;
    }
}
