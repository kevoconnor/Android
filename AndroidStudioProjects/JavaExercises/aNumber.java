// Exercise 1 in Control Flow Statements

public class aNumber{
    public static void main(String [] args){	
	int aNumber = 3;
	if (aNumber >= 0){
            if (aNumber == 0){
                System.out.println("first string");
            }else{ 
		System.out.println("second string");
            }
 	}
        System.out.println("third string");
    }
}

/*
A. If aNumber is 3, the output will be both "second string" and "third string" since the second string is contained in the else statement, and the third string is outside of the if statements so it is always printed.

B. The output is "second string" and "third string", which is what I predicted. Like I said before, the reason this happens is since there are no braces around the if and else statements, the second string is printed out in the else, and the third string is outside, causing it to always print out.

C. Done.

D. Done.
*/
