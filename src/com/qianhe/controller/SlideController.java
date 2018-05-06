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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.qianhe.model.Slide;
import com.qianhe.service.SlideService;

@Controller
public class SlideController {

	@Autowired
	private SlideService slideService;
	
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * 首页幻灯片广告
	 * 
	 * @return
	 */
	@RequestMapping(value = "/b/findSlide", method = RequestMethod.GET)
	public ModelAndView slide() {
		ModelAndView mav = new ModelAndView("WEB-INF/backstage/slide");
		List<Slide> slideList = slideService.findAllSlide();
		mav.addObject("slideList", slideList);
		return mav;
	}

	/**
	 * 准备编辑幻灯片广告
	 * 
	 * @param Slide
	 * @return slideedit.jsp
	 */
	@RequestMapping(value = "/b/prepareUpdateSlide/{id}", method = RequestMethod.GET)
	public ModelAndView prepareUpdateSlide(@PathVariable int id) {
		ModelAndView mav = new ModelAndView("WEB-INF/backstage/slideedit");
		List<Slide> slideList = slideService.findAllSlide();
		Slide slide = slideService.findSlideById(id);
		mav.addObject("slide", slide);
		mav.addObject("slideList", slideList);
		return mav;
	}

	/**
	 * 编辑幻灯片广告
	 * 
	 * @param Slide
	 * @return
	 */
	@RequestMapping(value = "/b/updateSlide", method = RequestMethod.POST)
	public ModelAndView updateSlide(Slide slide,HttpServletRequest request,RedirectAttributes attr,@RequestParam("myfile")   MultipartFile myfile) {
		   SimpleDateFormat dateformat = new SimpleDateFormat("yyyy/MM/dd");     
	        /**构建图片保存的目录**/    
	        String logoPathDir = "uploads/"+ dateformat.format(new Date());     
	        /**得到图片保存目录的真实路径**/    
	        String logoRealPathDir = request.getSession().getServletContext().getRealPath(logoPathDir);     
	        /**根据真实路径创建目录**/    
	        File logoSaveFile = new File(logoRealPathDir);     
	        if(!logoSaveFile.exists())     
	            logoSaveFile.mkdirs();           
	        /**页面控件的文件流**/    
	        if (myfile.getSize()==0) {   
             message="上传失败：文件为空";
				 attr.addFlashAttribute("message", message);
	            return new ModelAndView("redirect:/b/findSlide");
         }   
	        /**获取文件的后缀**/    
	        String suffix = myfile.getOriginalFilename().substring(myfile.getOriginalFilename().lastIndexOf("."));     
	        /**使用UUID生成文件名称**/    
	        String logImageName = UUID.randomUUID().toString()+ suffix;//构建文件名称     
	        /**拼成完整的文件保存路径加文件**/    
	        String fileName = logoRealPathDir + File.separator   + logImageName;                
	        File file = new File(fileName);          
	        try {     
	        	myfile.transferTo(file);     
	            String fileTemp=logoPathDir+"/"+logImageName;
	            slide.setMyFile(fileTemp);
	            slideService.editSlide(slide);
	            message="修改成功";
	    		attr.addFlashAttribute("message", message);
	        } catch (IllegalStateException e) {     
	            e.printStackTrace();     
	        } catch (IOException e) {            
	            e.printStackTrace();     
	        }     
	        	return new ModelAndView("redirect:/b/findSlide");
	}

	/**
	 * 删除幻灯片广告
	 * 
	 * @param id
	 * @return slidee.jsp
	 */
	@RequestMapping(value = "/b/deleteSlide/{id}", method = RequestMethod.GET)
	public ModelAndView deleteSlide(@PathVariable int id) {
		ModelAndView mav = new ModelAndView("redirect:/b/findSlide");
		slideService.deleteSlide(id);
		return mav;
	}
	
	/**
	 * 添加幻灯片广告
	 * @param user
	 * @return
	 */
	@RequestMapping(value="/b/saveSlide",method=RequestMethod.POST)
	public ModelAndView saveSlide(Slide slide,HttpServletRequest request,RedirectAttributes attr,@RequestParam("myfile")   MultipartFile myfile){
	        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy/MM/dd");     
	        /**构建图片保存的目录**/    
	        String logoPathDir = "uploads/"+ dateformat.format(new Date());     
	        /**得到图片保存目录的真实路径**/    
	        String logoRealPathDir = request.getSession().getServletContext().getRealPath(logoPathDir);     
	        /**根据真实路径创建目录**/    
	        File logoSaveFile = new File(logoRealPathDir);     
	        if(!logoSaveFile.exists())     
	            logoSaveFile.mkdirs();           
	        /**页面控件的文件流**/    
	        if (myfile.getSize()==0) {   
              message="上传失败：文件为空";
				 attr.addFlashAttribute("message", message);
	            return new ModelAndView("redirect:/b/findSlide");
          }   
	        /**获取文件的后缀**/    
	        String suffix = myfile.getOriginalFilename().substring(myfile.getOriginalFilename().lastIndexOf("."));     
	        /**使用UUID生成文件名称**/    
	        String logImageName = UUID.randomUUID().toString()+ suffix;//构建文件名称     
	        /**拼成完整的文件保存路径加文件**/    
	        String fileName = logoRealPathDir + File.separator   + logImageName;                
	        File file = new File(fileName);          
	        try {     
	        	myfile.transferTo(file);     
	            String fileTemp=logoPathDir+"/"+logImageName;
	            slide.setMyFile(fileTemp);
	            slideService.saveSlide(slide);
	            message="上传成功";
	    		attr.addFlashAttribute("message", message);
	        } catch (IllegalStateException e) {     
	            e.printStackTrace();     
	        } catch (IOException e) {            
	            e.printStackTrace();     
	        }     
	        	return new ModelAndView("redirect:/b/findSlide");
	}

}