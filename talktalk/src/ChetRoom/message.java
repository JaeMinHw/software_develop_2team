package ChetRoom;

import java.io.Serializable;

public class message implements Serializable {
	private static final long serialVersionUID = 1001L;

	public String type;
	public String msg;
	public User who;
}