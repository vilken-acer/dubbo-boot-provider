package com.jk.mapper;

import com.jk.pojo.Tree;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TreeMapper {

    @Select("select * from t_boot_user_tree where pid = #{id}")
    List<Tree> getUserTreeData(int id);
}
