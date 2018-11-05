package org.lion.cloud.service;

import org.lion.pojo.Dept;

import java.util.List;

public interface DeptClientService {
    public Dept get(long id);

    public List<Dept> list();

    public boolean add(Dept dept);
}
