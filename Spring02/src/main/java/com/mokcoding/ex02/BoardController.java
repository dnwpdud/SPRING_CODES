package com.mokcoding.ex02;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mokcoding.ex02.domain.BoardVO;
import com.mokcoding.ex02.service.BoardService;

import lombok.extern.log4j.Log4j;

@Controller // @Component
// - 클라이언트(JSP 페이지 등)와 service를 연결하는 역할
@RequestMapping(value = "/board") // url : /ex02/board
@Log4j
public class BoardController {
	
	@Autowired
	private BoardService boatdService;
	
	// 전체 게시글 데이터를 list.jsp 페이지로 전송
	@GetMapping("/list")
	public void list(Model model) {
		log.info("list()");
		
		List<BoardVO> boardList = boatdService.getAllBoardVOs();
		model.addAttribute("boardList", boardList);
	}
	
	// register.jsp 페이지 호출
	@GetMapping("/register")
	public void registerGET() {
		log.info("registerGET()");
	}
	
	// register.jsp에서 전송받은 게시글 데이터를 저장
	@PostMapping("/register")
	public String registerPOST(BoardVO boardVO, RedirectAttributes reAttr) {
		log.info("registerPOST()");
		log.info("boardVO = " + boardVO.toString());
		int result = boatdService.createBoard(boardVO);
		log.info(result + "행 등록");
		return "redirect:/board/list";
	}
	
}
