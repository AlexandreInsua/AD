package ud01;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class myObjectOutputStream extends ObjectOutputStream {

	public myObjectOutputStream(OutputStream out) throws IOException {
		super(out);
	}

	protected myObjectOutputStream() throws IOException, SecurityException {
		super();
	}

	
}