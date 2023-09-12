package hello.proxy.app.v1;

import org.springframework.web.bind.annotation.*;

@ResponseBody
@RequestMapping
public interface OrderControllerV1 {

    @GetMapping("/v1/request")
    String request(@RequestParam("itemId") String itemId) throws InterruptedException;


    @GetMapping("/v1/no-log")
        String noLog();


}
