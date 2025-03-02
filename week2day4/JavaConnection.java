package week2.day4;

public class JavaConnection extends MySQLConnection {

	public static void main(String[] args) {
		JavaConnection java1 = new JavaConnection();
		java1.connect();
		java1.disconnect();
		java1.executeUpdate();
		java1.executeQuery();
		
}

	@Override
	public void connect() {
		System.out.println("Connected to the database");
		// TODO Auto-generated method stub
		
	}

	@Override
	public void disconnect() {
		System.out.println("Disconnected from the database");
		// TODO Auto-generated method stub
		
	}

	@Override
	public void executeUpdate() {
		System.out.println("Execute is updated");
		// TODO Auto-generated method stub
		
	}

	@Override
	public void executeQuery() {
		System.out.println("Queries will be executed");
		// TODO Auto-generated method stub
		
	}

	}
