package cn.v5cn.v5cms.service;

import cn.v5cn.v5cms.entity.Content;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * Created by ZYW on 2014/11/19.
 */
public interface ContentService {

    /**
     * ==============================================================
     *
     * 通用方法
     *
     * ==============================================================
     **/
    Content findOne(Long contentId);
    /**
     * ==============================================================
     *
     * 后端方法
     *
     * ==============================================================
     **/
    Content save(Content content);
    Page<Content> findContentPageable(Content content,Integer currPage);
    /**
     * ==============================================================
     *
     * 前端方法
     *
     * ==============================================================
     **/

    Page<Content> findContentPageable(Long colId,Integer currPage,Integer maxSize);

    /**
     * 查找置顶的内容，根据栏目ID
     * */
    List<Content> findStickContents(Long colId);
}
