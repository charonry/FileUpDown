package com.fileupdown.charon.file.controller;

import com.fileupdown.charon.file.entity.User;
import com.fileupdown.charon.file.entity.UserFile;
import com.fileupdown.charon.file.service.UserFileService;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @program: FileUpDown
 * @description 文件操作的表现层
 * @author: charon
 * @create: 2020-07-07 23:44
 **/
@Controller
@RequestMapping("file")
public class FileController {

    @Resource
    UserFileService userFileService;

    /**
     * 展示所有文件
     */
    @GetMapping("/findAll")
    public String findAll(HttpSession session, Model model){
        User user = (User)session.getAttribute("user");
        List<UserFile>  userFileList = userFileService.findByUserId(user.getId());
        model.addAttribute("files",userFileList);
        return "showAll";
    }

    /**
     * 文件上传
     * @param file
     */
    @PostMapping("/upLoad")
    public String upLoad(MultipartFile file,HttpSession session) throws IOException {
        //获取文件原始文件
        String oldFileName = file.getOriginalFilename();
        //获取文件后缀
        String extension = FilenameUtils.getExtension(oldFileName);
        //生成新的文件名
        String newFileName = new SimpleDateFormat("yyyyMMddHH").format(new Date())+
                UUID.randomUUID().toString().replace("-","").substring(0,6)+"."+extension;
        //文件大小
        long size = file.getSize();
        //文件类型
        String type = file.getContentType();
        //处理根据日期生成目录
        String realPath = ResourceUtils.getURL("classpath:").getPath() + "/static/files";
        String aftPath = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        String dateDirth = realPath + "/" + aftPath;
        File dateDir = new File(dateDirth);
        if(!dateDir.exists()){
            dateDir.mkdirs();
        }
        //处理文件上传
        file.transferTo(new File(dateDir,newFileName));
        UserFile userFile = new UserFile();
        User user = (User)session.getAttribute("user");
        userFile.setOldFileName(oldFileName).setNewFileName(newFileName).setExt("."+extension).setSize(String.valueOf(size))
                .setUserId(user.getId()).setType(type).setPath("files/"+aftPath);
        userFileService.save(userFile);
        return "redirect:/file/findAll";
    }

    @GetMapping("/downLoad")
    public void  download(String opneStyle,String id, HttpServletResponse response) throws IOException {
       //打开方式
         opneStyle = opneStyle == null ? "attachment" : "inline";
        UserFile userFile = userFileService.findById(id);
        //点击下载更新
        if("attachment".equals(opneStyle)){
            userFile.setDowncounts(userFile.getDowncounts()+1);
            userFileService.update(userFile);
        }
        //获取文件真实路径
        String realPath = ResourceUtils.getURL("classpath:").getPath() + "static/" + userFile.getPath();
        //文件读取
        FileInputStream fileInputStream = new FileInputStream(new File(realPath,userFile.getNewFileName()));
        //附件下载
        response.setHeader("content-disposition", opneStyle+";filename="+
                URLEncoder.encode(userFile.getOldFileName(),"UTF-8"));
        //响应输出流
        ServletOutputStream outputStream = response.getOutputStream();
        //文件复制
        IOUtils.copy(fileInputStream,outputStream);
        //关闭流
        IOUtils.closeQuietly(fileInputStream);
        IOUtils.closeQuietly(outputStream);

    }


    /**
     * 删除文件
     * @param id
     */
    @GetMapping("delete")
    public String delet(String id) throws FileNotFoundException {
        UserFile userFile = userFileService.findById(id);
        String realPath = ResourceUtils.getURL("classpath:").getPath() + "static/" + userFile.getPath();
        File file = new File(realPath,userFile.getNewFileName());
        if(file.exists()){
            file.delete();
        }
        userFileService.delete(id);
        return "redirect:/file/findAll";
    }


    /**
     * 展示所有文件----JSon文件
     */
    @GetMapping("/findAllJson")
    @ResponseBody
    public List<UserFile> findAllJson(HttpSession session, Model model){
        User user = (User)session.getAttribute("user");
        List<UserFile>  userFileList = userFileService.findByUserId(user.getId());
        return userFileList;
    }
}
