package com.human.ex;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.human.dao.ICartDao;
import com.human.dto.CartDto;
import com.human.dto.CartShopDto;
import com.human.dto.OrderDto;
import com.human.dto.ShopDto;
import com.human.dto.UserDto;
import com.human.service.ICartService;
import com.human.service.ICartShopService;
import com.human.service.IOrderService;
import com.human.service.IShopService;
import com.human.service.IUserService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Inject
	private ICartService cartService;
	
	@Inject
	private IOrderService orderService;
	
	@Inject
	private IShopService shopService;
	
	@Inject
	private IUserService UserService;
	
	@Inject
	private ICartShopService cartshopService;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value = "/select", method = RequestMethod.GET)
	public void select(Locale locale, Model model) throws Exception {
		List<UserDto> dto = UserService.selectAll();
		model.addAttribute("UserDto", dto);	
		
		List<ShopDto> dto1 = shopService.selectAll();
		model.addAttribute("ShopDto", dto1);
		
		List<CartDto> dto2 = cartService.selectAll();
	    model.addAttribute("CartDto", dto2);
		
	    List<CartShopDto> dto3 = cartshopService.selectAll_CartShop();
		model.addAttribute("CartShopDto", dto3);	
		
		List<OrderDto> dto4 = orderService.selectAll();
		model.addAttribute("OrderDto", dto4);
		
	}
}
