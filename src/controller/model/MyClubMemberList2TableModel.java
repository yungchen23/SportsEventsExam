package controller.model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.views.mangerbyclubinfoFull;

public class MyClubMemberList2TableModel extends AbstractTableModel {

	private final List<mangerbyclubinfoFull> mlist;
	private final String[] columnNames = {"姓名", "性別", "生日","年齡","E-mail","電話","地區"};

	public MyClubMemberList2TableModel(List<mangerbyclubinfoFull> mlist) {
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

		//{"姓名", "性別", "生日","年齡","E-mail","電話","地區"};
		mangerbyclubinfoFull mtl = mlist.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return mtl.getName();
		case 1:
			return mtl.getGender();
		case 2:
			return mtl.getBirthday();
		case 3:
			return mtl.getAge();
		case 4:
			return mtl.getEmail();
		case 5:
			return mtl.getPhone();
		case 6:
			return mtl.getLocation();
		default:
			return null;
		}
	}


	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		mangerbyclubinfoFull mtl = mlist.get(rowIndex);
		
		//{"姓名", "性別", "生日","年齡","E-mail","電話","地區"};
		switch (columnIndex) {
		case 1:
			mtl.setName((String)aValue);
			break;
		case 2:		
			mtl.setGender((String)aValue);
			break;

		case 3:
			mtl.setBirthday((String) aValue);

			break;

		case 4:
			mtl.setAge((String) aValue);

			break;
			
		case 5:
			mtl.setEmail((String) aValue);
			break;
			
		case 6:
			mtl.setPhone((String) aValue);
			break;
			
		case 7:
			mtl.setLocation((String) aValue);
			break;
			
		}
		fireTableCellUpdated(rowIndex, columnIndex);
	}

	@Override
	public String getColumnName(int column) {
		return columnNames[column];
	}

	// 新增item到Item列表中
	public void addItem(mangerbyclubinfoFull mtl) {
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
