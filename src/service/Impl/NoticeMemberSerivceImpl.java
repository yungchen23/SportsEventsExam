package service.Impl;

import java.util.List;

import dao.Impl.NoticeMemberDaoImpl;
import model.NoticeMember;
import service.NoticeMemberSerivce;

public class NoticeMemberSerivceImpl implements NoticeMemberSerivce{

	public static void main(String[] args) {
		
		NoticeMember nm = new NoticeMember(null, "m00012", "c00003","社團通知556", "22這是社團通知測試~~~~~", null);
		new NoticeMemberSerivceImpl().addMsg(nm);
		
//		List<NoticeMember> l = new NoticeMemberSerivceImpl().getAllNotice();
//		l.forEach((x)->System.out.println(x.getId()+"-"+x.getMemberId()+"-"+x.getClubId()+"-"+x.getTopic()+"-"+x.getMessage()));
//		List<NoticeMember> ll = new NoticeMemberSerivceImpl().getNoticeByMember("m00001");
//		ll.forEach((x)->System.out.println(x.getId()+"-"+x.getMemberId()+"-"+x.getClubId()+"-"+x.getTopic()+"-"+x.getMessage()));
//		System.out.println("----------------------");
//		NoticeMember n = new NoticeMemberSerivceImpl().getNoticeById(2);
//		System.out.println(n.getId()+"-"+n.getMemberId()+"-"+n.getClubId()+"-"+n.getTopic()+"-"+n.getMessage());
		
	}

	private static NoticeMemberDaoImpl nmdi = new NoticeMemberDaoImpl();
	
	@Override
	public void addMsg(NoticeMember notice) {
		nmdi.addMsg(notice);
	}

	@Override
	public List<NoticeMember> getAllNotice() {
		return nmdi.getAllNotice();
	}

	@Override
	public NoticeMember getNoticeById(int id) {
		List<NoticeMember> list=  nmdi.getNoticeById(id);
		NoticeMember[] nm = list.toArray(new NoticeMember[list.size()]);

		return nm[0];
	}

	@Override
	public List<NoticeMember> getNoticeByMember(String memberId) {
		return nmdi.getNoticeByMember(memberId);
	}

	@Override
	public List<NoticeMember> getNoticeByClub(String clubId) {	
		return nmdi.getNoticeByClub(clubId);
	}

	@Override
	public void deletedNotice(int id) {
		nmdi.deletedNotice(id);
	}

}
