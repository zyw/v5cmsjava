package cn.v5cn.v5cms.service;

import cn.v5cn.v5cms.entity.SystemRes;

import java.util.List;

/**
 * Created by ZXF-PC1 on 2015/6/23.
 */
public interface SystemResService {
    List<SystemRes> findOrderByPidsAndId();
    List<Object> buildTreeNode(Long parentId);
}
