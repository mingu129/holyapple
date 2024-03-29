package algorithm;

import java.util.ArrayList;
import java.util.Arrays;

import org.bitbucket.eunjeon.seunjeon.Analyzer;
import org.bitbucket.eunjeon.seunjeon.Eojeol;
import org.bitbucket.eunjeon.seunjeon.LNode;
import org.bitbucket.eunjeon.seunjeon.Morpheme;

/**
 * <pre>
 * algorithm 
 * Testf.java
 *
 * 설명 : 형태소분석 예제
 * 
 * </pre>
 * 
 * @since : 2020. 5. 24.
 * @author : ymg74
 * @version : v1.0
 */
public class MorphemeExample {
	public void testReadme() {
		// 형태소 분석
		for (LNode node : Analyzer.parseJava("아버지가 방에 들어가신다.")) {
			System.out.println(node);
		}

		// 어절 분석
		for (Eojeol eojeol: Analyzer.parseEojeolJava("아버지가방에들어가신다.")) {
			System.out.println(eojeol);
			for (LNode node: eojeol.nodesJava()) {
				System.out.println(node);
			}
		}

		/**
		 * 사용자 사전 추가
		 * surface,cost
		 *   surface: 단어명. '+' 로 복합명사를 구성할 수 있다.
		 *           '+'문자 자체를 사전에 등록하기 위해서는 '\+'로 입력. 예를 들어 'C\+\+'
		 *   cost: 단어 출연 비용. 작을수록 출연할 확률이 높다.
		 */
		Analyzer.setUserDict(Arrays.asList("덕후", "버카충,-100", "낄끼+빠빠,-100").iterator());
		for (LNode node : Analyzer.parseJava("덕후냄새가 난다.")) {
			System.out.println(node);
		}

		// 활용어 원형
		for (LNode node : Analyzer.parseJava("빨라짐")) {
			for (LNode node2: node.deInflectJava()) {
				System.out.println(node2);
			}
		}

		// 복합명사 분해
		for (LNode node : Analyzer.parseJava("낄끼빠빠")) {
			System.out.println(node);   // 낄끼빠빠
			for (LNode node2: node.deCompoundJava()) {
				System.out.println(node2);  // 낄끼+빠빠
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		ArrayList<ArrayList<String> > list = new ArrayList<ArrayList<String> >(); 
//		ArrayList<String> s = new ArrayList<String>();
//		for (LNode node : Analyzer.parseJava("한편 근대 소설을 뜻하는 영어 Novel은 중세기 말 이탈리아에서 유행하던 노벨라(이탈리아어: Novella)에서 온 것으로 이 말은 새로운 것, 신기한 것이란 뜻을 담고 있다. 로망스와 달리 노벨라는 데카메론과 같이 현실의 세태를 반영한 이야기가 특징이다.[4]")) {
//			Morpheme m = node.morpheme();
//			s.add(m.surface());
//			//System.out.println(m.surface() + "/ 품사:  " + m.feature().head());
//			if(m.feature().head().equals("SF")) {
//				list.add(s);
//				s.clear();
//			}
//		}
		
//		for (Eojeol eojeol: Analyzer.parseEojeolJava("한편 근대 소설을 뜻하는 영어 Novel은 중세기 말 이탈리아에서 유행하던 노벨라(이탈리아어: Novella)에서 온 것으로 이 말은 새로운 것, 신기한 것이란 뜻을 담고 있다. 로망스와 달리 노벨라는 데카메론과 같이 현실의 세태를 반영한 이야기가 특징이다.")) {
//			for (LNode node: eojeol.nodesJava()) {
//				Morpheme m = node.morpheme();
//				System.out.println(m.surface());
//			}
//		}
		
		for (Eojeol eojeol: Analyzer.parseEojeolJava("아버지가방에들어가신다.")) {
			for (LNode node: eojeol.nodesJava()) {
				Morpheme m = node.morpheme();
				System.out.println(m.surface());
			}
		}
		
//		for (LNode node : Analyzer.parseJava("한편 근대 소설을 뜻하는 영어 Novel은 중세기 말 이탈리아에서 유행하던 노벨라(이탈리아어: Novella)에서 온 것으로 이 말은 새로운 것, 신기한 것이란 뜻을 담고 있다. 로망스와 달리 노벨라는 데카메론과 같이 현실의 세태를 반영한 이야기가 특징이다.")) {
//			Morpheme m = node.morpheme();
//			System.out.println(m.surface());
//
//		}
	}

}
