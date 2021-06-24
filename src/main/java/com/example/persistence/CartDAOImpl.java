package com.example.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.domain.CartVO;
import com.example.domain.CommonQAVO;
import com.example.domain.Criteria;

@Repository
public class CartDAOImpl implements CartDAO{
	String namespace="com.example.mapper.CartMapper";
	
	@Autowired
	SqlSession session;

	//��ٱ��� ���
	@Override
	public void cart_insert(CartVO vo) throws Exception {
		session.insert(namespace+".cart_insert", vo);
	}

	//��ٱ��� ���
	@Override
	public List<CartVO> cart_list(String user_id) throws Exception {
		return session.selectList(namespace+".cart_list", user_id);
	}
	
}
