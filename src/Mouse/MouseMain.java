package Mouse;
import java.io.*;
import java.util.Scanner;
public class MouseMain {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("C:\\Rat5.txt");// 讀檔
		Scanner input = new Scanner(file);// 設定從檔案輸入
		int map[][] = new int[12][12];
		while (input.hasNext()) {// 讀檔 把資料放入陣列
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
					map[i][j] = input.nextInt();
				}
			}
		}
		int range = map.length;// 取得 map 長度
		boolean check = false;// 判斷是否還有路可以走
		int x = 1;//起始點x位置
		int y = 1;//起始點y位置
		Stack_2 s = new Stack_2(1, 1);//呼叫物件
		do {
			if (x + 1 < range && map[y][x + 1] == 0) {// 向右走
				map[y][x + 1] = 1;// 設定要前往的格子為1，紀錄為走過了
				check = true;//之後判斷要不要繼續
				x = x + 1;//x值加1
			} else if (y + 1 < range && map[y + 1][x] == 0) {// 向下走
				map[y + 1][x] = 1;// 設定要前往的格子為1，紀錄為走過了
				check = true;//之後判斷要不要繼續
				y = y + 1;//y值加1
			} else if (x - 1 >= 0 && map[y][x - 1] == 0) {// 向左走
				map[y][x - 1] = 1;// 設定要前往的格子為1，紀錄為走過了
				check = true;//之後判斷要不要繼續
				x = x - 1;//x值減1
			} else if (y - 1 >= 0 && map[y - 1][x] == 0) {// 向上走
				map[y - 1][x] = 1;// 設定要前往的格子為1，紀錄為走過了
				check = true;//之後判斷要不要繼續
				y = y - 1;//y值減1
			} else {
				check = false;// 上下左右都無法行走的時候 check 為 false
			}

			if (x == 10 && y == 10) {// 走到終點了
				s.push(x, y);// 在 stack 加進一格的座標
				System.out.println("Go to : (" + s.peekX() + " , " + s.peekY() + ")");
				break;
			}else if (x == 1 && y == 1) {// 走回原點
				s.push(x, y);
				System.out.println("回到原點 (" + s.peekX() + " , " + s.peekY() + ")");
				break;
			} else if (check == true) {// 還有路可以走
				s.push(x, y);// 在 stack 加進一格的座標
				System.out.println("Go to : (" + s.peekX() + " , " + s.peekY() + ")");
			} else {
				if (s.empty() == false) {//上下左右都無法行走的時候退後且STACK還有東西
					s.pop();//x,y值丟出來
					y = s.peekY();//STACK 最後一個值給x
					x = s.peekX();//STACK 最後一個值給y
					System.out.println("Back from : (" + s.peekX() + " , " + s.peekY() + ")");
					map[x][y] = 1;//把死路給標記起來避免再走一次
				} else
					break;//STACK 沒有東西了回到一開始原點
			}
			
		} while (true);

		if (y == 10 && x == 10) {//到終點位置
			System.out.print("You win!");
		} else {
			System.out.print("You dead!");//找不到出口
		}
		
	}

}
