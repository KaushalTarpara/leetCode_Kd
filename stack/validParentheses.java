// 20. Valid Parentheses
// Easy
// 18.1K
// 1K
// Companies
// Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

// An input string is valid if:

// Open brackets must be closed by the same type of brackets.
// Open brackets must be closed in the correct order.
// Every close bracket has a corresponding open bracket of the same type.
 

// Example 1:

// Input: s = "()"
// Output: true
// Example 2:

// Input: s = "()[]{}"
// Output: true
// Example 3:

// Input: s = "(]"
// Output: false
 

// Constraints:

// 1 <= s.length <= 104
// s consists of parentheses only '()[]{}'.
public class validParentheses {
    public boolean isValid(String s) {
  
        //All Open bracket have closing so is even
        if(s.length()%2!=0)return false;
        
        Stack<Character> stack = new Stack<Character>();
  
        for(int i=0; i<s.length(); i++){
            char c=s.charAt(i);
            
            if(c=='('|| c=='['|| c=='{'){
                 stack.push(c);
            }else if(!stack.empty()){
                if((c==']' && stack.peek()=='[') ||(c==')' && stack.peek()=='(')||(c=='}' && stack.peek()=='{'))
                    stack.pop();
                else
                    stack.push(c);
            }else
                    stack.push(c);
            

        }
        if(stack.empty())
                return true;
        else
                return false;
    }
} {
    
}
