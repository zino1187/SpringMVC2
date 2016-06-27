package com.mvc.board.model;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

public class BoardDAOMybatis implements BoardDAO{
	private SqlSessionTemplate sqlSessionTemplate;
	
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	public List selectAll() {
		return sqlSessionTemplate.selectList("Board.selectAll");
	}

	@Override
	public Board select(int board_id) {
		return sqlSessionTemplate.selectOne("Board.selectOne", board_id);
	}

	@Override
	public void insert(Board board) {
		sqlSessionTemplate.insert("Board.insert", board);
	}

	@Override
	public void update(Board board) {
		sqlSessionTemplate.update("Board.update", board);
	}

	@Override
	public void delete(int board_id) {
		sqlSessionTemplate.delete("Board.delete", board_id);		
	}

}
