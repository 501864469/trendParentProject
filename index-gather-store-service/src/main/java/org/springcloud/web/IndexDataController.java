package org.springcloud.web;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import org.springcloud.pojo.IndexData;
import org.springcloud.service.IndexDataService;
@RestController
public class IndexDataController {
    @Autowired IndexDataService indexDataService;
    @GetMapping("/freshIndexData/{code}")
    public String fresh(@PathVariable("code")String code)throws Exception{
        indexDataService.fresh(code);
        return"fresh index data successfully";
    }
    @GetMapping("/getIndexData/{code}")
    public List<IndexData> get(@PathVariable("code")String code)throws Exception{
//        return indexDataService.get(code);
       return indexDataService.fetch_indexes_from_third_part(code);
    }
    @GetMapping("/removeIndexData/{code}")
    public String remove(@PathVariable("code")String code)throws Exception{
        indexDataService.remove(code);
        return"remove index data successfully";
    }
}
