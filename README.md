# 根据日期 + 流水生成自增序列

> * 架构介绍
> * api介绍
> * 性能介绍
> * 如何扩展

## 架构介绍

抽象基类：**SequenceNumber**,子类通过实现**process**方法进行扩展
日期流水生成器基类：**SequenceNumberByDay**提供了一个根据日期+流水生成sequence的抽象实现，其子类只需考虑如何持久化信息即可(持久化到文件或者数据库)
日期流水生成器，将信息持久化到文件：**SequenceNumberByDayPersientFile**提供了一种将信息持久化到文件的方式，适合非分布式系统
日期流水生成器，将信息持久化到数据库：**SequenceNumberByDayPersientDB**提供了一种将信息持久化到数据库的方式，适合分布式系统


## api介绍

```
SequenceNumberByDayPersientFile sequence = new SequenceNumberByDayPersientFile(5, "sequence.data");
```
args1 : 初始化一个序列宽度，比如制定5，则自增宽度为00000，生成YYYYMMDD+00000
args2 : 给定一个文件名持久化到本地磁盘，进行信息持久化


## 性能介绍

取100000条sequence完成时间需要: 38.061秒，次测试仅供参考

## 如何扩展

如果需要实现一个其他的序列规则，只需要继承**SequenceNumber**类即可进行扩展，然后在扩展数据持久化的方式即可

如果已有一个序列规则，需要扩展数据持久化方式，只需继承序列规则处理类(如**SequenceNumberByDay**类)即可
