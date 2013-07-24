package pango;

import java.util.Stack;

/* http://leetcode.com/onlinejudge
 * 
 * 给定只包含括号字符'('和 ')''的字符串，请找出最长的有效括号内子括号的长度。 
 * 举几个例子如下： 例如对于"( ()"，最长的有效的括号中的子字符串是"()" ，
 * 有效双括号数1个，故它的长度为 2。  再比如对于字符串") () () )"，
 * 其中最长的有效的括号中的子字符串是"() ()"，有效双括号数2个，
 * 故它的长度为4。  再比如对于"( () () )"，它的长度为6。          
 * 换言之，便是有效双括号"()"数的两倍。 
 * 给定函数原型int longestValidParentheses(string s)，请完成此函数，实现上述功能。 
 * */
public class LongestValidParentheses {
	
	static class Pair{
		public char c;
		public int i;
		
		public Pair(char c, int i){
			this.c = c;
			this.i = i;
		}
	}
	
	public static int longestValidParentheses(String s){
		Stack<Pair> sk = new Stack<Pair>();
		boolean[] flag = new boolean[s.length()];
		for(int i = 0; i < flag.length; ++i){
			flag[i] = false;
		}
		for(int i = 0; i < s.length(); ++i){
			if(s.charAt(i) == '('){
				sk.push(new Pair('(', i));
			}else{
				if(!sk.empty()){
					flag[sk.peek().i] = true;
					flag[i] = true;
					sk.pop();
				}
			}
		}
		
		int maxLen = 0, curLen = 0;
		for(int i = 0 ; i < flag.length; ++i){
			if(flag[i]){
				++curLen;
			}else{
				if(curLen > maxLen){
					maxLen = curLen;
				}
				curLen = 0;
			}
		}
		if(curLen > maxLen){
			maxLen = curLen;
		}
		return maxLen;
	}
	
	/* http://blog.csdn.net/abcbc/article/details/8826782
	 * 这道题可以用一维动态规划逆向求解。假设输入括号表达式为String s，
	 * 维护一个长度为s.length的一维数组dp[]，数组元素初始化为0。 
	 * dp[i]表示从s[i]到s[s.length - 1]最长的有效匹配括号子串长度。
	 * 则存在如下关系：
	 * a: dp[s.length - 1] = 0;
	 * b: 从i - 2 -> 0逆向求dp[]，并记录其最大值。若s[i] == '('，
	 * 		则在s中从i开始到s.length - 1计算s[i]的值。
	 * 		这个计算分为两步，通过dp[i + 1]进行的（注意dp[i + 1]已经在上一步求解）：
	 * 			1: 在s中寻找从i + 1开始的有效括号匹配子串长度，即dp[i + 1]，跳过这段有效的括号子串，
	 *    		查看下一个字符，其下标为j = i + 1 + dp[i + 1]。若j没有越界，并且s[j] == ‘)’，
	 *    		则s[i ... j]为有效括号匹配，dp[i] =dp[i + 1] + 2。
	 * 			2: 在求得了s[i ... j]的有效匹配长度之后，若j + 1没有越界，则dp[i]的值还要加上从j + 1开始的最长有效匹配，即dp[j + 1]。
	 * */
	public int longestValidParentheses2(String s) {  
	    // Start typing your Java solution below  
	    // DO NOT write main() function  
	    int n = s.length();  
	    int[] dp = new int[n];  
	    java.util.Arrays.fill(dp, 0);  
	    int max = 0;  
	    for (int i = n - 2; i >= 0; i--) {  
	      if (s.charAt(i) == '(') {  
	        int j = i + 1 + dp[i + 1];  
	        if (j < n && s.charAt(j) == ')') {  
	          dp[i] = dp[i + 1] + 2;  
	          int k = 0;  
	          if (j + 1 < n) {  
	            k = dp[j + 1];  
	          }  
	          dp[i] += k;  
	        }  
	        max = Math.max(max, dp[i]);  
	      }  
	    }  
	    return max;  
	  }  
	
	
	public static void main(String[] args){
		System.out.println(longestValidParentheses("()()"));
		System.out.println(longestValidParentheses("()(()"));
		System.out.println(longestValidParentheses(")(((((()())()()))()(()))("));
		System.out.println(longestValidParentheses("())()))()())()((())))())()))(()))))(()()))())(()))()))()()))((()))()((()()))))()((())())(((((()(())((()"));
		System.out.println(longestValidParentheses(")()))()())())()()((()())()))))()))(())(((())())))())(((((())))(()((()())(()()(()()((((((())))()(()(())))((())(())(())())())))())()))))))))(())(()"));
		System.out.println(longestValidParentheses("(()(()))())))())))(((()(())))(()())((())((()()()(())))))()(())))())))(())())())((())))((((()))((())()))()(()()(())))())())))()))(()()((()(())()))((())(((()()()(((())((()()((())()))(()(())))()()))(()()))))))))((()())((((())(())())((())((()))))((()()(())()))()())((()((()))(()((())()()))((()()(()(()((())))()((())((()))()(()))())(()()())())()())(()()))))((()())(())()((()))(()(((())()(())))(())())))()))())))()()((()(((()(())(())))((()))())())())))))))((()(((())(())))(((())(()((()))))))())())()((()()((()()(())((()(((()((()())(()())()()()))()(()(()(()(((((()()))(((()))(()((()((((((()())(()))())((()))())()())()((()))())))()(()(()()))()((())())((()((())(()((())((()))))((((((((())()())))()))())((())())())()()())))))(()))()())(())(((((())((()))((()()())()))))(())))))(()(((((((())((()((()))((())((((())))))))))()))))))(()(())))))((()))(()))(()))((()((())((()(()((()(())(()()())())()))()())()(()))))(()())()()))(()())))(()))))((()()))(()()()())))))(())()()(((()()()()((())(()()())(((()(()((((()(())())))()(((()(()())))())())(()))()))())())(()()()()()())())(())((((())((((((((((()())()))())))())()))))))()(()((((((()))))))()())((()())())(()())()()()))(())()(()(()()))()))(((()(((())())()((())()))(()()((((())()))))(()(((())((())(())())()))((())(())())()(()()(())()())(()()))())()))()())()((()(((()((()()(()())))))()(()((((((((()())))(()(()))((((()()))))))))((()()(()(())(()())(((()))(())))))())(((((()((())())()())()()())()())()())))((()(()()))(((()()((())())((()(()(()())(((((()()(())))))())(())(())(()(()))(())()()))(()))(())()())((((())()())())))))()(())))()(())(())))((()()()((())()(())(()((((()))())())()(()()())()())()(()(()(()))(()(()()((())(()())))(((()(())()())(())()))(())()))())())((((()()(()))())))))))(((()))(()(()()))))))))((()))(()((()))(((((()()()))((((()()(()())((()(())))())(((()(()()))(((())()))(("));
		System.out.println(longestValidParentheses("()))(()(((()()(()())(((())()()))())()"));
		System.out.println(longestValidParentheses(""));
	}
}
