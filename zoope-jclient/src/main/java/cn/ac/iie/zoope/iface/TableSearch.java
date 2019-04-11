package cn.ac.iie.zoope.iface;

public class TableSearch implements ITableSearch {

    private IZoopeTable table;

    TableSearch(IZoopeTable table) {
        this.table = table;
    }


    @Override
    public ITableSearch order(IZoopeField field, boolean isDesc) {
        return null;
    }

    @Override
    public ITableSearch order(String field, boolean isDesc) {
        return null;
    }

    @Override
    public ITableSearch limit(int number) {
        return null;
    }

    @Override
    public ITableSearch and(IZoopeField field, String term, String relation) {
        return null;
    }

    @Override
    public ITableSearch and(String field, String term, String relation) {
        return null;
    }

    @Override
    public ITableSearch and(String field, IZoopeTerm term, String relation) {
        return null;
    }

    @Override
    public ITableSearch or(IZoopeField field, String term, String relation) {
        return null;
    }

    @Override
    public ITableSearch or(String field, String term, String relation) {
        return null;
    }

    @Override
    public ITableSearch or(String field, IZoopeTerm term, String relation) {
        return null;
    }

    @Override
    public ITableSearch not(IZoopeField field, String term, String relation) {
        return null;
    }

    @Override
    public ITableSearch not(String field, String term, String relation) {
        return null;
    }

    @Override
    public ITableSearch time(String time, String relation) {
        return null;
    }

    @Override
    public ITableSearch time(String field, String time, String relation) {
        return null;
    }

    @Override
    public String run() {
        return null;
    }

    @Override
    public void zql(String zql) {

    }
}
