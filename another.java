import java.util.Random;

public class Another {

	public static  boolean deadflg = false;
	public static  int i;

	public static void main(String[] args) {


		//**味方チーム****************************
		Character3[] party;
		party= new Character3[3];


		party[0] = new Character3("勇者",450,10,200,false,false);
		party[1] = new Majyo("魔女",200,30,45,false,false);
		party[1].introduce();
		party[2] = new Monster("スライム",10,20,5,false,false);


		//**敵チーム****************************
		Character3[] enemy_party = new Character3[3];
		enemy_party[0] = new Character3("小ボス",100,50,30,false,false);
		enemy_party[1] = new Character3("中ボス",500,150,50,false,false);
		enemy_party[2] = new Character3("大ボス",1000,400,100,false,false);


		//どちらかのパーティーが絶滅するまで
		while(deadflg) {
			//敵、味方交代ずつ、攻撃する
			if(i%2 == 0) {

				if(party[0].deadcount == true && party[1].deadcount == true && party[2].deadcount == true) {
					System.out.println("勇者チームが全滅した！");
					deadflg = false;
				}else if(enemy_party[0].deadcount == true && enemy_party[1].deadcount == true && enemy_party[2].deadcount == true) {
					System.out.println("ボスチームが全滅した！");
					System.exit(0);

				}

				//勇者チーム
				for(int j = 0; j < party.length; j++) {
					//3人チームなので
					int number = random_attack(3);

						//1だったら敵１に攻撃
						if(number == 0 && enemy_party[0].deadcount == false) {
							party[j].attack(enemy_party[0]);
						//2だったら敵2に攻撃
 						}else if(number == 1 && enemy_party[1].deadcount == false){
							party[j].attack(enemy_party[1]);
						//3だったら敵3に攻撃
						}else if(number == 2 && enemy_party[2].deadcount  == false){
							party[j].attack(enemy_party[2]);
						}
					}

			}else {
					//敵チーム
					for(int k = 0; k < enemy_party.length; k++) {
						//3人チームなので
						int number = random_attack(3);
						//1だったら敵１に攻撃
						if(number == 0 && party[0].deadcount  == false) {
							enemy_party[k].attack(party[0]);
						//2だったら敵2に攻撃
						}else if(number == 1 && party[1].deadcount == false){
							enemy_party[k].attack(party[1]);
						//3だったら敵3に攻撃
						}else if(number == 2 && party[2].deadcount  == false){
							enemy_party[k].attack(party[2]);
					}
				}
			}

			//i = i +1;
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
