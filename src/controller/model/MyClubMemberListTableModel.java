package controller.model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.views.getclubofmember;

public class MyClubMemberListTableModel extends AbstractTableModel {

	private final List<getclubofmember> mlist;
	private final String[] columnNames = {"姓名", "稱謂", "等級","加入時間"};

	public MyClubMemberListTableModel(List<getclubofmember> mlist) {
		this.mlist = mlist;
	}

	@Override
	public int getRowCount() {
		return mlist.size();
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {

		getclubofmember mtl = mlist.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return mtl.getMAMBERNAME();
		case 1:
			return mtl.getTITLE();
		case 2:
			return mtl.getLEVEL();
		case 3:
			return mtl.getJOINTIME();
		default:
			return null;
		}
	}


	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		getclubofmember mtl = mlist.get(rowIndex);
		switch (columnIndex) {
		case 1:
			mtl.setMAMBERNAME((String) aValue);
			break;
		case 2:
			mtl.setTITLE((String) aValue);
			break;

		case 3:
			mtl.setLEVEL((String) aValue);

			break;

		case 4:
			mtl.setJOINTIME((String) aValue);

			break;
			
		}
		fireTableCellUpdated(rowIndex, columnIndex);
	}

	@Override
	public String getColumnName(int column) {
		return columnNames[column];
	}

	// 新增item到Item列表中
	public void addItem(getclubofmember mtl) {
		mlist.add(mtl);

		// 通知table數據已經變化
		// 不熟，待研究
		fireTableRowsInserted(mlist.size() - 1, mlist.size() - 1);
	}

	// 刪除Item列表中的item
	public void removeItem(int rowIndex) {
		if (rowIndex >= 0 && rowIndex < mlist.size()) {
			mlist.remove(rowIndex);
			// 通知表格删除行
			fireTableRowsDeleted(rowIndex, rowIndex);
		}
	}
}
