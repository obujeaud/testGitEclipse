package fr.afpa.stage.tools;

public enum MyLength {
	SEEK_TITLE(3), SEEK_ARTIST(33), SEEK_ALBUM(63), SEEK_YEAR(93), SEEK_COMMENT(97), SEEK_GENRE(127),

	LENGTH_TAG(3), LENGTH_FILE(128), LENGTH_TITLE(30), LENGTH_ARTIST(30), LENGTH_ALBUM(30), LENGTH_YEAR(
			4), LENGTH_COMMENT(30), LENGTH_GENRE(1);

	private int value;

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	MyLength(int laValue) {
		this.value = laValue;
	}
}