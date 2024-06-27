package controller.model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.views.myNoticelist;

public class MyNoticeListTableModel extends AbstractTableModel {

	private final List<myNoticelist> mlist;
	private final String[] columnNames = { "編號", "作者", "主旨","發出時間" ,"通知內容"};

	public MyNoticeListTableModel(List<myNoticelist> mlist) {
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

//	private int id;
//	private String author;
//	private String topic;
//	private String message;
//	private String publishDate;
	
	
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {

		myNoticelist mtl = mlist.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return mtl.getId();
		case 1:
			return mtl.getAuthor();
		case 2:
			return mtl.getTopic();
		case 3:
			return mtl.getPublishDate();
		case 4:
			return mtl.getMessage();	
		default:
			return null;
		}
	}


	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		myNoticelist mtl2 = mlist.get(rowIndex);
		switch (columnIndex) {
		case 1:
//			event2.setMemberId(Integer.parseInt(aValue.toString()));
			mtl2.setId(Integer.parseInt(aValue.toString()));
			break;
		case 2:
			mtl2.setAuthor((String) aValue);
			break;

		case 3:
			mtl2.setTopic((String) aValue);
			break;
			

		case 4:
			mtl2.setPublishDate((String) aValue);
			break;
			
		case 5:
			mtl2.setMessage((String) aValue);
			break;	
			
		}
		fireTableCellUpdated(rowIndex, columnIndex);
	}

	@Override
	public String getColumnName(int column) {
		return columnNames[column];
	}

	// 新增item到Item列表中
	public void addItem(myNoticelist mtl) {
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
