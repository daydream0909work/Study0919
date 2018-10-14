
interface Movable {
	default void move(Character target){
		System.out.println("弾を撃つぞ！");
	}
}
