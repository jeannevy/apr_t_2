package apr_t_2;

import java.util.Random;

public class Hajo implements Runnable {
	enum Orszag {
		amcsi, szovjet;
	}
	protected static boolean kapcsolat = false;
	
	protected Orszag o;
	protected int sor = 0;
	protected int oszlop = 0;
	int celsor;
	int celoszlop;
	

	public Hajo(int s, int o, Orszag or) {
		this.sor = s;
		this.oszlop = o;
		this.o = or;
	}
	
	public Orszag getOrszag() {
		return this.o;
	}
	
	public int getSor() {
		return this.sor;
	}
	public int getOszlop() {
		return this.oszlop;
	}
	
	public void setSor(int s) {
		this.sor = s;
	}
	
	public void setOszlop(int o) {
		this.oszlop = o;
	}
	public void setOszag(Orszag o) {
		this.o = o;
	}
	
	public void haladOszlop() {
		if (celoszlop < this.oszlop) {
			this.oszlop -= 1;
		} else if (celoszlop > this.oszlop) {
			this.oszlop += 1;
		}
		
	}

	protected void haladSor() {
		if (celsor < this.sor) {
			this.sor -= 1; 
		}
		else { if (celsor > this.sor) {
			this.sor += 1;
		}
		else {
			return;
		}
		}
	}
	
	public void halad() {
		if (this.sor != celsor) {
			this.haladSor();
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		if (this.oszlop != celoszlop) {
			this.haladOszlop();
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void setKapcsolat() {
		Hajo.kapcsolat = true;
	}
	
	public void ujcel() {
		Random r = new Random();
		this.celsor = r.nextInt(100);
		this.celoszlop = r.nextInt(100);
		System.out.println(this.celsor + ", " + this.celoszlop);
	}
	
	
	
	public void run() {
		while (Hajo.kapcsolat == false) {
			this.ujcel();
			
			while (Math.abs(this.sor-this.celsor) < 2 && Math.abs(this.oszlop-this.celoszlop) < 2) {
				this.halad();
			}
			
		}
	}
	
	
	
}
