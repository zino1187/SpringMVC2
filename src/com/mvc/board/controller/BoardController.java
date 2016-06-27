package com.mvc.board.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mvc.board.model.Board;
import com.mvc.board.model.BoardDAO;

@Controller
@RequestMapping("/board")
public class BoardController {
	private BoardDAO boardDAO;
	public void setBoardDAO(BoardDAO boardDAO) {
		this.boardDAO = boardDAO;
	}
	
	@RequestMapping("/list.do")
	public ModelAndView selectAll(){
		ModelAndView mav = new ModelAndView("board/list");
		List list=boardDAO.selectAll();
		mav.addObject("list", list);		
		return mav;
	}
	
	//�Ѱ� �������� 
	@RequestMapping("/detail.do")
	public ModelAndView select(int board_id){
		ModelAndView mav = new ModelAndView("board/detail");
		Board board=boardDAO.select(board_id);
		mav.addObject("board", board);
		return mav;
	}
	
	//�Ѱ� �ֱ� 
	@RequestMapping("/insert.do")
	public String insert(Board board){
		boardDAO.insert(board);
		return "redirect:/board/list.do";
	}
	
	//�Ѱ� �����ϱ� 
	@RequestMapping("/edit.do")
	public ModelAndView update(Board board){
		boardDAO.update(board);
		ModelAndView mav = new ModelAndView();
		mav.addObject("board", board);
		return mav;
	}
	
	//�Ѱ� �����ϱ� 
	@RequestMapping("/delete.do")
	public String delete(int board_id){
		boardDAO.delete(board_id);
		return "redirect:/board/list.do";
	}
}









