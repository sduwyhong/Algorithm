package MyAlgs;
//写一个Singleton出来。
class Singleton{
	private static Singleton singleton;
	private Singleton(){}
	public Singleton getInstance() {
		if(singleton == null) {
			singleton = new Singleton();
			return singleton;
		}else{
			return singleton;
		}
	}
}