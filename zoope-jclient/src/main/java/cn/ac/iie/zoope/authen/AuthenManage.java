package cn.ac.iie.zoope.authen;

/**
 * 用户权限认证
 * @author zhangzhanqi
 * @date 2019-04-09
 */
public class AuthenManage {

    private User user;

    public AuthenManage(User user) {
        this.user = user;
    }

    public boolean isRead() {
        return false;
    }

    public boolean isWrite() {
        return false;
    }

    public boolean isManage() {
        return false;
    }
}
