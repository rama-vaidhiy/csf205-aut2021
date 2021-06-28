package org.sticker.websocket;

import java.io.IOException;
import java.io.Writer;

import javax.json.JsonObject;
import javax.json.JsonWriter;
import javax.json.spi.JsonProvider;
import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;
/**
 * https://www.oracle.com/webfolder/technetwork/tutorials/obe/java/WebSocket/WebSocket.html
 *
 */
public class StickerEncoder implements Encoder.TextStream<Sticker> {

	@Override
	public void encode(Sticker sticker, Writer writer) throws EncodeException, IOException {

		JsonProvider provider = JsonProvider.provider();
		JsonObject jsonSticker = provider.createObjectBuilder().add("action", "add").add("x", sticker.getX())
				.add("y", sticker.getY()).add("sticker", sticker.getImage()).build();
		try (JsonWriter jsonWriter = provider.createWriter(writer)) {
			jsonWriter.write(jsonSticker);
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init(EndpointConfig arg0) {
		// TODO Auto-generated method stub

	}

}
