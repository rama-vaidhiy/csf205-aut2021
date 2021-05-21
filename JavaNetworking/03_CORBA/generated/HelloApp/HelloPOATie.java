package HelloApp;

import org.omg.PortableServer.POA;

/**
 * Generated from IDL interface "Hello".
 *
 * @author JacORB IDL compiler V 3.9
 * @version generated at 21 May 2021, 09:39:04
 */

public class HelloPOATie
	extends HelloPOA
{
	private HelloOperations _delegate;

	private POA _poa;
	public HelloPOATie(HelloOperations delegate)
	{
		_delegate = delegate;
	}
	public HelloPOATie(HelloOperations delegate, POA poa)
	{
		_delegate = delegate;
		_poa = poa;
	}
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
	public HelloOperations _delegate()
	{
		return _delegate;
	}
	public void _delegate(HelloOperations delegate)
	{
		_delegate = delegate;
	}
	public POA _default_POA()
	{
		if (_poa != null)
		{
			return _poa;
		}
		return super._default_POA();
	}
	public java.lang.String sayHello()
	{
		return _delegate.sayHello();
	}

}
