package dk.skat.rsu.b2b.sample.mvc;

import com.google.common.base.Strings;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.IOException;
import java.io.OutputStream;

@Controller
public class DownloadController {

    @GetMapping("/download/{transactionId}")
    public void download(@PathVariable String transactionId, HttpServletResponse response) throws IOException {
        if (Strings.isNullOrEmpty(transactionId)) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        Receipt receipt = ReceiptsStorage.get(transactionId);
        if (receipt == null) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        String fileName = transactionId + ".pdf";
        response.setContentType("application/octet-stream");
        response.setHeader("Content-disposition", "attachment; filename=" + fileName);
        OutputStream out = response.getOutputStream();
        byte[] result = receipt.getReceipt();
        out.write(result);
        out.flush();

    }
}
