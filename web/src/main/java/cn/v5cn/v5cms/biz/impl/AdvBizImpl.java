package cn.v5cn.v5cms.biz.impl;

import cn.v5cn.v5cms.biz.AdvBiz;
import cn.v5cn.v5cms.dao.AdvDao;
import cn.v5cn.v5cms.entity.Adv;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ZYW on 2014/7/28.
 */
@Service("advBiz")
public class AdvBizImpl implements AdvBiz {

    @Autowired
    private AdvDao advDao;

    @Override
    public Adv save(Adv adv) {
        adv.setCreateDate(DateTime.now().toDate());
        return advDao.save(adv);
    }
}
