package org.sticker.websocket;
/**
 * https://www.oracle.com/webfolder/technetwork/tutorials/obe/java/WebSocket/WebSocket.html
 *
 */
import java.io.IOException;
import java.io.Reader;

import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.spi.JsonProvider;
import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

public class StickerDecoder implements Decoder.TextStream<Sticker> {

	public StickerDecoder() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init(EndpointConfig arg0) {
	// TODO Auto-generated method stub
	}
	
	@Override
	public Sticker decode(Reader reader) throws DecodeException, IOException {
		JsonProvider provider = JsonProvider.provider();
		JsonReader jsonReader = provider.createReader(reader);
		JsonObject jsonSticker = jsonReader.readObject();
		Sticker sticker = new Sticker();
		sticker.setX(jsonSticker.getInt("x"));
		sticker.setY(jsonSticker.getInt("y"));
		sticker.setImage(jsonSticker.getString("sticker"));
		return sticker;

	}
}
