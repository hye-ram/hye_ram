package com.project.shoppingweb.controller;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.shoppingweb.service.*;
import com.project.shoppingweb.bean.*;


@Controller
// 현재 클래스를 스프링에서 관리하는 Controller Bean으로 설정함
/*
 * @RequestMapping("/product/*") //공통적인 url 맵핑
 */public class ProductController {

	@Inject // 의존관계 주입 (DI)
	ProductService productService; // 스프링에서 만든 서비스 객체를 연결시킴
	
	@Inject
	CartService cartService;

	@RequestMapping("product_list") // 세부적인 url mapping
	public ModelAndView list(ModelAndView mav) {
		mav.setViewName("product_list"); // 이동할 페이지 이름 (product_list.jsp 파일로 이동)
		mav.addObject("list", productService.listProduct()); // 데이터 저장
		// 서비스에서 상품 리스트를 받아와 list라는 이름의 변수에 저장
		// service -> model -> mybatis -> 리스트를 받아옴
		return mav; // 페이지 이동
	}

	
	//cart_list페이지와 맵핑되는 메소드

    @RequestMapping("cart")
    public ModelAndView list(HttpSession session, ModelAndView mav) {
    	HashMap<String, Object> map= new HashMap<String, Object>();

        //hashmap은 map(key,value)로 이뤄져 있고,
        //key값은 중복이 불가능 하고 value는 중복이 가능하다.
        //value에 null값도 사용이 가능하다.
        //전달할 정보가 많을 경우에는 HashMap<>을 사용하는 것이 좋다.
        //장바구니에 담을 값들이 많기 때문에 여기선 HashMap<>를 사용한다.
        String userid=(String)session.getAttribute("userId");
        //session에 저장된 userid를 getAttribute()메소드를 사용해서 얻어오고 오브젝트 타입이기 때문에
        //String 타입으로 타입변환한다.
        if(userid!=null) { 
            //로그인한 상태이면 실행
            List<CartDTO> list=cartService.listCart(userid);//장바구니 목록
            int sumMoney=cartService.sumMoney(userid);//금액 합계
            int fee=sumMoney >= 30000 ? 0 : 2500; 
            
            //배송료 계산
            //30000원이 넘으면 배송료가 0원, 안넘으면 2500원
            
           //hasp map에 장바구니에 넣을 각종 값들을 저장함
            map.put("sumMoney", sumMoney);
            map.put("fee", fee); //배송료
            map.put("sum", sumMoney+fee); //전체 금액
            map.put("list", list); //장바구니 목록
            map.put("count", list.size()); //레코드 갯수

           //ModelAndView mav에 이동할 페이지의 이름과 데이터를 저장한다.

            mav.setViewName("cart"); //이동할 페이지의 이름
            mav.addObject("map", map); //데이터 저장

            return mav; //화면 이동

        }else { //로그인하지 않은 상태
            return new ModelAndView("login", "", null);
            //로그인을 하지 않았으면 로그인 페이지로 이동시킨다.
        }
    }
    
    // 장바구니에 담기
	@RequestMapping("cart_insert") // 세부적인 url mapping
	public String insert(@ModelAttribute CartDTO dto, HttpSession session) {
		// @ModelAttribute는 sumit된 form의 내용을 저장해서 전달받거나, 다시 뷰로 넘겨서 출력하기 위해 사용되는 오브젝트 이다.
		// 도메인 오브젝트나 DTO의 프로퍼티에 요청 파라미터를 바인딩해서 한번에 받으면 @ModelAttribute 라고 볼 수 있다.
		// @ModelAttribute는 컨트롤러가 리턴하는 모델에 파라미터로 전달한 오브젝트를 자동으로 추가해준다.
		// 로그인 여부를 체크하기 위해 세션에 저장된 아이디 확인

		String userid = (String) session.getAttribute("userId");
		if (userid == null) {
			// 로그인하지 않은 상태이면 로그인 화면으로 이동
			return "redirect:login";
		}
		// 여기부터 안되노.. dto 왜 안되노..
		dto.setUserid(userid);
		System.out.println(dto);
		cartService.insert(dto); // 장바구니 테이블에 저장됨
		return "redirect:cart"; // 장바구니 목록으로 이동
	}
    
    @RequestMapping("cart_delete")
    public String delete(@RequestParam int cart_id) {
        cartService.delete(cart_id);
        return "redirect:/cart";
    }
    
    @RequestMapping("cart_deleteAll")
    public String deleteAll(HttpSession session) {
        String userid=(String)session.getAttribute("userId");
        if(userid!=null) {
            cartService.deleteAll(userid);
        }
        return "redirect:/cart";
    }



}
