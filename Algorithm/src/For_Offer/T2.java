package For_Offer;
//请实现一个函数，把字符串中的每个空格替换成"%20"，例如“We are happy.”，则输出“We%20are%20happy.”。
public class T2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] string = new char[50];
		String str = "we are happy";
		char[] chars = str.toCharArray();
		for (int j = 0; j < chars.length; j++) {
			string[j] = chars[j];
		}
		replaceBlank(string);
		System.out.print(string);
	}

	public static int replaceBlank(char[] string) {  
		//计算空格数与非空格数，若空格数*3+非空格数>数组大小则返回-1，
		//否则进行替换，每遇到空格，将空格后所有内容后移一个下标(从最后一个有效字符开始移动)，然后替换空格，修改指针位置，成功后返回1
		int nBlank = 0;
		int nUsed = 0;
		for (char c : string) {
			int ascii = (int)c;
			if(ascii != 0) {
				if(ascii == 32) {
					nBlank++; 
				} else {
					nUsed++;
				}
			}
		}
		if(string.length < nBlank*3 + nUsed ) {
			return -1;
		} else {
			for (int i = 0; i < string.length; i++) {
				int ascii = (int)string[i];
				if(ascii == 0) {
					break;
				}else if(ascii == 32) {
					for (int j = string.length-1; j >= i+1; j--) {
						if((int)string[j] != 0){
							string[j+2] = string[j];
						}
					}
					string[i] = '%';
					string[i+1] = '2';
					string[i+2] = '0';
					i = i+3;
				}
			}
		}
		return 1;
	}
}
