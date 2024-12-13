Step 1: Run the Calculator Program
Ensure you have Java installed on your system.
Save the provided code in a file named Calculator.java.
Compile the program:
Open a terminal or command prompt.
Navigate to the folder containing the file.
Run the command: javac Calculator.java.
Execute the program:
Run the command: java Calculator.
The calculator window will open.

Step 2: Understand the Calculator Interface
Display Area: At the top, a text field shows the numbers you input and the results of your calculations.
Buttons:
Numbers (0-9): To input numbers.
Operators (/ * - +): To perform division, multiplication, subtraction, or addition.
C: To clear the current input or reset the calculator.
=: To compute the result.
Step 3: Perform a Calculation
Input the First Number:

Click the numeric buttons (0-9) to type the first number.
Example: Click 7, the display will show 7.
Select an Operator:

Click one of the operator buttons (/, *, -, +) for the desired operation.
Example: Click +, the display will clear.
Input the Second Number:

Click the numeric buttons to type the second number.
Example: Click 3, the display will show 3.
Get the Result:

Click the = button.
Example: The result (10 in this case) will appear in the display.
Step 4: Handle Special Scenarios
Clear Input: Click C to reset everything.
Error Handling:
Division by Zero: If you try to divide by zero, the display will show Error.
Invalid Operations: If there’s an error during computation, it will display Error.
Step 5: View Calculation History
Each calculation is saved in a file named calculator_history.txt located in the same directory as the program.
Open this file with a text editor to review your calculations.
Example Walkthrough:
Perform 7 + 3:

Click 7.
Click +.
Click 3.
Click =.
The display will show 10.
Clear the screen:

Click C.
Perform 8 / 0:

Click 8.
Click /.
Click 0.
Click =.
The display will show Error.
