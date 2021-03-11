package controller;

import javax.swing.UIManager;

import view.MenuPrincipalView;

/**
 * Classe principal para executar o projeto
 * 
 * @author João Victor
 * @since 08/03/2021
 * @version 1.0
 */
public class Main {

	/*
//	 * método principal para executar a classe
	 */
	public static void main(String[] args) {

		/*
		 * configurando o estilo inicial do projeto
		 */
		try {

			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");

		} catch (Exception e) {

			e.printStackTrace();

		}

		// iniciando o menu principal
		new MenuPrincipalView().iniciaGui();
	}
}
