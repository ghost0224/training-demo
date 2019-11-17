package com.ibm.study.training.controller;

import com.ibm.study.training.pojo.RespMsg;
import com.ibm.study.training.pojo.TrainingDTO;
import com.ibm.study.training.service.TrainingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/training")
@Slf4j
public class TrainingController {

    @Autowired
    private TrainingService trainingService;

    @PostMapping("search")
    public @ResponseBody RespMsg search(@RequestBody TrainingDTO trainingDTO) {
        log.info("begin search");
        RespMsg respMsg = new RespMsg();
        List<TrainingDTO> trainingDTOList = trainingService.search(trainingDTO.getTitle());
        respMsg.setCode("1201");
        respMsg.setStatus(true);
        respMsg.setData(trainingDTOList);
        respMsg.setMsg("search successful.");
        return respMsg;
    }

    @PostMapping("findById")
    public RespMsg findById(@RequestBody TrainingDTO trainingDTO) {
        log.info("begin findById");
        RespMsg respMsg = new RespMsg();
        TrainingDTO training = trainingService.findById(trainingDTO.getId());
        respMsg.setCode("1205");
        respMsg.setStatus(true);
        respMsg.setData(training);
        respMsg.setMsg("find successful.");
        return respMsg;
    }

    @PostMapping("save")
    public @ResponseBody RespMsg save(@RequestBody TrainingDTO trainingDTO) {
        log.info("begin save");
        RespMsg respMsg = new RespMsg();
        if(trainingService.save(trainingDTO)) {
            respMsg.setCode("1202");
            respMsg.setStatus(true);
            respMsg.setMsg("save successful.");
        } else {
            respMsg.setCode("0202");
            respMsg.setMsg("save failure.");
        }
        return respMsg;
    }

    @PostMapping("update")
    public @ResponseBody RespMsg update(@RequestBody TrainingDTO trainingDTO) {
        log.info("begin update");
        RespMsg respMsg = new RespMsg();
        if(trainingService.update(trainingDTO)) {
            respMsg.setCode("1203");
            respMsg.setStatus(true);
            respMsg.setMsg("update successful.");
        } else {
            respMsg.setCode("0203");
            respMsg.setStatus(false);
            respMsg.setMsg("update failure.");
        }
        return respMsg;
    }

    @PostMapping("delete")
    public @ResponseBody RespMsg delete(@RequestBody TrainingDTO trainingDTO) {
        log.info("begin delete");
        RespMsg respMsg = new RespMsg();
        if(trainingService.delete(trainingDTO.getId())) {
            respMsg.setCode("1204");
            respMsg.setStatus(true);
            respMsg.setMsg("delete successful.");
        } else {
            respMsg.setCode("0204");
            respMsg.setMsg("delete failure.");
        }
        return respMsg;
    }

}
