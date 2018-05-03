package com.csu.geekspace.detectsoftware.controller;

import com.csu.geekspace.detectsoftware.enums.OutcomeEnum;
import com.csu.geekspace.detectsoftware.pojo.Outcome;
import com.csu.geekspace.detectsoftware.service.UploadService;
import com.csu.geekspace.detectsoftware.utils.OutcomeUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @Author xuhang
 * @date 2018/4/17 21:01
 */
@RestController
@CrossOrigin
/*@RequestMapping(value = "Upload")*/
public class UploadController {

    @Autowired
    private UploadService uploadService;

    @ApiOperation(value = "上传参数",notes = "上传工区详细位置参数")
    @PostMapping(value = "/import",consumes = "multipart/*",headers = "content-type=multipart/form-data")
    public Outcome addPosition(@ApiParam(value = "上传的文件",required = true) @RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException{
        /*System.out.println("接收到文件");*/
        String fileName = file.getOriginalFilename();
        String msg = uploadService.importExcel(fileName,file);
        if (msg.equals("导入出错！请检查数据格式！")){
            return OutcomeUtil.error(OutcomeEnum.IMPORT_ERROR);
        }else {
            return OutcomeUtil.success(OutcomeEnum.SUCCESS);
        }
    }
}
