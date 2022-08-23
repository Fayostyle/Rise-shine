/**
 You are playing the following Flip Game with your friend:
  Given a string that contains only these two characters: 
  + and -, you and your friend take turns to 
  flip two consecutive "++" into "--". 
  The game ends when a person can no 
  longer make a move and therefore
   the other person will be the winner.

Write a function to compute all possible 
states of the string after one valid move.

For example, given s = "++++", after one move, 
it may become one of the following states:

[
  "--++",
  "+--+",
  "++--"
]
If there is no valid move, return an empty list [].

Hide Company Tags Google
Hide Tags String
Hide Similar Problems (M) Flip Game II

 */

class Solution {
   public List<String> flip(String s) {
       List<String> res = new ArrayList<>();
       if(s == null || s.length < 2){
           return res;
       }
       char[] ch = s.toCharArray();
       for(int i=0; i<s.length()-1; i++) {
           if(ch.charAt(i) == '+' && ch.charAt(i+1) == ch.charAt(i)) {
               ch[i] = '-';
               ch[i+1]= '-';
               res.add(new String(ch));
               ch[i] = '+';
               ch[i+1] = '+';
           }

       }
       return res;
   }
    
}



/**
 *  294 翻转游戏2
 * You are playing the following Flip Game with your friend: Given a string that contains only these two characters: + and -, you and your friend take turns to flip two consecutive "++" into "--". The game ends when a person can no longer make a move and therefore the other person will be the winner.

Write a function to determine if the starting player can guarantee a win.

For example, given s = "++++", return true. The starting player can guarantee a win by flipping the middle "++" to become "+--+".

Follow up:
Derive your algorithm's runtime complexity.

293. Flip Game 的拓展，这次求是否先玩者可以有一种策略一定赢游戏。
 */
public class Solution{
    public boolean canWin(String s){        //corner
        if ( s == null || s.length() == 0 ){            
            return false;
        }        
    return helper(s.toCharArray());
}    
public boolean helper(char[] arr){
    for ( int i = 0; i < arr.length; i++ ) {
        if ( arr[i] == '+' && arr[i + 1] == '+' ){
            arr[i] = '-';
            arr[i + 1] = '-';                
            boolean otherWin = helper(arr);         //2人轮流
            
            arr[i] = '+';               //返回到upper level后恢复＋号
            arr[i + 1] = '+';                
            if ( !otherWin ){           //另一人false时走这一步，另一人true时，要继续遍历＋＋对
                return true;            //直到找到某一种走法可以让另一人false，最终整体返回的值为true，此时第一人赢
            }
        }
    }        
    return false;           //如果遍历到头没有＋＋对了，而且几种走法都一直找不到赢的走法了，第一人就最终false
}
}

public boolean canWin(String s) {
    if(s == null || s.length < 2) {
        return false;
    }

    for(int i = 0; i<s.length() - 1; i++) {
        char c = s.charAt(i);
        char c2 = s.charAt(i+1);
        if(c == '+' && c2 == '+') {
            StringBuilder sb = new StringBuilder(s);
            sb.setCharAt(i, '-');
            sb.setCharAt(i+1, '-');
            if(!canWin(sb.toString())) {
                return true;
            }
        }
    }

    return false;
}
