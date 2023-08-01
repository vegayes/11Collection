package edu.kh.collection.model.service;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import edu.kh.collection.model.vo.Member;

public class SetService {
	
	// Set(집합) 
	// -> 순서를 유지하지 않음(=> 인덱스 없음) 
	// -> 중복을 허용하지 않음( null 중복 X, 1개만 저장 가능) 
	
	// *** Set이 중복을 확인하는 방법 ***
	// -> 객체가 가지고 있는 필드값이 모두 같으면 중복으로 판단
	// --> 이 때, 필드값이 모두 같은지 비교하기 위해서 
	//      객체에 "equals()"가 반드시! 오버라이딩 되어 있어야 한다. 
	
	public void ex1() {
		
		Set<String> set = new HashSet<String>();
		
		// HashSet : Set의 대표적인 자식 클래스 
		// 사용조건 1) 저장되는 객체에 equals() 오버라이딩 필수
		// 사용조건 2) 저장되는 객체에 hashCode() 오버라이딩 필수
		
		// ** Hash라는 단어가 붙은 컬렉션은 반드시 저장되는 객체에 equals()와 hasCode()모두 오버라이딩 필수!!!
		// --> 근데 우리는 오버라이딩 안했는데,,? :: String 타입은 내부적으로 설정되어 있음.
		// (즉, 우리가 직접 만든 클래스에서 오버라이딩 작업이 필수다..)
		
		set.add("네이버");
		set.add("카카오");
		set.add("쿠팡");
		set.add("당근마켓");
		set.add("배민");
		set.add("배민");
		set.add("배민");
		set.add(null);
		set.add(null);
		set.add(null);
		
		
		System.out.println(set);
		// 확인된 것 : 순서 X/ 중복 X / null 중복 X 
		
		// size() : 저장된 데이터의 개수 반환
		System.out.println("저장된 데이터 수 :"+set.size());
		
		// remove(String e) : Set에 저장된 객체 중 매개변수 e와 필드 값이 같은 객체를 제거
		System.out.println(set.remove("당근마켓"));
		System.out.println(set.remove("라인"));
		System.out.println(set);  // String에 있는 toString값에 의해서 
		// 반환 값이 boolean 이라서 당근마켓은 삭제가 되었으므로 true, 라인은 원래 존재하지 않았으므로 false반환
	
		
		// Set은 순서가 없어서 저장된 객체 하나를 얻어올 수 있는 방법이 없음.
		// -> 대신에 Set 전체의 데이터를 하나씩 반복적으로 얻어올 순 있다.
		
		// 1) Iterator(반복자)
		// --> 컬렉션에서 제공하는 컬렉션 객체 반복 접근자
		// ( 컬렉션에 저장된 데이터를 임의로 하나씩 반복적으로 꺼내는 역할 )
		
		Iterator<String> it = set.iterator();
		// Iterator가 얻어온 데이터의 타입은 모두 String임을 알려줌.
		
		// set.iterator() : Set은 Iterator로 하나씩 꺼내갈 수 있는 모양으로 변환 
		
		// 대기열에서 대기.. 
		// hasNext를 이용하여 꺼내옴.
		while(it.hasNext()) { // hasNext() : 다음 값이 있으면 true 반환 
			
			// it.next() : 다음 값(객체)을 얻어옴.
			System.out.println(it.next());
			
		}
		
//		System.out.println(set);
		
		System.out.println("-".repeat(50));
		
		// 2) 향상된 for문 사용
		// for(하나씩 꺼내서 저장할 변수 : 컬렉션)
		for( String std : set) {
			System.out.println(std);
		}

	}
	
	
	public void ex2(){
		
		Set<Member> memberSet = new HashSet<Member>();
		
		memberSet.add(new Member("user01", "pass01", 30)) ;
		memberSet.add(new Member("user02", "pass02", 40)) ;
		memberSet.add(new Member("user03", "pass03", 50)) ;
		memberSet.add(new Member("user03", "pass03", 50)) ; 

		for(Member temp : memberSet) {
			System.out.println(temp);
			// equals랑 hashCode를 오버라이딩 안해서 중복제거 안됨. 
		}
		
		// Object의 equals(), hashCode() 오버라이딩
		
		// A.equals(B) : A와 B가 가지고 있는 필드 값이 모두 같으면 true, 아니면 false
		
		// Hash 함수 : 입력된 단어를 지정된 길이의 문자열로 변환하는 함수(중복X) 
		// ex) 입력 : 111-> "asdfg"(5글자)
		// ex) 입력 : 1233242 -> "qwezg" (5글자)
		
		// hashCode() : 필드 값이 다르면 중복되지 않는 숫자를 만드는 메서드 
		// -> 왜 만들까? 빠른 데이터 검색을 위해서 (객체가 어디에 있는지 빨리 찾기 위해서)
		
		// HashSet() : 중복 없이 데이터 저장하고, 데이터 검색이 빠름(::Hash 때문에)
		// Hash는 자료구조 연습하기! 
		
		// set 이용 : 랜덤쿠폰, 로또
		
	}
	
	
	public void ex3() {
		
		// Wrapper 클래스 : 기본 자료형 -> 객체형태로 포장하는 클래스
		
		// -> 컬렉션에 기본 자료형값을 저장하고 싶을 때, 사용  (그럼 위에서 사용한거는??)
		// -> 기본 자료형에 없던 추가 기능, 값을 이용하고 싶을 때 사용 
		
		
		// <Wrapper 클래스 종류>
		// int -> Integer
		// char -> Character
		// 나머지는 다 대문자로 변환, Boolean, Byte, Short, Long, Float, Double
		
		int iNum = 10;
		double dNum = 3.14;
		
		
		// 기본 자료형 -> 포장 
		Integer w1 = new Integer(iNum); // int가 Integer로 포장 
		Double w2 = new Double(dNum); // double이 Double로 포장
		// 중간 선이 삭제선 == 해당 구문은 삭제될 예정임. 
		// --> 사용을 권장하지 않음. 
		
		
		// Wrapper 클래스 활용 
		System.out.println("int 최대값 : " + w1.MAX_VALUE);
		System.out.println("double 최소값 : " + w2.MIN_VALUE);
		// 기울어진 글씨 ? == static 
		// static은 클래스명.필드명 / 클래스명.메소드명() 호출가능 
		// warring :: 변수명에 static 접근해버림.
		
		System.out.println("static 방식으로 Wrapper 클래스 사용하기");
		
		System.out.println("int 최대값 : " + Integer.MAX_VALUE);
		System.out.println("double 최소값 : " + Double.MIN_VALUE);
		
		// ---------------------------------------------------------------------------
		// parsing : 데이터 형식을 변환
		int num1 = Integer.parseInt("100");// 문자열 "100"을 int 형식으로 변환 
		double num2 = Double.parseDouble("1.2345");// 문자열 "1.2345"을 doouble 형식으로 변환
		
		System.out.println(num1 + num2);
		
	}
	
