package com.ecommerce.example;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class AdminController {
	
	@Autowired
	ShoeDAO shoe_dao;
	@Autowired
	ShoeRepo shoe_repo;
	
	@Autowired
	AdminDAO ad_dao;
	@Autowired
	AdminRepo ad_repo;
	@Autowired
	UserDAO u_dao;
	@Autowired
	UserRepo u_repo;
	@Autowired
	BankRepo b_repo;
	@Autowired
	BankDAO b_dao;
	
	@ResponseBody
	@RequestMapping("/")
	public ModelAndView displayadminpage(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("index.jsp");
		return mv;
	}


	@RequestMapping("/reg_admin")
	public ModelAndView ad_insert(HttpServletRequest req, HttpServletResponse res)
	{
		ModelAndView mv = new ModelAndView();
		Admin a = new Admin();
		a.setAd_fname(req.getParameter("ad_fname"));
		a.setAd_lname(req.getParameter("ad_lname"));
		a.setAd_phone(req.getParameter("ad_phone"));
		a.setAd_mail(req.getParameter("ad_mail"));
		a.setAd_dob(req.getParameter("ad_dob"));
		a.setAd_pass(req.getParameter("ad_pass"));

		Admin aa = ad_dao.ad_insert(a);
		if(aa!=null)
		{
			mv.setViewName("ad_reg_succ.jsp");
		}
		return mv;
	}

	//ADMIN LOGIN 
	
	@RequestMapping("/ad_login")
	public ModelAndView ad_loginbyname(HttpServletRequest req, HttpServletResponse res)
	{
		ModelAndView mv=new ModelAndView();
		String ad_fname = req.getParameter("ad_fname");
        String ad_pass= req.getParameter("ad_pass");
        Admin ad=ad_repo.findbyfnamepass(ad_fname, ad_pass);
		if(ad!=null)			
		{
			mv.setViewName("ad_login_succ.jsp");
		}else 
		{
			String msg="Check Crediantials";
			mv.addObject("msg",msg);
			mv.setViewName("admin_login_fail.jsp");
		}return mv;
	}
	//ADMIN CAN GET FORGOT PASSWORD USING REGISTERED MOBILE NUMBER 
	
	@RequestMapping("forget_ad_pass")
	public ModelAndView forget_ad_pass(HttpServletRequest req, HttpServletResponse res)
	{
		ModelAndView mv = new ModelAndView();
		String ad_phone = req.getParameter("ad_phone");
		List<Admin> pass_list = ad_repo.findByAdPhone(ad_phone);
		mv.setViewName("get_admin_pass.jsp");
		mv.addObject("pass_list",pass_list);
		return mv;
	}

	//ADMIN CAN GET SHOE  LIST
	@ResponseBody
	@RequestMapping("/get_report")
	public ModelAndView report(HttpServletRequest req, HttpServletResponse res)
	{
		ModelAndView mv = new ModelAndView();		
		List<Shoe> r_list = shoe_repo.findAll();
		mv.setViewName("shoe_list.jsp");
		mv.addObject("r_list",r_list);
		
		return mv;
	}
	//ADMIN can get user list 
	
	@RequestMapping("/get_user")
	public ModelAndView search_user(HttpServletRequest req, HttpServletResponse res)
	{
		ModelAndView mv = new ModelAndView();
		
		List<User> u_list = u_repo.findAll();
		mv.setViewName("user_list.jsp");
		mv.addObject("u_list", u_list);
		
		return mv;		
	}
	
	
		//insert shoe by Admin
	    private final String FOLDER_PATH="D:\\img\\";
		@RequestMapping("/insert_shoe")
		public ModelAndView ad_shoe_insert(HttpServletRequest req, HttpServletResponse res)
		{
			ModelAndView mv = new ModelAndView();
			Shoe sh=new Shoe();
			
			sh.setShoe_name(req.getParameter("shoe_name"));
			sh.setShoe_code(req.getParameter("shoe_code"));
			sh.setShoe_brand(req.getParameter("shoe_brand"));
			sh.setShoe_price(req.getParameter("shoe_price"));
			sh.setSell_date(req.getParameter("shoe_selldate"));
			

			Shoe s=shoe_dao.insert_shoe(sh);
			if(s!=null) {
				mv.setViewName("shoe_inserted_succ.jsp");
			} 
			return mv;
	
		}
		//delete shoe by admin
		
		@RequestMapping("/Delete_shoe")
		public ModelAndView ad_shoe_delete(HttpServletRequest req, HttpServletResponse res)
		{
			ModelAndView mv = new ModelAndView();
			
			Shoe sh=new Shoe();
			sh.setShoe_id(Integer.parseInt(req.getParameter("shoe_id")));
			String sd=shoe_dao.delete(sh);
			
			if(sd!=null) {
				mv.setViewName("shoe_deleted.jsp");
			}
			return mv;
			
		}
		//update shoe by admin
		
		@RequestMapping("/Update_shoe")
		public ModelAndView ad_shoe_update(HttpServletRequest req, HttpServletResponse res)
		{
           ModelAndView mv = new ModelAndView();
			
			Shoe sh=new Shoe();
			sh.setShoe_id(Integer.parseInt(req.getParameter("shoe_id")));
			sh.setShoe_name(req.getParameter("shoe_name"));
			sh.setShoe_code(req.getParameter("shoe_code"));
			sh.setShoe_brand(req.getParameter("shoe_brand"));
			sh.setShoe_price(req.getParameter("shoe_price"));
			sh.setSell_date(req.getParameter("sell_date"));
		
			Shoe sd=shoe_dao.updateShoe(sh);
			
			if(sd!=null) {
				mv.setViewName("shoe_updated.jsp");
			}
			return mv;
		
			
		}
		@RequestMapping("/reg_user")
		public ModelAndView user_insert(HttpServletRequest req, HttpServletResponse res)
		{
			ModelAndView mv = new ModelAndView();
			User u = new User();
			u.setUser_fname(req.getParameter("user_fname"));
			u.setUser_lname(req.getParameter("user_lname"));
			u.setUser_phone(req.getParameter("user_phone"));
			u.setUser_mail(req.getParameter("user_mail"));
			u.setUser_dob(req.getParameter("user_dob"));
			u.setUser_pass(req.getParameter("user_pass"));

			User uu = u_dao.user_insert(u);
			if(uu!=null)
			{
				mv.setViewName("user_reg_succ.jsp");
			}
			return mv;
		}
		//USER LOGIN 
				@ResponseBody
				@RequestMapping("/user_login")
				public ModelAndView user_login(HttpServletRequest req, HttpServletResponse res)
				{
					ModelAndView mv = new ModelAndView();
					String user_fname = req.getParameter("user_fname");
					String user_pass = req.getParameter("user_pass");
					
					User u=u_repo.findbyfnamepass(user_fname, user_pass);
					if(u!=null)			
					{
						mv.setViewName("user_login_succ.jsp");
					}else 
					{
						
						mv.setViewName("user_login_fail.jsp");
					}return mv;	
				}
				
				//USER CAN FORGET HIS PASSWORD USING PHONENUMBER
				@ResponseBody
				@RequestMapping("/forget_pass")
				public ModelAndView forget_pass(HttpServletRequest req, HttpServletResponse res)
				{
					ModelAndView mv = new ModelAndView();
					String user_phone = req.getParameter("user_phone");
					List<User> u_pass = u_dao.forget_pass(user_phone);
					mv.setViewName("get_user_pass.jsp");
					mv.addObject("u_pass",u_pass);
					return mv; 
				}
				//User CAN GET SHOE  LIST
				@ResponseBody
				@RequestMapping("/get_shoelist")
				public ModelAndView shoe_list(HttpServletRequest req, HttpServletResponse res)
				{
					ModelAndView mv = new ModelAndView();		
					List<Shoe> r_list = shoe_repo.findAll();
					mv.setViewName("ushoe_list.jsp");
					mv.addObject("r_list",r_list);
					
					return mv;
				}
				//User CAN GET buy from SHOE  LIST
				@ResponseBody
				@RequestMapping("/buy_shoe")
				public ModelAndView shoe_buy(HttpServletRequest req, HttpServletResponse res)
				{
					ModelAndView mv = new ModelAndView();	
					int bank_id=(Integer.parseInt(req.getParameter("bank_id")));
					String Bank_balance = req.getParameter("Bank_balance");
					List<Bank> r_list = b_repo.getByIdAndBalance(bank_id, Bank_balance);
					mv.setViewName("buy_list.jsp");
					mv.addObject("b_list",r_list);
					
					return mv;
				}
				
}
