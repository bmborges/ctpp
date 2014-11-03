
public class TesteObject {
	public static void main(String[] args) {
		Object[][] o = new Object[1][3];
		o[0][0] = "id_teste";
		o[0][1] = "=";
		o[0][2] = "1";
		
		for (int i = 0; i < o.length; i++) {
			Object[] objects = o[i];
				for (int j = 0; j < objects.length; j++) {
					System.out.println(objects[j]);
				}
			
		}
	}
}
