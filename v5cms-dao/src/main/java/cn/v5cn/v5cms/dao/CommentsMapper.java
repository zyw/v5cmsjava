package cn.v5cn.v5cms.dao;

import cn.v5cn.v5cms.entity.Comments;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface CommentsMapper extends Mapper<Comments> {
}