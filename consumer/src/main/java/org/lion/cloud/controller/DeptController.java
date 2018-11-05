package org.lion.cloud.controller;

import com.netflix.loadbalancer.IRule;
import org.lion.pojo.Dept;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptController {

    private static Logger logger = LoggerFactory.getLogger(DeptController.class);

    private final RestTemplate restTemplate;


    @Value("${my.consumer.baseUrl}")
    private String baseUrl;

    @Autowired
    public DeptController(RestTemplate restTemplate, IRule iRule) {
        this.restTemplate = restTemplate;
    }

    @RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
    public Dept get(@PathVariable("id") Long id) {
        return restTemplate.getForObject(baseUrl + "/dept/get/" + id, Dept.class);
    }

    @RequestMapping(value = "/dept/list", method = RequestMethod.GET)
    public List<Dept> list() {
        return restTemplate.getForObject(baseUrl + "/dept/list", List.class);
    }
}
