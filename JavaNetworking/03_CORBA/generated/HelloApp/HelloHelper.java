package HelloApp;


/**
 * Generated from IDL interface "Hello".
 *
 * @author JacORB IDL compiler V 3.9
 * @version generated at 21 May 2021, 09:39:04
 */

public abstract class HelloHelper
{
	private volatile static org.omg.CORBA.TypeCode _type;
	public static org.omg.CORBA.TypeCode type ()
	{
		if (_type == null)
		{
			synchronized(HelloHelper.class)
			{
				if (_type == null)
				{
					_type = org.omg.CORBA.ORB.init().create_interface_tc("IDL:HelloApp/Hello:1.0", "Hello");
				}
			}
		}
		return _type;
	}

	public static void insert (final org.omg.CORBA.Any any, final HelloApp.Hello s)
	{
			any.insert_Object(s);
	}
	public static HelloApp.Hello extract(final org.omg.CORBA.Any any)
	{
		return narrow(any.extract_Object()) ;
	}
	public static String id()
	{
		return "IDL:HelloApp/Hello:1.0";
	}
	public static Hello read(final org.omg.CORBA.portable.InputStream in)
	{
		return narrow(in.read_Object(HelloApp._HelloStub.class));
	}
	public static void write(final org.omg.CORBA.portable.OutputStream _out, final HelloApp.Hello s)
	{
		_out.write_Object(s);
	}
	public static HelloApp.Hello narrow(final org.omg.CORBA.Object obj)
	{
		if (obj == null)
		{
			return null;
		}
		else if (obj instanceof HelloApp.Hello)
		{
			return (HelloApp.Hello)obj;
		}
		else if (obj._is_a("IDL:HelloApp/Hello:1.0"))
		{
			HelloApp._HelloStub stub;
			stub = new HelloApp._HelloStub();
			stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
			return stub;
		}
		else
		{
			throw new org.omg.CORBA.BAD_PARAM("Narrow failed");
		}
	}
	public static HelloApp.Hello unchecked_narrow(final org.omg.CORBA.Object obj)
	{
		if (obj == null)
		{
			return null;
		}
		else if (obj instanceof HelloApp.Hello)
		{
			return (HelloApp.Hello)obj;
		}
		else
		{
			HelloApp._HelloStub stub;
			stub = new HelloApp._HelloStub();
			stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
			return stub;
		}
	}
}
