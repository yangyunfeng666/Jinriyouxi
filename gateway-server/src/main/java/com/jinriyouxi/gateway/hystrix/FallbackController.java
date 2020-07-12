package com.jinriyouxi.gateway.hystrix;

import com.jinriyouxi.common.constant.ResultJson;
import com.jinriyouxi.common.constant.ResultMsg;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {

    /*
     * @ClassName FallbackController
     * @Desc TODO   网关断路器
     * @Version 1.0
     */
    @RequestMapping("/fallback")
    public ResultJson fallback() {
        ResultJson resultJson =  ResultJson.of_error(ResultMsg.SERVICE_UNAVILABLE);
        return resultJson;
    }

}