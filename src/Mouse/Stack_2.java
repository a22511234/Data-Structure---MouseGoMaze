package Mouse;

public class Stack_2 {
	private int n=0;//用來記錄stack用幾層了
	private int x[]=new int [1000];//用來記錄Stack x值
	private int y[]=new int [1000];//用來記錄Stack y值
	
	public Stack_2(int x1,int y1) { //紀錄一開始起始位置
		 x[0]=x1;
		 y[0]=y1;
		 }

	public void push(int inputX, int inputY) { // 放置新資料
		n++;
		x[n]=inputX;
		y[n]=inputY;
	}

	public int peekX() { // 抓取最後的X值
		return x[n];
	}

	public int peekY() { // 抓取最後的Y值
		return y[n];
	}

	public void pop() { // 刪除最後存進的資料
		x[n]=0;
		y[n]=0;
		n--;
	}
	public boolean empty() { // 判斷STACK是否空了
		if(n==0&&x[n]==1&&y[n]==1) {
			return true;
		}
		else {
			return false;
		}
	}
}

