package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.List;

@Controller
public class FileUploadController {

	// 添加页面
	@RequestMapping("singlefile")
	public String singlefile() {
		return "singlefile";
	}

	@PostMapping("/SingleFile/upload")
	public String SingleFileUpLoad(@RequestParam("myfile") MultipartFile file, Model model,HttpServletRequest req ) {
		// 判断文件是否为空
		if (file.isEmpty()) {
			model.addAttribute("result_singlefile", "文件为空");
			return "singlefile";
		}

		// 创建输入输出流
		InputStream inputStream = null;
		OutputStream outputStream = null;

		try {
			// 指定上传的位置为 d:/upload/
			String path = "/Users/admin/Downloads/imgs/";
			// 获取文件的输入流
			inputStream = file.getInputStream();
			// 获取上传时的文件名
			String fileName = file.getOriginalFilename();
			if(fileName.contains(".png")){  
				String newFileName=  fileName.substring(0, fileName.lastIndexOf(".")) + ".jpg";
				System.out.println("newFileName"+newFileName);
			} 
			
			// 注意是路径+文件名
			File targetFile = new File(path + fileName);
			// 如果之前的 String path = "d:/upload/" 没有在最后加 / ，那就要在 path 后面 + "/"

			// 判断文件父目录是否存在
			if (!targetFile.getParentFile().exists()) {
				// 不存在就创建一个
				targetFile.getParentFile().mkdir();
			}

			// 获取文件的输出流
			outputStream = new FileOutputStream(targetFile);
			// 最后使用资源访问器FileCopyUtils的copy方法拷贝文件
			FileCopyUtils.copy(inputStream, outputStream);
			//FileCopyUtils.copy(targetFile, targetFile)
			System.out.println("ServerName:"+ req.getServerName()+":"+targetFile.getPath()); 
			// 告诉页面上传成功了
			model.addAttribute("result_singlefile", "上传成功");
		} catch (IOException e) {
			e.printStackTrace();
			// 出现异常，则告诉页面失败
			model.addAttribute("result_singlefile", "上传失败");
		} finally {
			// 无论成功与否，都有关闭输入输出流
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (outputStream != null) {
				try {
					outputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return "singlefile";
	}
	
	// 添加页面
		@RequestMapping("multiFile")
		public String multiFile() {
			return "multiFile";
		}

	@PostMapping("/MultiFile/upload")
	public String MultiFileUpload(Model model, HttpServletRequest request) {

		List<MultipartFile> list_files = ((MultipartHttpServletRequest) request).getFiles("myfile");

		if (list_files.isEmpty()) {
			model.addAttribute("result_multifile", "文件为空");
			return "multiFile";
		}
		InputStream inputStream = null;
		OutputStream outputStream = null;
		String path = "/Users/admin/Downloads/imgs/";
		for (MultipartFile file : list_files) {
			try {
				inputStream = file.getInputStream();
				String fileName = file.getOriginalFilename();
				File targetFile = new File(path + fileName);

				if (!targetFile.getParentFile().exists()) {
					targetFile.getParentFile().mkdir();
				}

				outputStream = new FileOutputStream(targetFile);
				FileCopyUtils.copy(inputStream, outputStream);
				model.addAttribute("result_multifile", "上传成功");
			} catch (IOException e) {
				e.printStackTrace();
				model.addAttribute("result_multifile", "上传失败");
			}
		}
		if (inputStream != null) {
			try {
				inputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (outputStream != null) {
			try {
				outputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return "multiFile";
	}
}