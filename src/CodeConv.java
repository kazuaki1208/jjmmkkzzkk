import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;

public class CodeConv {

	public static void main(String[] args) {
		
		for(char c = '\u0000'; c < '\uffff'; c++) {
			System.out.println(c);
			
			
			
		}
		
		
	}
	
	public static void Encode(char c) {
		CharBuffer cBuf = CharBuffer.wrap(new char[] {c});
		
		CharsetEncoder ms932Encoder = Charset.forName("MS932").newEncoder();
		
		ByteBuffer bBuf = ByteBuffer.allocate(2);
		
		ms932Encoder.reset();
		
		ms932Encoder.encode(cBuf, bBuf, true);
		
		ms932Encoder.flush(bBuf);
		
	}

}
