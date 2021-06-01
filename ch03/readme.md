Error Tracking：
1.javax.management.InstanceNotFoundException: org.springframework.boot:type=Admin,name=SpringApplication
ref：https://stackoverflow.com/questions/50436108/javax-management-instancenotfoundexception-org-springframework-boottype-admin
idea：remove the 'Enable launch optimization' and 'Enable JMX agent' checkboxes when Edit Configurations

2.Inferred type 'S' for type parameter 'S' is not within its bound;
ref：https://blog.csdn.net/HeatDeath/article/details/79840834
UserDetails userDetails = readerRepository.findById(username).orElse(null);

3.import org.springframework.boot.autoconfigure.web.DefaultErrorAttributes
ref：https://blog.csdn.net/qq_41971768/article/details/109597242
replace to：org.springframework.boot.web.servlet.error.DefaultErrorAttributes

4.java.lang.ClassNotFoundException: java.lang.reflect.InaccessibleObjectException
ref：https://blog.csdn.net/weixin_41561929/article/details/109345347
upgrade to java9+

5.org.apache.tomcat.jni.LibraryNotFoundError: Can't load library: D:\idea\workspace\ch03\bin\tcnative-1.dll, Can't load library: D:\idea\workspace\ch03\bin\libtcnative-1.dll, no tcnative-1 in java.library.path, no libtcnative-1 in java.library.path
ref：https://blog.csdn.net/m0_37460012/article/details/100749271
copy apache-tomcat-8.5.43\bin\tcnative-1.dll to C:\Windows\System32

6.java.lang.ClassNotFoundException: java.net.UnixDomainSocketAddress
ref：https://docs.oracle.com/en/java/javase/16/docs/api/java.base/java/net/UnixDomainSocketAddress.html
change to jdk16