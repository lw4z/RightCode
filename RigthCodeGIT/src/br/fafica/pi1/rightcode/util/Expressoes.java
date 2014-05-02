package br.fafica.pi1.rightcode.util;
public class Expressoes {

	public static void main(String[] args) {
		
		
		String teste = "public static void main(String args){"
				+ " if(teste ==null){"
				+ "synchronized (Singleton.class) {"
				+ " if(teste2 == null){"
				+ "instance = new Singleton();"
				+ "return instance;"
				+ "}";
		
		String teste2 = "public class Singleton {"
				+ "private static Singleton instance = new Singleton();"
				+ "private int quantidade = 0;"
				+ ""
				+ "private Singleton() {"
				+ "quantidade++;"
				+ "return instance;"
				+ "}";
		
		String teste3 = "public class Singleton {"
				+ ""
				+ "private static Singleton instance;"
				+ "private int quantidade = 0;"
				+ ""
				+ "private Singleton() {"
				+ "public static synchronized Singleton getInstance() {"
				+ ""
				+ "if (instance == null)"
				+ "instance = new Singleton();"
				+ "return instance;";
		
		boolean resultado = teste.matches("^.*if.*[==.null|==null].*synchronized.*class.*if.*[==.null|==null].*[=new|= new].*return.*");
		boolean resultado2 = teste2.matches("^.*[private static].*[=new|= new].*private static Singleton.*return.*");
		boolean resultado3 = teste3.matches("^.*[private static].*[public static synchronized].*if.*[==.null|==null].*[=new|= new].*return.*");		
				
		System.out.println("Teste1 = " + resultado);
		System.out.println("Teste2 = " + resultado2);
		System.out.println("Teste3 = " + resultado3);
		
	}

}
