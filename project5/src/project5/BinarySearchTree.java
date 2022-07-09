package project5;
import nonstandard.DuplicateItemException; import nonstandard.ItemNotFoundException;

public class BinarySearchTree<AnyType extends Comparable<? super AnyType>>
{
   
    public BinarySearchTree( )
    {
        root = null;
        min=null;
    }

   
    public void insert( AnyType x )
    {
        root = insert( x, root );
    }

    public void remove( AnyType x )
    {
        root = remove( x, root );
    }

    public void removeMin( )
    {
        root = removeMin( root );
    }

    public void findMin( )
    {
        findMin( root );
    }

    public void findMax( )
    {
       findMax( root );
    }

    public void find( AnyType x,int ind )
    {
        find( x, root,ind );
    }
    public AnyType findKth(int x )
    {
        return findKth(x,root);
    }


    public void makeEmpty( )
    {
        root = null;
    }

    public boolean isEmpty( )
    {
        return root == null;
    }
    public void printTree(BinaryNode node, String prefix)
	 {
	    if(node == null) return;

	    System.out.println(prefix + " * " + node.element);
	    printTree(node.left , prefix + " L of "+node.element);
	    printTree(node.right , prefix + " R of "+node.element);
	 }

    private AnyType elementAt( BinaryNode<AnyType> t )
    {
        return t == null ? null : t.element;
    }


    protected BinaryNode<AnyType> insert( AnyType x, BinaryNode<AnyType> t )
    {
        if( t == null )
            t = new BinaryNode<AnyType>( x );
        else if( x.compareTo( t.element ) < 0 )
            t.left = insert( x, t.left );
        else if( x.compareTo( t.element ) > 0 )
            t.right = insert( x, t.right );
        else
            throw new DuplicateItemException( x.toString( ) );  // Duplicate
        return t;
    }

    protected BinaryNode<AnyType> remove( AnyType x, BinaryNode<AnyType> t )
    {
        if( t == null )
            throw new ItemNotFoundException( x.toString( ) );
        if( x.compareTo( t.element ) < 0 )
            t.left = remove( x, t.left );
        else if( x.compareTo( t.element ) > 0 )
            t.right = remove( x, t.right );
        else if( t.left != null && t.right != null ) // Two children
        {
            t.element = min;//findMin( t.right ).element;
            t.right = removeMin( t.right );
        }
        else
            t = ( t.left != null ) ? t.left : t.right;
        return t;
    }

    protected BinaryNode<AnyType> removeMin( BinaryNode<AnyType> t )
    {
        if( t == null )
            throw new ItemNotFoundException( );
        else if( t.left != null )
        {
            t.left = removeMin( t.left );
            return t;
        }
        else
            return t.right;
    }    

    protected void findMin( BinaryNode<AnyType> t )
    {
        if( t != null && t.left != null ) {
    		findMin(t.left);
        }
        else {
        	System.out.println("found min value: "+t.element);
        	min=t.element;
        }

        return;
    }
    

    private void findMax( BinaryNode<AnyType> t )
    {
        if( t != null && t.right != null ) {
        		findMax(t.right);
    }
    else {
    	System.out.println("found max value: "+t.element);
    }

        return;
    }
   
    //findkth
     protected AnyType findKth( int k, BinaryNode<AnyType> t )
     {
    	 BinaryNode<AnyType> temp= t;
    	 int indx=0;
    	 while(t!=null) {
    		 t=t.left;
    		 indx++;
    	 }
    	 for(int i=0; i<indx-k;i++) {
    		 temp=temp.left;
    	 }
    	 return temp.element;
     }
    private void find( AnyType x, BinaryNode<AnyType> t, int index )
    {
        if(t!=null)
        {
            if( x.compareTo( t.element ) < 0 ) {
            	System.err.println("left");
                t = t.left;
                index++;
                find(x,t,index);
            }
            else if( x.compareTo( t.element ) > 0 ) {
            	System.err.println("right");
                t = t.right;
                index++;
                find(x,t,index);
            }
            else {
            	System.err.println("stop");
            	System.out.println("found '"+t.element+"' dist from root: "+index);
                return;
            }// Match
            
        }
        else
        System.err.println("the number: '"+x+"' was not found");
        return;  // Not found
    }

   
    protected BinaryNode<AnyType> root;
    protected AnyType min;

}
