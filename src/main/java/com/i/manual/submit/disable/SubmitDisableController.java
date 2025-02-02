package com.i.manual.submit.disable;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class SubmitDisableController {
	
	@GetMapping("/Submit/Disable/Form")
	public String Form() {
								
		return "submit/disable/form";
	}
	
	@PostMapping("/Submit/Disable/Submit")
	public String Submit(HttpServletRequest request) {
		
	    System.out.println( "textNormal Value : " +  request.getParameter("textNormal") );
	    System.out.println( "textReadonly Value : " +  request.getParameter("textReadonly") );
	    System.out.println( "textDisabled Value : " +  request.getParameter("textDisabled") );
	    System.out.println( "textRequired Value : " +  request.getParameter("textRequired") );
	    System.out.println( "textHidden Value : " +  request.getParameter("textHidden") );
	    
	    System.out.println( "checkboxNormal1 Value : " +  request.getParameter("checkboxNormal1") );
	    System.out.println( "checkboxNormal2 Value : " +  request.getParameter("checkboxNormal2") );
	    System.out.println( "checkboxNormal3 Value : " +  request.getParameter("checkboxNormal3") );
	    System.out.println( "checkboxReadonlyTrue Value : " +  request.getParameter("checkboxReadonlyTrue") );
	    System.out.println( "checkboxReadonlyFalse Value : " +  request.getParameter("checkboxReadonlyFalse") );
	    System.out.println( "checkboxDisabledTrue Value : " +  request.getParameter("checkboxDisabledTrue") );
	    System.out.println( "checkboxDisabledFalse Value : " +  request.getParameter("checkboxDisabledFalse") );

	    System.out.println( "selectNormal Value : " +  request.getParameter("selectNormal") );
	    System.out.println( "selectReadonly Value : " +  request.getParameter("selectReadonly") );
	    System.out.println( "selectDisabled Value : " +  request.getParameter("selectDisabled") );
	    
	    System.out.println( "radioNormal Value : " +  request.getParameter("radioNormal") );
	    System.out.println( "radioReadonly Value : " +  request.getParameter("radioReadonly") );
	    System.out.println( "radioDisabled Value : " +  request.getParameter("radioDisabled") );
	    
	    System.out.println( "textareaNormal Value : " +  request.getParameter("textareaNormal") );
	    System.out.println( "textareaReadonly Value : " +  request.getParameter("textareaReadonly") );
	    System.out.println( "textareaDisabled Value : " +  request.getParameter("textareaDisabled") );
	    
		return "redirect:/Submit/Disable/Form";
	}

}
