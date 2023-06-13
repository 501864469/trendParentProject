package org.springcloud.web;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Value;

@Controller
public class ViewController {

    @GetMapping("/")
    public String view() throws Exception {

        return "view";
    }
}