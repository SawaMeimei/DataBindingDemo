# DataBindingDemo

[文章地址](https://sawameimei.github.io/2016/10/15/ioc2/)

一个自己实现的DataBinding的小Demo 

剩余的问题

1.多个数据binding的情况，比如多个数据都binding到一个view，view的刷新是由多个数据共同决定。
比如bean中有三个String view显示其中最长的String，这种多个数据binding到一个view的情况还没办法解决。

2.这种binding形式持有了view的引用，数据要做好回收和释放，否则可能容易内存泄漏。

3.继承了BindObtain的bean不是单纯的POJO，不能通过gson直接转换成json字符串，也不能通过json字符串直接生成bean实体，需要另外想办法。

4.一个字段不能同时binding多个view的method，比如binding了setText就不能binding setVisible方法。
