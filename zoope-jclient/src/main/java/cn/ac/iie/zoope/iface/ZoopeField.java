package cn.ac.iie.zoope.iface;

/**
 * 字段
 * @author zhangzhanqi
 */
public class ZoopeField implements IZoopeField {

    /**
     * 字段名
     */
    private String name;

    /**
     * 字段类型，默认string
     */
    private FieldType type = FieldType.STRING;

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

    /**
     *
     * @param name 字段名
     *      字段类型为String，创建索引，不分词
     */
    public ZoopeField(String name) {
        this.name = name;
    }

    /**
     *
     * @param name 字段名
     * @param type 字段类型
     *      创建索引，不分词
     */
    public ZoopeField(String name, FieldType type) {
        this.name = name;
        this.type = type;
    }

    /**
     *
     * @param name 字段名
     * @param type 字段类型
     * @param indexed 是否索引
     *        不对字段分词
     */
    public ZoopeField(String name, FieldType type, boolean indexed) {
        this.name = name;
        this.type = type;
        this.indexed = indexed;
    }

    /**
     *
     * @param name 字段名
     * @param type 字段类型
     * @param indexed 是否索引
     * @param tokenized 是否分词
     */
    public ZoopeField(String name, FieldType type, boolean indexed, boolean tokenized) {
        this.name = name;
        this.type = type;
        this.indexed = indexed;
        this.tokenized = tokenized;
    }

    /**
     *
     * @param name 字段名
     * @param type 字段类型
     * @param indexed 是否索引
     * @param tokenized 是否分词
     * @param stored 是否存储
     */
    public ZoopeField(String name, FieldType type, boolean indexed, boolean tokenized, boolean stored) {
        this.name = name;
        this.type = type;
        this.indexed = indexed;
        this.tokenized = tokenized;
        this.stored = stored;
    }

    /**
     *
     * @param name 字段名
     * @param type 字段类型
     * @param indexed 是否索引
     * @param tokenized 是否分词
     * @param stored 是否存储
     * @param partition 是否为分区字段
     */
    public ZoopeField(String name, FieldType type, boolean indexed, boolean tokenized, boolean stored, boolean partition) {
        this.name = name;
        this.type = type;
        this.indexed = indexed;
        this.tokenized = tokenized;
        this.stored = stored;
        this.partition = partition;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FieldType getType() {
        return type;
    }

    public void setType(FieldType type) {
        this.type = type;
    }

    public boolean isIndexed() {
        return indexed;
    }

    public void setIndexed(boolean indexed) {
        this.indexed = indexed;
    }

    public boolean isStored() {
        return stored;
    }

    public void setStored(boolean stored) {
        this.stored = stored;
    }

    public boolean isTokenized() {
        return tokenized;
    }

    public void setTokenized(boolean tokenized) {
        this.tokenized = tokenized;
    }

    public boolean isPartition() {
        return partition;
    }

    public void setPartition(boolean partition) {
        this.partition = partition;
    }
}
