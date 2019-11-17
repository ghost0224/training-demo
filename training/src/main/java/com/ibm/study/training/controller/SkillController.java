package com.ibm.study.training.controller;

import com.ibm.study.training.pojo.RespMsg;
import com.ibm.study.training.pojo.SkillDTO;
import com.ibm.study.training.service.SkillService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/skill")
@Slf4j
public class SkillController {

    @Autowired
    private SkillService skillService;

    @PostMapping("search")
    public @ResponseBody RespMsg search(@RequestBody SkillDTO skillDTO) {
        log.info("begin search");
        RespMsg respMsg = new RespMsg();
        List<SkillDTO> skillDTOList = skillService.search(skillDTO.getName());
        respMsg.setCode("1211");
        respMsg.setStatus(true);
        respMsg.setData(skillDTOList);
        respMsg.setMsg("search successful.");
        return respMsg;
    }

    @PostMapping("findById")
    public RespMsg findById(@RequestBody SkillDTO skillDTO) {
        log.info("begin findById");
        RespMsg respMsg = new RespMsg();
        SkillDTO skill = skillService.findById(skillDTO.getId());
        respMsg.setCode("1205");
        respMsg.setStatus(true);
        respMsg.setData(skill);
        respMsg.setMsg("find successful.");
        return respMsg;
    }

    @PostMapping("save")
    public @ResponseBody RespMsg save(@RequestBody SkillDTO skillDTO) {
        log.info("begin save");
        RespMsg respMsg = new RespMsg();
        if(skillService.save(skillDTO)) {
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
    public @ResponseBody RespMsg update(@RequestBody SkillDTO skillDTO) {
        log.info("begin update");
        RespMsg respMsg = new RespMsg();
        if(skillService.update(skillDTO)) {
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
    public @ResponseBody RespMsg delete(@RequestBody SkillDTO skillDTO) {
        log.info("begin delete");
        RespMsg respMsg = new RespMsg();
        if(skillService.delete(skillDTO.getId())) {
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
