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

import com.qianhe.model.News;
import com.qianhe.model.Page;
import com.qianhe.service.NewsService;


@Controller
public class NewsController {
	
	@Autowired
	private NewsService newsService;
	
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	@RequestMapping({ "/news/{pageNow}" })
	public ModelAndView newsInfo(@PathVariable Integer pageNow) {
		ModelAndView mav=new ModelAndView("news");
		int totalCount = newsService.findAllNewsCounts();
		Page page = new Page(totalCount,pageNow);
		List<News> newsList = newsService.findAllNews(page);
		mav.addObject(page);
		mav.addObject(newsList);
		return mav;
	}
	
	@RequestMapping({ "/newst/{type}/{pageNow}" })
	public ModelAndView newsGongsi(@PathVariable Integer pageNow,@PathVariable Integer type) {
		ModelAndView mav = null;
		if(type == 2001 ){
			 mav=new ModelAndView("news_zx");
		}else if(type == 2002){
			 mav=new ModelAndView("news_hy");
		}else{
			 mav=new ModelAndView("news_zy");
		}
		List<News> tNewsList=null;
		Page page = null;
		int totalCount = (int) newsService.findNewsCategoryCounts(type);
		if (pageNow != null) {
			page = new Page(totalCount,pageNow);
			int startPos=page.getStartPos();
			int pageSize=page.getPageSize();
			tNewsList = newsService.findNewsByCategory(type,startPos,pageSize);
		} else {
			page = new Page(totalCount, 1);
			int startPos=page.getStartPos();
			int pageSize=page.getPageSize();
			tNewsList = newsService.findNewsByCategory(type,startPos,pageSize);
		}
		mav.addObject(type);
		mav.addObject(page);
		mav.addObject(tNewsList);
		return mav;
	}
	
	@RequestMapping({ "/news/detail" })
	public String newsDetail(@Param(value = "id") Integer id,Model model) {
		Integer maxId=newsService.findMaxNewsId();
		if(id<1){
			id=1;
		}else if(id>maxId){
			id=maxId;
		}
		News news=newsService.findNewsById(id);
		newsService.saveCount(id);
		model.addAttribute(news);
		return "newsdt";
	}
	
	/**
	 * 后台公司资讯-列表
	 * @param pageNow
	 * @return news.jsp
	 */
	@RequestMapping({ "/jcmx/n/{pageNow}" })
	public ModelAndView bn(@PathVariable Integer pageNow) {
		ModelAndView mav=new ModelAndView("WEB-INF/backstage/news");
		List<News> newsList=null;
		Page page = null;
		int totalCount = newsService.findAllNewsCounts();
		if (pageNow != null) {
			page = new Page(totalCount,pageNow);
			newsList = newsService.findAllNews(page);
		} else {
			page = new Page(totalCount, 1);
			newsList = newsService.findAllNews(page);
		}
		mav.addObject(page);
		mav.addObject(newsList);
		return mav;
	}
	
	/**
	 * 后台公司资讯-添加
	 * @return newsAdd.jsp
	 */
	@RequestMapping({ "/jcmx/na" })
	public String bna() {
		return "WEB-INF/backstage/newsAdd";
	}
	
	/**
	 * 后台公司资讯-添加保存
	 * @return news.jsp
	 */
	@RequestMapping(value="/jcmx/nas" ,method=RequestMethod.POST)
	public String bnas(@RequestParam(value = "myfile", required = false) MultipartFile file,News news,HttpServletRequest request,RedirectAttributes attr) {
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
				news.setTime(new Date());
				news.setImagePath(fileTemp);
				newsService.saveNews(news);
				message = "添加成功";
				attr.addFlashAttribute("message", message);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return "redirect:/jcmx/n/1";
		} else {
			message = "上传失败：文件为空";
			attr.addFlashAttribute("message", message);
			return "redirect:/jcmx/ha";
		}

	}
	
	/**
	 * 后台公司资讯-修改
	 * @return newsEdit.jsp
	 */
	@RequestMapping({ "/jcmx/ne" })
	public String bne(Integer id,ModelMap map) {
		News news  = newsService.findNewsById(id);
		map.put("news", news);
		return "WEB-INF/backstage/newsEdit";
	}
	
	/**
	 * 后台公司资讯-修改保存
	 * @return news.jsp
	 */
	@RequestMapping(value="/jcmx/nes" ,method=RequestMethod.POST)
	public String bnes(@RequestParam(value = "myfile", required = false) MultipartFile file,News news,HttpServletRequest request,RedirectAttributes attr) {
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
				news.setTime(new Date());
				news.setImagePath(fileTemp);
				newsService.updateNews(news);
				message = "修改成功";
				attr.addFlashAttribute("message", message);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return "redirect:/jcmx/n/1";
		} else {
				news.setTime(new Date());
				newsService.updateNews(news);
				message = "修改成功";
				attr.addFlashAttribute("message", message);
			return "redirect:/jcmx/n/1";
		}

	}
	
	/**
	 * 后台公司资讯-删除
	 * @return news.jsp
	 */
	@RequestMapping({ "/jcmx/nd" })
	public String bnd(Integer id) {
		newsService.delNews(id);
		return "redirect:/jcmx/n/1";
	}
	
	
}
