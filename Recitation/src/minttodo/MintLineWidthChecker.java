package minttodo;

public class MintLineWidthChecker extends MintSingleLineChecker {
  // **** TODO ****
  // Constructor

  // **** TODO ****
  // Constructor with maxWidth parameter.

  // **** TODO ****
  // Constructor with both maxWidth and tabSize parameters.

  // **** TODO ****
  // Override checkLine()

  // A helper method to set the error message.
  private void setErrorMessage() {
    errorMessage = "Line width exceeded " + maxWidth + " characters.";
  }
  
  private int maxWidth;
  private int tabSize;
@Override
public boolean checkLine(String line) {
	// TODO Auto-generated method stub
	return false;
}
}
