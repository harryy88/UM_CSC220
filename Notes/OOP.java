//OOP2 Notes -- 8/30


//ArrayList :::::::::::::::::
//Can only be used with a REF type (String, Objs)
ArrayList<String> list = new ArrayList<String>(); 


//Inheritance Notes 9/6

//Searching and Recursion notezz for 9/11


<? extends Shape> a

//comparable interface:
 compareTo(); 

 //Binary Search Algorithm: 

 while (min <= max){ 
    target = ( min + max ) / 2;
    if (arr[target] == find){
      System.out.println("FOUNT AT POSITION: " + target);
      break;
    }
    else if (arr[target] > find){
      max = target - 1; 
    }
    else if (arr[target] < find){
      min = target + 1; 
    }
  }

