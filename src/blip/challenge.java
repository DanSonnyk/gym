package blip;

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 *     Open brackets must be closed by the same type of brackets.
 *     Open brackets must be closed in the correct order.
 *     Every close bracket has a corresponding open bracket of the same type.
 *
 *
 * Example 1:
 * Input: s = "()"
 * Output: true
 *
 * Example 2:
 * Input: s = "()[]{}"
 * Output: true
 *
 * Example 3:
 * Input: s = "(]"
 * Output: false
 *
 * Example 4:
 * Input: s = "([])"
 * Output: true
 *
 */
public class challenge {
    public static void main(String[] args) {


    }

    private boolean iscvalid( String itens){

        //iterar para cada char
        //Map the pairs characters
        //If i enconter some diferent return false
        // ( , [  , ] , )



        int length = itens.length();
        for(int i = 0; i < length; i++ ){
            char c1 = itens.charAt(i);
            for(int f = i+1; f < length ; f++ ){
                char c2 = itens.charAt(f);
                if(c1 != c2){
                    return false;
                }
            }
        }

     return false;
    }
}
