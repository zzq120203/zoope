package cn.ac.iie.zoope.master;

public class FieldStruct {

    /**
     * 字段名
     */
    private String name;

    /**
     * 字段类型，默认string
     */
    private String type = "string";

    /**
     * 是否索引，默认true
     */
    private boolean indexed = true;

    /**
     * 是否分词，默认false
     */
    private boolean tokenized = false;

    /**
     * 是否存储，默认true
     */
    private boolean stored = true;

    /**
     * 字段是否为时间分区字段，默认false，search.time()函数根据分区字段检索
     */
    private boolean partition = false;
}
