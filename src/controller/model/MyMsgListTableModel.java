package controller.model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.views.myMsglist;

public class MyMsgListTableModel extends AbstractTableModel {

	private final List<myMsglist> mlist;
	private final String[] columnNames = { "編號", "姓名", "留言內容", "發出時間" };

	public MyMsgListTableModel(List<myMsglist> mlist) {
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

//	private String ID; V
//	private String memberId;
//	private String memberName;V
//	private String clubId;
//	private String message;V
//	private String publishDate;V

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {

		myMsglist mMsg = mlist.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return mMsg.getID();
		case 1:
			return mMsg.getMemberName();
		case 2:
			return mMsg.getMessage();
		case 3:
			return mMsg.getPublishDate();
		default:
			return null;
		}
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		myMsglist mMsg2 = mlist.get(rowIndex);
		switch (columnIndex) {
		case 1:
//			event2.setMemberId(Integer.parseInt(aValue.toString()));
//			mMsg2.setID(Integer.parseInt(aValue.toString()));
			mMsg2.setID(Integer.parseInt(aValue.toString()));
			break;
		case 2:
			mMsg2.setMemberName((String) aValue);
			break;

		case 3:
			mMsg2.setMessage((String) aValue);
			break;

		case 4:
			mMsg2.setPublishDate((String) aValue);
			break;
		}
		fireTableCellUpdated(rowIndex, columnIndex);
	}

	@Override
	public String getColumnName(int column) {
		return columnNames[column];
	}

	// 新增item到Item列表中
	public void addItem(myMsglist mMsg) {
		mlist.add(mMsg);

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
