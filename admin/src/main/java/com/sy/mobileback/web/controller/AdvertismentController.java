package com.sy.mobileback.web.controller;

import com.sy.mobileback.accessdb.domain.AdvertisementEntity;
import com.sy.mobileback.accessdb.service.AdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author shiyu
 * @Description
 * @create 2019-03-20 22:01
 */
// mysql数据库
@Controller
@RequestMapping("/advertisement")
public class AdvertismentController {

    @Autowired
    private AdvertisementService advertisementService;

    @RequestMapping("/list")
    @ResponseBody
    public List<AdvertisementEntity> advertisementEntityList(){
        return advertisementService.advertisementList();
    }
}
