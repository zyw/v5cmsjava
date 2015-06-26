package cn.v5cn.v5cms.dao;

import cn.v5cn.v5cms.entity.Adv;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by ZYW on 2014/7/28.
 */
@Repository("advDao")
public interface AdvDao extends PagingAndSortingRepository<Adv,Long>,JpaSpecificationExecutor<Adv>{

}
