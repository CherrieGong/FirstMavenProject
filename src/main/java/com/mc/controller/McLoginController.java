package com.mc.controller;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mc.entity.McUser;
import com.mc.pageModel.Json;
import com.mc.service.McRegisterService;

@Controller
@RequestMapping("/mclogin")
public class McLoginController {
	private static final Logger LOGGER = Logger
			.getLogger(McLoginController.class);

	/**
	 * @Autowired 可以对成员变量、方法和构造函数进行标注，来完成自动装配的工作 通过 @Autowired的使用来消除 set ，get方法
	 */

	@Autowired
	private McRegisterService mcRegisterService;
	@Autowired
	private SessionFactory sessionFactory;

	// hello函数，仅供学习mapping时测试检验
	@RequestMapping("/hello")
	public @ResponseBody String hello() {
		System.out.println("hello!");
		System.out.println("hello2!");
		return "success";
	}

	// 判断注册页面输入的用户名是否已经被注册
	@RequestMapping(value = "/checkRegisterName", method = RequestMethod.POST)
	public @ResponseBody Json checkRegisterName(McUser mcRegister) {
		System.out.println("checkRegisterName...");
		Json j = new Json();
		String uname = mcRegister.getuserName();
		Session session = sessionFactory.openSession();// 得到Session对象的实例后
		Transaction tx = session.beginTransaction();// 开启事务
		String hql = "from mc_user where username=:uName";
		Query query = session.createQuery(hql);
		query.setString("uName", uname);
		List<McUser> users = query.list();
		tx.commit();
		session.close();
		System.out.println(users.size());
		int n = users.size();
		if (n == 0) {
			j.setSuccess(true);
			j.setMsg("ok");
		} else if (n == 1) {
			j.setSuccess(false);
			j.setMsg("该用户名已被注册，请重新输入...");
		} else {
			j.setSuccess(false);
			j.setMsg("出现错误！");
		}
		return j;
	}

	// 注册信息完全正确，将信息存入mc_user表中
	@RequestMapping(value = "/addRegister", method = RequestMethod.POST)
	public @ResponseBody Json addMcRegister(McUser mcRegister) {
		System.out.println("addRegister...");
		System.out.println(mcRegister.getuserName());
		Json j = new Json();
		try {
			mcRegister.setId(UUID.randomUUID().toString());
			mcRegister.setregisterTime(new Date());
			mcRegisterService.save(mcRegister);
			j.setSuccess(true);
			j.setMsg("register success！");
			j.setObj(mcRegister);
			System.out.println(j);
		} catch (Exception e) {
			j.setMsg(e.getMessage());
			j.setSuccess(false);
			e.printStackTrace();
		}
		return j;
	}

	// 检查mc_user表中是否已经存在登录页面输入的用户名和密码，只有存在且只存在一条记录时提示"ok"
	@RequestMapping(value = "/checkUser", method = RequestMethod.POST)
	public @ResponseBody Json checkUser(McUser user) {
		Json j = new Json();
		String uname = user.getuserName();// 获得登录页面输入的用户名字段
		String uPSW = user.getpassWord();// 获得登录页面输入的密码字段
		System.out.println("checkUser...username = " + uname + " password = " + uPSW);
		Session session = sessionFactory.openSession();// 得到Session对象的实例后
		Transaction tx = session.beginTransaction();// 开启事务
		String hql = "from mc_user where username=:userName and password=:passWord";
		Query query = session.createQuery(hql);
		query.setString("userName", uname);
		query.setString("passWord", uPSW);
		List<McUser> users = query.list();
		tx.commit();
		session.close();
		System.out.println(users.size());
		int n = users.size();
		if (n == 0) {
			j.setSuccess(false);
			j.setMsg("用户名或密码错误！");
		} else if (n == 1) {
			j.setSuccess(true);
			j.setMsg("ok");
		} else {
			j.setSuccess(false);
			j.setMsg("出现错误！");
		}
		System.out.println("username:  " + j.getMsg() + " " + j.getObj() + " "
				+ j.isSuccess());
		return j;
	}
}
