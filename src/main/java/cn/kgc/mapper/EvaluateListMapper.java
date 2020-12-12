package cn.kgc.mapper;

import cn.kgc.entity.EvaluateList;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EvaluateListMapper {
    /**
     * 查询所有教评题目
     * @return
     */
    List<EvaluateList> findAll();

    /**
     * 新增教评问题
     * @param evaluateList
     * @return
     */
    Integer add(EvaluateList evaluateList);

    /**
     * 删除教评问题
     * @param elid
     * @return
     */
    Integer del(Integer elid);

    /**
     * 修改教评问题
     * @param evaluateList
     * @return
     */
    Integer update(EvaluateList evaluateList);


}
