package nanohttps;

import java.io.IOException;

import fi.iki.elonen.NanoHTTPD;

public class App extends NanoHTTPD {
	public App() throws IOException {
		super(8080);
		start(NanoHTTPD.SOCKET_READ_TIMEOUT, false);
	}

	public static void main(String[] args) throws IOException {
		new App();
	}

	@Override
	public Response serve(IHTTPSession session) {
		if (session.getMethod() == Method.GET) {
	        String itemIdRequestParameter = session.getParameters().get("itemId").get(0);
	        return newFixedLengthResponse("Requested itemId = " + itemIdRequestParameter);
	    }
	    return newFixedLengthResponse(Response.Status.NOT_FOUND, MIME_PLAINTEXT, 
	        "The requested resource does not exist");
	}
}