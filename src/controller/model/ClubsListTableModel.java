package controller.model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.views.mangerbyclubinfo;

public class ClubsListTableModel extends AbstractTableModel {

	private final List<mangerbyclubinfo> clist;
	private final String[] columnNames = { "社團ID", "社團名稱", "團長", "介紹", "目前人數" };

	public ClubsListTableModel(List<mangerbyclubinfo> clist) {
		this.clist = clist;
	}

	@Override
	public int getRowCount() {
		return clist.size();
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {

		mangerbyclubinfo clublist = clist.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return clublist.getClubId();
		case 1:
			return clublist.getClubName();
		case 2:
			return clublist.getClubLeader();
		case 3:
			return clublist.getClubIntroduction();
		case 4:
			return clublist.getNumberofMembers(); //暫時取用
		default:
			return null;
		}
	}

	// String queryLeaderById(int clubId); //獲取社團長名稱

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		mangerbyclubinfo cls = clist.get(rowIndex);
		switch (columnIndex) {
		case 1:
//			cls.setClubId(Integer.parseInt(aValue.toString()));
			cls.setClubId((String) aValue);
			break;
		case 2:
			cls.setClubName((String) aValue);
			break;

		case 3:
			cls.setClubLeader((String) aValue);
			break;

		case 4:
			cls.setClubIntroduction((String) aValue);
			break;
		case 5:
			cls.setNumberofMembers((Integer) aValue);
			break;

		}
		fireTableCellUpdated(rowIndex, columnIndex);
	}

	@Override
	public String getColumnName(int column) {
		return columnNames[column];
	}

	// 新增item到Item列表中
	public void addItem(mangerbyclubinfo c) {
		clist.add(c);

		// 通知table數據已經變化
		// 不熟，待研究
		fireTableRowsInserted(clist.size() - 1, clist.size() - 1);
	}

	// 刪除Item列表中的item
	public void removeItem(int rowIndex) {
		if (rowIndex >= 0 && rowIndex < clist.size()) {
			clist.remove(rowIndex);
			// 通知表格删除行
			fireTableRowsDeleted(rowIndex, rowIndex);
		}
	}
}
