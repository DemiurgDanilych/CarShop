public class Builder implements Runnable {
	private final AutoShop shop;
	private static final long BUILDTIME = 3000;
	
	public Builder(AutoShop shop) {
		this.shop = shop;
	}
	
	@Override
	public void run() {
		try {
			for (int i = 0; i < 9; i++) {
				Thread.sleep(BUILDTIME);
				System.out.println("Производитель Toyota выпустил 1 авто");
				synchronized (shop) {
					shop.getCars().add(new Car());
					shop.notify();
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}
