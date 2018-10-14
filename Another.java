import java.util.Random;

public class Another {

	public static  boolean deadflg = true;
	static int i = 0;

	public static void main(String[] args) {
		Machibito a = new Machibito();

		//**味方チーム****************************
		//Character3[] party = new Character3[3];
		Machibito[] party = new Character3[3];
		party[0]=  new Yusya("勇者",300,40,60,false);
		party[1] = new Majyo("魔女",200,30,45,false);
		party[2] = new Monster("スライム",10,20,5,false);

		//勇者
		party[0].introduce();
		party[0].damage(10);

		//魔女
		party[1].introduce();
		party[1].damage(10);

		//スライム
		party[2].introduce();
		party[2].damage(20);


		//**敵チーム****************************
		Character3[] enemy_party = new Character3[3];
		enemy_party[0] = new Boss1("小ボス",100,50,30,false);
		enemy_party[1] = new Boss2("中ボス",500,150,50,false);
		enemy_party[2] = new Boss3("大ボス",1000,400,100,false);

		//小ボス
		enemy_party[0].damage(5);

		//中ボス
		enemy_party[0].damage(10);

		//大ボス
		enemy_party[0].damage(15);

		a.move(party[2]);
		a.attack(party[0]);

		//どちらかのパーティーが絶滅するまで
		while(deadflg) {

			//敵、味方交代ずつ、攻撃する
			if(i%2 == 0) {
				if(party[0].deadflg == true && party[1].deadflg == true && party[2].deadflg == true) {
					System.out.println("勇者チームが全滅した！");
					deadflg = false;
					System.exit(0);
				}else if(enemy_party[0].deadflg == true && enemy_party[1].deadflg == true && enemy_party[2].deadflg == true) {
					System.out.println("ボスチームが全滅した！");
					deadflg = false;
					System.exit(0);
				}

				//勇者チーム
				for(int j = 0; j < party.length; j++) {
					//3人チームなので
					int number = random_attack(3);

						//1だったら敵１に攻撃
						if(number == 0 && enemy_party[0].deadflg == false) {
							party[j].attack(enemy_party[0]);
						//2だったら敵2に攻撃
 						}else if(number == 1 && enemy_party[1].deadflg == false){
							party[j].attack(enemy_party[1]);
						//3だったら敵3に攻撃
						}else if(number == 2 && enemy_party[2].deadflg  == false){
							party[j].attack(enemy_party[2]);
						}
					}

			}else {
					//敵チーム
					for(int k = 0; k < enemy_party.length; k++) {
						//3人チームなので
						int number = random_attack(3);
						//1だったら敵１に攻撃
						if(number == 0 && party[0].deadflg  == false) {
							enemy_party[k].attack(party[0]);
						//2だったら敵2に攻撃
						}else if(number == 1 && party[1].deadflg == false){
							enemy_party[k].attack(party[1]);
						//3だったら敵3に攻撃
						}else if(number == 2 && party[2].deadflg  == false){
							enemy_party[k].attack(party[2]);
					}
				}
			}

			i++;
		}

	}

	private static int random_attack(int j) {
		//ランダムメソッドで入力する。
		Random rnd = new Random();
		int randomNumber_2 = rnd.nextInt(j);
		return randomNumber_2;
	}
}
