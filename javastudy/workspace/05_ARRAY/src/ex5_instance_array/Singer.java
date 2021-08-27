package ex5_instance_array;

public class Singer {

	private String name;
	private Song[] songs;
	private int idx;
	
	public Singer(String name, int songCount) {
		this.name = name;
		songs = new Song[songCount];
	}
	
	// 노래 추가
	public void addSong(Song song) {	
		if (idx == songs.length) {
			System.out.println("Full!");
			return;
		}
		songs[idx++] = song;
	}
	// 노래 제거
	public void deleteSong(String title) {
		if (idx == 0) {
			System.out.println("Empty!");
			return;
		}
		for (int i = 0; i < idx; i++) {
			if (songs[i].getTitle().equals(title)) {
				for (int j = i + 1; j < idx; j++) {
					songs[j - 1] = songs[j];
				}
				songs[--idx] = null;
			}
		}
	}
	// 가수 정보
	public void singerInfo() {
		System.out.println("가수명: " + name);
		System.out.println("=====노래목록=====");
		for (int i = 0; i < idx; i++) {
			songs[i].songInfo();
		}
	}
	
}
