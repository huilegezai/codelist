## 二进制中 1 的个数

### 题目描述
输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。

### 解法
#### 解法一
利用整数 1，依次左移每次与 n 进行与运算，若结果不为0，说明这一位上数字为 1，++cnt。

此解法 i 需要左移 32 次。

不要用 n 去右移并与 1 进行与运算，因为n 可能为负数，右移时会陷入死循环。

```java
public class Solution {
    public int NumberOf1(int n) {
        int cnt = 0;
        int i = 1;
        while (i != 0) {
            if ((n & i) != 0) {
                ++cnt;
            }
            i <<= 1;
        }
        return cnt;
    }
}
```

#### 解法二（推荐）
- 运算 (n - 1) & n，直至 n 为 0。运算的次数即为 n 的二进制中 1 的个数。

因为 n-1 会将 n 的最右边一位 1 改为 0，如果右边还有 0，则所有 0 都会变成 1。结果与 n 进行与运算，会去除掉最右边的一个1。

举个栗子：
```
若 n = 1100，
n - 1 = 1011
n & (n - 1) = 1000

即：把最右边的 1 变成了 0。
```

> 把一个整数减去 1 之后再和原来的整数做位与运算，得到的结果相当于把整数的二进制表示中最右边的 1 变成 0。很多二进制的问题都可以用这种思路解决。

```java
/**
 * @author Anonymous
 * @since 2019/11/20
 */

public class Solution {
    /**
     * 计算整数的二进制表示里1的个数
     * @param n 整数
     * @return 1的个数
     */
    public int NumberOf1(int n) {
        int cnt = 0;
        while (n != 0) {
            n = (n - 1 ) & n;
            ++cnt;
        }
        return cnt;
    }
}

```

### 测试用例
1. 正数（包括边界值 1、0x7FFFFFFF）；
2. 负数（包括边界值 0x80000000、0xFFFFFFFF）；
3. 0。