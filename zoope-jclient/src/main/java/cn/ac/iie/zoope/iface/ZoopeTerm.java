package cn.ac.iie.zoope.iface;

public class ZoopeTerm implements IZoopeTerm {

    private String term;

    public ZoopeTerm(String term) {
        this.term = term;
    }

    @Override
    public IZoopeTerm and(IZoopeTerm term) {
        return null;
    }

    @Override
    public IZoopeTerm and(String term) {
        return null;
    }

    @Override
    public IZoopeTerm or(IZoopeTerm term) {
        return null;
    }

    @Override
    public IZoopeTerm or(String term) {
        return null;
    }

    @Override
    public IZoopeTerm not(IZoopeTerm term) {
        return null;
    }

    @Override
    public IZoopeTerm not(String term) {
        return null;
    }
}
