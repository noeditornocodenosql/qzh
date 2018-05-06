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

import com.qianhe.model.Page;
import com.qianhe.model.Team;
import com.qianhe.service.TeamServcie;


@Controller
public class TeamController {
	
	@Autowired
	private TeamServcie teamServcie;
	
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	@RequestMapping({ "/teaminfo/{pageNow}" })
	public ModelAndView newsInfo(@PathVariable Integer pageNow) {
		ModelAndView mav=new ModelAndView("team");
		List<Team> teamList = null;
		Page page = null;
		int totalCount = teamServcie.findAllTeamCounts();
		if (pageNow != null) {
			page = new Page(totalCount,pageNow);
			teamList = teamServcie.findAllTeam(page);
		} else {
			page = new Page(totalCount, 1);
			teamList = teamServcie.findAllTeam(page);
		}
		mav.addObject(page);
		mav.addObject(teamList);
		return mav;
	}
	
	/**
	 * 后台 企业团队-列表
	 * @param pageNow
	 * @return team.jsp
	 */
	@RequestMapping({ "/jcmx/t/{pageNow}" })
	public ModelAndView bh(@PathVariable Integer pageNow) {
		ModelAndView mav = new ModelAndView("WEB-INF/backstage/team");
		List<Team> teamList = null;
		Page page = null;
		int totalCount = teamServcie.findAllTeamCounts();
		if (pageNow != null) {
			page = new Page(totalCount,pageNow);
			teamList = teamServcie.findAllTeam(page);
		} else {
			page = new Page(totalCount, 1);
			teamList = teamServcie.findAllTeam(page);
		}
		mav.addObject(page);
		mav.addObject(teamList);
		return mav;
	}
	
	/**
	 * 后台 企业团队-添加
	 * @return teamAdd.jsp
	 */
	@RequestMapping({ "/jcmx/ta" })
	public String bha() {
		return "WEB-INF/backstage/teamAdd";
	}
	
	/**
	 * 后台 企业团队-添加保存
	 * @return team.jsp
	 */
	@RequestMapping(value="/jcmx/tas" ,method=RequestMethod.POST)
	public String bhas(@RequestParam(value = "myfile", required = false) MultipartFile file,Team team,HttpServletRequest request,RedirectAttributes attr) {
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
				team.setTime(new Date());
				team.setImagePath(fileTemp);
				teamServcie.saveTeam(team);
				message = "添加成功";
				attr.addFlashAttribute("message", message);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return "redirect:/jcmx/t/1";
		} else {
			message = "上传失败：文件为空";
			attr.addFlashAttribute("message", message);
			return "redirect:/jcmx/ta";
		}

	}
	
	/**
	 * 后台 企业团队-修改
	 * @return teamEdit.jsp
	 */
	@RequestMapping({ "/jcmx/te" })
	public String bhe(Integer id,ModelMap map) {
		Team team  = teamServcie.findTeamById(id);
		map.put("team", team);
		return "WEB-INF/backstage/teamEdit";
	}
	
	/**
	 * 后台 企业团队-修改保存
	 * @return team.jsp
	 */
	@RequestMapping(value="/jcmx/tes" ,method=RequestMethod.POST)
	public String bhes(@RequestParam(value = "myfile", required = false) MultipartFile file,Team team,HttpServletRequest request,RedirectAttributes attr) {
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
				team.setTime(new Date());
				team.setImagePath(fileTemp);
				teamServcie.updateTeam(team);
				message = "修改成功";
				attr.addFlashAttribute("message", message);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return "redirect:/jcmx/t/1";
		} else {
				team.setTime(new Date());
				teamServcie.updateTeam(team);
				message = "修改成功";
				attr.addFlashAttribute("message", message);
			return "redirect:/jcmx/t/1";
		}

	}
	
	/**
	 * 后台 企业团队-删除
	 * @return team.jsp
	 */
	@RequestMapping({ "/jcmx/td" })
	public String bhd(Integer id) {
		teamServcie.delTeam(id);
		return "redirect:/jcmx/t/1";
	}
}
