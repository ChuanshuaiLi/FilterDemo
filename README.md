# FilterDemo
项目：留言板过滤器
过滤器的应用：
完成字符集编码的处理和用户验证的功能
定义的CharacterEncodingFilter实现Filter接口，重写里面的doFilter方法,
doFileter方法主要有三个参数：请求、响应、过滤器链，
还要在里面最后实现chain.doFilter(request, response)方法，
执行下一步操作

还要在web.xml文件里完成 注册过滤器 拦截映射配置 操作

使用JSP来处理用户的请求，并未使用数据库
仅仅记录提交的登录信息，将信息放入session中
