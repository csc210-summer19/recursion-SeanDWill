/**
 * Complete the seven methods methods in this file using recursion, no loops. 
 * Also complete these three methods inside LinkedList<E>:
 *   get(int)
 *   removeAll(E)
 *   duplicateAll(E)
 *   
 * Also complete one method in ObstacleCourse that uses recursive backtracking.
 *   findExit(int, int)
 * 
 * Note: I believe the given unit test tests all methods. We will
 * be using this same for for correctness of code.
 * 
 * We will not be using code coverage for points.
 *
 * @author Rick Mercer and Your Name
 */
public class RecursionFun {

  // Complete recursive method combinations that returns from n choose k.
  // This method is described in 17_SimpleRecursion.pptx.
  public int combinations(int n, int k) {
	  if (n == k) {
		  return 1;
	  }
	  if (k== 1) {
		  return n;
	  }
	  return combinations(n-1, k-1)+combinations(n-1,k);
  }

 
  // Complete recursive method intWithCommas that returns the argument as a String
  // with commas in the correct places.
  //
  // intWithCommas(999) returns "999"
  // intWithCommas(1234) returns "1,234"
  // intWithCommas(1007) returns "1,007"
  // intWithCommas(1023004567) returns "1,023,004,567"
  //
  // Precondition: n >= 0
  public String intWithCommas(int n) {
    // TODO: Implement this method using recursion. Do not use a loop
	  if (n<10) {
		  String holder = Integer.toString(n);
		  return holder; 
	  }
	  if (n<100) {
		  String holder = Integer.toString(n);
		  return holder;
	  }
	  if (n< 1000) {
		  String holder = Integer.toString(n);
		  return holder;
	  }
	  if (n>=1000) {
		  String hold = Integer.toString(n);
		  String subHold = hold.substring(0,hold.length()-3);
		  int xx = Integer.parseInt(subHold);
		  String huumm = Integer.toString(xx);
		  String subHold1 = hold.substring(hold.length()-3,hold.length());
		  subHold1 = ","+subHold1;
		  int newN = Integer.parseInt(huumm);
		  String toRet = "";
		  toRet += intWithCommas(newN);
		  return toRet +subHold1;
	  }
    return "";
  }

  // Write recursive method reverseArray that reverses the array elements in a
  // filled array of ints. Use recursion; do not use a loop. The following
  // assertions must pass:
  //
  // int[] a = { 2, 4, 6 };
  // rf.reverseArray(a);
  // assertEquals(6, a[0]);
  // assertEquals(4, a[1]);
  // assertEquals(2, a[2]);
  //
  // Precondition: x.length > 0
  public void reverseArray(int[] x) {
    // You need a private helper that needs additional arguments.
    // like x and x.length to keep track of array the indexes
    // with no loop. Here is an example with the private helper
    // immediately below.
	int [] newX = new int [x.length];
    newX = reverseArray(x, 0, x.length, newX);
    assignNewEls(newX, 0, x);
  }

  private void assignNewEls(int[] newX, int i, int[] x) {
	// TODO Auto-generated method stub
	if (i >= x.length) {
		return;
	}
	else {
		x[i] = newX[i];
	}
	assignNewEls(newX, i+1, x);
}


private int[] reverseArray(int[] x, int index, int len, int [] newX) {
    // TODO: Complete this method with a recursive algorithm. 
    // Do NOT use a loop.
	  if (x.length == 1 ) {
		  return x;
	  }
	  else if (index >= len) {
		  return newX;
	  }
	  else {
		   newX[index] = x[len-1-index];
		   return reverseArray(x, index+1, len, newX);
		  
		  
	  }
  }

  // Write recursive method arrayRange that returns the maximum
  // integer minus the minimum integer in the filled array of 
  // integers, Use recursion; do not use a loop. 
  // Precondition: a.length > 0
  public int arrayRange(int[] a) {
    return arrayRangeMax(a, Integer.MIN_VALUE, 0) - arrayRangeMin(a, Integer.MAX_VALUE, 0);
  }

  private int arrayRangeMin(int[] a, int val, int index) {
	// TODO Auto-generated method stub
	if (a.length == 0) {
		return 0;
	}
	else if (index >= a.length) {
		return val;
	}
	else {
		if (a[index] < val) {
			val = a[index];
		}
		return arrayRangeMin(a, val, index+1);
	}
}


private int arrayRangeMax(int[] a, int val, int index) {
	// TODO Auto-generated method stub
	if (a.length == 0) {
		return 0;
	}
	else if (index >= a.length) {
		return val;
	}
	else {
		if (a[index] > val) {
			val = a[index];
		}
		return arrayRangeMax(a, val, index+1);
	}
}


// Return true if nums has all int elements in ascending order.
  // If not isSorted, return false.
  public boolean isSorted(int[] nums) {
    // Need to send down 0 to keep track of the index
	  if (nums.length == 0) {
		  return true;
	  }
    return isSortedHelp(nums, 0);
  }

  private boolean isSortedHelp(int[] nums, int i) {
	// TODO Auto-generated method stub
	if (i>= nums.length-1) {
		return true; 
	}
	if (nums[i] > nums[i+1]) {
		return false;
	}
	return isSortedHelp(nums, i+1);
}


// Complete method found to return true if search is found in strs.
  // If not found, return false. Use equals, not ==.
  public boolean found(String search, String[] strs) {
     return foundHelp(search, strs, 0);
  }


private boolean foundHelp(String search, String[] strs, int i) {
	if (strs.length == 0) {
		return true;
	}
	if (i>= strs.length) {
		return false;
	}
	if (strs[i].equals(search)) {
		return true;
	}
	return foundHelp(search, strs, i+1);
}
}
