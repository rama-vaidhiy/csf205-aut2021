package HelloApp;


/**
 * Generated from IDL interface "Hello".
 *
 * @author JacORB IDL compiler V 3.9
 * @version generated at 21 May 2021, 09:39:04
 */

public abstract class HelloPOA
	extends org.omg.PortableServer.Servant
	implements org.omg.CORBA.portable.InvokeHandler, HelloApp.HelloOperations
{
	static private final java.util.HashMap<String,Integer> m_opsHash = new java.util.HashMap<String,Integer>();
	static
	{
		m_opsHash.put ( "sayHello", Integer.valueOf(0));
	}
	private String[] ids = {"IDL:HelloApp/Hello:1.0"};
	public HelloApp.Hello _this()
	{
		org.omg.CORBA.Object __o = _this_object() ;
		HelloApp.Hello __r = HelloApp.HelloHelper.narrow(__o);
		return __r;
	}
	public HelloApp.Hello _this(org.omg.CORBA.ORB orb)
	{
		org.omg.CORBA.Object __o = _this_object(orb) ;
		HelloApp.Hello __r = HelloApp.HelloHelper.narrow(__o);
		return __r;
	}
	public org.omg.CORBA.portable.OutputStream _invoke(String method, org.omg.CORBA.portable.InputStream _input, org.omg.CORBA.portable.ResponseHandler handler)
		throws org.omg.CORBA.SystemException
	{
		org.omg.CORBA.portable.OutputStream _out = null;
		// do something
		// quick lookup of operation
		java.lang.Integer opsIndex = (java.lang.Integer)m_opsHash.get ( method );
		if ( null == opsIndex )
			throw new org.omg.CORBA.BAD_OPERATION(method + " not found");
		switch ( opsIndex.intValue() )
		{
			case 0: // sayHello
			{
				_out = handler.createReply();
				java.lang.String tmpResult0 = sayHello();
_out.write_string( tmpResult0 );
				break;
			}
		}
		return _out;
	}

	public String[] _all_interfaces(org.omg.PortableServer.POA poa, byte[] obj_id)
	{
		return ids;
	}
}
