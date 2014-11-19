package cn.v5cn.v5cms.biz.impl;

import cn.v5cn.v5cms.biz.ContentBiz;
import cn.v5cn.v5cms.dao.ContentDao;
import cn.v5cn.v5cms.entity.Content;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ZYW on 2014/11/19.
 */
@Service("contentBiz")
public class ContentBizImpl implements ContentBiz {

    private final static Logger LOGGER = LoggerFactory.getLogger(ContentBizImpl.class);

    @Autowired
    private ContentDao contentDao;

    @Override
    public Content save(Content content) {
        return contentDao.save(content);
    }
}
