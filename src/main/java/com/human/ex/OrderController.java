package com.human.ex;

import java.text.DateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.human.dto.CartShopDto;
import com.human.dto.OrderDto;
import com.human.dto.ShopDto;
import com.human.service.ICartShopService;
import com.human.service.IOrderService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class OrderController {
	
	private static final Logger logger = LoggerFactory.getLogger(OrderController.class);
	
	@Inject
	private ICartShopService cartshopService;
	
	@Inject
	private IOrderService orderService;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/shop/order_insertDB", method = RequestMethod.POST)
	public String Order_insertDB(OrderDto dto, HttpSession session, HttpServletRequest request) throws Exception{
		
	    String userId = (String) session.getAttribute("userId");

	    // Order_id를 UUID로 생성하여 설정합니다.
        dto.setOrder_id(UUID.randomUUID().toString());
       
        String Order_PhoneNumber = request.getParameter("phoneNumber1") + "-" + request.getParameter("phoneNumber2") + "-" + request.getParameter("phoneNumber3");
        System.out.println("Order_PhoneNumber : " + Order_PhoneNumber );
        dto.setOrder_phoneNumber(Order_PhoneNumber);
        
	    if (userId == null) {
	        // 비로그인 상태
	    	dto.setSession_id(session.getId()); // 세션 ID 설정
	    	
	    	System.out.println("session : " + session.getId() );
	    	System.out.println("order insert_session");
        	orderService.insert_session(dto);
	    } else {
	        // 로그인 상태
	    	dto.setUser_id(userId);  // dto에 userId를 설정합니다.
	    	
	    	String Order_Email = request.getParameter("email") + "@" + request.getParameter("select");
	    	System.out.println("Order_Email : " + Order_Email);
	    	dto.setOrder_email(Order_Email);
	    	 
	    	System.out.println("order insert_user");
        	orderService.insert_user(dto);
	    }
	    System.out.println(dto);
	    
	    session.setAttribute("order_id", dto.getOrder_id() );
	    System.out.println("order_id : " + dto.getOrder_id() );
	    return "redirect:/shop/order";
	}
	
	@RequestMapping(value = "/shop/order", method = RequestMethod.GET)
	public void order(Model model, HttpSession session) throws Exception{
		String sessionId = (String) session.getId();
		String userId = (String) session.getAttribute("userId");
		String order_id = (String) session.getAttribute("order_id");
		
		if (userId == null) {
			System.out.println("cart selectAll_session");
			System.out.println("session : " + session.getId() );
			List<CartShopDto> dto = cartshopService.selectAll_CartShop_session(sessionId);
			System.out.println(dto);
			model.addAttribute("Cart_list", dto);	
			
			// 세션 ID를 주문 서비스에 전달
	        String session_Id = session.getId();
	        System.out.println("order_id: " + order_id);
	        System.out.println("session_Id : " + session_Id );
	        OrderDto dto1 = orderService.select_session(order_id, session_Id);
	        System.out.println(dto1);
	        model.addAttribute("OrderDto",dto1);          
	        
	        String phoneNumber = dto1.getOrder_phoneNumber();
	        System.out.println(phoneNumber);
            String[] phoneNumberArr = phoneNumber.split("-");
            System.out.println(Arrays.toString(phoneNumberArr));
            session.setAttribute("Order_phoneNumberArr", phoneNumberArr);
		}else {
			System.out.println("cart selectAll_user");
			List<CartShopDto> dto = cartshopService.selectAll_CartShop_user(userId);
			System.out.println(dto);
			model.addAttribute("Cart_list", dto);	
			
			System.out.println("order select_user");
			String user_id = userId;
			OrderDto dto1 = orderService.select_user(order_id, user_id);
			System.out.println(dto1);
			model.addAttribute("OrderDto",dto1);
			
			String email = dto1.getOrder_email();
            String[] emailArr = email.split("@");
            session.setAttribute("Order_emailArr", emailArr);
            
            String phoneNumber = dto1.getOrder_phoneNumber();
            String[] phoneNumberArr = phoneNumber.split("-");
            session.setAttribute("Order_phoneNumberArr", phoneNumberArr);
		}
	}
	
	@RequestMapping(value = "/shop/order_history", method = RequestMethod.GET)
	public void order_history(Model model, HttpSession session) throws Exception{
		String userId = (String) session.getAttribute("userId");
		String order_id = (String) session.getAttribute("order_id");
		
		if (userId != null && order_id != null) {
			System.out.println("cart selectAll_user");
			List<CartShopDto> dto = cartshopService.selectAll_CartShop_user(userId);
			System.out.println(dto);
			model.addAttribute("Cart_list", dto);	
			
			System.out.println("order select_user");
			String user_id = userId;
			OrderDto dto1 = orderService.select_user(order_id, user_id);
			System.out.println(dto1);
			model.addAttribute("OrderDto",dto1);
			
			String email = dto1.getOrder_email();
            String[] emailArr = email.split("@");
            session.setAttribute("Order_emailArr", emailArr);
            
            String phoneNumber = dto1.getOrder_phoneNumber();
            String[] phoneNumberArr = phoneNumber.split("-");
            session.setAttribute("Order_phoneNumberArr", phoneNumberArr);
		}
	}
	
	@RequestMapping(value = "/shop/order_select", method = RequestMethod.GET)
	public String order_select(Model model, HttpSession session, HttpServletRequest request) throws Exception{
		String sessionId = (String) session.getId();
		String userId = (String) session.getAttribute("userId");
		String order_id = (String) session.getAttribute("order_id");
		
		if (userId == null) {
			System.out.println("cart selectAll_session");
			System.out.println("session : " + session.getId() );
			List<CartShopDto> dto = cartshopService.selectAll_CartShop_session(sessionId);
			System.out.println(dto);
			model.addAttribute("Cart_list", dto);	
			
	        System.out.println("order_id: " + order_id);
	        String Order_PhoneNumber = request.getParameter("phoneNumber1") + "-" + request.getParameter("phoneNumber2") + "-" + request.getParameter("phoneNumber3");
	        System.out.println("Order_PhoneNumber : " + Order_PhoneNumber );
	        String Order_password = request.getParameter("order_password");
	        System.out.println("order_password : " + Order_password);
	        
	        System.out.println("order select_session_pw");
	        OrderDto dto1 = orderService.select_session_pw(order_id,  Order_PhoneNumber, Order_password);
	        model.addAttribute("OrderDto",dto1);
	        System.out.println(dto1);
	             
	        String phoneNumber = dto1.getOrder_phoneNumber();
	        System.out.println(phoneNumber);
            String[] phoneNumberArr = phoneNumber.split("-");
            System.out.println(Arrays.toString(phoneNumberArr));
            session.setAttribute("Order_phoneNumberArr", phoneNumberArr);
            
		}
		return "/shop/order_history";
	}
	
}
