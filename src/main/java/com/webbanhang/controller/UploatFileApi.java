package com.webbanhang.controller;

import com.webbanhang.service.FileManagerService;
import com.webbanhang.service.utils.FileManagerUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.websocket.server.PathParam;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api/file")
public class UploatFileApi {

    @Autowired
    FileManagerService filemanager;

    @RequestMapping("{folder}/{file}")
    public byte[] download(@PathVariable("folder") String folder,@PathVariable("file") String file){

        return filemanager.read(folder,file);
    }

    @PostMapping("{folder}")
    public List<String> upload(@PathVariable("folder") String folder, @PathParam("files") MultipartFile[] files){
        try{
            return filemanager.save(folder,files);
        }catch (Exception e){
            return null;
        }
    }


 }
