package ex5_instance_array;

public class MainClass {

	public static void main(String[] args) {

		Producer producer = new Producer("jyp");
		
		Singer singer = new Singer("선미", 3);
		
		producer.produce(singer, new Song("꼬리", "댄스", 3.5));
		producer.produce(singer, new Song("꽃같네", "댄스", 4.0));
		producer.produce(singer, new Song("보라빛밤", "댄스", 4.5));
		
		singer.singerInfo();
		
		singer.deleteSong("꽃같네");
		
		singer.singerInfo();
		
	}

}
