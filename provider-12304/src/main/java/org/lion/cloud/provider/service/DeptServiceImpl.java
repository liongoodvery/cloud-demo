package org.lion.cloud.provider.service;

import org.lion.cloud.service.DeptClientService;
import org.lion.pojo.Dept;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptClientService {
    private List<Dept> depts;

    public DeptServiceImpl() {
        depts = new ArrayList<>();
        for (int i = 0; i < 10; i++) {

            depts.add(new Dept().setDb_source("db12301").setDeptno(Long.valueOf(i / 2)).setDname("name" + i));
        }
    }

    @Override
    public Dept get(long id) {
        try {
            return depts.get((int) id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Dept> list() {
        return depts;
    }

    @Override
    public boolean add(Dept dept) {
        return false;
    }
}
