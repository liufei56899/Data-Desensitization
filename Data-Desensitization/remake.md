
数据脱敏使用步骤
    1、创建类实现SensitiveStrategy接口
    2、在类上添加@Component注解并实现接口方法
        1）、getSensitiveType()返回枚举类型
        2）、maskingData(String str)调用对应的脱敏方法
    3、在SensitiveInfoUtils类中添加并实现具体脱敏方法
    4、在实体类字段添加注解：如：@SensitiveInfo(SensitiveType.MOBILE_PHONE)、@SensitiveInfo(SensitiveType.ADDRESS)


用注解和策略模式优雅地实现了数据的脱敏功能
    使用场景：
        比如手机号、银行卡、身份证号等关键信息不方便直接展示，将关键数据做了适当隐藏，这样就叫数据脱敏。如：手机号15*******85
    数据脱敏：
        数据脱敏又称数据去隐私化或数据变形，是在给定的规则、策略下对敏感数据进行变换、修改的技术机制，能够在很大程度上解决敏感数据在非可信环境
        中使用的问题。根据数据保护规范和脱敏策略．对业务数据中的敏感信息实施自动变形．实现对敏感信息的隐藏
