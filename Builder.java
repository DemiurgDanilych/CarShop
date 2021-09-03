public class Builder implements Runnable {
	AutoShop shop;
	final long buildTime = 3000;
	
	public Builder(AutoShop shop) {
		this.shop = shop;
	}
	
	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(buildTime);
				System.out.println("Производитель Toyota выпустил 1 авто");
				synchronized (shop) {
					shop.getCars().add(new Car());
					shop.notify();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
