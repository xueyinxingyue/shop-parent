package com.xueyin.orderserver.service.impl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TraceServiceImpl {
@SentinelResource(value = "tranceService")
public void tranceService(){
log.info("调用tranceService方法");
}
}
