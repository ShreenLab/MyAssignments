package week2.day4;

public abstract class MySQLConnection implements DatabaseConnection {
	public abstract void executeQuery();
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}


	public abstract void connect();


	public abstract void disconnect();


	public abstract void executeUpdate();
	

}
