package edu.kh.collection.model.service;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import edu.kh.collection.model.vo.Student;
import edu.kh.collection.model.vo.StudentRe;

/**
 * 
 */
public class StudentReService {
	
	// 필드   
	private Scanner sc = new Scanner(System.in);

	private List <StudentRe> studentList = new LinkedList<StudentRe>(); //  학생 값 넣어둘 리스트 선언
	
	public StudentReService(){
		
		studentList.add(new StudentRe("유은서",14,"서울특별시 구로구",'F',100));
		studentList.add(new StudentRe("러바오",11,"서울특별시 중구",'M',50));
		studentList.add(new StudentRe("푸바오",3,"경기도 용인시",'F',90));
		studentList.add(new StudentRe("아이바오",10,"충북 천안시",'F',70));
		
	}
	
	public void menu() {
		int menuNum = 0;
		
		do {
			
			System.out.println("\n==== 학생 관리 프로그램 ====\n");
			System.out.println("1. 학생 정보 추가");
			System.out.println("2. 학생 전체 조회");
			System.out.println("3. 학생 정보 수정");
			System.out.println("4. 학생 정보 제거");
			System.out.println("5. 이름으로 검색 (일치)");
			System.out.println("6. 이름으로 검색 (포함)");
			System.out.println("프로그램 종료");
			
			
			System.out.print("메뉴 선택 > ");
			
			try {
				menuNum = sc.nextInt();
				System.out.println(); // 줄바꿈
				
				switch(menuNum) { 
				
				case 1: System.out.println(addStudent()); break;
				case 2: updateStudent(); break;
				case 3: replaceStudent(); break;
				case 4: removeStudent(); break;
				case 5: searchStudent1(); break;
				case 6: searchStudent2(); break;
				case 0: System.out.println("프로그램 종료"); break;
				default : System.out.println("메뉴에 있는 숫자로 입력해주세요");break;  // 숫자 범위 벗어난 값 처리
				
				}
			
			}catch (InputMismatchException e){ // 숫자 입력이 아니라 문자입력시, 예외로 처리됨.
			
				System.out.println("Error!  입력 형식이 유효하지 않습니다. 다시 시도해주세요!");
				
				// 비워주는 값.
				sc.nextLine(); // 입력 버퍼에 남아있는 잘못된 문자열 제거
				
				
				// 첫 반복할 때 menuNum을 잘못 입력하면, 무한 루프를 돎. ( 왜냐면, 초기화를 0으로 잡았기 때문)
				// 그러므로 임의값 -1을 예외처리로 작성함.
				 menuNum = -1;
			
			
			}
			
		}while(menuNum!=0);
		
	}

	
	
	/**
	 * 1. 학생 정보 추가 
	 */
	public String addStudent() throws InputMismatchException {// 던지기 
		
		System.out.println("=== 학생 정보 추가 ====\n");
		
		
		System.out.print("이름 : ");
		String name = sc.next();
		
		System.out.print("나이 : ");
		int age = sc.nextInt();
		
		sc.nextLine();
		
		System.out.print("지역 : ");
		String region = sc.nextLine();
		
		System.out.print("성별(M/F) : ");
		char gender = sc.next().charAt(0);
		
		System.out.print("점수 : ");
		int score = sc.nextInt();
		
		
		if(studentList.add(new StudentRe(name,age,region,gender,score))) {

			return "성공";

		}else {
			
			return "실패";
		}
	}
	
	
	/**
	 * 2. 학생 전체 조회
	 */
	public void updateStudent() { 
		
		int i = 0;
		// 향상된 for문
		for(StudentRe std : studentList) {
			
			System.out.print((i++)+"번째 :");
			System.out.println(std);  // why toString이 출력되는거?
			
		}
	}
	
	/**
	 * 3. 학생 정보 수정 ★★★★★★★★
	 */
	public void replaceStudent() throws InputMismatchException {

		/* 중요함! 조건!!
		 * 1) 학생 정보가 list에 담겨있는가?
		 * 2) 인덱스 번호가 음수인 경우
		 * 3) 예외처리
		 * 4) list보다 더 많은 숫자를 입력한 경우
		 */
		
		System.out.println("=== 학생 정보 수정 ====\n");
		
		System.out.print("인덱스 번호 입력 :");
		int index = sc.nextInt();
		
		if(studentList.isEmpty()) { // 비어있니?
			System.out.println("등록된 학생 정보가 없습니다.");
		}else if(index < 0) {
			System.out.println("양수를 입력해주세요!");
		}else if ( index >= studentList.size()) {
			System.out.println("범위를 벗어났습니다. ");
		}else {
			System.out.println( index + "번째 현재 정보");
			System.out.println(studentList.get(index));
		
			System.out.print("이름 : ");
			String name = sc.next();
			
			System.out.print("나이 : ");
			int age = sc.nextInt();
			
			sc.nextLine();
			
			System.out.print("지역 : ");
			String region = sc.nextLine();
			
			System.out.print("성별(M/F) : ");
			char gender = sc.next().charAt(0);
			
			System.out.print("점수 : ");
			int score = sc.nextInt();
			
			StudentRe temp = studentList.set(index, new StudentRe(name,age,region,gender,score)); // ★★★★★★★
			
			System.out.println(temp.getName() + "의 정보가 변경되었습니다.");
			
		}
			
		
		
	}
	
	
	/**
	 * 4. 학생 정보 제거 ★★★★★★★★
	 */
	public void removeStudent() throws InputMismatchException{
		
		System.out.println("==== 학생 정보 제거 ====");
		
		System.out.print("인덱스 번호 입력 : ");
		int index = sc.nextInt();
		
		/* 중요함! 조건!!
		 * 1) 학생 정보가 list에 담겨있는가?
		 * 2) 인덱스 번호가 음수인 경우
		 * 3) 예외처리
		 * 4) list보다 더 많은 숫자를 입력한 경우
		 */
		
		if(studentList.isEmpty()) { // 비어있니?
			System.out.println("등록된 학생 정보가 없습니다.");
		}else if(index < 0) {
			System.out.println("양수를 입력해주세요!");
		}else if ( index >= studentList.size()) {
			System.out.println("범위를 벗어났습니다. ");
		}else {
			System.out.print("정말로 삭제 하시겠습니까? (Y/N) :");
			
			char check = sc.next().toUpperCase().charAt(0);
			
			if(check == 'Y') {

				StudentRe temp = studentList.remove(index); // ★★★★★★★
				System.out.println(temp.getName() + "의 정보가 변경되었습니다.");
			}else {
				
				System.out.println("취소 되었습니다.");
			}
		}	
	}
	
	
	/**
	 * 5. 검색할 이름 확인(동일한지)
	 */
	public void searchStudent1() {
		
		System.out.println("==== 검색 확인 (일치) ====");
		
		System.out.print("찾을 이름 >");
		String search = sc.next();
		
		boolean flag = true;
		
		for(StudentRe std : studentList) {
			
			if(search.equals(std.getName())){
				System.out.println(std);
				flag = false;
			}
		}
		
		if(flag) {
			System.out.println("검색한 결과가 없습니다.");
		}
	}
	
	public void searchStudent2() {
		
		System.out.println("==== 검색 확인 (포함) ====");
		
		System.out.print("찾을 이름 >");
		String search = sc.next();
		
		boolean flag = true;
		
		for(StudentRe std : studentList) {
			
			if(std.getName().contains(search)){
				System.out.println(std);
				flag = false;
			}
		}
		
		if(flag) {
			System.out.println("검색한 결과가 없습니다.");
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
