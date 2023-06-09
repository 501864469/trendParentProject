package org.springcloud.web;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springcloud.pojo.Index;
import org.springcloud.service.IndexService;
@RestController
public class IndexController {
    @Autowired IndexService indexService;
    @GetMapping("/getCodes")
    public List<Index> get()throws Exception{
        return indexService.fetch_indexes_from_third_part();
//        return indexService.get();
    }
    @GetMapping("/freshCodes")
    public List<Index> fresh()throws Exception{
        return indexService.fresh();
    }
    @GetMapping("/removeCodes")
    public String remove()throws Exception{
        indexService.remove();
        return "remove codes successfully";
    }
}
