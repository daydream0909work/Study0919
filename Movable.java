
public interface Movable	 {
	default void move(Movable party){
		System.out.println("弾を撃つぞ！");
	}
}
