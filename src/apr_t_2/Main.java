package apr_t_2;

import java.util.ArrayList;
import java.util.Random;

import apr_t_2.Hajo.Orszag;

public class Main {
	public static ArrayList<Hajo> hajolista = new ArrayList<Hajo>();
	
	public static void main(String[] args) {
		Random random = new Random();
		for (int i = 0; i < 15; i++) {
			Hajo hajo = null;
			if (i < 10) {
				hajo = new Hajo(random.nextInt(100), random.nextInt(100), Orszag.szovjet);
			} else {
				hajo = new Hajo(random.nextInt(100), random.nextInt(100), Orszag.amcsi);
			}
			Main.hajolista.add(hajo);
		}
		
		for (Hajo h : Main.hajolista) {
			Thread thread = new Thread(h);
			thread.start();
			System.out.println("letrejott a hajo");


		}

		VorosOctober vo = new VorosOctober(random.nextInt(100), random.nextInt(100), Orszag.szovjet);
		Thread thread = new Thread(vo);
		thread.start();
		System.out.println("letrejott a voros october");

	}

}
