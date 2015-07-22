package cn.v5cn.v5cms.service;

import cn.v5cn.v5cms.entity.Link;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * Created by ZXF-PC1 on 2015/7/22.
 */
public interface LinkService {
    Page<Link> findLinkPageable(Link link,Integer currPage);

    Link save(Link link);

    Link findOne(Long linkId);

    void deleteInBatch(Iterable<Link> linkIds);

    List<Link> findAll(Long[] linkIds);
}
