package exceptions;
//this is in a different package than main program wont run without exceptions imported
public class UnderflowException extends java.lang.Exception
{
    public UnderflowException(String err)
    {
        super(err);
    }
}