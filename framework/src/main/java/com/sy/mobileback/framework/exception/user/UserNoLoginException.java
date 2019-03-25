package com.sy.mobileback.framework.exception.user;


/**
 * @author shiyu
 * @Description
 * @create 2019-03-24 15:22
 */
public class UserNoLoginException extends UserException {
    private static final long serialVersionUID = 1L;

    public UserNoLoginException()
    {
        super("用户未登录,请重新登录",null);
    }
}
