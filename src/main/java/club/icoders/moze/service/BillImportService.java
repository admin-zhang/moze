package club.icoders.moze.service;

import club.icoders.moze.entity.AlipayBill;
import club.icoders.moze.entity.WeChatBill;
import club.icoders.moze.listener.BillDataListener;
import club.icoders.moze.mapper.AlipayBillMapper;
import club.icoders.moze.mapper.WeChatBillMapper;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.support.ExcelTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

@Service
public class BillImportService {

    @Autowired
    private WeChatBillMapper weChatBillMapper;

    @Autowired
    private AlipayBillMapper alipayBillMapper;

    public void importWeChatBill(MultipartFile file) throws IOException {
        EasyExcel.read(file.getInputStream(), WeChatBill.class, new BillDataListener(weChatBillMapper)).excelType(ExcelTypeEnum.CSV)
                .charset(Charset.forName("UTF-8")).sheet().doRead();
    }

    public void importAlipayBill(MultipartFile file) throws IOException {
        EasyExcel.read(file.getInputStream(), AlipayBill.class, new BillDataListener(alipayBillMapper))
//                .excelType(ExcelTypeEnum.CSV).charset(Charset.forName("UTF-8"))
                .sheet()
                .doRead();
    }
}
