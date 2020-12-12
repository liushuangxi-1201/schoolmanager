package cn.kgc.mapper;

import cn.kgc.entity.Newsinfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsinfoMapper {
    /**
     * 查询所有公告
     * @return
     */
    List<Newsinfo> getAllNewsinfo();
}
