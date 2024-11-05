package club.icoders.moze.entity;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@TableName("alipay_bill")
public class AlipayBill {
    @ExcelIgnore
    private Long id;

    @ExcelProperty("交易时间")
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String transactionTime;

    @ExcelProperty("交易分类")
    private String transactionCategory;

    @ExcelProperty("交易对方")
    private String counterpart;

    @ExcelProperty("对方账号")
    private String counterpartAccount;

    @ExcelProperty("商品说明")
    private String productDescription;

    @ExcelProperty("收/支")
    private String incomeExpense;

    @ExcelProperty("金额")
    private String amount;

    @ExcelProperty("收/付款方式")
    private String paymentMethod;

    @ExcelProperty("交易状态")
    private String transactionStatus;

    @ExcelProperty("交易订单号")
    private String transactionOrderNumber;

    @ExcelProperty("商家订单号")
    private String merchantOrderNumber;

    @ExcelProperty("备注")
    private String remarks;
}
