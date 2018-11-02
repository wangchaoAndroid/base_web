package com.json.jdbcdemo.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.json.jdbcdemo.config.SystemConfiguration;
import core.com.eryansky.common.model.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;




/** 
* @Description: TODO(通用文件上传) 
* @author ty 
* @date 2018-4-2 上午9:05:25 
*  
*/
@Controller
public class UploadController {
	/** 
	* <p>Title: </p> 
	* <p>Description:    通用文件上传 </p> 
	* @param file       文件流
	* @param fileDir    保存到哪个文件夹
	* @param suffix     文件后缀 
	* @return 
	*/
	@RequestMapping("/uploadFile")
	public   @ResponseBody
	Result uploadFile(@RequestParam("file") MultipartFile file, HttpServletRequest request, String fileDir, @RequestParam(defaultValue=".png") String suffix)
	{   
		try
		{   
			String dir ="";
			if (fileDir != null && !"".equals(fileDir))
			{
				dir = fileDir;
			}
			Date date = new Date();
			InputStream input = file.getInputStream();// 可替换为任何路径何和文件名
			request.setCharacterEncoding("UTF-8");
			long name = date.getTime();
			String dd= SystemConfiguration.PRITURE_WEBUPLOADER_TOMCAT_compression;
			String path = dd+ dir + "/" + name + suffix;//上传路径
			String web = SystemConfiguration.PRITURE_WEBUPLOADER_WEB + dir + "/" + name + suffix;//访问路径
			//检查文件是否存在，不存在则创建
	    	File  fi=new File(SystemConfiguration.PRITURE_WEBUPLOADER_TOMCAT_compression + dir);
	    	if(!fi.exists()&&!fi.isDirectory())
	    		fi.mkdirs();
			FileOutputStream output = new FileOutputStream(path);//文件流
			int in = input.read();
			while (in != -1)
			{
				output.write(in);
				in = input.read();
			}
			output.close();
			input.close();
			return Result.successResult().setObj(web).setMsg("上传成功");
		} catch (IOException e)
		{
			e.printStackTrace();
			return Result.errorResult().setMsg("文件流异常结束，请检查文件重新上传");
		} 
	}
	
	/**
	 *  用于 wangEditor 富文本图片上传
	 * @param request
	 * @param f 文件
	 * @param uploadAddress 存放在服务器上的位置
	 * @param fileNamePrefix 文件重命名前缀
	 * @param serverAddress 上传成功之后,服务器访问地址(不含文件名称)
	 * @return
	 */
	@RequestMapping("/uploadWangEditor")
	@ResponseBody
	public Map<String, Object> uploadWangEditor(HttpServletRequest request, @RequestPart(value = "files") MultipartFile files[]){
		Map<String, Object> map = new HashMap<String, Object>();
		String[] urlArray=new String[files.length];
		for(int i=0;i<files.length;i++)
		{
			MultipartFile f=files[i];
			if (request.getContentLength() > 0) {
				if (!f.isEmpty()) {
					String fileType = "";
					String fileName = f.getOriginalFilename();
					//System.err.println("========== file type: " + f.getContentType() + " // name: " + fileName);
					if (fileName != null) {
						fileType = fileName.substring(fileName.lastIndexOf("."), fileName.length());
					}

					File folder = new File(SystemConfiguration.PRITURE_WEBUPLOADER_TOMCAT_compression);
					if (!folder.exists()) {
						folder.mkdirs();
					}
					long now = System.currentTimeMillis();
					String name =now + fileType;
					File file = new File(SystemConfiguration.PRITURE_WEBUPLOADER_TOMCAT_compression, name);
					try {
						f.transferTo(file);
						urlArray[i]=SystemConfiguration.PRITURE_WEBUPLOADER_WEB + name;
					} catch (Exception  e) {
						map.put("errno", 1);
						map.put("message", "上传异常");
						map.put("data", e.getMessage());
						return map;
					}
				}
			} else {
				map.put("errno", 1);
				map.put("message", "请求length错误");
				return map;
			}
			map.put("errno", 0);
			map.put("data", urlArray);
		}
		return map;
	}
	

	
}
