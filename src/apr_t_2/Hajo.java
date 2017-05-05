package apr_t_2;

import java.util.Random;

public class Hajo implements Runnable {
	enum Orszag {
		amcsi, szovjet;
	}
	protected Orszag orszag;

	volatile protected static boolean kapcsolat = false;
	
	protected int x = 0;
	protected int y = 0;
	
	private int celX;
	private int celY;
	

	public Hajo(int x, int y, Orszag orszag) {
		this.x = x;
		this.y = y;
		this.orszag = orszag;
	}
	
	public Orszag getOrszag() {
		return this.orszag;
	}
	public void setOszag(Orszag o) {
		this.orszag = o;
	}
	
	public void setPozicio(int x, int y) {
		synchronized(this) {
			this.x = x;
			this.y = y;
		}
	}
	public int[] getPozicio() {
		synchronized(this) {
			return new int[]{this.x, this.y};
		}
	}

	protected void lepes() {
		if (celX < this.x && celY < this.y) { // del nyugat
			this.setPozicio(this.x-1, this.y-1);
		} else if (celX > this.x && celY > this.y) { // eszak kelet
			this.setPozicio(this.x+1, this.y+1);
		} else if (celX < this.x && celY > this.y) { // eszak nyugat
			this.setPozicio(this.x-1, this.y+1);
		} else if (celX > this.x && celY < this.y) { // del kelet
			this.setPozicio(this.x+1, this.y-1);
		} else if (celX == this.x && celY > this.y) { // eszak
			this.setPozicio(this.x, this.y+1);
		} else if (celX == this.x && celY < this.y) { // del
			this.setPozicio(this.x, this.y-1);
		} else if (celX < this.x && celY == this.y) { // nyugat
			this.setPozicio(this.x-1, this.y);
		} else if (celX > this.x && celY == this.y) { // kelet
			this.setPozicio(this.x+1, this.y);
		}

	}
	
	protected void halad() {
		this.lepes();
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
	
	public static void setKapcsolat() {
		Hajo.kapcsolat = true;
	}
	
	public void ujcel() {
		Random r = new Random();
		this.celY = r.nextInt(100);
		this.celX = r.nextInt(100);
		System.out.println(this.celY + ", " + this.celX);
	}
	
	
	
	public void run() {
		while (Hajo.kapcsolat == false) {
			this.ujcel();
			
			while (Math.abs(this.y-this.celY) > 1 || Math.abs(this.x-this.celY) > 1) {
				this.halad();
				if (Hajo.kapcsolat == true) {
					System.out.println("leallitottam a szalat: " + Thread.currentThread().toString());
					return;
				}
					
			}
			
		}
	}
	
	
	
}
