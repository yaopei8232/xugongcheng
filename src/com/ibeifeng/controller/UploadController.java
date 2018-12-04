package com.ibeifeng.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.Collection;

/**
 * Created by ibf on 2018/12/3.
 */
@MultipartConfig
public class UploadController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     /*   Part file = req.getPart("file");
//form-data; name="file"; filename="icudtl.dat"
        String header = file.getHeader("content-disposition");
        String substr = substr(header);
        file.write("D:/upload/"+substr);*/
        Collection<Part> parts = req.getParts();
        for(Part  part:parts){
            String header = part.getHeader("content-disposition");
            String substr = substr(header);
            part.write("D:\\upload\\"+substr);
        }
    }

    public  String  substr(String  str){
        //form-data; name="file"; filename="icudtl.dat"
        // form-data; name="file"; filename="D:\workspace\Hello1\hello.xml"
        String[] splits = str.split("=");
        int start = splits[2].indexOf("\"");
        int end= splits[2].lastIndexOf("\"");
        return splits[2].substring(start+1,end);
    }
}
