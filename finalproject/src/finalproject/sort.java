package finalproject;

public class sort {
	
	private static void print(int i,int [ ] a ) {
		for(int j=0; j<i;j+=1) {
		System.out.print(a[j]+", ");
		}
		System.out.println();
	}
	private static void removeDupe(int [ ] a ) {
		int[] arr=new int[a.length+1];
		int indx=0;
		for(int i=0; i<a.length;i++) {
			arr[i+1]=a[i];
		}
		for(int j=1; j<arr.length;j++) {
			if(arr[j-1]!=arr[j]) {
			a[indx]=arr[j];
			indx+=1;
			}
		}
		System.out.println("<--removed duplicates-->\n");
		print(indx,a);	
		
	}


	 public static void insertionSort( int [ ] a )
	    {
	        for( int p = 1; p < a.length; p++ )
	        {
	            int tmp = a[ p ];
	            int j = p;

	            for( ; j > 0 && tmp < a[ j - 1 ]; j-- )
	                a[ j ] = a[ j - 1 ];
	            a[ j ] = tmp;
	        }
	        removeDupe(a);
	    }
	 private static void insertionSort( int [ ] a, int low, int high )
	    {
	        for( int p = low + 1; p <= high; p++ )
	        {
	            int tmp = a[ p ];
	            int j;

	            for( j = p; j > low && tmp<a[ j - 1 ]; j-- )
	                a[ j ] = a[ j - 1 ];
	            a[ j ] = tmp;
	        }
	       
	    }

	 
	 public static void shellsort( int [ ] a )
	    {
	        for( int gap = a.length / 2; gap > 0;
	                     gap = gap == 2 ? 1 : (int) ( gap / 2.2 ) )
	            for( int i = gap; i < a.length; i++ )
	            {
	                int tmp = a[ i ];
	                int j = i;

	                for( ; j >= gap && tmp <a[ j - gap ]; j -= gap )
	                    a[ j ] = a[ j - gap ];
	                a[ j ] = tmp;
	            }
	        removeDupe(a);
	    }
	 public static void mergeSort( int [ ] a )
	    {
	        int [ ] tmpArray = new int[ a.length ];
	        mergeSort( a, tmpArray, 0, a.length - 1 );
	        removeDupe(a);
	    }
	 private static void mergeSort( int [ ] a, int [ ] tmpArray,int left, int right )
  {
      if( left < right )
      {
          int center = ( left + right ) / 2;
          mergeSort( a, tmpArray, left, center );
          mergeSort( a, tmpArray, center + 1, right );
          merge( a, tmpArray, left, center + 1, right );
      }
  }
	 
	 private static void merge( int [ ] a, int [ ] tmpArray,int leftPos, int rightPos, int rightEnd )
	 {
		 int leftEnd = rightPos - 1;
		 int tmpPos = leftPos;
		 int numElements = rightEnd - leftPos + 1;

		 // Main loop
		 while( leftPos <= leftEnd && rightPos <= rightEnd )
			 if( a[ leftPos ]<= a[ rightPos ] )
				 tmpArray[ tmpPos++ ] = a[ leftPos++ ];
			 else
				 tmpArray[ tmpPos++ ] = a[ rightPos++ ];

		 while( leftPos <= leftEnd )    // Copy rest of first half
			 tmpArray[ tmpPos++ ] = a[ leftPos++ ];

		 while( rightPos <= rightEnd )  // Copy rest of right half
			 tmpArray[ tmpPos++ ] = a[ rightPos++ ];

		 // Copy tmpArray back
		 for( int i = 0; i < numElements; i++, rightEnd-- )
			 a[ rightEnd ] = tmpArray[ rightEnd ];
	 }
	    public static void quicksort( int [ ] a )
	    {
	        quicksort( a, 0, a.length - 1 );
	        removeDupe(a);
	    }

	    private static final int CUTOFF = 10;
	    
	    public static final void swapReferences(int [ ] a, int index1, int index2 )
	    {
	        int tmp = a[ index1 ];
	        a[ index1 ] = a[ index2 ];
	        a[ index2 ] = tmp;
	    }

	   
	    private static void quicksort( int [ ] a, int low, int high )
	    {
	        if( low + CUTOFF > high )
	            insertionSort( a, low, high );
	        else
	        {
	                // Sort low, middle, high
	            int middle = ( low + high ) / 2;
	            if( a[ middle ]< a[ low ] )
	                swapReferences( a, low, middle );
	            if( a[ high ]< a[ low ] )
	                swapReferences( a, low, high );
	            if( a[ high ]< a[ middle ])
	                swapReferences( a, middle, high );

	                // Place pivot at position high - 1
	            swapReferences( a, middle, high - 1 );
	            int pivot = a[ high - 1 ];

	                // Begin partitioning
	            int i, j;
	            for( i = low, j = high - 1; ; )
	            {
	                while( a[ ++i ]< pivot  )
	                    ;
	                while( pivot<a[ --j ] )
	                    ;
	                if( i >= j )
	                    break;
	                swapReferences( a, i, j );
	            }

	                // Restore pivot
	            swapReferences( a, i, high - 1 );

	            quicksort( a, low, i - 1 );    // Sort small elements
	            quicksort( a, i + 1, high );   // Sort large elements
	        }
	    }
	}
