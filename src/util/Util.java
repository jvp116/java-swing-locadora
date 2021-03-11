package util;

/**
 * Classe auziliar para armazenar métodos de conversão de daods
 * 
 * @author João Victor
 * @since 09/03/2021
 * @version 1.0
 */
public class Util {

	/*
	 * método para converter uma String em inteiro
	 */
	public static Integer getInt(String args) {
		return Integer.parseInt(args);
	}

	/*
	 * método para converter uma String em double
	 */
	public static Double getDouble(String args) {
		return Double.parseDouble(args);
	}

	public static Boolean getBoolean(String args) {
		return Boolean.parseBoolean(args);
	}

}