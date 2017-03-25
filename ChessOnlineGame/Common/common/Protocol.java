package common;

public interface Protocol {
	
	public static final int COMMAND_PORT=9896;
	public static final int MESSAGE_PORT=9895;
	
	public static final int RQ_CONNECT=102;
	public static final int RQ_DISCONNECT=103;
	public static final int RQ_MOVE=1010;
	public static final int RQ_PIECES=52;
	public static final int RQ_FIND_GAME=545;
	
	
	public static final int RP_OK=10;
	public static final int RP_KO=20;
	public static final int RP_PIECES=506;
	public static final int RP_MOVED_PIECE=1542;
}
