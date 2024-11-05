package club.icoders.moze.listener;

import club.icoders.moze.entity.AlipayBill;
import club.icoders.moze.entity.WeChatBill;
import club.icoders.moze.mapper.AlipayBillMapper;
import club.icoders.moze.mapper.WeChatBillMapper;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson2.JSON;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class BillDataListener<T> extends AnalysisEventListener<T> {
    private static final int BATCH_COUNT = 100;
    private final List<T> dataList = new ArrayList<>();
    private final Object mapper;

    public BillDataListener(Object mapper) {
        this.mapper = mapper;
    }

    @Override
    public void invoke(T data, AnalysisContext context) {
        log.info("解析到一条数据: {}", JSON.toJSONString(data));
        dataList.add(data);
        if (dataList.size() >= BATCH_COUNT) {
            saveData();
            dataList.clear();
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        saveData();
    }

    private void saveData() {
        log.info("账单数据: {}", dataList);

        if (mapper instanceof WeChatBillMapper) {
            for (T t : dataList) {
                ((WeChatBillMapper) mapper).insert((WeChatBill) t);
            }
        } else if (mapper instanceof AlipayBillMapper) {
            for (T t : dataList) {
                ((AlipayBillMapper) mapper).insert((AlipayBill) t);
            }
    }
    }
}
