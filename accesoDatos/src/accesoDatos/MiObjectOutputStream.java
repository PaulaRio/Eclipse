package accesoDatos;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class MiObjectOutputStream extends ObjectOutputStream
{

	protected MiObjectOutputStream(OutputStream out) throws IOException, SecurityException
	{
		super(out);
		// TODO Auto-generated constructor stub
	}

	protected MiObjectOutputStream() throws IOException, SecurityException
	{
		super();
		// TODO Auto-generated constructor stub
	}

	protected void writerStreamHeader() throws IOException
	{

	}

}
