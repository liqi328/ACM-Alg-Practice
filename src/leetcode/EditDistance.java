package leetcode;

import java.util.Arrays;

/** http://leetcode.com/onlinejudge
 * 设A和B是2个字符串。要用最少的字符操作将字符串A转换为字符串B。这里所说的字符操作包括:
	(1)删除一个字符;
	(2)插入一个字符；
	(3)将一个字符改为另一个字符。
	将字符串A变换为字符串B所用的最少字符操作数称为字符串A到B的编辑距离,记为d(A,B)。试设计一个有效算法,对任给的2个字符串A和B,计算出它们的编辑距离d(A,B)。
	要求：
	输入：第1行是字符串A,第2行是字符串B。
	输出：字符串A和B的编辑距离d(A,B)
 * @author Liqi
 *
 */
public class EditDistance {
	
	public static int calcluate(String word1, String word2){
		int lenA = word1.length();
		int lenB = word2.length();
		
		int[][] distance = new int[lenA + 1][lenB + 1];
		
		for(int i = 0; i <= lenA; ++i){
			distance[i][0] = i;
		}
		for(int j = 0; j <= lenB; ++j){
			distance[0][j] = j;
		}
		
		for(int i = 1; i <= lenA; ++i){
			for(int j = 1; j <= lenB; ++j){
				distance[i][j] = Math.min(distance[i][j - 1] + 1,
						Math.min(distance[i - 1][j] + 1, 
								distance[i - 1][j - 1] + (word1.charAt(i - 1) == word2.charAt(j - 1) ? 0 : 1)));
			}
		}
		
		return distance[lenA][lenB];
	}
	
	
	public static void main(String[] args){
		String A = "hit";
		String B = "cog";
		System.out.println(calcluate(A, B));
	}
}