	public void ex4() {
		
		// Wrapper 클래스의 AutoBoxing / AutoUnboxing
		
		Integer w1 = new Integer(100);
		
		// 자동으로 변환 (Integer <- (int)) <AutoBoxing>
		Integer w2 = 100;
		Integer w3 = 200; 
		// w2와 100은 원래 연산이 안되어야 하지만, 
		// Integer는 int의 포장 형식이라는 것을 Java가 인식하고 있어서 
		// 위와 같은 경우 int를 Integer로 자동 포장해준다. 
		
		
		System.out.println("w2 + w3 = " + w2 + w3);
		// w2 (Integer 객체) 
		// w3 (Integer 객체) 
		// w2 + w3 == 객체 + 객체 --> 원래는 불가능
		
		// Integer는 int의 포장형태라는 걸 Java가 인식하고 있어서 
		// '+' 연산 시, 포장을 자동으로 벗겨냄
		
		// Integer + Integer -> int + int (자동 포장 해제)  <AutoUnboxing>
		
	}
	
	
	public void lotto() {
		
		// 로또 번호 생성기 Version.2
		
		// 6개의 번호 난수 1 ~ 45 사이 
		// 중복 X 
		
		
//		Set<Integer> lotto = new HashSet<Integer>();  // HashSet은 정렬 기능이 없음. 

		Set<Integer> lotto = new TreeSet<Integer>(); // 자동 정렬 Set
//		Set<Integer> lotto = new LinkedHashSet<Integer>(); // 나온 순서대로 저장 ( 순서 유지 Set )
		
		
		// Integer는 equals(), hashCode()이미 오버라이딩 완료 상태

		while(lotto.size() != 6) {
			// looto에 저장된 값의 개수가 6개 미만 또는 6개인경우에 빠져나오게 하여 반복
			
			int random = (int) (Math.random() * 45 + 1);
			
			System.out.println(random);
			lotto.add(random);
			// int값이 자동으로 Integer로 포장되어 lotto에 추가
		}
		
		System.out.println("로또 번호 :" + lotto);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
