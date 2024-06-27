package dao;

import java.util.List;

import model.Clubs;

public interface ClubsDao {

	// C
	void addClubs(Clubs c);

	// R
	List<Clubs> getAllClubs();
	List<Clubs> getClubsById(int id);
	List<Clubs> getClubsByClubId(String ClubId);
//	List<Clubs> getClubByName();
	Integer getLatestId(); //返回已存在最後一筆id
	
	//U
	void updateClubs(Clubs c);	//編輯社團
	void updateClubsName(Clubs c); //修改社團名字
		
	//D
	void deletedClubs(int id);  //解散社團
	
}
