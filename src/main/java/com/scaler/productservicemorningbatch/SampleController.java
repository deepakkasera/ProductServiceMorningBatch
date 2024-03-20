package com.scaler.productservicemorningbatch;

import org.springframework.web.bind.annotation.*;

//This controller supports REST API's (HTTP Requests).
//The requests coming to endpoint /hello, transfer them to this controller
@RestController
@RequestMapping("/hello")
public class SampleController {
    @GetMapping("/{name}/{number}")
    public String sayHello(@PathVariable("name") String name, @PathVariable("number") int number) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i <= number; i++) {
            stringBuilder.append("Hello " + name + "\n");
        }
        //return "Hello " + name;
        return stringBuilder.toString();
    }
}
