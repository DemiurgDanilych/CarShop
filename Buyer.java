public class Buyer implements Runnable {
	private final AutoShop shop;
	private final int carsPurchased = 3;
	final long buyerWaiting = 1000;
	
	
	public Buyer(AutoShop shop) {
		this.shop = shop;
	}
	
	@Override
	public void run() {
		for (int i = 0; i <= carsPurchased; i++) {
			synchronized (shop) {
				try {
					System.out.println(Thread.currentThread().getName() + " зашел в автосалон");
					if (shop.getCars().size() == 0) {
						System.out.println("Машин нет!");
						shop.wait();
					}
					Thread.sleep(buyerWaiting);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + " уехал на новеньком авто");
				shop.getCars().remove(0);
			}
		}
	}
}

