package ex5_instance_array;

public class Producer {

	private String name;

	public Producer(String name) {
		super();
		this.name = name;
	}

	public void produce(Singer singer, Song song) {
		singer.addSong(song);
	}
	
}
