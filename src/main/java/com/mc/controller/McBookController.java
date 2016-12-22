package com.mc.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.mc.bean.*;
import com.mc.bean.KeyWord;
import com.mc.entity.*;
import com.mc.pageModel.Json;
import com.mc.service.BorrowService;
import com.mc.service.McBookService;
import com.mc.service.impl.McBookServiceImpl;

@Controller
@RequestMapping("/mcbook")
public class McBookController {
	private static final Logger LOGGER = Logger
			.getLogger(McBookController.class);

	@Autowired
	private McBookService mcBookService;
	@Autowired
	private BorrowService borrowService;
	@Autowired
	private SessionFactory sessionFactory;

	@RequestMapping("/hello")
	public @ResponseBody String hello() {
		System.out.println("hello!");
		System.out.println("hello2!");
		return "success";
	}

	@RequestMapping(value = "/addBook", method = RequestMethod.POST)
	public @ResponseBody Json addBook(McBook mcBook) {
		System.out.println("addBook...");
		System.out.println(mcBook.getNo() + " " + mcBook.getTitle() + " "
				+ mcBook.getStatus() + " " + mcBook.getNotes());
		Json j = new Json();
		try {
			Session session = sessionFactory.openSession();// 得到Session对象的实例后
			Transaction tx = session.beginTransaction();// 开启事务
			String hql = "select max(b.no) from mc_book b";
			Query query = session.createQuery(hql);
			String result = (String) query.uniqueResult();
			tx.commit();
			session.close();
			if (result == null || result.trim().length() == 0) {
				result = "0";
			}
			System.out.println("now(no):" + (Integer.parseInt(result) + 1));
			int no = Integer.parseInt(result) + 1;
			mcBook.setId(UUID.randomUUID().toString());
			mcBook.setStatus("Y");
			mcBook.setNo(no + "");
			mcBookService.save(mcBook);
			j.setSuccess(true);
			j.setMsg("Add book 《" + mcBook.getTitle() + "》 success！");
			j.setObj(mcBook);
		} catch (Exception e) {
			j.setMsg(e.getMessage());
			e.printStackTrace();
		}
		return j;
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/deleteBook", method = RequestMethod.POST)
	public @ResponseBody Json deleteBook(McBook mcBook) {
		System.out.println("deleteBook...It's registrationNumber = "
				+ mcBook.getRegistrationNumber());
		Json j = new Json();
		String rNumber = mcBook.getRegistrationNumber();// 获得输入的总登记号
		Session session = sessionFactory.openSession();// 得到Session对象的实例后
		Transaction tx = session.beginTransaction();// 开启事务
		String hql = "from mc_book where registrationNumber=:rnumber";
		Query query = session.createQuery(hql);
		query.setString("rnumber", rNumber);
		List<McBook> books = query.list();
		tx.commit();
		System.out.println(books.size());
		int n = books.size();
		try {
			for (int i = 0; i < n; i++) {
				if (i == 0) {
					j.setMsg("");
				}
				System.out.println(books.get(i));
				Transaction tx2 = session.beginTransaction();// 开启事务
				McBook book = (McBook) session.get(McBook.class, books.get(i)
						.getId());
				session.delete(book);
				tx2.commit();
				session.close();
				j.setMsg("删除成功！");
				j.setSuccess(true);
			}
		} catch (Exception e) {
			j.setMsg("删除操作失败，可能书库中并不存在该书，请重新核对信息...\n" + "错误信息如下："
					+ e.getMessage());
			j.setSuccess(false);
		}
		return j;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/findAllBooks", method = RequestMethod.POST)
	public @ResponseBody List findAllBooks() {
//		try {
			Session session = sessionFactory.openSession();// 得到Session对象的实例后
			Transaction tx = session.beginTransaction();// 开启事务
			String hql = "from mc_book";
			Query query = session.createQuery(hql);
			List<InformationOfBook> infoBooks = new ArrayList();
			
			List<McBook> books = query.list();
			tx.commit();
			System.out.println(books.size());
			int n = books.size();
			for (int i = 0; i < n; i++) {
				InformationOfBook ib = new InformationOfBook();
				BeanUtils.copyProperties(books.get(i), ib);
				ib.setPublishingDate(books.get(i).getPublishingDate().getTime());
				infoBooks.add(ib);
				System.out.println(books.get(i));
				if (books.get(i).getStatus().equals("N")) {
					// 当前书已经被借走,需要将借书人和应归还日期进行查询和赋值
					String num = books.get(i).getRegistrationNumber();
					Transaction tx2 = session.beginTransaction();
					String hql2 = "from borrow as b where b.registrationNumber=:rNumber and b.tag='N'";
					Query query2 = session.createQuery(hql2);
					query2.setString("rNumber", num);
					List<Borrow> borrows = query2.list();
					tx2.commit();
					infoBooks.get(i).setBackTime(
							borrows.get(0).getBackTime().getTime());
					infoBooks.get(i).setUserName(borrows.get(0).getUserName());
				} else if (books.get(i).getStatus().equals("Y")) {
					// 当前书可借，将借书人和应归还日期设为空
					infoBooks.get(i).setBackTime("0000-00-00");
					infoBooks.get(i).setUserName("无");
				}
			}
			session.close();
			return infoBooks;
//		} catch (Exception e) {
//			return null;
//		}

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/findHistory", method = RequestMethod.POST)
	public @ResponseBody List findHistory() {
		try {
			Session session = sessionFactory.openSession();// 得到Session对象的实例后
			Transaction tx = session.beginTransaction();// 开启事务
			String hql = "from borrow";
			Query query = session.createQuery(hql);
			List<InformationOfBorrow> infoBorrows = new ArrayList();
			
			List<Borrow> borrows = query.list();
			tx.commit();
			System.out.println(borrows.size());
			int n = borrows.size();
			for (int i = 0; i < n; i++) {
				InformationOfBorrow ib = new InformationOfBorrow();
				BeanUtils.copyProperties(borrows.get(i), ib);
				ib.setBackTime(borrows.get(i).getBackTime().getTime());
				ib.setTime(borrows.get(i).getTime().getTime());
				infoBorrows.add(ib);
				System.out.println(borrows.get(i));
			}
			session.close();
			return infoBorrows;
		} catch (Exception e) {
			return null;
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/findBook", method = RequestMethod.POST)
	public @ResponseBody List<?> findBook(KeyWord key) {
		System.out.println("findBook..." + key.getKeyWord());
		try {
			Session session = sessionFactory.openSession();// 得到Session对象的实例后
			Transaction tx = session.beginTransaction();// 开启事务
			String hql = "from mc_book where title like '%" + key.getKeyWord()
					+ "%'";
			Query query = session.createQuery(hql);
			List<InformationOfBook> infoBooks = new ArrayList();
			InformationOfBook ib = new InformationOfBook();
			List<McBook> books = query.list();
			tx.commit();
			System.out.println(books.size());
			int n = books.size();
			for (int i = 0; i < n; i++) {
				BeanUtils.copyProperties(books.get(i), ib);
				ib.setPublishingDate(books.get(i).getPublishingDate().getTime());
				infoBooks.add(ib);
				System.out.println(books.get(i));
				if (books.get(i).getStatus().equals("N")) {
					// 当前书已经被借走,需要将借书人和应归还日期进行查询和赋值
					String num = books.get(i).getRegistrationNumber();
					Transaction tx2 = session.beginTransaction();
					String hql2 = "from borrow as b where b.registrationNumber=:rNumber";
					Query query2 = session.createQuery(hql2);
					query2.setString("rNumber", num);
					List<Borrow> borrows = query2.list();//
					tx2.commit();
					infoBooks.get(i).setBackTime(
							borrows.get(0).getBackTime().getTime());
					infoBooks.get(i).setUserName(borrows.get(0).getUserName());
				} else if (books.get(i).getStatus().equals("Y")) {
					// 当前书可借，将借书人和应归还日期设为空
					infoBooks.get(i).setBackTime("0000-00-00");
					infoBooks.get(i).setUserName("无");
				}
			}
			session.close();
			return infoBooks;
		} catch (Exception e) {
			return null;
		}
	}

	@SuppressWarnings({ "unchecked", "unused" })
	@RequestMapping(value = "/borrowBook", method = RequestMethod.POST)
	public @ResponseBody Json borrowBook(Borrow br) {
		Json j = new Json();
		String rname = br.getUserName();
		try {
			Session session = sessionFactory.openSession();// 得到Session对象的实例后
			Transaction tx = session.beginTransaction();// 开启事务
			String hql = "from mc_user where username=:uName";
			Query query = session.createQuery(hql);
			query.setString("uName", rname);
			List<McUser> users = query.list();
			tx.commit();
			System.out.println(users.size());
			int n = users.size();
			if (n == 0) {
				j.setSuccess(false);
				j.setMsg("请先注册...");
			} else {// 用户已经注册过了，可以借书
				String rNumber = br.getRegistrationNumber();
				System.out.println(br.getBookName() + " "
						+ br.getRegistrationNumber());

				br.setId(UUID.randomUUID().toString());
				Transaction tx2 = session.beginTransaction();// 开启事务
				String hql2 = "from mc_book where registrationNumber=:rn";
				Query query2 = session.createQuery(hql2);
				query2.setString("rn", rNumber);
				List<McBook> records = query2.list();
				tx2.commit();
				session.close();
				if (records.size() == 0) {
					j.setMsg("书库中不存在该书，请查看您的书名和总登记号是否一致...");
					j.setSuccess(false);
					return j;
				} else if (records.size() == 1) {
					System.out.println(records.get(0).getStatus());
					if ((records.get(0).getStatus()).compareTo("N") == 0) {
						j.setMsg("当前该书已借出...");
						j.setSuccess(false);
					} else {
						records.get(0).setStatus("N");
						mcBookService.saveOrUpdate(records.get(0));
						Date dNow = new Date();
						System.out.println(dNow);
						Date dBack = new Date();
						System.out.println(dBack);
						br.setTime(dNow);// 借书日期为当前系统时间
						Calendar calendar = Calendar.getInstance(); // 得到日历
						calendar.setTime(dNow);// 把当前时间赋给日历
						calendar.add(Calendar.DAY_OF_MONTH, 30); // 设置为前一天
						dBack = calendar.getTime(); // 得到应归还的日期
						System.out.println(dBack);
						br.setBackTime(dBack);
						br.setTag("N");
						borrowService.save(br);
						j.setSuccess(true);
						j.setMsg(br.getUserName() + "借书成功！");
						j.setObj(br);
					}
				}
			}
		} catch (Exception e) {
			j.setMsg(e.getMessage());
			j.setSuccess(false);
			return j;
		}

		return j;
	}

	// 根据输入的用户名、总登记号、书名将借书表中相应记录删除
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/returnBook", method = RequestMethod.POST)
	public @ResponseBody Json returnBook(Borrow br) {
		System.out.println("returnBook...It's registrationNumber = "
				+ br.getRegistrationNumber());
		Json j = new Json();
		String rNumber = br.getRegistrationNumber();// 获得输入的总登记号
		String rname = br.getUserName();// 用户名
		Session session = sessionFactory.openSession();// 得到Session对象的实例后
		Transaction tx = session.beginTransaction();// 开启事务
		String hql = "from borrow where username=:rname and registrationNumber=:rNumber and tag = 'N'";
		Query query = session.createQuery(hql);
		query.setString("rname", rname);
		query.setString("rNumber", rNumber);
		List<Borrow> borrows = query.list();
		tx.commit();

		try {
			if (borrows.size() == 1) {
				borrows.get(0).setTag("Y");
				borrowService.saveOrUpdate(borrows.get(0));
				Transaction tx2 = session.beginTransaction();// 开启事务
				String hql2 = "from mc_book where registrationNumber=:rnumber";
				Query query2 = session.createQuery(hql2);
				query2.setString("rnumber", rNumber);
				tx2.commit();
				List<McBook> records = query2.list();
				if (records.size() == 1) {
					records.get(0).setStatus("Y");
					mcBookService.saveOrUpdate(records.get(0));
					j.setMsg("还书成功!");
					j.setSuccess(true);
					j.setObj(borrows.get(0));
				} else {
					j.setMsg("error!");
					j.setSuccess(false);
				}

			}
		} catch (Exception e) {
			j.setMsg("删除操作失败，可能输入信息有误，请重新核对信息...\n" + "错误信息如下："
					+ e.getMessage());
			j.setSuccess(false);
		}
		session.close();
		return j;
	}

}
