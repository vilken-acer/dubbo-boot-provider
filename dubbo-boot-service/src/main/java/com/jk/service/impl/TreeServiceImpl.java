package com.jk.service.impl;

import com.jk.mapper.TreeMapper;
import com.jk.pojo.Tree;
import com.jk.service.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("treeService")
public class TreeServiceImpl implements TreeService {

    @Autowired
    private TreeMapper treeMapper;

    @Override
    public List<Tree> getUserTreeData(int id) {
        List<Tree> plist = treeMapper.getUserTreeData(id);
        if (plist != null && plist.size()>0) {
            for (Tree tree: plist){
                tree.setState("closed");
                int a = tree.getId();
                List<Tree> clist = treeMapper.getUserTreeData(a);
                tree.setChildren(clist);
            }
        }
        return plist;
    }
}
