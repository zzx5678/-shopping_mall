package com.human.ex;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.human.dto.ShopDto;
import com.human.dto.UserDto;
import com.human.service.IShopService;
import com.human.service.IUserService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class ShopController {

	private static final Logger logger = LoggerFactory.getLogger(ShopController.class);
	
	@Inject
	private IShopService shopService;
	
	@Inject
	private IUserService UserService;
	
	/**
	* Simply selects the home view to render by returning its name.
	*/
	@RequestMapping(value = "/shop/add", method = RequestMethod.GET)
	public void add() throws Exception{
		System.out.println("add insert");
	}
	
	@RequestMapping(value = "/shop/addDB", method = RequestMethod.POST)
	public String addDB(ShopDto dto) throws Exception{
		System.out.println("insert db");
		shopService.insert(dto);
		System.out.println(dto);
		return "redirect:/shop/products";
	}
	
	@RequestMapping(value = "/shop/products", method = RequestMethod.GET)
	public void products(Model model) throws Exception{
		System.out.println("selectAll");
		List<ShopDto> dto = shopService.selectAll();
		System.out.println(dto);
		model.addAttribute("list",dto);		
	}
	
	@RequestMapping(value = "/shop/editProducts", method = RequestMethod.GET)
	public void editProducts(Model model) throws Exception{
		System.out.println("edit_selectAll");
		List<ShopDto> dto = shopService.selectAll();
		System.out.println(dto);
		model.addAttribute("list",dto);		
	}
	@RequestMapping(value = "/shop/product_deleteDB", method = RequestMethod.GET)
	public String product_deleteDB(Model model, @RequestParam("code")String code) throws Exception{
		System.out.println("product_deleteDB");
		shopService.delete(code);

		return "redirect:/shop/editProducts";
	}
	
	@RequestMapping(value = "/shop/product", method = RequestMethod.GET)
	public void product(Model model,@RequestParam("code")String code) throws Exception{
		System.out.println("select code");
		ShopDto dto = shopService.select(code);
		System.out.println(dto);
		model.addAttribute("ShopDto",dto);		
	}
	
	@RequestMapping(value = "/shop/product_update", method = RequestMethod.GET)
	public void product_update(Model model, @RequestParam("code")String code) throws Exception{
		System.out.println("update code");
		ShopDto dto = shopService.select(code);
		System.out.println(dto);
		model.addAttribute("ShopDto",dto);		
	}
	@RequestMapping(value = "/shop/product_updateDB", method = RequestMethod.POST)
	public String product_updateDB(Model model,ShopDto dto) throws Exception{
		System.out.println("update db");
		shopService.update(dto);
		return "redirect:/shop/editProducts";
	}
	
	@RequestMapping(value = "/shop/ship", method = RequestMethod.GET)
	public void ship(Model model, HttpSession session) throws Exception{
		System.out.println("ship");
		
		Date currentDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy년 MM월 dd일, HH시 mm분 ss초");
        String formattedDate = dateFormat.format(currentDate);
        
        // 현재 날짜를 JSP에 전달
        model.addAttribute("formattedDate", formattedDate);
        
        
        String userId = (String) session.getAttribute("userId");
        if (userId != null) {
        	UserDto dto = UserService.select(userId);
			model.addAttribute("UserDto",dto);
			System.out.println(dto);
	        
	    	String email = dto.getEmail();
        	String[] emailArr = email.split("@");
        	session.setAttribute("emailArr", emailArr);
            
        	String phoneNumber = dto.getPhoneNumber();
        	String[] phoneNumberArr = phoneNumber.split("-");
        	session.setAttribute("phoneNumberArr", phoneNumberArr);
        }
	}
	
	@RequestMapping(value = "/shop/shop_complete", method = RequestMethod.GET)
	public void shop_complete(Model model) throws Exception{
		System.out.println("shop_complete");
			
	}
}

