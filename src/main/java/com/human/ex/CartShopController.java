package com.human.ex;

import java.text.DateFormat;
import java.util.Arrays;
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

import com.human.dto.CartShopDto;
import com.human.dto.OrderDto;
import com.human.service.ICartShopService;
import com.human.service.IOrderService;


/**
 * Handles requests for the application home page.
 */
@Controller
public class CartShopController {
	
	private static final Logger logger = LoggerFactory.getLogger(CartShopController.class);
	
	@Inject
	private ICartShopService cartshopService;
	
	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/shop/cartshop", method = RequestMethod.GET)
	public void cartshop(Model model, HttpSession session) throws Exception{
		String sessionId = (String) session.getId();
		String userId = (String) session.getAttribute("userId");
		
		if (userId == null) {
			System.out.println("cart selectAll_session");
			System.out.println("session : " + session.getId() );
			List<CartShopDto> dto = cartshopService.selectAll_CartShop_session(sessionId);
			System.out.println(dto);
			model.addAttribute("Cart_list", dto);	
		}else {
			System.out.println("cart selectAll_user");
			List<CartShopDto> dto = cartshopService.selectAll_CartShop_user(userId);
			System.out.println(dto);
			model.addAttribute("Cart_list", dto);	
		}
			
	}

	@RequestMapping(value = "/shop/cartshop_delete", method = RequestMethod.GET)
	public String cartshop_deleteDB(String product_code, HttpSession session ) throws Exception{
		String session_Id = (String) session.getId();
		String userId = (String) session.getAttribute("userId");
		
		if (userId == null) {
			System.out.println("cart session_delete");
			System.out.println("session : " + session.getId() );
			
			cartshopService.delete_session(session_Id, product_code);
		}else {
			System.out.println("cart user_delete");
			
			cartshopService.delete_user(userId, product_code);
		}
		return "redirect:/shop/cartshop";	
	}
	
	
	
	
	
}
