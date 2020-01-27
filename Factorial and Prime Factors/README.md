__Find a factorial of n number's prime factors__
 ------------
  - For example, n = 5: 
  
    Then we want to find the prime factors of `5! = 2^3 * 3 * 5`. 
    
    Return the number of each prime factors: `[3,1,1]`
  
  - __Solution:__
 
    If we want to calculate the prime factors of `n!`, its prime factors can be calculated by the below formula:

    The number of __p__ = `n/p + n/p^2 + n/p^3 ...`, which p is all the prime factors. 

    For instance, 
      - `5! = 2^3 * 3 * 5`
   
        The number of `2` is: 5/2 + 5/4 = 2 + 1 = 3
    
        The number of `3` is: 5/3 = 1
    
        The number of `5` is: 5/5 = 1

      - `10! = 2^8 + 3^4 + 5^2`
      
        The number of '2' is: 10/2 + 10/4 + 10/8 = 5 + 2 + 1 = 8
        
        The number of '3' is: 10/3 + 10/9 = 3 + 1 = 4
        
        The number of '5' is: 10/5 = 2
        
