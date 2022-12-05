package TalkTalk;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Converter {
	
	public static byte[] ObjectToBytes(Object obj) throws IOException {
	    ByteArrayOutputStream boas = new ByteArrayOutputStream();
	    try (ObjectOutputStream ois = new ObjectOutputStream(boas)) {
	        ois.writeObject(obj);
	        return boas.toByteArray();
	    }
	}
	
	public static Object BytesToObject(byte[] bytes)
            throws IOException, ClassNotFoundException {
        InputStream is = new ByteArrayInputStream(bytes);
        try (ObjectInputStream ois = new ObjectInputStream(is)) {
            return ois.readObject();
        }
    }
}
