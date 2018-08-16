import java.util.Stack;

public class RPNcalculator{

/*
 * Implement a simple RPN calculator
 * with an Stack
 * this is a possible solution, others are
 * also possible
 */
public static int calculate(String ops[]){
	int result = 0;
	int x,y;
	String operators = new String("+-/*");
	// Define a Stack
	Stack st = new Stack();
	for (String op: ops) {
		if (op.compareTo("+") != 0 &&
			op.compareTo("-") != 0 &&
			op.compareTo("/") != 0 &&
			op.compareTo("*") != 0) {
			st.push(op);
		} else {
			y = Integer.parseInt(st.pop().toString());
			x = Integer.parseInt(st.pop().toString());
			switch (op) {
				case "+":
					st.push(x + y);
					break;
				case "-":
					st.push(x - y);
					break;
				case "/":
					st.push(x / y);
					break;
				case "*":
					st.push(x * y);
					break;
			}
		}
	}
	if (!st.empty()) {
		result = (int) st.pop();
	} else {
		result = 0;
	}
	return result;
}
public static void main(String args[]){
        /*
	     * The main program should print
	        5 3 + =8
            5 3 - = 2
            2 1 12 3 / - + = -1
            3 2 * 11 - = -5
	    */
	
	String[] argu= new String[]{"5","3","+"};
	int result = calculate(argu);
	System.out.println(result);
	System.out.println("5"+" 3"+" +"+" ="+ result);
	
	result = calculate(new String[]{"6","3","/"});
	System.out.println("6"+" 3"+" /"+" = "+ result);
	
	result = calculate(new String[]{"5","3","-"});
	System.out.println("5"+" 3"+" -"+" = "+ result);
	result = calculate(new String[]{"2","1","12","3","/", "-", "+"});
	System.out.println("2"+" 1"+" 12"+" 3"+" /"+ " -"+ " +"+" = "+ result);
	result = calculate(new String[]{"3", "2", "*", "11", "-"});
	System.out.println("3"+" 2"+" *"+" 11"+" -"+" = "+ result);
	
	System.out.println("this is " + "+".compareTo("+"));
}
}
