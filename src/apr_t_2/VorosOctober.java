package apr_t_2;

import java.util.Random;

import apr_t_2.Hajo;

public class VorosOctober extends Hajo {

	public VorosOctober(int s, int o, Orszag or) {
		super(s, o, or);
	}
	
	public void halad() {
		try {
			Thread.sleep(120);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.lepes();

		for (Hajo hajo: Main.hajolista) {
			int[] hajoPoz = hajo.getPozicio();
			int hajoX = hajoPoz[0];
			int hajoY = hajoPoz[1];
			if (Math.abs(this.y-hajoY) <= 10 && Math.abs(this.x-hajoX) <= 10 && hajo.orszag == Orszag.amcsi ) {
				System.out.println(hajoX + ", " + hajoY+ ", voros: " + this.y + ", " + this.x);
				Random r = new Random();
				
				int rint = r.nextInt(10);
				if (rint < 3) {
					System.out.println("sikerult megmenekulni");
					Hajo.setKapcsolat();
					break;
				}
			}
		}
	
	}
}
