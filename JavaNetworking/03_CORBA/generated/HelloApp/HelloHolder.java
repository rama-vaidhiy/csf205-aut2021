package HelloApp;

/**
 * Generated from IDL interface "Hello".
 *
 * @author JacORB IDL compiler V 3.9
 * @version generated at 21 May 2021, 09:39:04
 */

public final class HelloHolder	implements org.omg.CORBA.portable.Streamable{
	 public Hello value;
	public HelloHolder()
	{
	}
	public HelloHolder (final Hello initial)
	{
		value = initial;
	}
	public org.omg.CORBA.TypeCode _type()
	{
		return HelloHelper.type();
	}
	public void _read (final org.omg.CORBA.portable.InputStream in)
	{
		value = HelloHelper.read (in);
	}
	public void _write (final org.omg.CORBA.portable.OutputStream _out)
	{
		HelloHelper.write (_out,value);
	}
}
