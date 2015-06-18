package cn.v5cn.v5cms.biz;

import cn.v5cn.v5cms.entity.SystemUser;

/**
 * Created by ZXF-PC1 on 2015/6/18.
 */
public interface SystemUserBiz {
    SystemUser findByLoginname(String loginname);
}
