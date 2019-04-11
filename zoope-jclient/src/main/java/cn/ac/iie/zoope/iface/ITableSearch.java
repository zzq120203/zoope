package cn.ac.iie.zoope.iface;

/**
 * 检索数据操作
 * @author zhangzhanqi
 * @date 2019-04-09
 */
public interface ITableSearch {

    /**
     * 排序
     * @param field
     * @param isDesc
     * @return
     */
    ITableSearch order(IZoopeField field, boolean isDesc);


    /**
     * 排序
     * @param field
     * @param isDesc
     * @return
     */
    ITableSearch order(String field, boolean isDesc);


    /**
     * 返回数据条数
     * @param number
     * @return
     */
    ITableSearch limit(int number);

    /**
     * 与条件
     * @param field
     * @return
     */
    ITableSearch and(IZoopeField field, String term, String relation);

    /**
     * 与条件
     * @param field
     * @param term
     * @param relation = != < > <= >=
     * @return
     */
    ITableSearch and(String field, String term, String relation);

    /**
     * 与条件
     * @param field
     * @param term
     * @param relation = != < > <= >=
     * @return
     */
    ITableSearch and(String field, IZoopeTerm term, String relation);

    /**
     * 或条件
     * @param field
     * @param term
     * @param relation = != < > <= >=
     * @return
     */
    ITableSearch or(IZoopeField field, String term, String relation);

    /**
     * 或条件
     * @param field
     * @param term
     * @param relation = != < > <= >=
     * @return
     */
    ITableSearch or(String field, String term, String relation);

    /**
     * 与条件
     * @param field
     * @param term
     * @param relation = != < > <= >=
     * @return
     */
    ITableSearch or(String field, IZoopeTerm term, String relation);

    /**
     * 非条件
     * @param field
     * @param term
     * @param relation = != < > <= >=
     * @return
     */
    ITableSearch not(IZoopeField field, String term, String relation);

    /**
     * 非条件
     * @param field
     * @param term
     * @param relation = != < > <= >=
     * @return
     */
    ITableSearch not(String field, String term, String relation);

    /**
     * 时间条件，根据时间分区字段查询
     * field {relation} time
     * create_time < 2019-01-01 00:00:00
     *
     * @return
     */
    ITableSearch time(String time, String relation);

    /**
     * 时间条件，根据时间分区字段查询
     * @return
     */
    ITableSearch time(String field, String time, String relation);

    /**
     * 提交查询
     * @return 数据json
     */
    String run();

    /**
     * 以Lucene查询语法，提交查询
     * title:"hello title"
     * grade:{60,80]
     * name:{A,C}
     * tom AND john
     * tom OR john
     * tom NOT john
     * @param zql
     */
    void zql(String zql);

}
