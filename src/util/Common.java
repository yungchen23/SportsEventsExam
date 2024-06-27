package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Common {

	public static void main(String[] args) {

//		System.out.println(formatNumber("m",9));
//		System.out.println(formatNumber("m",12));
//		System.out.println(formatNumber("m",5));
//		System.out.println(formatNumber("m",9110));

		System.out.println(currentAge(null));

	}

	public static void setWindows(JFrame jfame) {
		// 視窗相關配置
		jfame.setResizable(false); // 不可改變大小
		jfame.setLocationRelativeTo(null); // 視窗置中
//		jfame.setUndecorated(true); // 設置視窗無邊框
		jfame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // 設置關閉操作 不會執行

	}

	public static String creaditDate() {

		Date date = new Date();
		SimpleDateFormat currDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String creaditDate = currDate.format(date);

		return creaditDate;
	}

	public static String updateDate() {

		Date date = new Date();
		SimpleDateFormat currDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String updateDate = currDate.format(date);

		return updateDate;
	}

	//加入社團時間
	public static String joinDate() {

		Date date = new Date();
		SimpleDateFormat currDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String joinDate = currDate.format(date);

		return joinDate;
	}
	
	//日期比較(不可以大於當前日期)
	public static boolean dateComparison(String date) {

	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");   // 日期格式化物件
	        
	        LocalDate localdate = LocalDate.parse(date, formatter);  // 將字串解析為LocalDate物件
            LocalDate today = LocalDate.now(); 	   // 獲取當前的日期

            // 比较日期
            if (localdate.isAfter(today)) {
                System.out.println("日期不能大於今天的日期");
                return false;              
                
            } else {
                System.out.println("日期有效");
                return true;
            }		
	}
	
	
	// 計算歲數
	public static String currentAge(String birthday) {
		Integer age = null;
		// 定義日期格式
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");

		if (birthday != null) {

			try {
				Date birthdate = sdf.parse(birthday); // 將String birthday解析為 Date

				Calendar today = Calendar.getInstance(); // 取得今天日期
				Calendar memberbirthday = Calendar.getInstance(); // 設置一個紀錄生日的宣告
				memberbirthday.setTime(birthdate); // 設置生日，將生日的日期寫入

				// 計算年齡
				age = today.get(Calendar.YEAR) - memberbirthday.get(Calendar.YEAR);

			} catch (ParseException e) {

				e.printStackTrace();
			}
		}
		return age+"";
	}

	//項目編號產生器
	public static String formatNumber(String type, int id) {
		String Number = null;

		// 使用String.format來格式化數字
		// 確保數字有5位數，不足位數填上0
		Number = String.format(type + "%05d", (id + 1));

		return Number;
	}
	
	

}
