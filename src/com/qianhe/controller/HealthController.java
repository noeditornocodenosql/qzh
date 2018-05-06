package com.qianhe.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.qianhe.model.Health;
import com.qianhe.model.Page;
import com.qianhe.service.HealthService;

@Controller
public class HealthController {
	
	@Autowired
	private HealthService healthService;
	
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	@RequestMapping({ "/health/{pageNow}" })
	public ModelAndView healthinfo(@PathVariable Integer pageNow) {
		ModelAndView mav=new ModelAndView("health");
		List<Health>healthList=null;
		Page page = null;
		int totalCount = healthService.findAllHealthCounts();
		if (pageNow != null) {
			page = new Page(totalCount,pageNow);
			healthList = healthService.findAllHealth(page);
		} else {
			page = new Page(totalCount, 1);
			healthList = healthService.findAllHealth(page);
		}
		mav.addObject(page);
		mav.addObject(healthList);
		return mav;
	}
	
	@RequestMapping({ "/healtht/{type}/{pageNow}" })
	public ModelAndView healtht(@PathVariable Integer pageNow,@PathVariable Integer type) {
		ModelAndView mav = null;
		if(type == 5001 ){
			 mav=new ModelAndView("health_m");
		}else if(type == 5002){
			 mav=new ModelAndView("health_y");
		}else if(type == 5003){
			 mav=new ModelAndView("health_s");
		}else{
			 mav=new ModelAndView("health_j");
		}
		List<Health> tHealthList=null;
		Page page = null;
		int totalCount = healthService.findHealthCategoryCounts(type);
		if (pageNow != null) {
			page = new Page(totalCount,pageNow);
			int startPos=page.getStartPos();
			int pageSize=page.getPageSize();
			tHealthList = healthService.findHealthByCategory(type, startPos, pageSize);
		} else {
			page = new Page(totalCount, 1);
			int startPos=page.getStartPos();
			int pageSize=page.getPageSize();
			tHealthList = healthService.findHealthByCategory(type, startPos, pageSize);
		}
		mav.addObject(type);
		mav.addObject(page);
		mav.addObject(tHealthList);
		return mav;
	}
	
	@RequestMapping({ "/health/detail" })
	public String healthDetail(@Param(value = "id") Integer id,Model model) {
		Integer maxId = healthService.findMaxHealthId();
		if(id<1){
			id=1;
		}else if(id>maxId){
			id=maxId;
		}
		Health health=healthService.findHealthById(id);
		healthService.saveCount(id);
		model.addAttribute(health);
		return "healthdt";
	}
	
	/**
	 * 后台 健康生活-列表
	 * @param pageNow
	 * @return health.jsp
	 */
	@RequestMapping({ "/jcmx/h/{pageNow}" })
	public ModelAndView bh(@PathVariable Integer pageNow) {
		ModelAndView mav=new ModelAndView("WEB-INF/backstage/health");
		List<Health>healthList=null;
		Page page = null;
		int totalCount = healthService.findAllHealthCounts();
		if (pageNow != null) {
			page = new Page(totalCount,pageNow);
			healthList = healthService.findAllHealth(page);
		} else {
			page = new Page(totalCount, 1);
			healthList = healthService.findAllHealth(page);
		}
		mav.addObject(page);
		mav.addObject(healthList);
		return mav;
	}
	
	/**
	 * 后台 健康生活-添加
	 * @return healthAdd.jsp
	 */
	@RequestMapping({ "/jcmx/ha" })
	public String bha() {
		return "WEB-INF/backstage/healthAdd";
	}
	
