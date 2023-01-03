package com.example.boilerplateproj.domain.board.controller;

import com.example.boilerplateproj.domain.board.controller.request.BoardRequest;
import com.example.boilerplateproj.domain.board.entity.Board;
import com.example.boilerplateproj.domain.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardService service;

	@GetMapping("/register")
	public void registerForm(Board board, Model model) throws Exception {
		log.info("registerForm");
	}

	@PostMapping("/register")
	public String register(Board board, Model model) throws Exception {
		log.info("register");
		
		service.register(board);

		model.addAttribute("msg", "등록이 완료되었습니다.");

		return "board/success";
	}

	@GetMapping("/list")
	public void list(Model model) throws Exception {
		log.info("list");

		model.addAttribute("list", service.list());
	}

	@GetMapping("/read")
	public void read(int boardNo, Model model) throws Exception {
		log.info("read");

		model.addAttribute(service.read(boardNo));
	}

	@PostMapping("/remove")
	public String remove(int boardNo, Model model) throws Exception {
		log.info("remove");

		service.remove(boardNo);

		model.addAttribute("msg", "삭제가 완료되었습니다.");

		return "board/success";
	}

	@GetMapping("/modify")
	public void modifyForm(int boardNo, Model model) throws Exception {
		log.info("modifyForm");

		model.addAttribute(service.read(boardNo));
	}

	@PostMapping("/modify")
	public String modify(BoardRequest boardRequest, Model model) throws Exception {
		log.info("modify");

		service.modify(boardRequest, (int) 1);

		model.addAttribute("msg", "수정이 완료되었습니다.");

		return "board/success";
	}

}