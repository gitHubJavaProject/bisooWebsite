package com.demo.controller;

import com.demo.commons.CommonProperties;
import com.demo.core.model.base.ResultEntity;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@RestController
@RequestMapping("/file")
public class FileController {
    private static final Logger LOGGER = LoggerFactory.getLogger(FileController.class);

    @Autowired
    private CommonProperties commonProperties;

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public ResponseEntity<byte[]> showImage(@RequestParam("path") String path, HttpServletResponse response) {
        try {
            if (StringUtils.isNotBlank(path)) {
                File imageFile = new File(commonProperties.getImagePathPrefix() + commonProperties.getImageUploadPath(), path);
                if (imageFile.exists()) {
                    String type = "image/" + path.substring(path.lastIndexOf('.') + 1);
                    response.setHeader("Pragma", "No-cache");
                    response.setHeader("Cache-Control", "No-cache");
                    response.setHeader("Content-Type", type);
                    response.setContentLength((int) imageFile.length());
                    response.setContentType(type);
                    FileCopyUtils.copy(FileCopyUtils.copyToByteArray(imageFile), response.getOutputStream());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            LOGGER.error(e.getMessage(), e);
        }
        return null;
    }

    @RequestMapping(value = "upload", method = RequestMethod.POST)
    public Object addImg(@RequestParam("file") MultipartFile file) {
        Map<String, Object> map = new HashMap<>();
        try {
            //String ext = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")+1);
        /*if (!imageType.contains(ext)) {
            return R.error(403, "请上传以下图片类型："+imageType);
        }*/
            String url = uploadFile(file, "");
            Map<String, Object> data = new HashMap<>();
            data.put("src", "/file/show?path=" + url);
            data.put("title", file.getOriginalFilename());
            map.put("code",0);
            map.put("msg", "上传成功");
            map.put("data", data);
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error(e.getMessage(), e);
            map.put("code", 1);
            map.put("msg", "上传失败");
        }
        return map;
    }

    private String uploadFile(MultipartFile fileData, String type) {
        try {
            String fileFullPath = getFilePath(fileData, type);
            File saveFile = new File(commonProperties.getImagePathPrefix() + commonProperties.getImageUploadPath(), fileFullPath);
            if (!saveFile.getParentFile().exists()) {
                saveFile.getParentFile().mkdirs();
            }
            fileData.transferTo(saveFile);
            return fileFullPath;
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
            return null;
        }
    }

    /**
     * 生成文件路径
     *
     * @param fileData
     * @param type
     * @return
     */
    private String getFilePath(MultipartFile fileData, String type) {
        String fileName = createFileName();
        String ext = fileData.getOriginalFilename().substring(fileData.getOriginalFilename().lastIndexOf(".") + 1);
        String fileNameWithExtension = fileName + "." + ext;
        StringBuilder subPath = new StringBuilder();
        return type + "/" + subPath.toString() + createPathBasedData() + "/" + fileNameWithExtension;
    }

    /**
     * 生产文件名，生成随机数
     *
     * @return
     */
    private String createFileName() {
        DateFormat dateFormat = new SimpleDateFormat("HH-mm-ss");
        Random random = new Random();
        return dateFormat.format(new Date()) + random.nextInt(65535);
    }

    /**
     * 创建文件日期路径
     *
     * @return
     */
    private String createPathBasedData() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        return dateFormat.format(new Date());
    }
}
