package controller.model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Events;

public class EventListTableModel extends AbstractTableModel {

	private final List<Events> mlist;
	private final String[] columnNames = { "序號", "活動名稱", "活動介紹","開始日期", "截止日期" };

	public EventListTableModel(List<Events> mlist) {
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
		
		Events event = mlist.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return event.getId();
		case 1:
			return event.getEventTitle();
		case 2:
			return event.getEventDescription(); 
		case 3:
			return event.getEventStartDate();
		case 4:
			return event.getEventEndDate();
		default:
			return null;
		}
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

		Events event2 = mlist.get(rowIndex);
		switch (columnIndex) {
		case 1:
//			event2.setMemberId(Integer.parseInt(aValue.toString()));
			event2.setId(Integer.parseInt(aValue.toString()));
			break;
		case 2:
			event2.setEventTitle((String) aValue);
			break;

		case 3:
			event2.setEventDescription((String) aValue);
			break;
			
		case 4:
			event2.setEventStartDate((String) aValue);
			break;
			
		case 5:
			event2.setEventEndDate((String) aValue);
			break;
		}
		fireTableCellUpdated(rowIndex, columnIndex);
	}

	@Override
	public String getColumnName(int column) {
		return columnNames[column];
	}

	// 新增item到Item列表中
	public void addItem(Events e) {
		mlist.add(e);

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
