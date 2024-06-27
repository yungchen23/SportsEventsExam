package service.Impl;

import java.util.List;

import dao.Impl.NoticeMemberDaoImpl;
import model.NoticeMember;
import service.NoticeMemberSerivce;

public class NoticeMemberSerivceImpl implements NoticeMemberSerivce{

	public static void main(String[] args) {
		

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
