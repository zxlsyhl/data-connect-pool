package zxl.com.dataconnectpool.springbootdruid.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import zxl.com.dataconnectpool.springbootdruid.service.DruidService;
import zxl.com.dataconnectpool.springbootdruid.util.DruidUtil;

import java.sql.Connection;
import java.sql.SQLException;

@RestController
public class DruidController {
    @Autowired
    private DruidService druidService;

    @GetMapping("/test")
    public String test(){
        druidService.get();
        return "succe";
    }

    @GetMapping("/getStudentSize")
    public String getStudentSize(){


        return "";
    }
}
