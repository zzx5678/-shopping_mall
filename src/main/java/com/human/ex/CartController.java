package com.human.ex;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import java.util.UUID;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.human.dto.CartDto;
import com.human.service.ICartService;
import com.human.service.ICartShopService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class CartController {
	
	private static final Logger logger = LoggerFactory.getLogger(CartController.class);
	
	@Inject
	private ICartService cartService;
	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */

	@RequestMapping(value = "/shop/cart_insertDB", method = RequestMethod.POST)
	public String cart_insertDB(CartDto dto, HttpSession session) throws Exception{
		// 로그인 여부를 세션을 통해 확인합니다.
	    String userId = (String) session.getAttribute("userId");

	    // cart_id를 UUID로 생성하여 설정합니다.
        dto.setCart_id(UUID.randomUUID().toString());
        dto.setQuantity(1); // 기본 수량을 1로 설정
        
	    if (userId == null) {
	        // 비로그인 상태
	    	dto.setSession_id(session.getId()); // 세션 ID 설정
	    	
	    	// 세션 장바구니 항목이 존재하는지 확인합니다.
	        int count = cartService.checkSessionCart(dto);
	        if (count > 0) {
	        	System.out.println("count : " + count);
	        	System.out.println("cart update_session");
	        	cartService.update_session(dto);
	        }else {
	        	System.out.println("cart insert_session");
	        	cartService.insert_session(dto);
	        }
	    } else {
	        // 로그인 상태
	    	dto.setUser_id(userId);  // dto에 userId를 설정합니다.
	    	
	    	// 사용자 장바구니 항목이 존재하는지 확인합니다.
	        int count = cartService.checkUserCart(dto);
	        if (count > 0) {
	        	System.out.println("count : " + count);
	    		System.out.println("cart update_user");
	    		cartService.update_user(dto);
	    		
		    }else {
		    	System.out.println("cart insert_user");
	        	cartService.insert_user(dto);
		    }
	    }
	    System.out.println(dto);
		return "redirect:/shop/products";
	}
	
	
	@RequestMapping(value = "/shop/cart_all_delete", method = RequestMethod.GET)
	public String cartshop_all_delete(HttpSession session ) throws Exception{
		String userId = (String) session.getAttribute("userId");
		String session_Id = session.getId();
		 
		if (userId == null) {
			System.out.println("cart session_delete");
			System.out.println("session : " + session.getId() );
			
			cartService.all_delete_session_id(session_Id);
		}else {
			System.out.println("cart user_delete");
			
			cartService.all_delete_user_id(userId);
		}
		return "redirect:/shop/cartshop";	
	}
	
}
