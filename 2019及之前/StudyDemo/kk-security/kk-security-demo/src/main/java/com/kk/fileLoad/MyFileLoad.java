package com.kk.fileLoad;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

@RestController
public class MyFileLoad {

    @PostMapping("upload")
    public void loadFile(MultipartFile file) {
        System.out.println("file.getOriginalFilename() = " + file.getOriginalFilename());
        System.out.println("file.getContentType() = " + file.getContentType());
        System.out.println("file.getSize() = " + file.getSize());
    }

//    @GetMapping("download/{fileName}")
//    public void download(HttpServletResponse response,@PathVariable("fileName") String file) throws FileNotFoundException {
//       try (
//               InputStream inputStream = new FileInputStream(new File("D:\\resFile",file+".txt"));
//               OutputStream outputStream = response.getOutputStream();
//           ){
//
//       }
//
//    }
}
