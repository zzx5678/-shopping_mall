package com.human.ex;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.human.dto.UserDto;
import com.human.service.IUserService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Inject
	private IUserService UserService;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 * @param session 
	 * @return 
	 */
	@RequestMapping(value = "/user/login", method = RequestMethod.GET)
	public void login() throws Exception{
		
	}
	@RequestMapping(value = "/user/login_Check", method = RequestMethod.GET)
	public String login_Check(Model model, UserDto dto, HttpServletRequest request, HttpSession session) throws Exception{
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		String login_Move;
		if (id != null && pw != null) {
			boolean loginCheck = UserService.login(id, pw);
			System.out.println("로그인 성공 여부 : " + loginCheck);

            // ID가 "user"인 경우 관리자로 처리 예시
            if(id.equals("user")&& pw.equals("user")) {
            	System.out.println("관리자 로그인에 성공했습니다. 아이디 : " + id + ", 비밀번호 : " + pw); 
            	login_Move = "/user/index";
            } else if (loginCheck) {
                System.out.println("사용자 로그인에 성공했습니다. 아이디 : " + id + ", 비밀번호 : " + pw);
                
                session.setAttribute("userId", id);
                session.setAttribute("userpw", pw);
                session.setAttribute("action", "login");
                System.out.println("세션에 저장된 ID: " + session.getAttribute("userId"));
                System.out.println("세션에 저장된 Password: " + session.getAttribute("userpw"));
                
                session.setAttribute("action", "login");
                login_Move = "/user/complete";
            } else {
                System.out.println("로그인에 실패했습니다. 아이디 또는 비밀번호가 일치하지 않습니다. \n 입력한 아이디 : " + id + ", 비밀번호 : " + pw);
                login_Move = "/user/login";
            }
        } else {
            System.out.println("로그인에 실패했습니다. ID 또는 비밀번호를 입력해주세요. \n 입력한 아이디 : " + id + ", 비밀번호 : " + pw);
            login_Move = "/user/login";
        }
		
		//HttpSession session=request.getSession();
		String idSave = request.getParameter("id_save");
		if(idSave != null && idSave.equals("id_save")) {
			System.out.println("아이디 저장이 선택되었습니다.");
			session.setAttribute("ids", id);
			session.setAttribute("id_save_Checked", "checked");
		}
		 
		String autoLogin = request.getParameter("auto_login");
		if(autoLogin != null && autoLogin.equals("auto_login")) {
			System.out.println("자동 로그인이 선택되었습니다.");
			session.setAttribute("ids", id);
			session.setAttribute("pws", pw);
			session.setAttribute("auto_login_Checked", "checked");
		} 
		
		if ( (idSave == null || !idSave.equals("id_save") ) && (autoLogin == null || !autoLogin.equals("auto_login") ) ) {
			System.out.println("아이디 저장이 선택되지 않았습니다.");
			System.out.println("자동 로그인이 선택되지 않았습니다.");
            // 아이디 저장과 자동 로그인 모두 체크되지 않았을 때 세션 초기화
            session.removeAttribute("ids");
            session.removeAttribute("pws");
            session.removeAttribute("id_save_Checked");
            session.removeAttribute("auto_login_Checked");
        } else if ( (idSave != null && idSave.equals("id_save")) && (autoLogin == null || !autoLogin.equals("auto_login"))) {
        	System.out.println("아이디 저장이 선택되었습니다.");
        	System.out.println("자동 로그인이 선택되지 않았습니다.");
        	// 아이디 저장이 체크되고, 자동 로그인 체크되지 않았을 때 세션 초기화
        	session.removeAttribute("pws");
        	session.removeAttribute("auto_login_Checked");
        } else if ( (idSave == null || !idSave.equals("id_save")) && (autoLogin != null && autoLogin.equals("auto_login"))) {
        	System.out.println("아이디 저장이 선택되지 않았습니다.");
        	System.out.println("자동 로그인이 선택되었습니다.");
        	session.removeAttribute("id_save_Checked");
        	// 아이디 저장이 체크되지 않고, 자동 로그인 체크되었을 때 세션 초기화
        }
		
		return login_Move;
	}
	@RequestMapping(value = "/user/index", method = RequestMethod.GET)
	public void index() throws Exception{
		
	}
	@RequestMapping(value = "/user/join", method = RequestMethod.GET)
	public void join() throws Exception{
		
	}
	@RequestMapping(value = "/user/joinDB", method = RequestMethod.POST)
	public String joinDB(UserDto dto, HttpServletRequest request, HttpSession session) throws Exception{
		System.out.println("User insertDB");
		
		// 요청 파라미터를 가져와서 LocalDate로 변환
		int year = Integer.parseInt(request.getParameter("year"));
		int month = Integer.parseInt(request.getParameter("month"));
		int day = Integer.parseInt(request.getParameter("day"));

		// LocalDate를 java.util.Date로 변환
		LocalDate localDate = LocalDate.of(year, month, day);
		Date birthday = java.sql.Date.valueOf(localDate);
		
		dto.setBirthday(birthday);
		
		String Email = request.getParameter("email") + "@" + request.getParameter("select");
    	System.out.println("Email : " + Email);
    	dto.setEmail(Email);
    	
		String PhoneNumber = request.getParameter("phoneNumber1") + "-" + request.getParameter("phoneNumber2") + "-" + request.getParameter("phoneNumber3");
        System.out.println("PhoneNumber : " + PhoneNumber );
        dto.setPhoneNumber(PhoneNumber);
    	
		UserService.insert(dto);
		System.out.println(dto);
		
		session.setAttribute("action", "join");
		return "/user/complete";
	}
	@RequestMapping(value = "/user/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) throws Exception{
		session.removeAttribute("ids");
        session.removeAttribute("pws");
		session.removeAttribute("userId");
	    session.removeAttribute("userpw");
	    session.removeAttribute("id_save_Checked");
        session.removeAttribute("auto_login_Checked");
        
		return "/user/login";
	}
	@RequestMapping(value = "/user/update_pw", method = RequestMethod.GET)
	public void update_pw() throws Exception{
		
	}
	@RequestMapping(value = "/user/update_Check", method = RequestMethod.GET)
	public String update_Check(Model model, HttpServletRequest request, HttpSession session) throws Exception{
		String userpw = (String) session.getAttribute("userpw");
		String pw_Check = request.getParameter("pw_Check");
		
		if (userpw != null && userpw.equals(pw_Check)) {
			System.out.println("비밀번호가 일치합니다. 회원정보 수정 페이지로 이동합니다. \n 입력한 비밀번호: " + pw_Check + ", 유저의 비밀번호 : " + userpw);
            
			return "redirect:/user/update";
	    } else {
	    	System.out.println("회원정보 확인에 실패했습니다. 비밀번호가 일치하지 않습니다. \n 입력한 비밀번호 : " + pw_Check + ", 유저의 비밀번호 : " + userpw);
	    	return "/user/update_pw";
	    }
	}
	@RequestMapping(value = "/user/update", method = RequestMethod.GET)
	public void update(Model model, HttpSession session) throws Exception{
		String userId = (String) session.getAttribute("userId");
		
		UserDto dto = UserService.select(userId);
		model.addAttribute("UserDto",dto);
		System.out.println(dto);
			
		Date birthday = dto.getBirthday();
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    String birthdayStr = sdf.format(birthday);
	    String[] birthdayArr = birthdayStr.split("-");
	    session.setAttribute("birthdayArr", birthdayArr);
	        
	    String email = dto.getEmail();
        String[] emailArr = email.split("@");
        session.setAttribute("emailArr", emailArr);
            
        String phoneNumber = dto.getPhoneNumber();
        String[] phoneNumberArr = phoneNumber.split("-");
        session.setAttribute("phoneNumberArr", phoneNumberArr);
	}
	@RequestMapping(value = "/user/updateDB", method = RequestMethod.POST)
	public String updateDB(UserDto dto, HttpServletRequest request, HttpSession session) throws Exception{
		
		// 요청 파라미터를 가져와서 LocalDate로 변환
		int year = Integer.parseInt(request.getParameter("year"));
		int month = Integer.parseInt(request.getParameter("month"));
		int day = Integer.parseInt(request.getParameter("day"));

		// LocalDate를 java.util.Date로 변환
		LocalDate localDate = LocalDate.of(year, month, day);
		Date birthday = java.sql.Date.valueOf(localDate);
			
		dto.setBirthday(birthday);
		System.out.println("Birthday : " + birthday);
			
		String Email = request.getParameter("email") + "@" + request.getParameter("select");
	    System.out.println("Email : " + Email);
	    dto.setEmail(Email);
	    	
		String PhoneNumber = request.getParameter("phoneNumber1") + "-" + request.getParameter("phoneNumber2") + "-" + request.getParameter("phoneNumber3");
	    System.out.println("PhoneNumber : " + PhoneNumber );
	    dto.setPhoneNumber(PhoneNumber);
	        
	    UserService.update(dto);
		System.out.println(dto);
			
		session.setAttribute("action", "update");
	    return "/user/complete";
	}
	@RequestMapping(value = "/user/deleteDB", method = RequestMethod.GET)
	public String deleteDB(HttpServletRequest request, HttpSession session) throws Exception{
		String id = (String) session.getAttribute("userId");
		UserService.delete(id);
		session.setAttribute("action", "delete");
		return "/user/complete";
	}
	
	@RequestMapping(value = "/user/complete", method = RequestMethod.GET)
	public void complete() throws Exception{
		
	}
	
}



