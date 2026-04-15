class Solution:
    def myPow(self, x: float, n: int) -> float:
        
        # base case
        if n == 0:
            return 1
        
        # handle negative
        if n < 0:
            return 1 / self.myPow(x, -n)
        
        # divide
        half = self.myPow(x, n // 2)
        
        # combine
        if n % 2 == 0:
            return half * half
        else:
            return half * half * x