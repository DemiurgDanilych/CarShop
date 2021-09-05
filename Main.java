public class Main {
	public static void main(String[] args) {
		
		final AutoShop shop = new AutoShop();
		
		new Thread(new Buyer(shop),"Покупатель 1").start();
		new Thread(new Buyer(shop),"Покупатель 2").start();
		new Thread(new Buyer(shop),"Покупатель 3").start();
		
		new Thread(new Builder(shop),"Производитель Toyota ").start();
	}
}
