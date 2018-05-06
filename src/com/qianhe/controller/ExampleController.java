package com.qianhe.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.qianhe.model.Example;
import com.qianhe.model.Page;
import com.qianhe.service.ExampleService;


@Controller
public class ExampleController {

	@Autowired
	private ExampleService caseService;

	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@RequestMapping({ "/exampleIinfo/{pageNow}" })
	public ModelAndView caseinfo(@PathVariable Integer pageNow,HttpServletRequest request) {
		ModelAndView mav=new ModelAndView("exampleinfo");
		List<Example> exampleInfoList=null;
		Page page = null;
		int totalCount = caseService.findAllCaseCounts();
		if (pageNow != null) {
			page = new Page(totalCount,pageNow);
			page.setPageSize(4);
			exampleInfoList = caseService.findAllCase(page);
		} else {
			page = new Page(totalCount, 1);
			exampleInfoList = caseService.findAllCase(page);
		}
		mav.addObject(page);
		request.setAttribute("exampleInfoList", exampleInfoList);
		return mav;
	}
	
	@RequestMapping({ "/exampleIinfo/{type}/{pageNow}" })
	public ModelAndView exampleForType (@PathVariable Integer pageNow,@PathVariable Integer type,HttpServletRequest request) {
		ModelAndView mav = null;
		if(type == 3001 ){
			 mav=new ModelAndView("exampleIinfo_hz");
		}else{
			 mav=new ModelAndView("exampleIinfo_xm");
		}
		List<Example> tExampleList=null;
		Page page = null;
		int totalCount = caseService.findCaseCountsByType(type);
		if (pageNow != null) {
			page = new Page(totalCount,pageNow);
			int startPos=page.getStartPos();
			int pageSize=page.getPageSize();
			tExampleList = caseService.findExampleByCategory(type, startPos, pageSize);
		} else {
			page = new Page(totalCount, 1);
			int startPos=page.getStartPos();
			int pageSize=page.getPageSize();
			tExampleList = caseService.findExampleByCategory(type, startPos, pageSize);
		}
		mav.addObject(type);
		mav.addObject(page);
		request.setAttribute("tExampleList", tExampleList);
		return mav;
	}
	
	/**
	 * 后台 加盟案例-列表
	 * @param pageNow
	 * @return example.jsp
	 */
	@RequestMapping({ "/jcmx/e/{pageNow}" })
	public ModelAndView be(@PathVariable Integer pageNow) {
		ModelAndView mav=new ModelAndView("WEB-INF/backstage/example");
		List<Example> exampleList=null;
		Page page = null;
		int totalCount = caseService.findAllCaseCounts();
		if (pageNow != null) {
			page = new Page(totalCount,pageNow);
			exampleList = caseService.findAllCase(page);
		} else {
			page = new Page(totalCount, 1);
			exampleList = caseService.findAllCase(page);
		}
		mav.addObject(page);
		mav.addObject(exampleList);
		return mav;
	}
	
	/**
	 * 后台 加盟案例-添加
	 * @return exampleAdd.jsp
	 */
	@RequestMapping({ "/jcmx/ea" })
	public String bea() {
		return "WEB-INF/backstage/exampleAdd";
	}
	
	/**
	 * 后台 加盟案例-添加保存
	 * @return example.jsp
	 */
	@RequestMapping(value="/jcmx/eas" ,method=RequestMethod.POST)
	public String bhas(@RequestParam(value = "myfile", required = false) MultipartFile file,Example example,HttpServletRequest request,RedirectAttributes attr) {
		/** 页面控件的文件流 **/
		if (file.getSize() != 0) {
			SimpleDateFormat dateformat = new SimpleDateFormat("yyyy/MM/dd");
			/** 构建图片保存的目录 **/
			String logoPathDir = "uploads/" + dateformat.format(new Date());
			/** 得到图片保存目录的真实路径 **/
			String logoRealPathDir = request.getSession().getServletContext().getRealPath(logoPathDir);
			/** 根据真实路径创建目录 **/
			File logoSaveFile = new File(logoRealPathDir);
			if (!logoSaveFile.exists())
				logoSaveFile.mkdirs();
			/** 获取文件的后缀 **/
			String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
			/** 使用UUID生成文件名称 **/
			String logImageName = UUID.randomUUID().toString() + suffix;// 构建文件名称
			/** 拼成完整的文件保存路径加文件 **/
			String fileName = logoRealPathDir + File.separator + logImageName;
			File files = new File(fileName);
			try {
				file.transferTo(files);
				String fileTemp = logoPathDir + "/" + logImageName;
				example.setTime(new Date());
				example.setUrl(fileTemp);
				caseService.saveExample(example);
				message = "添加成功";
				attr.addFlashAttribute("message", message);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return "redirect:/jcmx/e/1";
		} else {
			message = "上传失败：文件为空";
			attr.addFlashAttribute("message", message);
			return "redirect:/jcmx/ha";
		}

	}
	
	/**
	 * 后台 加盟案例-修改
	 * @return exampleEdit.jsp
	 */
	@RequestMapping({ "/jcmx/ee" })
	public String bee(Integer caseId,ModelMap map) {
		Example example  = caseService.findCaseById(caseId);
		map.put("example", example);
		return "WEB-INF/backstage/exampleEdit";
	}
	
	/**
	 * 后台 加盟案例-修改保存
	 * @return example.jsp
	 */
	@RequestMapping(value="/jcmx/ees" ,method=RequestMethod.POST)
	public String bhes(@RequestParam(value = "myfile", required = false) MultipartFile file,Example example,HttpServletRequest request,RedirectAttributes attr) {
		/** 页面控件的文件流 **/
		if (file.getSize() != 0) {
			SimpleDateFormat dateformat = new SimpleDateFormat("yyyy/MM/dd");
			/** 构建图片保存的目录 **/
			String logoPathDir = "uploads/" + dateformat.format(new Date());
			/** 得到图片保存目录的真实路径 **/
			String logoRealPathDir = request.getSession().getServletContext().getRealPath(logoPathDir);
			/** 根据真实路径创建目录 **/
			File logoSaveFile = new File(logoRealPathDir);
			if (!logoSaveFile.exists())
				logoSaveFile.mkdirs();
			/** 获取文件的后缀 **/
			String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
			/** 使用UUID生成文件名称 **/
			String logImageName = UUID.randomUUID().toString() + suffix;// 构建文件名称
			/** 拼成完整的文件保存路径加文件 **/
			String fileName = logoRealPathDir + File.separator + logImageName;
			File files = new File(fileName);
			try {
				file.transferTo(files);
				String fileTemp = logoPathDir + "/" + logImageName;
				example.setTime(new Date());
				example.setUrl(fileTemp);
				caseService.updateExample(example);
				message = "修改成功";
				attr.addFlashAttribute("message", message);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return "redirect:/jcmx/e/1";
		} else {
				example.setTime(new Date());
				caseService.updateExample(example);
				message = "修改成功";
				attr.addFlashAttribute("message", message);
			return "redirect:/jcmx/e/1";
		}
	       
	}
	
	/**
	 * 后台 加盟案例-删除
	 * @return example.jsp
	 */
	@RequestMapping({ "/jcmx/ed" })
	public String bed(Integer caseId) {
		caseService.delExample(caseId);
		return "redirect:/jcmx/e/1";
	}
	
}
