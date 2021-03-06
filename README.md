# Jinriyouxi

# 脚手架说明
基本模块说明
```
auth-server是授权服务器
commons是基础包，一些错误提示和返回类
gateway-server是网关服务
eureka-server是注册中心服务
tms-server是服务提供者
sercurity-lib是spring security的资源包
```
整体架构是，服务都注册到注册中心，通过网关访问授权服务器，读取到token，然后通过网关读取到资源。使用spring security oauth2的密码模式，读取token ，token是存储在redis环境下的，然后通过访问资源服务器，在资源服务读取信息。
这里的知识点包括
```
注册中心的配置
网关的配置和拦截、请求转发
授权服务器的配置
资源服务器的配置
跨越的配置
方法级别的授权访问
```
在本地启动注册中心的话，需要在hosts文件配置node的ip地址
如果要访问授权服务器，返回是redis token 
```
curl --location --request POST 'localhost:8080/author/login?grant_type=password&username=test3&password=AFDD0B4AD2EC172C586E2150770FBF9E&scope=all' \
--header 'Content-Type: application/json' \
--header 'Authorization: Basic Y2xpZW50YXBwOjExMjIzMw=='
```
返回值 value就是token
```
{
    "code": 200,
    "data": {
        "additionalInformation": {},
        "expiration": 1594548262915,
        "expired": false,
        "expiresIn": 5598,
        "refreshToken": {
            "expiration": 1597133062911,
            "value": "9a77f97a-b611-42d3-80c6-de8763e7fd2a"
        },
        "scope": [],
        "tokenType": "bearer",
        "value": "be56e2f2-a035-470f-b9ed-20e2d8f400fe"
    },
    "msg": "执行成功"
}

```
访问资源服务器，需要读取收取服务器的token值
```
curl --location --request POST 'localhost:8080/tms/user/queryMenu' \
--header 'Authorization: Bearer be56e2f2-a035-470f-b9ed-20e2d8f400fe'

```
返回值
```
{
    "code": 200,
    "data": {
        "id": "4",
        "rememerMe": false,
        "password": "AFDD0B4AD2EC172C586E2150770FBF9E",
        "userName": "test3",
        "userType": "SYSTEM",
        "authorities": [
            {
                "id": 2,
                "createUser": "",
                "name": "接口权限",
                "service": "oms",
                "controller": "user",
                "method": "queryMenu",
                "isRootPermission": 0,
                "authority": "queryMenu_user_oms"
            }
        ],
        "enabled": true,
        "username": "4_SYSTEM_test3",
        "accountNonExpired": true,
        "credentialsNonExpired": true,
        "accountNonLocked": true
    },
    "msg": "执行成功"
}
```

数据库文件在account.sql
```
r_user 用户表
r_user_role 用户和角色的表
r_role 角色表
r_role_menu 角色菜单表
r_menu 菜单表
r_permission 权限表 这个表的配置的是方法的权限
r_menu_permission 菜单权限表
r_client 客户端表
```
权限控制方法的访问的思路是 用户有一个角色，角色定义页面，页面定义访问的权限，而权限是在方法上的注解是需要当前访问虚这个权限。




