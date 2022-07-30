package TokensParser;

import java.util.Queue;

import GenTokens.Token;

public interface Node
{
	public void Print(String space);
	public void Run(Queue<Token> q);
}
