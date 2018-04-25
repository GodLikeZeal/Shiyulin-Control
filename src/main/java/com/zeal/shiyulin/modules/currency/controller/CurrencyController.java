package com.zeal.shiyulin.modules.currency.controller;

import com.zeal.shiyulin.exception.ExceptionUtils;
import com.zeal.shiyulin.exception.ZealException;
import com.zeal.shiyulin.modules.currency.service.CurrencyService;
import com.zeal.shiyulin.utils.AliyunOSSMethod;
import com.zeal.shiyulin.utils.AliyunOSSUtils;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * 通用方法的入口
 * Created by Zeal on 2017/4/26.
 */
@Controller
public class CurrencyController {
    @Autowired
    CurrencyService currencyService;

    /**
     * 上传图片到OSS对象云存储，并返回图片链接
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/uploadImg",method = RequestMethod.POST)
    @ResponseBody
    public String uploadImg(HttpServletRequest request,HttpServletResponse response) throws IOException {
        MultipartHttpServletRequest re = (MultipartHttpServletRequest) request;
        MultipartFile fileM = re.getFile("file");
        //File file= AliyunOSSUtils.multipartToFile(fileM);
        String resultUrl=new AliyunOSSMethod().uploadFile(fileM);
        return resultUrl;
    }



}
