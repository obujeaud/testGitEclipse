package fr.afpa.stage.tools;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import stat.Mp3ManagerException;

public class Mp3Manager {

	private File f;
	private RandomAccessFile rf;

	private String leTag;
	private String leTitle;
	private String leArtist;
	private String leAlbum;
	private String leYear;
	private String leComment;
	private String leGenre;

	// Create a new RandomAccessFile and read all fields
	public Mp3Manager(String unF) throws FileNotFoundException, IOException, Mp3ManagerException {
		f = new File(unF);
		rf = new RandomAccessFile(f, "rw");
		readTags();
	}

	// Read all descriptions (artist, title, ...) of the music
	public void readTags() throws IOException {
		String res = getTag() + "\nTitre = " + getTitle() + "\nArtiste = " + getArtist() + "\nAlbum = " + getAlbum()
				+ "\nAnnée de parution = " + getYear() + "\nCommentaire = " + getComment() + "\nGenre = " + getGenre();
		System.out.println();
		System.out.println(res);
		System.out.println();
	}

	// Replace all fields with attributes changed thanks to set methods
	public void writeTags() throws IOException {

		long length = rf.length() - MyLength.LENGTH_FILE.getValue() + MyLength.SEEK_TITLE.getValue();
		rf.seek(length);
		rf.write(this.leTitle.getBytes());

		length = rf.length() - MyLength.LENGTH_FILE.getValue() + MyLength.SEEK_ARTIST.getValue();
		rf.seek(length);
		rf.write(this.leArtist.getBytes());

		length = rf.length() - MyLength.LENGTH_FILE.getValue() + MyLength.SEEK_ALBUM.getValue();
		rf.seek(length);
		rf.write(this.leAlbum.getBytes());

		length = rf.length() - MyLength.LENGTH_FILE.getValue() + MyLength.SEEK_YEAR.getValue();
		rf.seek(length);
		rf.write(this.leYear.getBytes());

		length = rf.length() - MyLength.LENGTH_FILE.getValue() + MyLength.SEEK_COMMENT.getValue();
		rf.seek(length);
		rf.write(this.leComment.getBytes());

		length = rf.length() - MyLength.LENGTH_FILE.getValue() + MyLength.SEEK_GENRE.getValue();
		rf.seek(length);
		rf.write(this.leGenre.getBytes());
	}

