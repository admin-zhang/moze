package club.icoders.moze.entity;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@TableName("wechat_bill")
public class WeChatBill {
    @ExcelIgnore
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    @ExcelProperty("交易时间")
//    @JsonFormat(pattern = "yyyy/M/d HH:mm:ss")
    private String transactionTime;

    @ExcelProperty("交易类型")
    private String transactionType;

    @ExcelProperty("交易对方")
    private String counterpart;

    @ExcelProperty("商品")
    private String product;

    @ExcelProperty("收/支")
    private String incomeExpense;

    @ExcelProperty("金额(元)")
    private String amount;

    @ExcelProperty("支付方式")
    private String paymentMethod;

    @ExcelProperty("当前状态")
    private String currentStatus;

    @ExcelProperty("交易单号")
    private String transactionNumber;

    @ExcelProperty("商户单号")
    private String merchantNumber;

    @ExcelProperty("备注")
    private String remarks;
}
