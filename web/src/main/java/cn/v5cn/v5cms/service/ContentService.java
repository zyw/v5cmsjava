package cn.v5cn.v5cms.service;

import cn.v5cn.v5cms.entity.Content;
import org.springframework.data.domain.Page;

/**
 * Created by ZYW on 2014/11/19.
 */
public interface ContentService {
    Content save(Content content);
    Page<Content> findContentPageable(Content content,Integer currPage);
}
