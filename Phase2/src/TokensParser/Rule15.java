package TokensParser;

import java.util.Queue;

import GenTokens.Token;

public class Rule15 implements Node
{
	int isRight;
	Token token;
	Rule16 rule16;
	
	public Rule15() 
	{
	}

	void def()
	{
		isRight = 0;
		token = new Token();
		rule16 = new Rule16();
	}

	public void Print(String space)
	{
		if(isRight == 1)
		{
			System.out.println(space + "Rule15 : NULL");
			return;
		}
		
		if(isRight == 2)
		{
			System.out.println(space + "Rule15 : Syntex Error");
			return;
		}

		System.out.println(space + "Rule15 :");
		
		space += "	";
		
		System.out.println(space + token.Type + " : " + token.Value);
		
		rule16.Print(space);		
	}

	public void Run(Queue<Token> q)
	{
		def();
		
		 if(q.peek().Type.equals("<INT>"))
		 {
			 token = q.peek();
			 q.poll();
			 
			 rule16.Run(q);
			 
			 if(rule16.isRight == 2)
				 isRight = 2;
		 }
		 
		 else if(q.peek().Type.equals("<BOOLEAN>"))
		 {
			 token = q.peek();
			 q.poll();
			 
			 rule16.Run(q);
			 
			 if(rule16.isRight == 2)
				 isRight = 2;
		 }
		 
		 else if(q.peek().Type.equals("<FLOAT>"))
		 {
			 token = q.peek();
			 q.poll();
			 
			 rule16.Run(q);
			 
			 if(rule16.isRight == 2)
				 isRight = 2;
		 }
		 
		 else if(q.peek().Type.equals("<STRING>"))
		 {
			 token = q.peek();
			 q.poll();
			 
			 rule16.Run(q);
			 
			 if(rule16.isRight == 2)
				 isRight = 2;
		 }

		 else if(q.peek().Type.equals("<CHARACTER>"))
		 {
			 token = q.peek();
			 q.poll();
			 
			 rule16.Run(q);
			 
			 if(rule16.isRight == 2)
				 isRight = 2;
		 }

		 else
			 isRight = 2;		
	}

}
