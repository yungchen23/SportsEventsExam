package service.Impl;

import java.util.List;

import dao.Impl.MemberDaoImpl;
import model.Member;
import service.MemberService;

public class MemberServiceImpl implements MemberService {

	public static void main(String[] args) {


		
		
	}

	private static MemberDaoImpl mdi = new MemberDaoImpl();

	@Override
	public void addMember(Member m) {
		mdi.addMember(m);
	}

	@Override
	public List<Member> getAllMember() {

		return mdi.getAllMember();
	}

	@Override
	public Member getMemberById(int id) {
		List<Member> list = mdi.getMemberById(id);
		Member[] member = list.toArray(new Member[list.size()]);

		return member[0];
	}

	@Override
	public Member getMemberByUser(String account) {
		List<Member> list = mdi.getMemberByUser(account);
		if(list.size()!=0) {
			Member[] member = list.toArray(new Member[list.size()]);
			return member[0];
		}else {
			return null;
		}
	}
	
	@Override
	public Member getMemberByUser2(String memberName) {
		List<Member> list = mdi.getMemberByUser2(memberName);
		if(list.size()!=0) {
			Member[] member = list.toArray(new Member[list.size()]);
			return member[0];
		}else {
			return null;
		}
	}

	
	
	@Override
	public Member getMemberByUser(String account, String password) {
		List<Member> list = mdi.getMemberByUser(account, password);
		
		if(list.size()!=0) {
			Member[] member = list.toArray(new Member[list.size()]);
			return member[0];
		}else {
			return null;
		}
	}

	@Override
	public void updateMember(int id, Member member) {
		
		Member m = new MemberServiceImpl().getMemberById(id);
		m.setMemberName(member.getMemberName());
		m.setMemberEmail(member.getMemberEmail());
		m.setMemberBirthday(member.getMemberBirthday());
		m.setMemberGender(member.getMemberGender());
		m.setMemberAge(member.getMemberAge());
		m.setMemberPhone(member.getMemberPhone());
		m.setMemberLocation(member.getMemberLocation());
		m.setMemberIntroduction(member.getMemberIntroduction());
		m.setUpdateDate(member.getUpdateDate());

		mdi.updateMember(m);
	}

	@Override
	public void updateMember(int id, String password) {
		Member member = new MemberServiceImpl().getMemberById(id);
		member.setMemberPassword(password);
		mdi.updateMemberPassword(member);
	}



}
