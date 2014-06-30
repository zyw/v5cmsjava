package cn.v5cn.v5cms.biz;

import cn.v5cn.v5cms.entity.Site;
import com.google.common.base.Optional;

/**
 * Created by ZYW on 2014/6/30.
 */
public interface SiteBiz {
    Optional<Site> findSize();
}
