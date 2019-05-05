package com.sy.mobileback.web.controller;

import com.sy.mobileback.accessdb.service.DestinationCountryService;
import com.sy.mobileback.accessdb.service.PassportService;
import com.sy.mobileback.accessdb.service.PlanapplyService;
import com.sy.mobileback.accessdb.service.StudyabroadService;
import com.sy.mobileback.common.annotation.Log;
import com.sy.mobileback.common.constant.AccessConstants;
import com.sy.mobileback.common.utils.JsonResult;
import io.jsonwebtoken.Claims;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author shiyu
 * @Description 对应 教育国际交流页面
 * @create 2019-04-21 21:27
 */
@Controller
@RequestMapping("/jwgjjl")
public class JYGJJLController {
    @Autowired
    private PlanapplyService planapplyService;
    @Autowired
    private StudyabroadService studyabroadService;
    @Autowired
    private DestinationCountryService destinationCountryService;
    @Autowired
    private PassportService passportService;

    /**
     * 所有的公派留学考察列表
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Log(title = "公派留学考察列表")
    @ResponseBody
    @RequestMapping("/planApplyList")
    public JsonResult planApplyList(@RequestParam(value = "pageNum",required = false) Integer pageNum, @RequestParam(value = "pageSize",required = false) Integer pageSize , HttpServletRequest request) {
        Claims claims = (Claims) request.getAttribute("CLAIMS");
        if (null == claims) {
            return JsonResult.error("请传递token");
        }
        int userFlag = (Integer)claims.get("userFlag");
        if (userFlag!=2) {
            return JsonResult.error("请用管理员账户登陆");
        }
        if (null==pageNum ) {
            pageNum=1;
        }
        if (null==pageSize) {
            pageSize = AccessConstants.PAGE_SIZE;
        }
        return planapplyService.palanapplyList(pageNum,pageSize);
    }

    /**
     * 所有的申请留学列表的list返回
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Log(title = "留学申请列表")
    @GetMapping("/applyListByPage")
    @ResponseBody
    public JsonResult applyListByPage(@RequestParam(value = "pageNum",required = false) Integer pageNum, @RequestParam(value = "pageSize",required = false) Integer pageSize ,  HttpServletRequest request) {
        Claims claims = (Claims) request.getAttribute("CLAIMS");
        if (null == claims) {
            return JsonResult.error("请传递token");
        }
        int userFlag = (Integer)claims.get("userFlag");
        if (userFlag!=2) {
            return JsonResult.error("请用管理员账户登陆");
        }
        if (null==pageNum ) {
            pageNum=1;
        }
        if (null==pageSize) {
            pageSize = AccessConstants.PAGE_SIZE;
        }
        return studyabroadService.studyabroadApplyListByPage(pageNum,pageSize);
    }

    /**
     * 目的国培训列表
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Log(title = "目的国培训")
    @GetMapping("/destinationCountry")
    @ResponseBody
    public JsonResult destinationCountryList(@RequestParam(value = "pageNum",required = false) Integer pageNum, @RequestParam(value = "pageSize",required = false) Integer pageSize , HttpServletRequest request) {
        Claims claims = (Claims) request.getAttribute("CLAIMS");
        if (null == claims) {
            return JsonResult.error("请传递token");
        }
        int userFlag = (Integer)claims.get("userFlag");
        if (userFlag!=2) {
            return JsonResult.error("请用管理员账户登陆");
        }
        if (null==pageNum ) {
            pageNum=1;
        }
        if (null==pageSize) {
            pageSize = AccessConstants.PAGE_SIZE;
        }
        return destinationCountryService.destinationCountryList(pageNum,pageSize);
    }

    @Log(title = "护照查询")
    @GetMapping("/passportSearch")
    @ResponseBody
    public JsonResult passportSearch(@RequestParam("searchName") String searchName ,@RequestParam(value = "pageNum",required = false) Integer pageNum, @RequestParam(value = "pageSize",required = false) Integer pageSize , HttpServletRequest request) {
        Claims claims = (Claims) request.getAttribute("CLAIMS");
        if (null == claims) {
            return JsonResult.error("请传递token");
        }
        int userFlag = (Integer)claims.get("userFlag");
        if (userFlag!=2) {
            return JsonResult.error("请用管理员账户登陆");
        }
        if (StringUtils.isEmpty(searchName) || StringUtils.isBlank(searchName)) {
            return JsonResult.error("搜索不能为空");
        }
        Map<String,Object> map = new HashMap<>();
        if (null==pageNum ) {
            pageNum=1;

        }
        if (null==pageSize) {
            pageSize = AccessConstants.PAGE_SIZE;
        }
        map.put("pageNum",pageNum);
        map.put("pageSize",pageSize);
        map.put("searchName",searchName);

        return passportService.passportSearch(map);
    }


}
