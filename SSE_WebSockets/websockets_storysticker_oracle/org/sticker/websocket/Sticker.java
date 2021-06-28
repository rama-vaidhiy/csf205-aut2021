package org.sticker.websocket;

/**
 * https://www.oracle.com/webfolder/technetwork/tutorials/obe/java/WebSocket/WebSocket.html
 *
 */
public class Sticker {

	private int x;
    private int y;
    private String image;

    public Sticker() {
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}
