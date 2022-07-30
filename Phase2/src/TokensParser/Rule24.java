package TokensParser;

import java.util.Queue;

import GenTokens.Token;

public class Rule24 implements Node
{
	int isRight;
	Token token;
	
	public Rule24() 
	{
	}
	
	void def()
	{
		isRight = 0;
		token = new Token();
	}

	public void Print(String space)
	{
		if(isRight == 1)
		{
			System.out.println(space + "Rule24 : NULL");
			return;
		}
		
		if(isRight == 2)
		{
			System.out.println(space + "Rule24 : Syntex Error");
			return;
		}

		System.out.println(space + "Rule24 :");
		
		space += "	";

		System.out.println(space + token.Type + " : " + token.Value);
	}

	public void Run(Queue<Token> q) 
	{
		def();

		if(Check(q.peek().Type))
		{
			token = q.peek();
			q.poll();
		}
		else
			isRight = 2;		
	}

	boolean Check(String s)
	{
		return s.equals("<AND>") || s.equals("<PLUS>") || s.equals("<EQUAL>") || s.equals("<NOT_EQUAL>")
				|| s.equals("<OR>") || s.equals("<MINUS>") || s.equals("<MULTIPLY>") || s.equals("<DIV>")
				|| s.equals("<LESSTHAN>") || s.equals("<GREATERTHAN>") || s.equals("<LESS_EQ>") || s.equals("<GREATER_EQ>"); 
	}
}
