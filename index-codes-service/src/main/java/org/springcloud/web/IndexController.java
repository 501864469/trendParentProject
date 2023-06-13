package org.springcloud.web;
import java.util.List;
import org.springcloud.config.IpConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springcloud.pojo.Index;
import org.springcloud.service.IndexService;
@RestController
public class IndexController {
    @Autowired IndexService indexService;
    @Autowired IpConfiguration ipConfiguration;
    @GetMapping("/codes")
    @CrossOrigin
    public List<Index> codes()throws Exception{
        System.out.println("current instance's port is"+ipConfiguration.getPort());
        return indexService.get();
    }
}
