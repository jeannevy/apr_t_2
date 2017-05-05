package apr_t_2;

import java.util.Random;

import apr_t_2.Hajo;

public class VorosOctober extends Hajo {

	public VorosOctober(int s, int o, Orszag or) {
		super(s, o, or);
	}
	
	public void halad() {
		if (this.getSor() != celsor) {
			this.haladSor();
			try {
				Thread.sleep(120);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		if (this.getOszlop() != celoszlop) {
			this.haladOszlop();
			try {
				Thread.sleep(120);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		for (Hajo haj: Main.hajolista) {
			if (Math.abs(this.getSor()-haj.getSor()) <= 10 && Math.abs(this.getOszlop()-haj.getOszlop()) <= 10 && haj.o == Orszag.amcsi ) {
				System.out.println(haj.getOszlop() + ", " + haj.getSor() + ", voros: " + this.getSor() + ", " + this.getOszlop());
				Random r = new Random();
				
				int rint = r.nextInt(10);
				if (rint < 3) {
					System.out.println("sikerult megmenekulni");
					Hajo.setKapcsolat();
					VorosOctober.setKapcsolat();
				}
			}
		}
	}
}
