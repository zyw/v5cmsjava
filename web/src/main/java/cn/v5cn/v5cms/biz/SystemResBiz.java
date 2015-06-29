package cn.v5cn.v5cms.biz;

import cn.v5cn.v5cms.entity.SystemRes;
import cn.v5cn.v5cms.entity.wrapper.ZTreeNode;

import java.util.List;

/**
 * Created by ZXF-PC1 on 2015/6/23.
 */
public interface SystemResBiz {
    List<SystemRes> findOrderByPidsAndId();
    List<ZTreeNode> buildTreeNode(Long parentId);
}
