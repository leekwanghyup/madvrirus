package chap03.simple;

public class BoardService {
	
	private BoardDao boardDao;
	
	public BoardService(BoardDao boardDao) {
		this.boardDao = boardDao;
	}

	public void list() {
		System.out.println("BoardService 객체 사용");
		boardDao.list();
	}
}
