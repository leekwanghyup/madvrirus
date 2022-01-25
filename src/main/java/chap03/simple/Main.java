package chap03.simple;

public class Main {
	public static void main(String[] args) {
		BoardDao boardDao = new BoardDao();
		BoardService service = new BoardService(boardDao); 
		service.list();
	}
}
