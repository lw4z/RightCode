package br.fafica.pi1.rightcode.util;

public class ExpressoesTeste {

	 public static void main(String[] args) {
	  
	  
	  String teste = "public static void main(String args){"
	    + " if(teste == null){"
	    + "Sincronized{"
	    + " if(teste2 == null){"
	    + "resultado de boolean"
	    + "}";
	  
	  boolean resultado = teste.matches("^.*if.*==.null.*Sincronized.*if.*==.null.*");
	  
	  System.out.println(resultado);
	 }

	}