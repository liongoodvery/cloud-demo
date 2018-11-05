package org.lion.cloud.provider.controller;

import org.apache.commons.lang3.tuple.Pair;
import org.lion.cloud.service.DeptClientService;
import org.lion.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class DeptController {

    @Autowired
    private DeptClientService service;

    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
    public Dept get(@PathVariable("id") Long id) {
        return service.get(id);
    }

    @RequestMapping(value = "/dept/list", method = RequestMethod.GET)
    public List<Dept> list() {
        return service.list();
    }

    @RequestMapping(value = "/dept/services", method = RequestMethod.GET)
    public List<String> services() {
        return client.getServices();
    }


    @RequestMapping(value = "/dept/instances", method = RequestMethod.GET)
    Map<String, List<ServiceInstance>> getInstances() {
        return client.getServices()
                .stream()
                .map(s -> Pair.of(s, client.getInstances(s)))
                .collect(Collectors.toMap(Pair::getKey, Pair::getValue));
    }

    @RequestMapping(value = "/dept/instance/{serviceId}", method = RequestMethod.GET)
    List<ServiceInstance> getInstance(@PathVariable("serviceId") String serviceId) {
        return client.getInstances(serviceId);
    }

}
