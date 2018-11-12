package com.hzed.qmqb.admin.infrastructure.enums;

import lombok.Getter;

/**
 * 错误枚举
 *
 * @author guichang
 */
@Getter
public enum BizCodeEnum {

    // 0-成功
    SUCCESS("0000", "处理成功"),

    // 9-系统服务异常
    UNKNOWN_EXCEPTION("9999", "系统未知错误"),
    SERVICE_EXCEPTION("9998", "内部服务处理异常"),
    ILLEGAL_REQUEST("9997", "无效的请求"),
    ALIYUN_EXCEPTION("9996", "阿里云操作异常"),

    // 8-支付交易
    NOT_ENOUGH_MONEY("8001", "用户余额不足"),
    LOAN_TRANSACTION_ERROR("8002", "支付放款接口异常"),
    RECEIVER_TRANSACTION_ERROR("8003", "支付收款接口异常"),
    OVER_REPAYMENT_MONEY("8004", "还款金额大于项目待还总额"),
    PAYMENTCODE_ERROR("8005","获取还款码接口异常"),
    USERTRANSACTION_ERROR("8006","没有待交易的账单"),
    LOANVOUCHER_ERROR("8007","还款凭证错误"),
    REPAYMENT_INFORMATION_ERROR("8008","必要信息错误"),
    CHECK_ACCOUNT_ERROR("8009","校验用户银行卡信息接口异常"),
    BANK_NOT_EXISTS("8010", "校验失败，找不到匹配的银行。"),
    CUSTOMER_NAME_NOT_EXISTS("8011", "校验失败，用户名称不匹配。"),
    ACCOUNT_NOT_EXISTS("8012", "校验失败，没有找到这个账户。"),
    ACCOUNT_ERROR("8013", "校验失败，银行账户异常。"),

    // 1-请求业务校验
    ILLEGAL_PARAM("1000", "请求参数非法"),
    ILLEGAL_CLIENT("1001", "无效的client"),
    ILLEGAL_PLATFORM("1002", "无效的platform"),
    ILLEGAL_VERSION("1003", "无效的version"),
    ILLEGAL_TOKEN("1004", "无效的token"),
    ILLEGAL_I18N("1005", "无效的i18n"),
    ILLEGAL_IMEI("1006", "无效的imei"),

    ILLEGAL_SMSCODE("1007", "无效的验证码"),
    ERROR_SMS_RESULT("1008", "运营商认证发送验证码返回数据异常"),
    USER_NOT_EXIST("1009", "用户不存在"),
    DICT_NOTEXISTS("1010", "字典不存在"),
    NO_USEFUL_PRODUCT("1011", "无可用产品"),
    TOKEN_EXPIRE("1012", "用户登录信息失效"),
    PIC_CODE_ERROR("1013", "图片验证码错误"),
    UN_IDENTITY_AUTH("1014", "用户未进行身份认证"),
    OVER_TIME_SMS_CODE("1015", "验证码超时"),
    FREQUENTLY_SMS_SEND("1016", "短信发送过于频繁"),
    SMS_CODE_SEND_FAIL("1017", "短信发送失败"),
    PIC_CODE_TO_CHECK("1018", "需要图片验证码校验"),
    BID_EXISTS("1019", "您账户中有一笔借款中，暂不能借款"),
    ILLEGAL_LEDGER_TYPE("1020", "账单ID：{0}的台账类型{1}不存在"),
    ERROR_RISK_RESULT("1021", "风控返回数据异常"),

    FAIL_IDCARD_RECOGNITION("1022", "身份证识别失败"),
    FAIL_FACE_RECOGNITION("1023", "人脸识别失败"),
    FAIL_IDENTITY_AUTH("1024", "身份信息认证失败"),
    FAIL_PROFESSIONAL_AUTH("1025", "专业信息认证失败"),
    FAIL_AUTH("1026", "认证失败"),
    ILLEGAL_BIDID("1027", "标ID：{0}不存在"),
    NOT_INDONESIA_PRODUCT("1028", "标ID：{0}不是印尼产品"),
    ILLEGAL_LEDGER("1029", "账单ID：{0}不存在台账"),
    ILLEGAL_BILLID("1030", "账单ID：{0}不存在"),
    NOT_EXIST_BILL("1031",  "标ID：{0}的账单不存在"),
    INSUFFICIENT_QUOTA("1032","可申请名额已经使用完了"),
    UN_LOAN_QUALIFICATION("1033","感谢您的申请，您的资质未达到平台要求"),
    NEED_JUMP("1034","需要跳转"),
    EXIST_USER("1035","用户已经存在"),
    FAIL_PUSH_RISK("1036","推送风控失败"),
    FAIL_CALLBACK_RISK("1037","风控回调失败"),
    HAVE_AUTH_RISK("1038","已认证"),
    FREQUENTLY_AUTH_RISK("1039","认证频繁，一分钟后重试"),
    PARAMS_AUTH_RISK("1040","认证数据不正确"),
    NOT_END_AUTH_RISK("1041","认证未结束不能重发验证码"),
    NEED_SMS_AUTH_RISK("1042","验证码错误，请重新输入验证码"),
    SUCCESS_AUTH("1043", "运营商认证成功"),
    UPLOAD_PIC_FAIL("1044","图片上传失败"),
    PIC_SIZE_ERROR("1045","图片后缀长度不匹配"),
    IDCARD_EXIST("1046","该身份证已经被使用过了，认证失败"),
    CLEAR_ONCE("1047","需要一次性结清"),
    MOBILE_ILLEGAL("1048","尊敬的用户，目前部分号码暂不支持Rupiah Get，请换个号码试试！"),
    MOBILE_INCORRECT("1049","手机号格式不正确"),
    AUTH_RISK_ING("1050","认证中"),
    AUTH_OVER_TIME("1051","认证过期"),
    FREQUENTLY_CREATE_BID("1052","进件频繁，十分钟后重试"),
    AUTH_UN_DONE("1053","未完成全部认证"),
    SPECIAL_CHARACTERS("1054","存在特殊字符"),
    RISK_REJECT_BEFORE("1055","感谢您的申请，您的资质未达到平台要求"),


    // 首页还款检测
    MSG_BID_OVERDUE_TODAY("2001","您的借款于今天到期，请尽快还款，以免逾期"),
    MSG_BID_OVERDUE_AFTER("2002","您的借款已经逾期{0}天，请尽快还款"),
    MSG_BID_OVERDUE_BEFORE("2003","您的借款于{0}天后到期，请尽快还款，以免逾期"),
    MSG_REPAY_APPLY("2004","您已经提交还款申请，立即查看还款结果？"),
    MSG_REPAY_UNSUCCESS("2005","您上次还款未完成，是否继续?"),
    ;


    // 20-

    // 21-

    // 3-


    /**
     * 错误码
     */
    private final String code;

    /**
     * 错误信息
     */
    private final String message;

    BizCodeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
