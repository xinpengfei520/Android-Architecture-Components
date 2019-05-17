# Android-Architecture-Components

Android Architecture Components (AAC)

Android Architecture Components 是谷歌在Google I/O 2017发布一套帮助开发者解决Android 架构设计的方案。

里面包含：

 - 生命周期相关组件： Lifecycle-aware Components
 - 数据库解决方案： Room

## 架构图

总体架构图：

![image](https://github.com/xinpengfei520/Android-Architecture-Components/blob/master/images/arch1.png)

Lifecycle 使用两个主要的枚举类来表示其所关联组件的生命周期：

 - Event 事件 从组件或者Lifecycle类分发出来的生命周期，它们和Activity／Fragment生命周期的事件一一对应。(ON_CREATE, ON_START, ON_RESUME, ON_PAUSE, ON_STOP, ON_DESTROY)；

 - State 状态 当前组件的生命周期状态(INITIALIZED, DESTROYED, CREATED, STARTED, RESUMED)。

![image](https://github.com/xinpengfei520/Android-Architecture-Components/blob/master/images/arch2.png)

ViewModel 与 LiveData 之间的关系图：

![image](https://github.com/xinpengfei520/Android-Architecture-Components/blob/master/images/arch3.png)

Room 架构图：

![image](https://github.com/xinpengfei520/Android-Architecture-Components/blob/master/images/arch4.png)

## Reference Link

[https://developer.android.com/topic/libraries/architecture/](https://developer.android.com/topic/libraries/architecture/)

[https://developer.android.com/reference/android/arch/lifecycle/package-summary](https://developer.android.com/reference/android/arch/lifecycle/package-summary)

[https://developer.android.google.cn/training/data-storage/room/](https://developer.android.google.cn/training/data-storage/room/)

[https://codelabs.developers.google.com/codelabs/android-room-with-a-view/#2](https://codelabs.developers.google.com/codelabs/android-room-with-a-view/#2)

[https://github.com/googlesamples/android-architecture-components](https://github.com/googlesamples/android-architecture-components)

[https://developer.android.com/topic/libraries/architecture/livedata#java](https://developer.android.com/topic/libraries/architecture/livedata#java)

[Android Architecture Components 只看这一篇就够了](https://juejin.im/post/5b30e39bf265da599423510a)

[带你领略Android Jetpack组件的魅力](https://mp.weixin.qq.com/s/OyimA5CBLlN_LhaGYDUxaA)