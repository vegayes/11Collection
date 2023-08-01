package edu.kh.collection.ex.model.service;

import java.nio.file.spi.FileSystemProvider;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class BookService {

	private Scanner sc = new Scanner(System.in);
	
	List<Map<String, Object>> bookList  = new ArrayList<Map<String, Object>>();

	List<Map<String, Object>> likeList  = new ArrayList<Map<String, Object>>();
	
//	Map<String, Object> bookList = new HashMap<String, Object>();
	
	public BookService() {
		
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> map2 = new HashMap<String, Object>();
		
		map.put("bookNum", 1);
		map.put("bookName", "돼지책");
		map.put("author", "몰라");
		map.put("price", 10000);
		map.put("publisher", "모르겠다.");
		
		
		bookList.add(map);
		
		map2.put("bookNum", 2);
		map2.put("bookName", "우와");
		map2.put("author", "몰라");
		map2.put("price", 20000);
		map2.put("publisher", "모르겠다.");
		bookList.add(map2);
	}
	
	
	public void displayMenu() {  // try catch 구문 한번에 잡기. (+ 오류 값 inputMissmatch, exception)

		
		int menuNum = 0;
		
		do {
			
			System.out.println("\n ========= 도서 관리 메뉴 ========= ");
			System.out.println("1. 도서 등록");
			System.out.println("2. 도서 조회");
			System.out.println("3. 도서 수정");
			System.out.println("4. 도서 삭제");
			System.out.println("5. 도서 좋아요 추가");
			System.out.println("6. 도서 좋아요 삭제");
			System.out.println("7. 도서 좋아요 조회");
			System.out.println("0. 프로그램 종료");
			
			System.out.print("\n>> 메뉴 선택  :");
			
			

			try {
				
				menuNum = sc.nextInt();
				System.out.println();
				
	
				switch(menuNum) {
					case 1 : System.out.println(registerBook());break;
					case 2 : updateBook();break;
					case 3 : replaceBook();break;
					case 4 : System.out.println(removeBook());break;
					case 5 : likeAdd();break;
					case 6 : likeRemove();break;
					case 7 : likeUpdate();break;
					case 0 : System.out.println("프로그램이 종료 되었습니다.");break;
					default :System.out.println("메뉴에 있는 값을 입력해주세요! "); break;
					
				}
				
			}catch(InputMismatchException e) {
					
					System.out.println("error! 입력 값을 사용할 수 없습니다. 다시 입력해주세요!");
					
					sc.nextLine();
					
					menuNum = -1;
					
			}
				
		} while(menuNum != 0);
	
	}
	
	/**
	 * 1. 도서 등록 
	 */
	public String registerBook() {
		
		System.out.println("\n==== 도서 등록시스템 ====");
		
//		sc.nextLine() ; // 입력 버퍼 개행 문자 제거
		
		System.out.print("도서 번호 :");
		int bookNum = sc.nextInt();
		
		sc.nextLine();
		
		System.out.print("도서명 : ");
		String bookName = sc.nextLine();
		
		System.out.print("저자 : ");
		String author = sc.next();
		
		System.out.print("가격 : ");
		int price = sc.nextInt();
		
		sc.nextLine();
		
		System.out.print("출판사 : ");
		String publisher = sc.nextLine();
		
		// Map 생성 
		Map<String,Object> book = new HashMap<String,Object>();
		
		// 데이터 추가
		book.put("bookNum", bookNum);
		book.put("bookName", bookName);
		book.put("author", author);
		book.put("price", price);
		book.put("publisher", publisher);
		
		
		if(bookList.add(book)) {
				
			return "성공";
			
		}else {
			
			return "실패";
		}

	}

	
	/**
	 * 2. 도서 조회 (다른 방법으로도 진행해보기)
	 */
	public void updateBook() {
		
		System.out.println("\n==== 도서 조회 시스템 ====");
		
		if(bookList.size() == 0) {
			System.out.println("도서 리스트가 존재하지 않습니다.");
		}else {
		
			for(Map<String, Object> temp : bookList ) {
				
				System.out.print(temp.get("bookNum")+ "번 도서 ");
				System.out.print("[ 도서제목 : "+ temp.get("bookName")+ " / ");
				System.out.print("도서저자 : "+ temp.get("author")+ " / ");
				System.out.print("도서가격 : "+ temp.get("price")+ " / ");
				System.out.print("출판사 : "+ temp.get("publisher")+ " ]\n");
				
			}
		}
		
	}

	
	/**
	 * 3. 도서 수정  (선택해서 도서 수정하기) 
	 */
	public void replaceBook() throws InputMismatchException {

		
		int replaceNum = 0;
		
		System.out.println("\n==== 도서 수정 시스템 ====\n");
		
		// 현재 도서 목록 보여줌.
		for(Map<String, Object> temp : bookList ) {
			
			System.out.print(temp.get("bookNum")+ "번 도서 ");
			System.out.print("[ 도서제목 : "+ temp.get("bookName")+ " / ");
			System.out.print("도서저자 : "+ temp.get("author")+ " / ");
			System.out.print("도서가격 : "+ temp.get("price")+ " / ");
			System.out.print("출판사 : "+ temp.get("publisher")+ " \n");
			
		}
		
		System.out.print("\n수정할 도서 번호를 입력해주세요 :");
		replaceNum = sc.nextInt();
		
		
//		System.out.println();
		sc.nextLine();

		for( int i = 0 ; i < bookList.size(); i++) {
			
			for( Map<String, Object> temp : bookList ) {
				
//				if( Integer.valueOf((String) temp.get("bookNum")) == replaceNum ) {
				if( (int)temp.get("bookNum") == replaceNum ) {
					
					
					
					int changeNum = 0;
					
					do {
						
						System.out.println("\n1. 도서명");
						System.out.println("2. 도서 저자");
						System.out.println("3. 도서 가격");
						System.out.println("4. 도서 출판사");
						System.out.println("0. 수정 종료");
						
						System.out.print("\n어떤 정보를 수정하시겠습니까? : ");
						changeNum = sc.nextInt();
						
						sc.nextLine();
						
						switch(changeNum) {

						case 1: System.out.println(bookNameRepalce(replaceNum)); break;
						case 2: System.out.println(AuthorRepalce(replaceNum)); break;
						case 3: System.out.println(bookPriceRepalce(replaceNum)); break;
						case 4: System.out.println(publisherRepalce(replaceNum)); break;
						case 0: System.out.println("수정을 종료하겠습니다."); break;
						default : System.out.println("수정 메뉴에 있는 값만 입력해주세요!");
						
					
						}
					
					}while(changeNum != 0);
					
					
					
				}	
			}	
		}	
	}
	
	
	
	/**
	 * 3-1 도서명 수정
	 */
	public String bookNameRepalce(int replaceNum) throws InputMismatchException{
		
		System.out.println("\n==== 도서명 수정 ====");
		
		System.out.print("\n수정할 도서명을 입력해주세요 :");
		String bookNameRe = sc.nextLine();
		
		for(Map<String,Object> name : bookList) {
			
			if((int) name.get("bookNum") == replaceNum ) {
				
				name.put("bookName", bookNameRe);
				return "수정 완료";
			}


		}

		return "수정 실패";
		
	}
	
	
	
	/**
	 *  3-2 도서저자 수정
	 */
	public String AuthorRepalce(int replaceNum) throws InputMismatchException{
		
		System.out.println("\n==== 도서저자 수정 ====");
		
		System.out.print("\n수정할 저자이름을 입력해주세요 :");
		String authorRe = sc.next();
		
		for(Map<String,Object> name : bookList) {
			
			if((int) name.get("bookNum") == replaceNum ) {
				
				name.put("author", authorRe);
				return "수정 완료";
			}


		}

		return "수정 실패";
		
	}
	
	
	/**
	 *  3-3 도서가격 수정
	 */
	public String bookPriceRepalce(int replaceNum) throws InputMismatchException{
		
		System.out.println("\n==== 도서가격 수정 ====");
		
		System.out.print("\n수정할 가격을 입력해주세요 :");
		int priceRe = sc.nextInt();
		
		for(Map<String,Object> name : bookList) {
			
			if((int) name.get("bookNum") == replaceNum ) {
				
				name.put("price", priceRe);
				return "수정 완료";
			}
		}
		return "수정 실패";
		
	}
	
	
	/**
	 *  3-4 출판사 이름 수정
	 */
	public String publisherRepalce(int replaceNum) throws InputMismatchException{
		
		System.out.println("\n==== 출판사 수정 ====");
		
		System.out.print("\n수정할 출판사 이름을 입력해주세요 :");
		String publisherRe = sc.nextLine();
		
		for(Map<String,Object> name : bookList) {
			
			if((int) name.get("bookNum") == replaceNum ) {
				
				name.put("publisher", publisherRe);
				return "수정 완료";
			}
		}
		return "수정 실패";
		
	}
	
	
	/**
	 * 4. 도서 삭제  (선택해서 도서 수정하기) 
	 */
	public String removeBook() throws InputMismatchException {

		int index = -1;
		
		System.out.println("\n==== 도서 삭제 시스템 ====\n");
		
		// 현재 도서 목록 보여줌.
		for(Map<String, Object> temp : bookList ) {
			
			System.out.print(temp.get("bookNum")+ "번 도서 ");
			System.out.print("[ 도서제목 : "+ temp.get("bookName")+ " / ");
			System.out.print("도서저자 : "+ temp.get("author")+ " / ");
			System.out.print("도서가격 : "+ temp.get("price")+ " / ");
			System.out.print("출판사 : "+ temp.get("publisher")+ " \n");

		}
		
		System.out.print("삭제할 도서 번호를 입력해주세요 :");
		int removeNum = sc.nextInt();

		
		
			for( Map<String, Object> temp : bookList ) {
				
				if( (int)temp.get("bookNum") == removeNum) {
					
					index = bookList.indexOf(temp);
					System.out.println(index);
				
				}

			}


		
		if(index == -1){
			return "일치하는 도서가 없습니다.";
		}else {
			
			System.out.print("정말 삭제하시겠습니까? (Y/N):");
			char check = sc.next().toUpperCase().charAt(0);
			
			if( check == 'Y') {
				
				bookList.remove(index);
				return "삭제 성공!";
			}else {
				
				return "삭제진행을 취소합니다.";
			}	
			
		}
		
/*		
//		sc.nextLine();

		for( int i = 0 ; i < bookList.size(); i++) {
			
			for( Map<String, Object> temp : bookList ) {
				
				if( (int)temp.get("bookNum") == removeNum) {
					
					bookList.remove(i);
				}
			}
				

		}	
		
		return "삭제를 취소합니다.";
	
	
	*/
	}
	/**
	 *	5. 도서 좋아요 추가
	 */
	public void likeAdd() {
		
		System.out.println("\n ==== 즐겨찾기 추가 ====");
		
		System.out.print("즐겨찾기에 추가할 도서 번호를 입력하세요! :");
		int likeNum = sc.nextInt();
		
//		for( int i = 0 ; i < bookList.size(); i++) {
		
			for( Map<String, Object> temp : bookList ) {
				
				if( (int)temp.get("bookNum") == likeNum) {
					
					Map<String,Object> like = new HashMap<String,Object>();
					
					// 데이터 추가
					like.put("bookNum", temp.get("bookNum"));
					like.put("bookName", temp.get("bookName"));
					like.put("author", temp.get("author"));
					like.put("price", temp.get("price"));
					like.put("publisher", temp.get("publisher"));
					likeList.add(like);
				}

			}
//		}
		
		
	}
	
	
	
	/**
	 *	6. 도서 좋아요 삭제
	 */
	public void likeRemove() {

		System.out.println("\n ==== 즐겨찾기 삭제 ====");
		
		System.out.print("즐겨찾기에 삭제할 도서 번호를 입력하세요! :");
		int removeNum = sc.nextInt();
		
		int index = -1;
		
			for( Map<String, Object> temp : likeList ) {
				
				if( (int)temp.get("bookNum") == removeNum) {
					
					index = likeList.indexOf(temp);
					
					System.out.println(index);
				
				}

			}

		
		if(index == -1){
			System.out.println("일치하는 도서가 없습니다.");
		}else {
			
			System.out.print("정말 삭제하시겠습니까? (Y/N):");
			char check = sc.next().toUpperCase().charAt(0);
			
			if( check == 'Y') {
				
				likeList.remove(index);
				System.out.println("삭제 성공!");
			}else {
				System.out.println("삭제진행을 취소합니다.");
			}	
			
		}
		
	}
	
	
	/**
	 * 7. 좋아요 조회 (다른 방법으로도 진행해보기)
	 */
	public void likeUpdate() {
		
		System.out.println("\n==== 좋아요 도서 조회 시스템 ====");
		
		if(likeList.size() == 0) {
			System.out.println("좋아요 도서 리스트가 존재하지 않습니다.");
		}else {
			
			for(Map<String, Object> temp : likeList ) {
				
				System.out.print(temp.get("bookNum")+ "번 도서 ");
				System.out.print("[ 도서제목 : "+ temp.get("bookName")+ " / ");
				System.out.print("도서저자 : "+ temp.get("author")+ " / ");
				System.out.print("도서가격 : "+ temp.get("price")+ " / ");
				System.out.print("출판사 : "+ temp.get("publisher")+ " ]\n");
				
			}
		}
		
	}

	
	
}
