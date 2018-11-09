package stat;

import java.io.IOException;
import fr.afpa.stage.tools.Mp3Manager;

public class MainMp3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Mp3Manager mp = null;

		try {
			mp = new Mp3Manager("file/muzik.mp3");
			String title = mp.getTitle();
			String artist = mp.getArtist();
			String album = mp.getAlbum();
			String year = mp.getYear();
			String comment = mp.getComment();
			String genre = mp.getGenre();

			System.out.println("Titre = " + title + " Auteur = " + artist + " Album = " + album + " Year = " + year
					+ " Comment = " + comment + " Genre = " + genre);

			mp.setTitle("Le petit lapin");
			mp.setArtist("Moi-meme");
			mp.setAlbum("Au pays des bestioles");
			mp.setYear("1964");
			mp.writeTags();
			mp.readTags();

			mp.setTitle("Acid Spit");
			mp.setArtist("Mega Drive");
			mp.setAlbum("1985");
			mp.setYear("2015");
			mp.writeTags();
			mp.readTags();

			mp.setTitle(title);
			mp.setArtist(artist);
			mp.setAlbum(album);
			mp.setYear(year);
			mp.writeTags();
			mp.readTags();

			System.out.println(mp.toString());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Mp3ManagerException mm) {
			mm.printStackTrace();
		} finally {
			try {
				mp.closeFile();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}