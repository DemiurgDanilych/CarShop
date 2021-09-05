public class Buyer implements Runnable {
	private final AutoShop shop;
	private static final int CARSPURCHASED = 2;
	private static final long BUYERWAITING = 1000;
	
	
	public Buyer(AutoShop shop) {
		this.shop = shop;
	}
	
	@Override
	public void run() {
		for (int i = 0; i <= CARSPURCHASED; i++) {
			synchronized (shop) {
				try {
					System.out.println(Thread.currentThread().getName() + " зашел в автосалон");
					if (shop.getCars().size() == 0) {
						System.out.println("Машин нет!");
						shop.wait();
					}
					Thread.sleep(BUYERWAITING);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + " уехал на новеньком авто");
				shop.getCars().remove(0);
			}
		}
	}
}

