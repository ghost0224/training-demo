package com.ibm.study.training.feignclient;

import com.ibm.study.training.pojo.RespMsg;
import com.ibm.study.training.pojo.TrainingDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "TRAINING")
public interface TrainingService {

    @PostMapping("training/findByUserId/{userId}")
    RespMsg findByUserId(@PathVariable("userId") Long userId);

}
