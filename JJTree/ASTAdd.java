/* Generated By:JJTree: Do not edit this line. ASTAdd.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
public
class ASTAdd extends SimpleNode {
  public String operator = "+"; 

  public ASTAdd(int id) {
    super(id);
  }

  public ASTAdd(eg2 p, int id) {
    super(p, id);
  }

  public String toString() {
    return operator;
  }

  public SimpleNode reduce() {
    SimpleNode leftSubExpr = (SimpleNode)jjtGetChild(0);
    SimpleNode rightSubExpr = (SimpleNode)jjtGetChild(1);

    SimpleNode reducedLeftSubExpr = leftSubExpr.reduce(); // Recursively reduce the left sub expression
    SimpleNode reducedRightSubExpr = rightSubExpr.reduce(); // Recursively reduce the right sub expression
 
    SimpleNode reducedExpr = null;
    if (reducedLeftSubExpr instanceof ASTInteger && reducedRightSubExpr instanceof ASTInteger) { // case that can be reduced
      int sum =((ASTInteger)reducedLeftSubExpr).getInt() + ((ASTInteger)reducedRightSubExpr).getInt(); // Create a new ASTInteger node for the sum
      reducedExpr = new ASTInteger(5);
      ((ASTInteger)reducedExpr).setVal(sum);
    } else { // case that cannot be reduced
     reducedExpr = this;
     jjtAddChild(reducedLeftSubExpr, 0);
     jjtAddChild(reducedRightSubExpr, 1);
    }  
    return reducedExpr;
  }  

}
/* JavaCC - OriginalChecksum=dfc727c98a103927d9c8a752c6232c73 (do not edit this line) */
