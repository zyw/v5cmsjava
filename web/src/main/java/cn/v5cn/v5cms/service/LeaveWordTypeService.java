package cn.v5cn.v5cms.service;

import cn.v5cn.v5cms.entity.LeaveWordType;
import org.springframework.data.domain.Page;

/**
 * Created by ZXF-PC1 on 2015/7/28.
 */
public interface LeaveWordTypeService {

    Page<LeaveWordType> findLeaveWordTypePageable(LeaveWordType leaveWordType,Integer currPage);
}
