package org.zerock.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.domain.MessageVO;
import org.zerock.persistence.MessageDAO;
import org.zerock.persistence.PointDAO;

@Service
public class MessageServiceImpl implements MessageService {

	@Inject
	private MessageDAO mDAO;
	
	@Inject
	private PointDAO pDAO;
	
	@Transactional
	@Override
	public void addMessage(MessageVO vo) throws Exception {
		mDAO.create(vo);
		pDAO.updatePoint(vo.getSender(), 10);
	}

	@Override
	public MessageVO readMessage(String uid, Integer mno) throws Exception {
		mDAO.updateState(mno);
		pDAO.updatePoint(uid, 5);
		return mDAO.readMessage(mno);
	}

}