	// Show the tag field
	public String getTag() throws IOException {
		byte[] bt = new byte[MyLength.LENGTH_TAG.getValue()];

		try {
			long len = f.length() - MyLength.LENGTH_FILE.getValue();
			rf.seek(len);
			rf.read(bt);
			this.leTag = new String(bt, "UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return this.leTag;
	}

	// Show the title field
	public String getTitle() throws IOException {
		byte[] bt = new byte[MyLength.LENGTH_TITLE.getValue()];

		try {
			long len = f.length() - MyLength.LENGTH_FILE.getValue();
			rf.seek(len + MyLength.SEEK_TITLE.getValue());
			rf.read(bt);
			this.leTitle = new String(bt, "UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return this.leTitle;
	}

	// Show the artist field
	public String getArtist() throws IOException {
		byte[] bt = new byte[MyLength.LENGTH_ARTIST.getValue()];

		try {
			long len = f.length() - MyLength.LENGTH_FILE.getValue();
			rf.seek(len + MyLength.SEEK_ARTIST.getValue());
			rf.read(bt);
			this.leArtist = new String(bt, "UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return this.leArtist;
	}

	// Show the album field
	public String getAlbum() throws IOException {
		byte[] bt = new byte[MyLength.LENGTH_ALBUM.getValue()];

		try {
			long len = f.length() - MyLength.LENGTH_FILE.getValue();
			rf.seek(len + MyLength.SEEK_ALBUM.getValue());
			rf.read(bt);
			this.leAlbum = new String(bt, "UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return this.leAlbum;
	}

	// Show the year field
	public String getYear() throws IOException {
		byte[] bt = new byte[MyLength.LENGTH_YEAR.getValue()];

		try {
			long len = f.length() - MyLength.LENGTH_FILE.getValue();
			rf.seek(len + MyLength.SEEK_YEAR.getValue());
			rf.read(bt);
			this.leYear = new String(bt, "UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return this.leYear;
	}

	// Show the comment field
	public String getComment() throws IOException {
		byte[] bt = new byte[MyLength.LENGTH_COMMENT.getValue()];

		try {
			long len = f.length() - MyLength.LENGTH_FILE.getValue();
			rf.seek(len + MyLength.SEEK_COMMENT.getValue());
			rf.read(bt);
			this.leComment = new String(bt, "UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return this.leComment;
	}

	// Show the genre field
	public String getGenre() throws IOException {
		byte[] bt = new byte[MyLength.LENGTH_GENRE.getValue()];

		try {
			long len = f.length() - MyLength.LENGTH_FILE.getValue();
			rf.seek(len + MyLength.SEEK_GENRE.getValue());
			rf.read(bt);
			this.leGenre = new String(bt, "UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return this.leGenre;
	}

	// Replace the title with entered String
	public void setTitle(String newTitle) throws IOException {

		try {
			long len = f.length() - MyLength.LENGTH_FILE.getValue();
			rf.seek(len + MyLength.SEEK_TITLE.getValue());
			if (newTitle.length() < MyLength.LENGTH_TITLE.getValue()) {
				int longManquant = MyLength.LENGTH_TITLE.getValue() - newTitle.length();
				for (int a = 0; a < longManquant; a++) {
					newTitle += " ";
				}
			}
			this.leTitle = newTitle;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Replace the artist name with entered String
	public void setArtist(String newArtist) throws IOException {

		try {
			long len = f.length() - MyLength.LENGTH_FILE.getValue();
			rf.seek(len + MyLength.SEEK_ARTIST.getValue());
			if (newArtist.length() < MyLength.LENGTH_ARTIST.getValue()) {
				int longManquant = MyLength.LENGTH_ARTIST.getValue() - newArtist.length();
				for (int a = 0; a < longManquant; a++) {
					newArtist += " ";
				}
			}
			this.leArtist = newArtist;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Replace the album name with entered String
	public void setAlbum(String newAlbum) throws IOException {

		try {
			long len = f.length() - MyLength.LENGTH_FILE.getValue();
			rf.seek(len + MyLength.SEEK_ALBUM.getValue());
			if (newAlbum.length() < MyLength.LENGTH_ALBUM.getValue()) {
				int longManquant = MyLength.LENGTH_ALBUM.getValue() - newAlbum.length();
				for (int a = 0; a < longManquant; a++) {
					newAlbum += " ";
				}
			}
			this.leAlbum = newAlbum;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Replace the year with entered String
	public void setYear(String newYear) throws IOException {

		try {
			long len = f.length() - MyLength.LENGTH_FILE.getValue();
			rf.seek(len + MyLength.SEEK_YEAR.getValue());
			if (newYear.length() < MyLength.LENGTH_YEAR.getValue()) {
				int longManquant = MyLength.LENGTH_YEAR.getValue() - newYear.length();
				for (int a = 0; a < longManquant; a++) {
					newYear += " ";
				}
			}
			this.leYear = newYear;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Replace the comment with entered String
	public void setComment(String newComment) throws IOException {

		try {
			long len = f.length() - MyLength.LENGTH_FILE.getValue();
			rf.seek(len + MyLength.SEEK_COMMENT.getValue());
			if (newComment.length() < MyLength.LENGTH_COMMENT.getValue()) {
				int longManquant = MyLength.LENGTH_COMMENT.getValue() - newComment.length();
				for (int a = 0; a < longManquant; a++) {
					newComment += " ";
				}
			}
			this.leComment = newComment;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Replace the genre with entered String
	public void setGenre(String newGenre) throws IOException {

		try {
			long len = f.length() - MyLength.LENGTH_FILE.getValue();
			rf.seek(len + MyLength.SEEK_GENRE.getValue());
			if (newGenre.length() < MyLength.LENGTH_GENRE.getValue()) {
				int longManquant = MyLength.LENGTH_GENRE.getValue() - newGenre.length();
				for (int a = 0; a < longManquant; a++) {
					newGenre += " ";
				}
			}
			this.leGenre = newGenre;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Show all fields
	@Override
	public String toString() {
		return "Mp3Manager [" + leTag + " le Titre = " + leTitle + ", l'artiste = " + leArtist + ", l'album = "
				+ leAlbum + ", date = " + leYear + ", commentaire = " + leComment + ", genre = " + leGenre + "]";
	}

	// Close the file
	public void closeFile() {
		try {
			rf.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}