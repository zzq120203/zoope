package cn.ac.iie.zoope.iface;

/**
 * 查询关系运算条件
 * @author zhangzhanqi
 * @date 2019-04-09
 */
public interface IZoopeTerm {

    IZoopeTerm and(IZoopeTerm term);

    IZoopeTerm and(String term);

    IZoopeTerm or(IZoopeTerm term);

    IZoopeTerm or(String term);

    IZoopeTerm not(IZoopeTerm term);

    IZoopeTerm not(String term);
}
