package service.Impl;

import java.util.List;

import dao.Impl.MessageBoardDaoImpl;
import model.MessageBoard;
import service.MessageBoardService;

public class MessageBoardServiceImpl implements MessageBoardService {

	public static void main(String[] args) {

		MessageBoardServiceImpl mbsi = new MessageBoardServiceImpl();
		
//		MessageBoard msg = new MessageBoard(null, "m000005", "c00001", "無聊無聊無聊無聊無聊無聊無聊無聊無聊無聊無聊!!!!",null, null);
//		mbsi.addMsg(msg);

//		mbsi.deletedMsg(9);

//		List<MessageBoard>l = mbsi.getAllMsg();
//		List<MessageBoard> bb = mbsi.getMsgByClub("c00001");
//		System.out.println(bb.getId()+"-"+bb.getMemberId()+"-"+bb.getMessage()+"-"+bb.getPublishDate());

//		bb.forEach((x) -> System.out.println(x.getId() + "-" + x.getClubId() + "-" + x.getMemberId() + "-"
//				+ x.getMessage() + "-" + x.getPublishDate()));
		
		MessageBoard msg= new MessageBoard();
		msg.setMessage("無聊無聊無聊無聊無聊無聊無聊無聊無聊無聊無聊!!!!");
		
		mbsi.updateMsg(13, msg);
		
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
