package club.icoders.moze.controller;

import club.icoders.moze.service.BillImportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/bill")
@Slf4j
public class BillController {

    @Autowired
    private BillImportService billImportService;

    @PostMapping("/import/wechat")
    public ResponseEntity<String> importWeChatBill(@RequestParam("file") MultipartFile file) {
        try {
            billImportService.importWeChatBill(file);
            return ResponseEntity.ok("微信账单导入成功");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("导入失败: " + e.getMessage());
        }
    }

    @PostMapping("/import/alipay")
    public ResponseEntity<String> importAlipayBill(@RequestParam("file") MultipartFile file) {
        try {
            billImportService.importAlipayBill(file);
            return ResponseEntity.ok("支付宝账单导入成功");
        } catch (Exception e) {
            log.error("导入支付宝账单失败:  ", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("导入失败: " + e.getMessage());
        }
    }
}
