package miniPro;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Mini {
	public static void main(String[] args) throws IOException  {
		
		//읽는다
		//,기준으로 분리해서 리스트로 저장
		//while문으로 계속 반복하도록
		//case로 그 번호 눌렀을때 작동하게
		//리스트에 등록,제거
		
		
		//읽기(빨아들이기)
		Reader fr = new FileReader("C:\\javaStudy\\PhoneDB_mini.txt");
		BufferedReader br = new BufferedReader(fr);
		
		//리스트 만들기
		List<String> person = new ArrayList<String>();
		
		//리스트에 잘라서 배열 넣기
		while(true) {
			
			String str = br.readLine();
			
			if(str == null) {
				break;
			}
			String[] phoneBook = str.split(",");
//			String name = phoneBook[0];
//			String hp = phoneBook[1];
//			String company = phoneBook[2];
			person.add(str);
//			System.out.println(str.indent(0)+ name+"\t" + hp+"\t"+company);
		}
		
		
		
		//시작화면
		System.out.println("*********************************************");
		System.out.println("*               전화번호 관리 프로그램             *");
		System.out.println("*********************************************");
		System.out.println("1.리스트  2.등록  3.삭제  4.검색  5.종료");
		System.out.println("----------------------------------");
		
		
		//스캐너 준비
		Scanner sc = new Scanner(System.in);

		
		//계속 메뉴번호 물어보기
		while(true) {
			System.out.print("메뉴번호: ");
			int num = sc.nextInt();
			
			//case별 조건
			switch(num) {
			
			case 1:
//				person.clear();
				//리스트 보여주기
				System.out.println("<1.리스트>");
				//리스트로 저장

				for(int i = 0; i<person.size(); i++) {
					System.out.println(i+1 +"."+  person.get(i));					
				}
				br.close();
				
//			    fr = new FileReader("C:\\javaStudy\\PhoneDB_mini.txt");
//				br = new BufferedReader(fr);
				continue;
				
			case 2:
//				person.clear();
				//등록
//				while(true) {
//					String str = br.readLine();
//					
//					if(str == null) {
//						break;
//					}
////					String[] phoneBook = str.split(",");
////					String name = phoneBook[0];
////					String hp = phoneBook[1];
////					String company = phoneBook[2];
//					
////					System.out.println(str);
//					person.add(str);
//					
//				}
//				System.out.println(person.toString());
				
				System.out.println("<2.등록>");
				
				System.out.print(">이름: ");
				String name = sc.next(); // nextLine하면 한줄씩 안나옴
				
				System.out.print(">휴대전화: ");
				String hp = sc.next();
				
				System.out.print(">회사전화: ");
				String company = sc.next();
				
				Writer fw = new FileWriter("C:\\javaStudy\\PhoneDB_mini.txt");
				BufferedWriter bw = new BufferedWriter(fw);
				
				
				for(int i=0; i<person.size(); i++) {
					bw.write(person.get(i));
					bw.newLine();
				}

				bw.write(name+","+hp+","+company);
				bw.flush();
//				br.close();
				bw.close();
				
//				fr = new FileReader("C:\\javaStudy\\PhoneDB_mini.txt");
//				br = new BufferedReader(fr);
				System.out.println("[등록되었습니다.]");				
				continue;
				
			case 3:
				//삭제
//				person.clear();
//				while(true) {
//					String str = br.readLine();
//					
//					if(str == null) {
//						break;
//					}
////					String[] phoneBook = str.split(",");
////					name = phoneBook[0];
////					hp = phoneBook[1];
////					company = phoneBook[2];
//					person.add(str);
//					
//				}
				
				System.out.println("<3.삭제>");
				
				System.out.print(">번호:");
				int no = sc.nextInt(); 
			
				person.remove(no-1);
				
				Writer fw2 = new FileWriter("C:\\javaStudy\\PhoneDB_mini.txt");
				BufferedWriter bw2 = new BufferedWriter(fw2);
				
				
				for(int i=0; i<person.size(); i++) {
					bw2.write(person.get(i));
					bw2.newLine();
				}
				
//				br.close();
				bw2.close();
				
//				fr = new FileReader("C:\\javaStudy\\PhoneDB_mini.txt");
//				br = new BufferedReader(fr);
				System.out.println("[삭제되었습니다.]");
				continue;
			case 4:
				
				//검색
				
//				person.clear();
//				while(true) {
//					String str = br.readLine();
//					
//					if(str == null) {
//						break;
//					}
////					String[] phoneBook = str.split(",");
////					name = phoneBook[0];
////					hp = phoneBook[1];
////					company = phoneBook[2];
////					System.out.println(str);
//					person.add(str);
//					
//				}
//				System.out.println(person.toString());
				
				System.out.println("<4.검색>");
				System.out.print("검색:");
				String lang = sc.next();
				
				
				for(int i = 0; i<person.size(); i++) {
					if(person.get(i).contains(lang)) {
						System.out.println(i+"." + person.get(i));
					}
				}
				
				
				
				continue;
			case 5:
				System.out.println("*********************************************");
				System.out.println("*                   감사합니다.                *");
				System.out.println("*********************************************");
				break;
			default:
				System.out.println("[다시 입력해주세요]");
				continue;
				
			}
			break;
			
		}
		
		
		//종료
		sc.close();
		br.close();
		
		
	}
}
