import java.io.DataInputStream;
import java.lang.FunctionalInterface;

@FunctionalInterface
public interface ProtocolFunctional
{
	//CONVERT RESPONSE TO STRING 
	String m_serverResponse(int response, DataInputStream in);	
}