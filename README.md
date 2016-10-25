# CS477_lab_1
Step 1:
 Create a new Android project (can be called Lab1
or whatever you like).
 The first step is to modify activity_main.xml to
create a user inteface that has the same fields as the app
on the left. You can do the modification directly in xml
or using a graphical tool. Examples of all of these
different things (TextView, EditText, Button,
RadioButton) can be found in the slides.
 You can use either multiple LinearLayouts or a
RelativeLayout to place the widgets on the screen.
 It doesn’ t need to look exactly the same EXCEPT
that I want you to use radio buttons for the different
formats and a table format for the results – see the slides
or HelloTable online (Sample Code->UI Examples->Basic)
if you want to try this.
 Be sure to put your name somewhere on the
screen.
 Run your app. It won’t be able to do anything
but should have the same stuff on the screen (except for
the actual values).
Step 2:
 Now we are going to do some simple wiring. In your XML layout, add identifiers to each of the
widgets you are going to use. For example, android:id=”@+id/input_value” could be used for
the first EditText widget.
 There are examples of dealing with radio buttons on the slides. I used this to set the ‘base’ for a
given input to 2,8,10 or 16.
 Add a listener to the ‘convert’ button that uses Integer.parseInt(numberstring,base) to convert
the input to the base specified by the radio buttons. Note that until you do the step below, the
app will die if you try to do this conversion on an illegal input. Using this value, I used string
functions toHexString, toOctalString, toBinaryString to output the correct format.
 Test your code by running the app and playing with it a little.
 
Step 3:
A better version does the following two things:
 Error checking: You may have noticed that parseInt raises an exception if the input string is
illegal for the given base. Add exception handling to prevent the app dying and use Toast to
provide an error message, like below. An example of Toast is in the slides.
 Control the legal input: For binary, octal and decimal, we only need integer input. You control
the keyboard in the java code by using:
inputNum.setInputType(InputType.TYPE_CLASS_NUMBER); and
inputNum.setInputType(InputType.TYPE_CLASS_TEXT);
