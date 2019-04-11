package cn.ac.iie.zoope.authen;

/**
 * 用户
 * @author zhangzhanqi
 * @date 2019-04-09
 */
public class User {

    private String name;
    private String password;

    /**
     * 用户权限
     * 0 停用
     * 1 只读
     * 2 读写
     * 3 管理用户
     */
    private int permissions;

    public User(String name, String password, int permissions) {
        this.name = name;
        this.password = password;
        this.permissions = permissions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPermissions() {
        return permissions;
    }

    public void setPermissions(int permissions) {
        this.permissions = permissions;
    }
}
