package dk.skat.rsu.b2b.sample.mvc;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * ReceiptsStorage - Simple solution to keep the 4 most recent receipts in memory.
 *
 * This sample may then be extended with a page listing all stored documents by transaction id.
 *
 * @author SKAT
 * @since 1.0
 */
public class ReceiptsStorage {

    private static final HashMap<String, Receipt> RECEIPTS = new LinkedHashMap<String, Receipt>();

    /**
     * Put receipt. Will only hold the latest 4 receipts.
     * For this reason we only allow one caller at a time.
     *
     * @param receipt Receipt
     */
    public static synchronized void put(Receipt receipt) {
        RECEIPTS.put(receipt.getTransactionId(), receipt);
        if (RECEIPTS.size() > 4) {
            // Remove first element.
            RECEIPTS.remove(RECEIPTS.keySet().iterator().next());
        }
    }

    /**
     * Get receipt
     *
     * @param transactionId Transaction id
     * @return Receipt
     */
    public static Receipt get(String transactionId) {
        return RECEIPTS.get(transactionId);
    }

}
