
public class Tes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//D:\Tomcat 6.0\webapps\jyk\excel\odi.bat
		//D:\\Program Files\\Java\\Tomcat 6.0\\webapps\\jyk\\excel\\excel\\odi.bat
		String batPath = "D:\\Tomcat 6.0\\webapps\\jyk\\excel\\odi.bat";
		ProcessBuilder pb = new ProcessBuilder();
		System.out.println(pb);
		pb.command(batPath);
		System.out.println(batPath);
		Process p;
		try {
			p = pb.start();
			p.waitFor();
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		System.out.println("continue");
	}

}
