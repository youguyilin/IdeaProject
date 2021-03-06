## 时间空间复杂度
- 时间复杂度：执行这个算法需要消耗多少时间
- 空间复杂度：这个算法需要占用多少内存空间。

#### 算法的时间复杂度
（1）**语句频度T（n）** 一个算法执行所花的时间，从理论上说是不能算出来的，必须上机运行测试才能知道，只需要知道哪个方法花的时间多，哪个方法花的时间少就可以了。
 **而且一个算法花费的时间与算法中的基本操作语句的执行次数成正比例。**
（2）时间复杂度：在语句频度中，n称为问题的规模，当n不断变化时，语句频度T（n）也会不断变化，但有时候我们想知道它的变化呈现什么规律。
一般情况下，算法中的基本操作语句的重复执行次数是问题规模n的某个函数，用T(n)表示，若有某个辅助函数f(n)，使得当n趋于无穷大时，T(n)/f(n)的极限值为不等于零的常数。则称f(n)是T(n)的同量级函数。O（f(n)）为算法的渐进时间复杂度，称为时间复杂度。

#### 算法的空间复杂度
空间复杂度是对一个算法在运行过程中临时占用存储空间大小的量度，记做 S(n) = O(f(n))