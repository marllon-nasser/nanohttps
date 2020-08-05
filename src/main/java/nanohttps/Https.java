package nanohttps;

import java.io.IOException;

import fi.iki.elonen.NanoHTTPD;

public class Https extends NanoHTTPD {

	public Https() throws IOException {
		super(8080);
		makeSecure(NanoHTTPD.makeSSLSocketFactory("/keystore.jks", "password".toCharArray()), null);
		start(NanoHTTPD.SOCKET_READ_TIMEOUT, false);
	}
	public Https(int porta) throws IOException {
		super(porta);
		makeSecure(NanoHTTPD.makeSSLSocketFactory("/keystore.jks", "password".toCharArray()), null);
		start(NanoHTTPD.SOCKET_READ_TIMEOUT, false);
	}
    @Override
    public Response serve(IHTTPSession session) {
        return newFixedLengthResponse("Hello world");
    }

	public static void main(String[] args) throws IOException {
		new Https(8443);
	}

}