	/**
	 * 后台 健康生活-添加保存
	 * @return health.jsp
	 */
	@RequestMapping(value="/jcmx/has" ,method=RequestMethod.POST)
	public String bhas(@RequestParam(value = "myfile", required = false) MultipartFile file,Health health,HttpServletRequest request,RedirectAttributes attr) {
        /**页面控件的文件流**/    
        if (file.getSize()!=0) {  
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy/MM/dd");     
        /**构建图片保存的目录**/    
        String logoPathDir = "uploads/"+ dateformat.format(new Date());     
        /**得到图片保存目录的真实路径**/    
        String logoRealPathDir = request.getSession().getServletContext().getRealPath(logoPathDir);     
        /**根据真实路径创建目录**/    
        File logoSaveFile = new File(logoRealPathDir);     
        if(!logoSaveFile.exists())     
            logoSaveFile.mkdirs();           
        	 /**获取文件的后缀**/    
	        String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));     
	        /**使用UUID生成文件名称**/    
	        String logImageName = UUID.randomUUID().toString()+ suffix;//构建文件名称     
	        /**拼成完整的文件保存路径加文件**/    
	        String fileName = logoRealPathDir + File.separator   + logImageName;                
	        File files = new File(fileName);          
	        try {     
	        	file.transferTo(files);     
	            String fileTemp=logoPathDir+"/"+logImageName;
	            health.setTime(new Date());
	            health.setImagePath(fileTemp);
	            healthService.saveHealth(health);
	            message="添加成功";
	    		attr.addFlashAttribute("message", message);
	        } catch (IllegalStateException e) {     
	            e.printStackTrace();     
	        } catch (IOException e) {            
	            e.printStackTrace();     
	        }     
	        return "redirect:/jcmx/h/1";
        }else{
        	message="上传失败：文件为空";
			attr.addFlashAttribute("message", message);
            return "redirect:/jcmx/ha";
        }   
	       
	}
	
	/**
	 * 后台 健康生活-修改
	 * @return healthEdit.jsp
	 */
	@RequestMapping({ "/jcmx/he" })
	public String bhe(Integer id,ModelMap map) {
		Health health  = healthService.findHealthById(id);
		map.put("health", health);
		return "WEB-INF/backstage/healthEdit";
	}
	
	/**
	 * 后台 健康生活-修改保存
	 * @return health.jsp
	 */
	@RequestMapping(value="/jcmx/hes" ,method=RequestMethod.POST)
	public String bhes(@RequestParam(value = "myfile", required = false) MultipartFile file,Health health,HttpServletRequest request,RedirectAttributes attr) {
		  /**页面控件的文件流**/
		if (file.getSize()!=0) {   
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy/MM/dd");     
	        /**构建图片保存的目录**/    
	        String logoPathDir = "uploads/"+ dateformat.format(new Date());     
	        /**得到图片保存目录的真实路径**/    
	        String logoRealPathDir = request.getSession().getServletContext().getRealPath(logoPathDir);     
	        /**根据真实路径创建目录**/    
	        File logoSaveFile = new File(logoRealPathDir);     
	        if(!logoSaveFile.exists())     
	            logoSaveFile.mkdirs();           
        	 /**获取文件的后缀**/    
	        String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));     
	        /**使用UUID生成文件名称**/    
	        String logImageName = UUID.randomUUID().toString()+ suffix;//构建文件名称     
	        /**拼成完整的文件保存路径加文件**/    
	        String fileName = logoRealPathDir + File.separator   + logImageName;                
	        File files = new File(fileName);          
	        try {     
	        	file.transferTo(files);     
	            String fileTemp=logoPathDir+"/"+logImageName;
	            health.setTime(new Date());
	            health.setImagePath(fileTemp);
	            healthService.updateHealth(health);
	            message="修改成功";
	    		attr.addFlashAttribute("message", message);
	        } catch (IllegalStateException e) {     
	            e.printStackTrace();     
	        } catch (IOException e) {            
	            e.printStackTrace();     
	        }     
	        return "redirect:/jcmx/h/1";
        }else{
        	 health.setTime(new Date());
        	 healthService.updateHealth(health);
        	 return "redirect:/jcmx/h/1";
        }   
	       
	}
	
	/**
	 * 后台 健康生活-删除
	 * @return health.jsp
	 */
	@RequestMapping({ "/jcmx/hd" })
	public String bhd(Integer id) {
		healthService.delHealth(id);
		return "redirect:/jcmx/h/1";
	}
	
}
