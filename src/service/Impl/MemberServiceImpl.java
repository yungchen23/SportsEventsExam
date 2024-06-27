package service.Impl;

import java.util.List;

import dao.Impl.MemberDaoImpl;
import model.Member;
import service.MemberService;

public class MemberServiceImpl implements MemberService {

	public static void main(String[] args) {

		MemberServiceImpl msi =new MemberServiceImpl();
		
		Member m = new Member(null, "大A", "aaa", "111", "aa@abc.com", null, null, null, null, null, null, true, null,
				null);
//		new MemberServiceImpl().addMember(m);
		System.out.println("1=====================");
		List<Member> list = msi.getAllMember();
		for(Member x : list) {
			System.out.println(x.getMemberId()+"-"+x.getMemberName()+"-"+x.getMemberAccount());
		}
		System.out.println("2=====================");
		
		Member m1 =msi.getMemberByUser("大A");
		System.out.println(m1);
		
//		Member m2 = msi.getMemberById(4);
//		System.out.println(m2.getMemberId()+"-"+m2.getMemberName()+"-"+m2.getMemberAccount());

//		Member m2= msi.getMemberById("ddd", "111");
//		System.out.println(m2.getMemberId()+"-"+m2.getMemberName()+"-"+m2.getMemberAccount());
		
//		Member mm = new Member();
//		mm.setMemberName("鋤大D");
//		mm.setMemberEmail("999@cc.com");
//		mm.setMemberBirthday("1999-4-5");
//		mm.setMemberGender("女");
//		mm.setMemberPhone("123-4567-8888");
//		mm.setMemberLocation("枕頭山");
//
//		msi.updateMember(4, mm);
		
//		Member mm = new Member();
//		msi.updateMember(1, "66666");
		
		
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
