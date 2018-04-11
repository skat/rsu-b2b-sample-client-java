package dk.skat.rsu.b2b.sample.mvc;

import com.google.common.base.Strings;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

/**
 * DownloadReceipt - Simple download servlet - Minimal efforts put into this.
 * However, it does name receipts by the transaction id - makes it easier to find
 * the receipt in the Download folder.
 *
 * @author SKAT
 * @since 1.0
 */
public class DownloadReceipt extends HttpServlet {

    /**
     * Download receipt stored in memory.
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String transactionId = request.getParameter("transactionId");
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
