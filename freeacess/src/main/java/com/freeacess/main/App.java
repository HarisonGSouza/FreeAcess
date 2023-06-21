package com.freeacess.main;

import java.util.Locale;

import java.awt.EventQueue;

public class App {

	public static void main(String[] args) {

		Locale.setDefault(new Locale("tr", "TR"));

		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {

				new Login();

			}
		});

	}

}