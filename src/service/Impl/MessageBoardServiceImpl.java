package service.Impl;

import java.util.List;

import dao.Impl.MessageBoardDaoImpl;
import model.MessageBoard;
import service.MessageBoardService;

public class MessageBoardServiceImpl implements MessageBoardService {

	public static void main(String[] args) {

		MessageBoardServiceImpl mbsi = new MessageBoardServiceImpl();

		
	}

	private static MessageBoardDaoImpl mbdi = new MessageBoardDaoImpl();

	@Override
	public void addMsg(MessageBoard msg) {
		mbdi.addMsg(msg);
	}

	@Override
	public List<MessageBoard> getAllMsg() {
		return mbdi.getAllMsg();
	}

	@Override
	public MessageBoard getMsgById(int id) {
		List<MessageBoard> list = mbdi.getMsgById(id);
		MessageBoard[] msg = list.toArray(new MessageBoard[list.size()]);

		return msg[0];
	}

	@Override
	public List<MessageBoard> getMsgByClub(String clubId) {
		return mbdi.getMsgByClub(clubId);
	}

	@Override
	public void updateMsg(int id, MessageBoard msg) {
		MessageBoard m = new MessageBoardServiceImpl().getMsgById(id);
		m.setMessage(msg.getMessage());
		m.setUpdateDate(msg.getUpdateDate());
		mbdi.updateMsg(m);		
	}

	@Override
	public void deletedMsg(int id) {
		mbdi.deletedMsg(id);

	}

}
